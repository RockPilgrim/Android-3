package my.lesson_3.first;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import my.lesson_3.R;

public class FirstActivity extends AppCompatActivity implements OnSetText {


    @BindView(R.id.rx_sub_button)
    public Button subButton;

    @BindView(R.id.rx_unsub_button)
    public Button unsubButton;

    @BindView(R.id.chat_textView)
    public TextView chatView;


    public static final String TAG = "FirstActivity";

    private FirstPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);

        presenter = new FirstPresenter(this);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.rx_unsub_button)
    public void onUnsubClik(View view) {
        Log.i(TAG, "Unsub"+ Thread.currentThread());
        presenter.unsubscribe();
    }

    @OnClick(R.id.rx_sub_button)
    public void onSubClik(View view) {
        Log.i(TAG, "sub"+ Thread.currentThread());
        presenter.subscribe();
    }

    @Override
    public void setText(String text) {
        chatView.setText(text);
    }
}
