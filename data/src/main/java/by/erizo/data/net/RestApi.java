package by.erizo.data.net;

import io.reactivex.Observable;

import java.util.List;

import by.erizo.data.entity.GifModel;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Erizo on 26.03.2018.
 */

public interface RestApi {

    @GET("trending?api_key=znPHErRvFXNnJCaijQZUYlzEWCzpbGMm")
    Observable<GifModel> loadGifs(@Query("limit") String limit, @Query("rating") String rating);

    @GET("v1/gifs/trending")
    Observable<GifModel> getTrending(@Query("api_key") String key, @Query("limit") String limit, @Query("rating") String rating);

    @GET("v1/gifs/search")
    Observable<GifModel> getSearch(@Query("api_key") String key, @Query("q") String search, @Query("offset") String offset,  @Query("limit") String limit,@Query("rating") String rating);
}
