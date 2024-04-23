import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.Action;

public class ModuleAssignment10 extends Frame {
    private Label lred, lgreen, lblue, lalpha;
    private TextField tred, tgreen, tblue, talpha;
    private Button bcompute, bclear;
    private Panel inputpanel, colorpanel;
    private final String DEFAULT_TEXT_VALUE = "0";

    private Label error;
    private Panel BG;

    {
        this.addWindowListener(
                new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                        System.exit(0);
                    }

                    @Override
                    public void windowGainedFocus(WindowEvent e) {
                        System.out.println("Window gained focus");
                    }
                });
    }

    public ModuleAssignment10() {

        lred = new Label("Red:");
        lgreen = new Label("Green:");
        lblue = new Label("Blue:");
        lalpha = new Label("Alpha:");

        error = new Label("                                                     ");
  
        BG = new Panel(new GridLayout(1,1));

        tred = new TextField(DEFAULT_TEXT_VALUE, 15);
        tgreen = new TextField(DEFAULT_TEXT_VALUE, 15);
        tblue = new TextField(DEFAULT_TEXT_VALUE, 15);
        talpha = new TextField(DEFAULT_TEXT_VALUE, 15);

        bcompute = new Button("Compute");
        bclear = new Button("Clear");

        inputpanel = new Panel(new GridLayout(5, 2));
        colorpanel = new Panel();

    }

    class NegativeValueException extends RuntimeException {
    }

    class ValueBeyondRangeException extends RuntimeException {
    }

    class NonIntegerValueException extends RuntimeException {
    }

    class BlankTextFieldException extends RuntimeException {
    }

    private class buttoncompute implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Clicked");
            error.setText(null);

            String r = tred.getText();
            String g = tgreen.getText();
            String b = tblue.getText();
            String a = talpha.getText();
            int red = 0, blue = 0, green = 0, alpha = 0;
            try {
                if (r.equals("") || g.equals("") || b.equals("") || a.equals("")) {// blanktextfield
                    throw new BlankTextFieldException();
                }

                try {
                    red = Integer.parseInt(r);
                    green = Integer.parseInt(g);
                    blue = Integer.parseInt(b);
                    alpha = Integer.parseInt(a);
                } catch (NumberFormatException f) {// noninteger
                    throw new NonIntegerValueException();
                }

                if (red < 0 || green < 0 || blue < 0 || alpha < 0) {// negativevalue
                    throw new NegativeValueException();
                }
                if (!(0 <= red && red <= 255) || !(0 <= green && green <= 255) || !(0 <= blue && blue <= 255)
                        || !(0 <= alpha && alpha <= 255)) {
                    throw new ValueBeyondRangeException();// beyondrange
                }
            } catch (BlankTextFieldException f) {
                colorpanel.setBackground(null);
                error.setText("Error: blank text field");
                error.setBackground(null);
                return;
            } catch (NonIntegerValueException f) {
                colorpanel.setBackground(null);
                error.setText("Error: Invalid Input");
                error.setBackground(null);
                return;
            } catch (NegativeValueException f) {
                colorpanel.setBackground(null);
                error.setText("Error: Negative value found");
                error.setBackground(null);
                return;
            } catch (ValueBeyondRangeException f) {
                colorpanel.setBackground(null);
                error.setText("Error: Invalid range");
                error.setBackground(null);
                return;
            } catch (NumberFormatException f) {

                return;
            }
            colorpanel.setBackground(new Color(red, green, blue, alpha));
            error.setBackground(null);

        }
    }

    private class buttonclear implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            tred.setText(DEFAULT_TEXT_VALUE);
            tgreen.setText(DEFAULT_TEXT_VALUE);
            tblue.setText(DEFAULT_TEXT_VALUE);
            talpha.setText(DEFAULT_TEXT_VALUE);
            colorpanel.setBackground(null);
        }
    }

    public void startUp() {
        this.setLayout(new GridLayout(2, 1));

        // set clear button event
        bclear.addActionListener(new buttonclear());
        // set compute button event
        bcompute.addActionListener(new buttoncompute());

        BG.setBackground(Color.white);

        BG.add(colorpanel);

        colorpanel.add(error);

        inputpanel.add(lred);
        inputpanel.add(tred);
        inputpanel.add(lgreen);
        inputpanel.add(tgreen);
        inputpanel.add(lblue);
        inputpanel.add(tblue);
        inputpanel.add(lalpha);
        inputpanel.add(talpha);
        inputpanel.add(bcompute);
        inputpanel.add(bclear);

        this.add(inputpanel);
        this.add(BG);

        this.pack();
        this.setVisible(true);
    }
    // class buttonF implements ActionListener{

    // @Override
    // public void actionPerformed(ActionEvent e){
    // if(e.getSource() == bcompute){
    // int red = Integer.parseInt(tred.getText());
    // int green = Integer.parseInt(tgreen.getText());
    // int blue = Integer.parseInt(tblue.getText());
    // int alpha = Integer.parseInt(talpha.getText());

    // }else if(e.getSource() == bclear){
    // tred.setText(DEFAULT_TEXT_VALUE);
    // tgreen.setText(DEFAULT_TEXT_VALUE);
    // tblue.setText(DEFAULT_TEXT_VALUE);
    // talpha.setText(DEFAULT_TEXT_VALUE);
    // colorpanel.setBackground(null);

    // }

    // }

    // }

    public static void main(String[] args) {
        ModuleAssignment10 m = new ModuleAssignment10();
        m.startUp();
    }

}