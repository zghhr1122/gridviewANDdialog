package com.mobile.dialog;

import android.graphics.drawable.Drawable;

public class RightItemModel {

    public RightItemModel(String name, Drawable image){
        this.image=image;
        this.name=name;
    }

    public String name;
    public Drawable image;

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
