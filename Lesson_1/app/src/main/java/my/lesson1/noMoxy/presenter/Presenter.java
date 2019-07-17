package my.lesson1.noMoxy.presenter;

import my.lesson1.noMoxy.view.Connector;
import my.lesson1.noMoxy.model.ModelPOJO;

public class Presenter {

    private ModelPOJO model;
    private Connector connector;

    public Presenter(Connector connector) {
        this.connector = connector;
        model = new ModelPOJO();
    }

    public void onButtonClick(String  text) {
        String t = (model.getText().isEmpty()) ? "" : model.getText();
        t = text.isEmpty() ? t : t + " " + text;
        connector.sendinputText(t);
        model.setText(t);
    }

}
