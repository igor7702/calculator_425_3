import javax.swing.*;

public class CalculatorFrame extends JFrame {
    CalculatorFrame() {
        int w = 300, h = 240;
        setTitle("Калькулятор");
        setBounds(100, 100, w, h);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        CalcPanel panel = new CalcPanel(w, h);
        add(panel);
        setResizable(false);
        setVisible(true);
    }
}
