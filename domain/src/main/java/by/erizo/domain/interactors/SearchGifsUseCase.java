package by.erizo.domain.interactors;

import java.util.List;

import javax.inject.Inject;

import by.erizo.domain.entity.GifsEntity;
import by.erizo.domain.executor.PostExecutionThread;
import by.erizo.domain.repositories.GifsRepository;
import io.reactivex.Observable;

/**
 * Created by Erizo on 30.03.2018.
 */

public class SearchGifsUseCase extends BaseUseCase {

    private GifsRepository gifsRepository;

    @Inject
    public SearchGifsUseCase(PostExecutionThread postExecutionThread, GifsRepository gifsRepository) {
        super(postExecutionThread);
        this.gifsRepository = gifsRepository;
    }


    public Observable<List<GifsEntity>> searchGifs(String s, String offset, String limit, String rating) {
        return gifsRepository.searchGifs(s, offset, limit, rating).subscribeOn(threadExecution).observeOn(postExecutionThread);
    }
}
