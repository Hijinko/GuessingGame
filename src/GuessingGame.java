import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		int guess = Integer.parseInt(guessText);
		if (guess < theNumber) {
			message = guess + " is too low, try again.";
		}
		else if (guess > theNumber) {
			message = guess + " is too high, try agian.";
		}
		else {
			message = guess + " is correct. You win!";
		}
		lblOutput.setText(message);
	}
	
	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);
	}
	
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setType(Type.UTILITY);
		setTitle("Hijinko's HiLo Guessing Game");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hijinko's Hi-Lo Guessing Game");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 75, 538, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Guess a number betwee 1 and 100");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(55, 173, 242, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtGuess = new JTextField();
		txtGuess.setBounds(321, 170, 64, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setFont(new Font("Arial", Font.BOLD, 12));
		btnGuess.setBounds(223, 262, 91, 23);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setFont(new Font("Arial", Font.BOLD, 12));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(0, 360, 538, 14);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(550,450));
		theGame.setVisible(true);
	}
}
