import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnAction implements ActionListener {
    public JTextField TxtFld;
    private boolean start;
    private boolean point;
    private String cmd;
    private double result;

    BtnAction(JTextField TxtFld) {
        this.TxtFld = TxtFld;
        onStart();
    }

    private void onStart() {
        start = true;
        point = true;
        cmd = "C";
        result = 0;
        TxtFld.setText("0.0");
    }

    private void calc() {
        double x;
        x = Double.parseDouble(TxtFld.getText());
        if (cmd.equals("*")) result *= x;
        else if (cmd.equals("/")) result /= x;
        else if (cmd.equals("-")) result -= x;
        else if (cmd.equals("+")) result += x;
        else result = x;
        TxtFld.setText(Double.toString(result));
    }

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();
        if (str.equals("C")) {
            onStart();
            return;
        }
        if (str.equals("+") | str.equals("-") | str.equals("*") | str.equals("/")
                | str.equals("=")) {
            calc();
            cmd = str;
            start = true;
            point = true;
            return;
        }
        if (start) {
            if (str.equals(".")) {
                TxtFld.setText("0.");
                point = false;
                start = false;
                return;
            } else {
                TxtFld.setText(str);
                start = false;
                return;
            }
        } else {
            if (str.equals(".")) {
                str = point ? str : "";
                point = false;
            }
            if (TxtFld.getText().equals("0") & !str.equals(".")) {
                TxtFld.setText(str);
            } else {
                TxtFld.setText(TxtFld.getText() + str);
            }
        }
    }
}
