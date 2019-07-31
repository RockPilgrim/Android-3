package my.lesson_5;

import android.app.Application;

import androidx.room.Room;

import my.lesson_5.Model.AppDatabase;


public class App extends Application {

    private static AppDatabase appDatabase;


    @Override
    public void onCreate() {
        super.onCreate();

        appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "user_database").build();
    }

    public static AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
