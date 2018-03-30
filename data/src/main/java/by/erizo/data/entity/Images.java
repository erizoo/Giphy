package by.erizo.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Erizo on 30.03.2018.
 */

public class Images {

    @SerializedName("fixed_height_still")
    @Expose
    private FixHeight fixHeight;

    public Images() {
    }

    public Images(FixHeight fixHeight) {
        this.fixHeight = fixHeight;
    }

    public FixHeight getFixHeight() {
        return fixHeight;
    }

    public void setFixHeight(FixHeight fixHeight) {
        this.fixHeight = fixHeight;
    }
}
