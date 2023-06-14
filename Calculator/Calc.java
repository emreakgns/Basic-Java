import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calc extends JFrame implements ActionListener {
    private JTextField textField;
    private double firstNumber;
    private String operator;
    private boolean isOperatorClicked;

    public Calc() {
        // We define our title and some properties
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(300, 400);

        JPanel panel = new JPanel(); // we create a panel because we add our buttons on panel
        panel.setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        textField.setPreferredSize(new Dimension(300, 60)); // set the size of text area
        textField.setFont(new Font("Arial", Font.BOLD, 25));
        panel.add(textField, BorderLayout.NORTH); // Our text area is located on the top

        JPanel buttonPanel = new JPanel(); // Our button panel
        buttonPanel.setLayout(new GridLayout(4, 4)); // in each row and each column has 4 button
        

        String[] buttonLabels = {"7", "8", "9", "/",
                                 "4", "5", "6", "*",
                                 "1", "2", "3", "-",
                                 "0", "C", "=", "+"};  // button list

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            buttonPanel.add(button);
        }
        // we assigned an actionlistener to each button

        panel.add(buttonPanel, BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("[0-9]")) {
            if (isOperatorClicked) {
                textField.setText("");
                isOperatorClicked = false;
            } 
            textField.setText(textField.getText() + command); // displays each digit when pressed, appending it to its right
        } else if (command.equals("C")) {
            textField.setText("");  // when user clicked the button 'C' clear the textfield
        } else if (command.equals("=")) {
            calculateResult(); 
            isOperatorClicked = false;  // if user click the = button it call the calculateResult and calculate the reslut
        } else {
            operator = command;
            firstNumber = Double.parseDouble(textField.getText());
            isOperatorClicked = true;
        }
    }
    // its the calculating part
    public void calculateResult() {
        double secondNumber = Double.parseDouble(textField.getText());
        double result = 0;

        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    textField.setText("Geçersiz ifade");
                    return;
                }
                break;
        }

        textField.setText(Double.toString(result));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calc();
            }
        });
    }
}
