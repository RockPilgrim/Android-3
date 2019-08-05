package my.lesson_6.dagger.app;

import javax.inject.Singleton;

import dagger.Component;
import my.lesson_6.DaggerActivity;

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {

    void inject(DaggerActivity daggerActivity);

}
