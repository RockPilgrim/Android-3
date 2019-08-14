package my.lesson_7.mockito;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IGetApi {

    @GET("/users/{user}")
    Observable<User> getUser(@Path("user") String user);
}
