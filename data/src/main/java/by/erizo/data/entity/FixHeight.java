package by.erizo.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Erizo on 30.03.2018.
 */

public class FixHeight {

    @SerializedName("url")
    @Expose
    private String url;

    public FixHeight() {
    }

    public FixHeight(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
