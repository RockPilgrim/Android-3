 package my.lesson_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.concurrent.TimeUnit;

 public class MainActivity extends AppCompatActivity {

     public static final String TAG = "MainActivity";

     @Override
     protected void onCreate(Bundle savedInstanceState) {

         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         AsyncTask asyncTask = new AsyncTask() {
             @Override
             protected Object doInBackground(Object[] objects) {
                 try {
                     for (int i = 0; i < 30; i++) {
                         TimeUnit.SECONDS.sleep(1);
                         Log.i(TAG, "time: " + (i + 1));
                     }
                 } catch (InterruptedException e) {
                     Log.e(TAG, "Interrupted");
                 }

                 return null;
             }
         }.execute();
     }
}
