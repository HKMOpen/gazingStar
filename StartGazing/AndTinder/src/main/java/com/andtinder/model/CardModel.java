/**
 * AndTinder v0.1 for Android
 *
 * @Author: Enrique López Mañas <eenriquelopez@gmail.com>
 * http://www.lopez-manas.com
 * <p/>
 * TAndTinder is a native library for Android that provide a
 * Tinder card like effect. A card can be constructed using an
 * image and displayed with animation effects, dismiss-to-like
 * and dismiss-to-unlike, and use different sorting mechanisms.
 * <p/>
 * AndTinder is compatible with API Level 13 and upwards
 * @copyright: Enrique López Mañas
 * @license: Apache License 2.0
 */

package com.andtinder.model;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class CardModel {

    private String title;
    private String description;
    private Drawable cardImageDrawable;
    private Drawable cardLikeImageDrawable;
    private Drawable cardDislikeImageDrawable;

    private OnCardDismissedListener mOnCardDismissedListener = null;

    private OnClickListener mOnClickListener = null;

    public interface OnCardDismissedListener {
        void onLike();

        void onDislike();
    }

    public interface OnClickListener {
        void OnClickListener();
    }

    public CardModel() {
        this(null, null, (Drawable) null);
    }

    public CardModel(String title, String description, Picasso initiated_picasso, String image_url) {
        this.title = title;
        this.description = description;
        this.cardImageDrawable = null;
        initiated_picasso.load(image_url).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                cardImageDrawable = new BitmapDrawable(null, bitmap);
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });
    }

    public CardModel(String title, String description, Drawable cardImage) {
        this.title = title;
        this.description = description;
        this.cardImageDrawable = cardImage;
    }

    public CardModel(String title, String description, Bitmap cardImage) {
        this.title = title;
        this.description = description;
        this.cardImageDrawable = new BitmapDrawable(null, cardImage);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Drawable getCardImageDrawable() {
        return cardImageDrawable;
    }

    public void setCardImageDrawable(Drawable cardImageDrawable) {
        this.cardImageDrawable = cardImageDrawable;
    }

    public Drawable getCardLikeImageDrawable() {
        return cardLikeImageDrawable;
    }

    public void setCardLikeImageDrawable(Drawable cardLikeImageDrawable) {
        this.cardLikeImageDrawable = cardLikeImageDrawable;
    }

    public Drawable getCardDislikeImageDrawable() {
        return cardDislikeImageDrawable;
    }

    public void setCardDislikeImageDrawable(Drawable cardDislikeImageDrawable) {
        this.cardDislikeImageDrawable = cardDislikeImageDrawable;
    }

    public void setOnCardDismissedListener(OnCardDismissedListener listener) {
        this.mOnCardDismissedListener = listener;
    }

    public OnCardDismissedListener getOnCardDismissedListener() {
        return this.mOnCardDismissedListener;
    }


    public void setOnClickListener(OnClickListener listener) {
        this.mOnClickListener = listener;
    }

    public OnClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    public OnCardDismissedListener getOnCardDimissedListener() {
        return mOnCardDismissedListener;
    }
}
