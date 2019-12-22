package com.jack.mbolang.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Wisata implements Parcelable {
    String key, name, img_url, rating, description;
    public Wisata() {
    }

    public Wisata(String key, String name, String img_url, String rating, String description) {
        this.key = key;
        this.name = name;
        this.img_url = img_url;
        this.rating = rating;
        this.description = description;
    }

    protected Wisata(Parcel in) {
        key = in.readString();
        name = in.readString();
        img_url = in.readString();
        rating = in.readString();
        description = in.readString();
    }

    public static final Creator<Wisata> CREATOR = new Creator<Wisata>() {
        @Override
        public Wisata createFromParcel(Parcel in) {
            return new Wisata(in);
        }

        @Override
        public Wisata[] newArray(int size) {
            return new Wisata[size];
        }
    };

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(key);
        dest.writeString(name);
        dest.writeString(img_url);
        dest.writeString(rating);
        dest.writeString(description);
    }
}
