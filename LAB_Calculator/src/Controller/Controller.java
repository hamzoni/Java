package Controller;

import Event.ButtonEvent;
import GUI.UICalculator;

public class Controller {

    private UICalculator uic;

    public static void main(String[] args) {
        new Controller().init();
    }

    private void init() {
        uic = new UICalculator(this);
        uic.setVisible(true);

        Calculator.MC();

        eventDispatcher();
    }

    public void show(double v) {
        uic.getInput_result().setText(v + "");
    }
    public void show(String v) {
        uic.getInput_result().setText(v);
    }

    private void eventDispatcher() {
        uic.getBtn_0().addActionListener(new ButtonEvent(uic.getBtn_0(), this));
        uic.getBtn_1().addActionListener(new ButtonEvent(uic.getBtn_1(), this));
        uic.getBtn_2().addActionListener(new ButtonEvent(uic.getBtn_2(), this));
        uic.getBtn_3().addActionListener(new ButtonEvent(uic.getBtn_3(), this));
        uic.getBtn_4().addActionListener(new ButtonEvent(uic.getBtn_4(), this));
        uic.getBtn_5().addActionListener(new ButtonEvent(uic.getBtn_5(), this));
        uic.getBtn_6().addActionListener(new ButtonEvent(uic.getBtn_6(), this));
        uic.getBtn_7().addActionListener(new ButtonEvent(uic.getBtn_7(), this));
        uic.getBtn_8().addActionListener(new ButtonEvent(uic.getBtn_8(), this));
        uic.getBtn_9().addActionListener(new ButtonEvent(uic.getBtn_9(), this));

        uic.getBtn_decimal().addActionListener(new ButtonEvent(uic.getBtn_decimal(), this));
        uic.getBtn_divide().addActionListener(new ButtonEvent(uic.getBtn_divide(), this));
        uic.getBtn_fraction().addActionListener(new ButtonEvent(uic.getBtn_fraction(), this));

        uic.getBtn_minus().addActionListener(new ButtonEvent(uic.getBtn_minus(), this));
        uic.getBtn_minusPlus().addActionListener(new ButtonEvent(uic.getBtn_minusPlus(), this));
        uic.getBtn_mult().addActionListener(new ButtonEvent(uic.getBtn_mult(), this));
        uic.getBtn_plus().addActionListener(new ButtonEvent(uic.getBtn_plus(), this));
        uic.getBtn_result().addActionListener(new ButtonEvent(uic.getBtn_result(), this));
        uic.getBtn_sqrt().addActionListener(new ButtonEvent(uic.getBtn_sqrt(), this));

        uic.getBtn_mc().addActionListener(new ButtonEvent(uic.getBtn_mc(), this));
        uic.getBtn_mp().addActionListener(new ButtonEvent(uic.getBtn_mp(), this));
        uic.getBtn_mm().addActionListener(new ButtonEvent(uic.getBtn_mm(), this));
        uic.getBtn_mr().addActionListener(new ButtonEvent(uic.getBtn_mr(), this));

        uic.getBtn_modulus().addActionListener(new ButtonEvent(uic.getBtn_modulus(), this));
    }

    

}
