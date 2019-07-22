package my.lesson_2rxjava.third;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import my.lesson_2rxjava.R;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener, OnSetText {

    private Button subButton;
    private Button unsubButton;
    private TextView chatView;

    public static final String TAG = "ThirdActivity";

    private ThirdPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);

        initGUI();
        presenter = new ThirdPresenter(this);
    }

    private void initGUI() {
        subButton = findViewById(R.id.rx_sub_button);
        unsubButton = findViewById(R.id.rx_unsub_button);
        chatView = findViewById(R.id.chat_textView);

        subButton.setOnClickListener(this);
        unsubButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rx_sub_button:
                Log.i(TAG, "Sub " + Thread.currentThread());
                presenter.subscribe();
                break;
            case R.id.rx_unsub_button:
                Log.i(TAG, "Unsub " + Thread.currentThread());
                presenter.unsubscribe();
                break;
        }
    }

    @Override
    public void setText(String text) {
        chatView.setText(text);
    }
}
