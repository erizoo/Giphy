package by.erizo.gifapi.app;

import android.app.Application;

import by.erizo.gifapi.injection.AppComponent;
import by.erizo.gifapi.injection.AppModule;
import by.erizo.gifapi.injection.DaggerAppComponent;

/**
 * Created by Erizo on 26.03.2018.
 */

public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}