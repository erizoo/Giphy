package by.erizo.gifapi.injection;

import javax.inject.Singleton;

import by.erizo.gifapi.screens.GifsViewModel;
import dagger.Component;

/**
 * Created by Erizo on 26.03.2018.
 */

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    void inject(GifsViewModel gifsViewModel);
}
