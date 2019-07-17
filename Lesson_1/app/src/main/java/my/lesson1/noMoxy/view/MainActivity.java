package my.lesson1.noMoxy.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.Objects;

import my.lesson1.noMoxy.presenter.Presenter;
import my.lesson1.R;

public class MainActivity extends AppCompatActivity implements Connector {

    private EditText editText;
    private Button button;
    private TextView textView;

    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initGUI();
        initEventsListeners();
        presenter = new Presenter(this);
    }

    private void initGUI() {
        editText = findViewById(R.id.edit_text);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.text_view);
    }

    private void initEventsListeners() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonClick((Objects.requireNonNull(editText.getText())).toString());
            }
        });
    }

    @Override
    public void sendinputText(String text) {
        textView.setText(text);
        editText.setText("");
    }
}
