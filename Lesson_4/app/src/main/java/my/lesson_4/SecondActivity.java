package my.lesson_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity implements ISetFace {

    @BindView(R.id.get_button)
    public Button button;

    @BindView(R.id.jake_wharton_face)
    public ImageView imageView;

    private Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        presenter = new Presenter(this);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.get_button)
    public void onClickFindWharton() {

        presenter.theyNeedJake();
    }


    @Override
    public ImageView getFaceWhartonToSet() {
        return imageView;
    }
}
