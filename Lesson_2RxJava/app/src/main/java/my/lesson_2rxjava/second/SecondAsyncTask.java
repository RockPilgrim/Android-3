package my.lesson_2rxjava.second;

import android.os.AsyncTask;
import android.util.Log;

public class SecondAsyncTask extends AsyncTask<SecondDatabase,String ,String> {

    private SecondDatabase database;

    @Override
    protected String doInBackground(SecondDatabase... sendDataBase) {
        this.database = sendDataBase[0];
        for (int i = 0; i < database.size(); i++) {
            try {
                database.getSubber(i).getSpam(database.getMagazineName(), i + 1);
            } catch (InterruptedException e) {
                return "Interrupted";
            }
        }
        return "Done";
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Log.i("Task", result + ": " + Thread.currentThread());
    }

}
