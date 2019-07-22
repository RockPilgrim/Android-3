package my.lesson_2rxjava.second;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import my.lesson_2rxjava.R;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private Button subButton;
    private Button unsubButton;
    private Button spamButton;

    private SecondMagazine magazine;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        initGUI();
        magazine = new SecondMagazine("GQ");
    }

    private void initGUI() {
        subButton = findViewById(R.id.sub_button);
        unsubButton = findViewById(R.id.unsub_button);
        spamButton = findViewById(R.id.spam_button);

        subButton.setOnClickListener(this);
        unsubButton.setOnClickListener(this);
        spamButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sub_button:
                magazine.registerSub(new SecondSubscriber());
                break;
            case R.id.unsub_button:
                magazine.unregisterSub(magazine.getLastSub());
                break;
            case R.id.spam_button:
                magazine.sendSpam();
                break;
        }
    }
}
