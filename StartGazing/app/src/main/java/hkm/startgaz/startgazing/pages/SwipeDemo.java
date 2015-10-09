package hkm.startgaz.startgazing.pages;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andtinder.model.CardModel;
import com.andtinder.model.Orientations;
import com.andtinder.view.CardContainer;
import com.andtinder.view.SimpleCardStackAdapter;
import com.pinterest.android.pdk.PDKCallback;
import com.pinterest.android.pdk.PDKClient;
import com.pinterest.android.pdk.PDKException;
import com.pinterest.android.pdk.PDKPin;
import com.pinterest.android.pdk.PDKResponse;
import com.squareup.picasso.Picasso;

import java.util.Iterator;
import java.util.List;

import hkm.startgaz.startgazing.R;
import hkm.startgaz.startgazing.network.PinNetwork;

/**
 * Created by hesk on 8/10/15.
 */
public class SwipeDemo extends Fragment {
    private CardContainer mCardContainer;
    private SimpleCardStackAdapter adapter;
    private int pins = 0;


    public SwipeDemo() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.swipe, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCardContainer = (CardContainer) view.findViewById(R.id.layoutview);
        mCardContainer.setOrientation(Orientations.Orientation.Disordered);
        adapter = new SimpleCardStackAdapter(getActivity());
        mCardContainer.setAdapter(adapter);
        PDKClient
                .getInstance()
                .getBoardPins(
                        getActivity().getString(R.string.officialboard),
                        PinNetwork.PIN_FIELDS,
                        new SDKCallBack());
    }


    protected void loadUpData(List<PDKPin> list) {
        Log.d("gazing", "start now");
        Iterator<PDKPin> it = list.iterator();
        while (it.hasNext()) {
            PDKPin p = it.next();
            CardModel mode = new CardModel(p.getUid(), p.getNote(), Picasso.with(getActivity()), p.getImageUrl());
            adapter.add(mode);
        }
    }

    private class SDKCallBack extends PDKCallback {
        @Override
        public void onSuccess(PDKResponse response) {
            loadUpData(response.getPinList());
        }

        @Override
        public void onFailure(PDKException exception) {
            Log.d("expection", exception.getMessage());
        }
    }

}
