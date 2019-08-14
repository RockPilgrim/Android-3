package my.lesson_7.mockito;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerConnector  {

    public static Observable<User> requestServer(String user) {

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);

        RxJava2CallAdapterFactory adapterFactory = RxJava2CallAdapterFactory.create();

        IGetApi api = new Retrofit.Builder()
                .addCallAdapterFactory(adapterFactory)
                .addConverterFactory(gsonConverterFactory)
                .build().create(IGetApi.class);
        return api.getUser(user).subscribeOn(Schedulers.io());
    }

}
