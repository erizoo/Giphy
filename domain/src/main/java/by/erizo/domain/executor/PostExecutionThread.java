package by.erizo.domain.executor;

import io.reactivex.Scheduler;

/**
 * Created by Erizo on 26.03.2018.
 */

// этот интерфейс нужно реализовать в presentation
public interface PostExecutionThread {
    
    Scheduler getScheduler();

}
