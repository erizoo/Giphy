package by.erizo.gifapi.screens;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import by.erizo.domain.entity.GifsEntity;

/**
 * Created by Erizo on 26.03.2018.
 */

public class ItemGifsViewModel extends BaseObservable {

    private GifsEntity entity;


    public GifsEntity getEntity() {
        return entity;
    }

    public void setEntity(GifsEntity entity) {
        this.entity = entity;
        notifyChange();
    }

    @Bindable
    public String getUrl() {
        return entity.getUrl();
    }

}
