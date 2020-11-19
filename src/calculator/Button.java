/**
 * 
 */
package calculator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

	public Button(JPanel panel_calcul, Calculator calculate, JLabel calcul_display, JPanel panel_2, String value,
			String command, int operand, int x, int y) {
		// TODO Auto-generated constructor stub


		operator = operand;
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

		if (command.equals("2")) {
			btnNewButton.addActionListener(new ChiffreListener());
		} else if (command.equals("4")) {
			btnNewButton.addActionListener(new OperandListener());
		} else if (command.equals("3")) {
			btnNewButton.addActionListener(new MonoOperandListener());
		} else if (command.equals("0")) {
			btnNewButton.addActionListener(new Memories());
		} else if (command.equals("1")) {
			btnNewButton.addActionListener(new ResetOn());
		} else if (command.equals("5")) {
			btnNewButton.addActionListener(new Dot());
		} else if (command.equals("6")) {
			btnNewButton.addActionListener(new Signe());
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



	class ChiffreListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			calculate.addNumber(calcul_display, btnNewButton.getText());
			calcul_display.requestFocus();

		}

	}

	class OperandListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			calculate.doOperation(calcul_display, operator);
			
			if(!btnNewButton.getText().equals("=")) {
				calculate.number = 0;
			}
			
			
			calcul_display.requestFocus();

		}

	}

	class EqualsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			calculate.doOperation(calcul_display, calculate.getCurrentOperator());
			calcul_display.requestFocus();

		}

	}

	class MonoOperandListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			calculate.cheickTypeMonoOperator(calcul_display, operator);
			calcul_display.requestFocus();

		}

	}

	class Memories implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(operator + "opera");
			calculate.memorieValue(calcul_display, operator);
			calcul_display.requestFocus();

		}

	}

	class ResetOn implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(operator + "opera");
			calculate.resetOn(calcul_display, panel_calcul, operator);
			calcul_display.requestFocus();

		}

	}

	class Dot implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(operator + "opera");
			calculate.addDot(calcul_display);
			calcul_display.requestFocus();

		}

	}

	class Signe implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(operator + "opera");
			calculate.addSigne(calcul_display);
			calcul_display.requestFocus();

		}

	}
}
