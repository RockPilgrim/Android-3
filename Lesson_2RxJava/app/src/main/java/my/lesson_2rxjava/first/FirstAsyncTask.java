package my.lesson_2rxjava.first;

import android.os.AsyncTask;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class FirstAsyncTask extends AsyncTask<String, String, String> {

    public static final String TAG = "First Presenter";
    public static final int PARTS = 4;

    private IFirstConnector activity;

    public FirstAsyncTask(IFirstConnector activity) {
        this.activity = activity;
    }


    @Override
    protected String doInBackground(String... strings) {
        try {
            for (int i = 1; i <= PARTS; i++) {
                String s = "Progress: " + i + "/" + PARTS;
                Log.i(TAG, s + " " + Thread.currentThread());
                publishProgress(s);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            Log.i(TAG, "Interrupted");
            return "Interrupted";
        }
        return "Done";
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        activity.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        activity.setProgress(s);
    }
}
