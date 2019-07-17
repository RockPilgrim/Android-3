package my.lesson1.sameButMoxy.presenter;

import moxy.InjectViewState;
import moxy.MvpPresenter;
import my.lesson1.noMoxy.model.ModelPOJO;
import my.lesson1.sameButMoxy.view.SecondView;

@InjectViewState
public class SecondPresenter extends MvpPresenter<SecondView> {

    private ModelPOJO model;

    public SecondPresenter() {
        model = new ModelPOJO();
    }

    public void onButtonClick(String  text) {
        String t = (model.getText().isEmpty()) ? "" : model.getText();
        t = text.isEmpty() ? t : t + " " + text;
        getViewState().setText(t);
        model.setText(t);
    }

}
