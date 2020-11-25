/**
 * 
 */
package calculator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author ahmed
 *
 */
public class Button {

	JButton btnNewButton;
	JLabel calcul_display;
	Calculator calculate;
	String choice;
	int size = 55;
	int operator;
	JPanel panel_calcul;

	/**
	 * Constructor for the class
	 * 
	 * @param panel_calcul
	 * @param calculate
	 * @param calcul_display
	 * @param panel_2
	 * @param value
	 * @param command
	 * @param operand
	 * @param x
	 * @param y
	 */
	public Button(JPanel panel_calcul, Calculator calculate, JLabel calcul_display, JPanel panel_2, String value,
			String command, int operand, int x, int y) {

		operator = operand;
		// if the button is for the plus operand we change his size
		if (x == 259 && y == 218) {

			size = 123;
		}

		this.panel_calcul = panel_calcul;
		this.calculate = calculate;

		this.calcul_display = calcul_display;
		btnNewButton = new JButton(value);
		choice = command;

		btnNewButton.setActionCommand(value);
		btnNewButton.setBounds(x, y, 73, size);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		if (value.equals("ON-C")) {
			btnNewButton.setBackground(Color.RED);
		}

		// add listener in according of the type of button
		if (command.equals("2")) {
			btnNewButton.addActionListener(new NumberListener());
		} else if (command.equals("4")) {
			btnNewButton.addActionListener(new OperandListener());
		} else if (command.equals("3")) {
			btnNewButton.addActionListener(new MonoOperandListener());
		} else if (command.equals("0")) {
			btnNewButton.addActionListener(new MemoryListener());
		} else if (command.equals("1")) {
			btnNewButton.addActionListener(new ResetOnListener());
		} else if (command.equals("5")) {
			btnNewButton.addActionListener(new DotListener());
		} else if (command.equals("6")) {
			btnNewButton.addActionListener(new SignListener());
		}
		panel_2.add(btnNewButton);
	}

	/**
	 * @return the btnNewButton
	 */
	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	/**
	 * @param btnNewButton the btnNewButton to set
	 */
	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	/**
	 * listener for numbers
	 * 
	 * @author ahmed
	 *
	 */
	class NumberListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			calculate.addNumber(calcul_display, btnNewButton.getText());
			calcul_display.requestFocus();

		}

	}

	/**
	 * listener for operand
	 * 
	 * @author ahmed
	 *
	 */
	class OperandListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			

			calculate.doOperation(calcul_display, operator);

			if (!btnNewButton.getText().equals("=")) {
				calculate.number = 0;
			}

			calcul_display.requestFocus();

		}

	}

	/**
	 * listener for mono operand
	 * 
	 * @author ahmed
	 *
	 */
	class MonoOperandListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			calculate.cheickTypeMonoOperator(calcul_display, operator);
			calcul_display.requestFocus();

		}

	}

	/**
	 * listener for memories
	 * 
	 * @author ahmed
	 *
	 */
	class MemoryListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		
			
			calculate.memoryValue(calcul_display, operator);
			calcul_display.requestFocus();

		}

	}

	/**
	 * listener for reset and on buttons
	 * 
	 * @author ahmed
	 *
	 */
	class ResetOnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		
			
			calculate.resetOn(calcul_display, panel_calcul, operator);
			calcul_display.requestFocus();

		}

	}

	/**
	 * listener for dot
	 * 
	 * @author ahmed
	 *
	 */
	class DotListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			calculate.addDot(calcul_display);
			calcul_display.requestFocus();

		}

	}

	/**
	 * listener for sign
	 * 
	 * @author ahmed
	 *
	 */
	class SignListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		
			
			calculate.addSigne(calcul_display);
			calcul_display.requestFocus();

		}

	}
}
