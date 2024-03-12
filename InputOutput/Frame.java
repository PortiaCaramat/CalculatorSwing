import javax.swing.*;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class Frame extends JFrame implements ActionListener { /* We extend the JFrame class in both the Frame and Output classes.
     This is done to create custom window frames that can display user interface components and handle user interactions,
     without cluttering the main window with additional components. It also provides a clear separation of uses,
     where the Frame window handles user input, and the Output window displays the output.
     The ActionListener event is used to check on what the button does when it is clicked. */

    //for button to be able to be accessed globally
    JButton button;

    //textfields for each variable
    //The JTextField is method is used for asking the user in entering inputs in the GUI
    JTextField nameField;
    JTextField firstNum;
    JTextField secondNum;
    JTextField operatorField;

    public Frame() {

        button = new JButton(); //create button class

        //for Frame GUI
        this.setTitle("Basic Input and Output Program"); //Title of the program that is seen in the tab.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //function that makes the exit button close the program
        this.setSize(500, 500); //sets the size of the GUI
        this.setLayout(null); //is set null to manually place elements on the GUI
        setLocationRelativeTo(null); //displays at center of screen
        this.setResizable(false); //prevents window from being resized by the user


        //create labels
        JLabel nameLabel = new JLabel("Input your name:"); //The text that is used by the label
        nameLabel.setBounds(10, 10, 150, 25); //set space that occupies the JLabel
        add(nameLabel); //makes JLabel visible

        JLabel num1Label = new JLabel("Input first number:");
        num1Label.setBounds(10, 40, 150, 25); //set space that occupies the JLabel
        add(num1Label); //makes JLabel visible

        JLabel num2Label = new JLabel("Input second number:");
        num2Label.setBounds(10, 70, 150, 25); //set space that occupies the JLabel
        add(num2Label); //makes JLabel visible

        JLabel operatorLabel = new JLabel("Input operator (+, - , * , /):");
        operatorLabel.setBounds(10, 100, 150, 25); //set space that occupies the JLabel
        add(operatorLabel); //makes JLabel visible

        //for textfields
        nameField = new JTextField();
        nameField.setBounds(300, 10, 150, 25); //set space that occupies the JTextField
        add(nameField); //makes TextField visible

        firstNum = new JTextField();
        firstNum.setBounds(300, 40, 150, 25); //set space that occupies the JTextField
        add(firstNum); //makes TextField visible

        secondNum = new JTextField();
        secondNum.setBounds(300, 70, 150, 25); //set space that occupies the JTextField
        add(secondNum); //makes TextField visible

        operatorField = new JTextField();
        operatorField.setBounds(300, 100, 150, 25); //set space that occupies the JTextField
        add(operatorField); //makes TextField visible

        //for Button GUI
        button.setText("Compute ->"); //sets the text inside the button
        button.setBounds(250, 400, 200, 50);
        button.setFocusable(false); //removes box that surrounds the text of the button
        button.addActionListener(this);
        add(button); //adds the button

        setVisible(true); //makes GUI visible
    }

    //action on what the button will do after being pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        obtainedInputs();
        /*if(e.getSource()==button){
            this.dispose(); //prevents multiple Calculate windows from opening
        }*/
    }

    //gets the inputs from the 4 textfields
    public void obtainedInputs() {
        String name = nameField.getText();
        double num1, num2;
        String operator;

        try {   //checker for when an invalid number is entered
            num1 = Double.parseDouble(firstNum.getText());
            num2 = Double.parseDouble(secondNum.getText());
            operator = operatorField.getText();

            if(!isValidOperator(operator)){ //checks if the operator is valid
                JOptionPane.showMessageDialog(this, "Invalid operator", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Output output = new Output(name, num1, num2, operator); //passes the 4 values to the Output class
            output.setVisible(true); //displays the GUI of the Output class

        } catch (NumberFormatException a) { //pops up a message dialogue when an invalid number is entered
            JOptionPane.showMessageDialog(this, "Invalid input for numbers", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private boolean isValidOperator(String operator){ //valid operator checker
        return operator.equals("+") || operator.equals("-")|| operator.equals("*")||operator.equals("/");
    }
}
