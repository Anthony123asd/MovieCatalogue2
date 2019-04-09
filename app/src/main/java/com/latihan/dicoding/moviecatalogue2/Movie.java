package com.latihan.dicoding.moviecatalogue2;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String title;
    private String date;
    private String description;
    private int poster;

    public Movie() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    protected Movie(Parcel in) {
        title = in.readString();
        date = in.readString();
        description = in.readString();
        poster = in.readInt();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(date);
        dest.writeString(description);
        dest.writeInt(poster);
    }



}