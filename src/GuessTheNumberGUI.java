import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GuessTheNumberGUI extends JFrame {
    private int numberToGuess;
    private int attempts = 0;
    private JTextField inputField;
    private JLabel messageLabel;

    public GuessTheNumberGUI() {
        // Frame setup
        setTitle("Number Guessing Game");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Generate random number
        numberToGuess = new Random().nextInt(100) + 1;

        // GUI Components
        JLabel titleLabel = new JLabel("🎯 Guess a number between 1 and 100");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        inputField = new JTextField(10);
        JButton guessButton = new JButton("Guess");
        messageLabel = new JLabel("Enter your guess above and click 'Guess'.");

        // Add action listener
        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleGuess();
            }
        });

        // Add components
        add(titleLabel);
        add(inputField);
        add(guessButton);
        add(messageLabel);

        setLocationRelativeTo(null); // Center window
        setVisible(true);
    }

    private void handleGuess() {
        try {
            int guess = Integer.parseInt(inputField.getText());
            attempts++;

            if (guess < numberToGuess) {
                messageLabel.setText("Too low! Try again.");
            } else if (guess > numberToGuess) {
                messageLabel.setText("Too high! Try again.");
            } else {
                messageLabel.setText("🎉 Correct! Attempts: " + attempts);
                inputField.setEditable(false);
            }
        } catch (NumberFormatException ex) {
            messageLabel.setText("Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        new GuessTheNumberGUI();
    }
}
