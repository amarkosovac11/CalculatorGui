import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGui implements ActionListener
{
    JFrame frame;
    JTextField textField;
    JButton[] numButtons = new JButton[10];
    JButton[] funcButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, eqButton, delButton, clrButton, negButton;
    JPanel panel;

    Font myFont = new Font("Times New Roman", Font.BOLD, 30);
    
    double num1=0, num2=0, result=0;
    char operator;


    CalculatorGui()
    {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);


        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(",");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr"); 
        eqButton = new JButton("=");
        negButton = new JButton("(-)");

        funcButtons[0] = addButton;
        funcButtons[1] = subButton;
        funcButtons[2] = mulButton;
        funcButtons[3] = divButton;
        funcButtons[4] = decButton;
        funcButtons[5] = eqButton;
        funcButtons[6] = delButton;
        funcButtons[7] = clrButton;
        funcButtons[8] = negButton;


        for(int i = 0; i<9; i++)
        {
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(myFont);
            funcButtons[i].setFocusable(false);
        }

        for(int i = 0; i<10; i++)
        {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(myFont);
            numButtons[i].setFocusable(false);

        }

        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);


        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        
        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(addButton);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(subButton);
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numButtons[0]);
        panel.add(eqButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);


    }

    public static void main(String[] args) 
    {
        CalculatorGui calc = new CalculatorGui();    
    }
    public void actionPerformed(ActionEvent e)
    {
        for(int i = 0; i < 10; i++)
        {
            if(e.getSource() == numButtons[i])
            {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }  
        if(e.getSource() == decButton)
        {
            textField.setText(textField.getText().concat(String.valueOf(",")));
        }
        else if(e.getSource() == addButton)
        {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        else if(e.getSource() == subButton)
        {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        else if(e.getSource() == mulButton)
        {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        else if(e.getSource() == divButton)
        {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        else if(e.getSource() == eqButton)
        {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 /  num2;
                    break;
                default:
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        
        }
        else if(e.getSource() == clrButton)
        {
            textField.setText("");
        }
        else if(e.getSource() == delButton)
        {
            String string = textField.getText();
            textField.setText("");
            for(int i = 0; i<string.length()-1; i++)
            {
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        else if(e.getSource() == negButton)
        {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }    
}
