package my.lesson_4;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IConnectToServer {

    @GET("users/{user}")
    Observable<UserGithub> connectToUser(@Path("user") String user);
}
