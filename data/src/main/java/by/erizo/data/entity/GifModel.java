package by.erizo.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Erizo on 26.03.2018.
 */

public class GifModel {

    @SerializedName("data")
    @Expose
    private List<ImageModel> data;

    public GifModel() {
    }

    public GifModel(List<ImageModel> data) {
        this.data = data;
    }

    public List<ImageModel> getData() {
        return data;
    }

    public void setData(List<ImageModel> data) {
        this.data = data;
    }
}
