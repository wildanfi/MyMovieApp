package com.android.wildanfi.mymovieapp.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by WildanFI on 24/01/2018.
 */

public class Language extends RealmObject {
    @SerializedName("iso_639_1")
    String languageCode;
    @SerializedName("name")
    String languageName;

    public String getLanguageCode() {
        return languageCode;
    }

    public String getLanguageName() {
        return languageName;
    }
}
