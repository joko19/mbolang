package com.jack.mbolang.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Artikel implements Parcelable {
    private String arKey, arTitle, arImage, arContent;
    public Artikel() {
    }

    public Artikel(String arKey, String arTitle, String arImage, String arContent) {
        this.arKey = arKey;
        this.arTitle = arTitle;
        this.arImage = arImage;
        this.arContent = arContent;
    }

    protected Artikel(Parcel in) {
        arKey = in.readString();
        arTitle = in.readString();
        arImage = in.readString();
        arContent = in.readString();
    }

    public static final Creator<Artikel> CREATOR = new Creator<Artikel>() {
        @Override
        public Artikel createFromParcel(Parcel in) {
            return new Artikel(in);
        }

        @Override
        public Artikel[] newArray(int size) {
            return new Artikel[size];
        }
    };

    public String getArKey() {
        return arKey;
    }

    public void setArKey(String arKey) {
        this.arKey = arKey;
    }

    public String getArTitle() {
        return arTitle;
    }

    public void setArTitle(String arTitle) {
        this.arTitle = arTitle;
    }

    public String getArImage() {
        return arImage;
    }

    public void setArImage(String arImage) {
        this.arImage = arImage;
    }

    public String getArContent() {
        return arContent;
    }

    public void setArContent(String arContent) {
        this.arContent = arContent;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(arKey);
        dest.writeString(arTitle);
        dest.writeString(arImage);
        dest.writeString(arContent);
    }
}
