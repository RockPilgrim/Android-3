package my.lesson_2rxjava.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import my.lesson_2rxjava.R;

public class FirstActivity extends AppCompatActivity implements IFirstConnector{

    private Button button;
    private TextView textView;

    public static final String TAG = "FirstActivity";
    public static final String START = "Start";

    private FirstAsyncTask presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        initGUI();
    }

    private void initGUI() {
        button = findViewById(R.id.first_button);
        textView = findViewById(R.id.first_textView);

        final IFirstConnector  connector= this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: "+Thread.currentThread());
                Toast.makeText(getApplicationContext(), START, Toast.LENGTH_SHORT).show();
                textView.setText(START);
                presenter = new FirstAsyncTask(connector);
                presenter.execute(START);
                Log.i(TAG, "onClick Done: "+Thread.currentThread());
            }
        });
    }

    @Override
    public void setProgress(String progress) {
        Log.i(TAG, progress + ": " + Thread.currentThread());
        textView.setText(progress);
    }
}
