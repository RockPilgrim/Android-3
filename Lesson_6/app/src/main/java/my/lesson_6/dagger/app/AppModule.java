package my.lesson_6.dagger.app;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import my.lesson_6.colors.Green;
import my.lesson_6.colors.Red;

@Module
public class AppModule {


    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }


    @Provides
    @Singleton
    public Green provideGreen() {
        return new Green();
    }

    @Provides
    @Singleton
    public Red provide(Green green) {
        return new Red(green);
    }


}
