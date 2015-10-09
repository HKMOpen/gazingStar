package hkm.startgaz.startgazing.network;

import android.content.Context;
import android.util.Log;

import com.pinterest.android.pdk.PDKCallback;
import com.pinterest.android.pdk.PDKClient;
import com.pinterest.android.pdk.PDKException;
import com.pinterest.android.pdk.PDKResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hesk on 8/10/15.
 */

public class PinNetwork {
    private Context mContext;
    public static final String PIN_FIELDS = "id,link,creator,image,counts,note,created_at,board,metadata";
    public PinNetwork(Context c) {
        mContext = c;
    }

    public void dologin() {
        List scopes = new ArrayList<String>();
        scopes.add(PDKClient.PDKCLIENT_PERMISSION_READ_PUBLIC);
        scopes.add(PDKClient.PDKCLIENT_PERMISSION_WRITE_PUBLIC);
        PDKClient.getInstance().login(mContext, scopes, new PDKCallback() {
            @Override
            public void onSuccess(PDKResponse response) {
                Log.d(getClass().getName(), response.getData().toString());
                //user logged in, use response.getUser() to get PDKUser object
            }

            @Override
            public void onFailure(PDKException exception) {
                Log.e(getClass().getName(), exception.getDetailMessage());
            }
        });
    }


}
