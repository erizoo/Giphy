package by.erizo.domain.repositories;


import java.util.List;

import by.erizo.domain.entity.GifsEntity;
import io.reactivex.Observable;

/**
 * Created by Erizo on 26.03.2018.
 */

public interface GifsRepository {

    Observable<GifsEntity> getGifs(String limit, String rating);

    Observable<List<GifsEntity>> searchGifs(String s, String offset, String limit, String rating);

    Observable<List<GifsEntity>> getTaradingGifs(String limit, String rating);
}
