package my.lesson_5;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RoomActivity extends AppCompatActivity implements ISetTextInformation {


    public static final String TAG = "Room Activity";
    @BindView(R.id.information_textView)
    public TextView infoTextView;

    @BindView(R.id.id_editText)
    public EditText idEditText;

    @BindView(R.id.name_editText)
    public EditText nameEditText;

    @BindView(R.id.surname_editText)
    public EditText surnameEditText;

    @BindView(R.id.age_editText)
    public EditText ageEditText;

    @BindView(R.id.get_all_button)
    public Button getAllButton;

    @BindView(R.id.add_button)
    public Button addbutton;

    @BindView(R.id.update_button)
    public Button updateButton;

    @BindView(R.id.delete_button)
    public Button deleteButton;

    private Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter(this);
        presenter.getAll();

        ButterKnife.bind(this);
    }

    @OnClick(R.id.add_button)
    public void addUser() {

        if (!nameEditText.getText().toString().isEmpty() && !ageEditText.getText().toString().isEmpty()) {
            presenter.addUser(nameEditText.getText().toString(),
                    surnameEditText.getText().toString(),
                    Integer.parseInt(ageEditText.getText().toString()));
        }else if (!nameEditText.getText().toString().isEmpty())
            presenter.addUser(nameEditText.getText().toString(),
                    surnameEditText.getText().toString());
        else
            setText("Insert user name");
    }

    @OnClick(R.id.update_button)
    public void updateUser() {
        try {

            presenter.updateUser(Integer.parseInt(idEditText.getText().toString()),
                    nameEditText.getText().toString(),
                    surnameEditText.getText().toString(),
                    Integer.parseInt(ageEditText.getText().toString()));
        } catch (NumberFormatException e) {
            Log.e(TAG, "Id error");
            setText("Insert id");
        }
    }

    @OnClick(R.id.delete_button)
    public void deleteUser() {
        try {

            presenter.deleteUser(Integer.parseInt(idEditText.getText().toString()));
        } catch (NumberFormatException e) {
            Log.e(TAG, "Id error");
            setText("Insert id");
        }
    }

    @OnClick(R.id.get_all_button)
    public void getAllUsers() {
        presenter.getAll();
    }

    @Override
    public void setText(String info) {
        infoTextView.setText(info);
        clearFields();
    }

    private void clearFields() {
        idEditText.setText("");
        nameEditText.setText("");
        surnameEditText.setText("");
        ageEditText.setText("");
    }
}
