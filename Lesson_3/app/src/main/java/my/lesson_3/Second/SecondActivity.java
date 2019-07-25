package my.lesson_3.Second;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import my.lesson_3.R;
import my.lesson_3.first.OnSetText;

public class SecondActivity extends AppCompatActivity implements OnSetText {


    @BindView(R.id.button)
    public Button button;

    @BindView(R.id.second_textView)
    public TextView textView;


    private SecondPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        presenter = new SecondPresenter(this);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onClick() {
        presenter.subscribe();
    }

    @Override
    public void setText(String text) {
        textView.setText(text);
    }
}
