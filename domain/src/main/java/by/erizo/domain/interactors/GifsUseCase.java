package by.erizo.domain.interactors;

import java.util.List;

import javax.inject.Inject;

import by.erizo.domain.entity.GifsEntity;
import by.erizo.domain.executor.PostExecutionThread;
import by.erizo.domain.repositories.GifsRepository;
import io.reactivex.Observable;

/**
 * Created by Erizo on 26.03.2018.
 */

public class GifsUseCase extends BaseUseCase {

    private GifsRepository gifsRepository;

    @Inject
    public GifsUseCase(PostExecutionThread postExecutionThread, GifsRepository gifsRepository) {
        super(postExecutionThread);
        this.gifsRepository = gifsRepository;
    }

    public Observable<List<GifsEntity>> get(String limit, String rating) {
        return gifsRepository.getTaradingGifs(limit, rating ).subscribeOn(threadExecution).observeOn(postExecutionThread);
    }
}
