package by.erizo.gifapi.base;

import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Erizo on 26.03.2018.
 */

public abstract class BaseViewModel extends ViewModel {
    public static final String MY_TEG = "my_teg";
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    public abstract void createInject();

    public BaseViewModel() {
        createInject();
    }

    public void onResume() {

    }

    public void onPause() {

    }

    public void onStart() {
        System.out.println("dg");
    }

    public void onStop() {

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}