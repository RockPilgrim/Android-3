package my.lesson_7.mockito;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

public class mockitoTest {

    private Presenter presenter;
    private ServerConnector serverConnector;

    @BeforeClass
    public static void setUpClass() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(schedulerCallable -> Schedulers.trampoline());
    }

    @Before
    public void begin() {
        MockitoAnnotations.initMocks(this);
        presenter = Mockito.spy(new Presenter());
        serverConnector = new ServerConnector();
    }

    @Test
    public void getStringRight() {
        IGetApi api = new IGetApi() {
            @Override
            public Observable<User> getUser(String user) {
                return null;
            }
        };
        User user = new User();
        user.setLogin("Jake Chan");
        Mockito.when(api.getUser("JakeWharton")).thenReturn(Observable.just(user));

    }
}
