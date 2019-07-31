package my.lesson_5;

import android.util.Log;

import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import my.lesson_5.Model.User;
import my.lesson_5.Model.UserDao;

public class Presenter {

    private ISetTextInformation uiInformation;

    public static final String TAG = "Presenter";

    private UserDao userDao;


    public Presenter(ISetTextInformation uiInformation) {
        this.uiInformation = uiInformation;
        userDao = App.getAppDatabase().userDao();
    }

    public void addUser(String name, String surname, int age) {
        Disposable disposable = addUserRX(new User(name, surname, age)).observeOn(AndroidSchedulers.mainThread()).subscribe((s, throwable) -> {
            sendInformation(s);
        });
    }
    public void addUser(String name, String surname) {
        Disposable disposable = addUserRX(new User(name, surname)).observeOn(AndroidSchedulers.mainThread()).subscribe((s, throwable) -> {
            sendInformation(s);
        });
    }

    public void getAll() {
        StringBuffer stringBuffer = new StringBuffer();
        Disposable disposable1 = userDao.getAllUsers().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((userList, throwable) -> {
            for (User u : userList) {
                stringBuffer.append(u).append("\n");
            }
            sendInformation(stringBuffer.toString());
        });
    }

    private Single<String> addUserRX(User user) {
        return Single.create((SingleOnSubscribe<String>) emitter -> {
            userDao.addUser(user);
            emitter.onSuccess("Added: " + user);
        }).subscribeOn(Schedulers.io());
    }


    public void updateUser(int id, String name, String surname, int age) {
        Disposable disposable = updateUserRX(new User(id, name, surname, age)).observeOn(AndroidSchedulers.mainThread()).subscribe((s, throwable) -> {
            sendInformation(s);
            Log.e(TAG, "Error", throwable);
        });
    }

    private Single<String> updateUserRX(User user) {
        return Single.create((SingleOnSubscribe<String>) emitter -> {
            userDao.updateUser(user);
            emitter.onSuccess("Update: " + user);
        }).subscribeOn(Schedulers.io());
    }


    public void deleteUser(int id) {
        Disposable disposable = deleteUserRX(new User(id)).observeOn(AndroidSchedulers.mainThread()).subscribe((s, throwable) -> {
            sendInformation(s);
        });
    }

    private Single<String> deleteUserRX(User user) {

        return Single.create((SingleOnSubscribe<String>) emitter -> {
            userDao.deleteUser(user);
            emitter.onSuccess("Deleted: " + user);
        }).subscribeOn(Schedulers.io());
    }

    private void sendInformation(String info) {
        uiInformation.setText(info);
    }

}
