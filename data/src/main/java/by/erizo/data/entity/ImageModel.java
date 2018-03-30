package by.erizo.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import by.erizo.domain.entity.Image;

/**
 * Created by Erizo on 26.03.2018.
 */

public class ImageModel {

    @SerializedName("images")
    @Expose
    private Images images;

    public ImageModel() {
    }

    public ImageModel(Images images) {
        this.images = images;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }
}
