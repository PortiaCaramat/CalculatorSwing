import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Output extends JFrame implements ActionListener {

    //for button to be able to be accessed globally
    JButton button;
    public Output(String name, double num1, double num2, String operator) {
        button = new JButton();

        //for frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //function that makes the exit button close the program
        this.setSize(500, 500); //sets the size of the GUI
        this.setLayout(null); //is set null to manually place elements on the GUI
        this.setResizable(false); //prevents window from being resized by the user
        this.setLocationRelativeTo(null); //displays at center of screen

        double answer = 0; //initialize variable

        //calculator
        switch (operator){
            case "+":
                answer = num1 + num2;
                break;
            case "-":
                answer = num1 - num2;
                break;
            case "*":
                answer = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    answer = num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(this, "Error: Division by zero", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                break;
        }

        String resultMessage ="Hello " + name + "! The result of " + num1 + " " + operator + " " + num2 + " is: " + answer; //creates a String that shows the result and name
        JLabel resultLabel = new JLabel(resultMessage); //create label class for displaying the resultMessage String
        resultLabel.setBounds(0,0,400,100); //sets the size for the resultLabel
        add(resultLabel); //add the Label to the GUI


        //for Button GUI
        button.setText("Exit Program"); //sets the text inside the button
        button.setBounds(250, 400, 200, 50);
        button.setFocusable(false); //removes box that surrounds the text of the button
        add(button); //adds the button
        button.addActionListener(this);

        setVisible(true); //displays the GUI
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.exit(0);//exits the program

        }
    }
}
