package my.lesson_2rxjava.second;

import android.util.Log;

import java.util.ArrayList;

public class SecondDatabase {

    public static final String TAG = "Database";
    private ArrayList<ISecondObserver> subscribers;
    private String magazineName;

    public String getMagazineName() {
        return magazineName;
    }

    public void setMagazineName(String magazineName) {
        this.magazineName = magazineName;
    }

    public SecondDatabase(String magazineName) {
        this.magazineName = magazineName;
        subscribers = new ArrayList<>();
    }

    public ISecondObserver getSubber(int index) {
        return subscribers.get(index);
    }

    public void addSubber(ISecondObserver observer) {
        subscribers.add(observer);
        Log.i(TAG, "Added customer: " + subscribers.size() + " " + Thread.currentThread());
    }

    public void removeSubber(ISecondObserver observer)  {
        subscribers.remove(observer);
        Log.i(TAG, "removed customer: " + (subscribers.size()+1) + " " + Thread.currentThread());
    }

    public ArrayList<ISecondObserver> getSubscribers() {
        return subscribers;
    }

    public int size() {
        return subscribers.size();
    }

    public void setSubscribers(ArrayList<ISecondObserver> subscribers) {
        this.subscribers = subscribers;
    }
}
