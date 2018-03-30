package by.erizo.data.repositories;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import by.erizo.data.entity.GifModel;
import by.erizo.data.entity.ImageModel;
import by.erizo.data.entity.Images;
import by.erizo.data.net.RestService;
import by.erizo.domain.entity.Gif;
import by.erizo.domain.entity.GifsEntity;
import by.erizo.domain.entity.Image;
import by.erizo.domain.repositories.GifsRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by Erizo on 26.03.2018.
 */

public class GifsRepositoryImpl implements GifsRepository {

    private Context context;
    private RestService restService;

    @Inject
    public GifsRepositoryImpl(Context context, RestService restService) {
        this.context = context;
        this.restService = restService;
    }

    @Override
    public Observable<GifsEntity> getGifs(String limit, String rating) {
        return restService.loadGifs(limit, rating).map(new Function<GifModel, GifsEntity>() {
            @Override
            public GifsEntity apply(GifModel gifModel) throws Exception {
                GifsEntity gifsEntity = new GifsEntity();
                return gifsEntity;
            }
        });
    }

    @Override
    public Observable<List<GifsEntity>> searchGifs(String s, String offset, String limit, String rating) {
        return restService.searchGifs(s, offset, limit, rating).map(gifModel -> {
            List<GifsEntity> gifs = new ArrayList<>();
            for (ImageModel item: gifModel.getData() ) {
                gifs.add(new GifsEntity(item.getImages().getFixHeight().getUrl()));
            }
            return gifs;
        });
    }


    @Override
    public Observable<List<GifsEntity>> getTaradingGifs(String limit, String rating) {
        return restService.getTrending(limit, rating).map(r -> {
            List<GifsEntity> gifs = new ArrayList<>();
            for (ImageModel item: r.getData() ) {
                gifs.add(new GifsEntity(item.getImages().getFixHeight().getUrl()));
            }
            return gifs;
        });
    }


}
