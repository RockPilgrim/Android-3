package my.lesson1.sameButMoxy.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;
import my.lesson1.R;
import my.lesson1.sameButMoxy.presenter.SecondPresenter;

public class SecondActivity extends MvpAppCompatActivity implements SecondView {

    private EditText editText;
    private Button button;
    private TextView textView;

    @InjectPresenter
    SecondPresenter presenter;


    @ProvidePresenter
    public SecondPresenter providePresenter() {
        return new SecondPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initGUI();
        initEventListeners();
    }

    private void initGUI() {
        editText = findViewById(R.id.edit_text);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.text_view);
    }

    private void initEventListeners() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonClick(editText.getText().toString());
            }
        });
    }

    @Override
    public void setText(String text) {
        textView.setText(text);
        editText.setText("");
    }
}
