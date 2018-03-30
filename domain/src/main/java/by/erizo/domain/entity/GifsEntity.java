package by.erizo.domain.entity;

import java.util.List;

/**
 * Created by Erizo on 26.03.2018.
 */

public class GifsEntity {

    private String url;

    public GifsEntity() {
    }

    public GifsEntity(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
