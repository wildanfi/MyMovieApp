package com.android.wildanfi.mymovieapp.model;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;
/**
 * Created by WildanFI on 24/01/2018.
 */

public class Genre extends RealmObject{
    @SerializedName("name")
    String genreName;

    public String getGenreName() {
        return genreName;
    }
}
