package by.erizo.data.net;

import javax.inject.Inject;
import javax.inject.Singleton;

import by.erizo.data.entity.GifModel;
import io.reactivex.Observable;

/**
 * Created by Erizo on 26.03.2018.
 */
@Singleton
public class RestService {

    private static final String API_KEY = "znPHErRvFXNnJCaijQZUYlzEWCzpbGMm";
    private RestApi restApi;

    @Inject
    public RestService(RestApi restApi) {
        this.restApi = restApi;
    }

    public Observable<GifModel> loadGifs(String limit, String rating) {
        return restApi.loadGifs(limit, rating);
    }

    public Observable<GifModel> getTrending(String limit, String rating) {
        return restApi.getTrending(API_KEY, limit, rating);
    }

    public Observable<GifModel> searchGifs(String search, String offset, String limit, String rating) {
        return restApi.getSearch(API_KEY, search, offset, limit, rating);
    }


}
