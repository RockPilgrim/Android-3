package my.lesson_2rxjava.second;

import android.util.Log;

public class SecondMagazine implements ISecondObservable {

    private SecondDatabase database;
    private String magazineName;

    public SecondMagazine(String magazineName) {
        this.magazineName = magazineName;
        database = new SecondDatabase(magazineName);
    }

    @Override
    public void registerSub(ISecondObserver customer) {
        database.addSubber(customer);
    }

    @Override
    public void unregisterSub(ISecondObserver customer) {
        if (customer != null) {
            database.removeSubber(customer);
        }
    }

    public ISecondObserver getLastSub() {
        try {
            return database.getSubber(database.size() - 1);

        } catch (IndexOutOfBoundsException e) {
            Log.i("Magazine", "Error");
            return null;
        }
    }

    @Override
    public void sendSpam() {
        SecondAsyncTask task = new SecondAsyncTask();
        task.execute(database);
    }
}
