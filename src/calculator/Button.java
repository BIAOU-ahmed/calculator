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
//		if(value.equals("+")) {
//			operator=1;
//		}
//		if(value.equals("-")) {
//			operator=2;
//		}
//		if(value.equals("X")) {
//			operator=3;
//		}
//		if(value.equals("\u00F7")) {
//			operator=4;
//		}
//		if(value.equals("=")) {
//			operator=0;
//		}

		operator = operand;
		if (x == 259 && y == 218) {
//			System.out.println("in plus");
			size = 123;
		}

		this.panel_calcul = panel_calcul;
		this.calculate = calculate;
//		System.out.println(command);
		this.calcul_display = calcul_display;
		btnNewButton = new JButton(value);
		choice = command;
//		btnNewButton.setSize(80, 80);
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

//	@Override
//	public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub

//		System.out.println("command " + choice);
//		if (choice.equals("0")) {
////			if (calculate.isOn()) {
////				if (calculate.isValueInMemorie) {
////					calcul_display.setText("" + calculate.memorieValue);
////					System.out.println(calculate.memorieValue);
////				}
////
////			}
//			calculate.displayMemorieValu(calcul_display);
//		}
//		if (choice.equals("1")) {
////			if (calculate.isOn) {
////				calculate.memorieValue += Double.parseDouble(calcul_display.getText());
////				calculate.isValueInMemorie = true;
////				System.out.println(calculate.memorieValue);
////			}
//			
//			calculate.addMemorieValu(calcul_display);
//		}
//		if (choice.equals("2")) {
////			if (calculate.isOn) {
////				calculate.memorieValue -= Double.parseDouble(calcul_display.getText());
////				calculate.isValueInMemorie = true;
////				System.out.println(calculate.memorieValue);
////			}
//			calculate.substractMemorieValu(calcul_display);
//		}
//		if (choice.equals("3")) {
//			calcul_display.setText("");
//
//		}
//		if (choice.equals("4")) {
//			
//		}
//		if(choice.equals("5")) {
//			calculate.addNumber(calcul_display, btnNewButton.getText());
//		}
//		if(choice.equals("6")) {
//			calculate.cheickTypeMonoOperator(calcul_display,operator);
//		}
//		if(choice.equals("7")) {
//			calculate.doOperation(calcul_display, operator);
//		}
//		if (choice.equals("8")) {
//			calculate.addDot(calcul_display);
//		}
//		if (choice.equals("9")) {
//			calculate.addSigne(calcul_display);
//		}
//		calcul_display.setText(calcul_display.getText()+ btnNewButton.getText());
//		System.out.println(btnNewButton.getText());

//	}

//	@Override
//	public void keyTyped(KeyEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void keyPressed(KeyEvent e) {
//		// TODO Auto-generated method stub
//
//		int key = e.getKeyCode();
//		String number = "" + e.getKeyChar();
//
//		System.out.println(number);
//		if (key == KeyEvent.VK_0 || key == KeyEvent.VK_NUMPAD0 || key == KeyEvent.VK_1 || key == KeyEvent.VK_NUMPAD1
//				|| key == KeyEvent.VK_2 || key == KeyEvent.VK_NUMPAD2 || key == KeyEvent.VK_3
//				|| key == KeyEvent.VK_NUMPAD3 || key == KeyEvent.VK_4 || key == KeyEvent.VK_NUMPAD4
//				|| key == KeyEvent.VK_5 || key == KeyEvent.VK_NUMPAD5 || key == KeyEvent.VK_6
//				|| key == KeyEvent.VK_NUMPAD6 || key == KeyEvent.VK_8 || key == KeyEvent.VK_NUMPAD7
//				|| key == KeyEvent.VK_7 || key == KeyEvent.VK_NUMPAD8 || key == KeyEvent.VK_9
//				|| key == KeyEvent.VK_NUMPAD9) {
//
//			try {
//
//				if (Integer.parseInt(number) >= 0 || Integer.parseInt(number) <= 9) {
//					calculate.addNumber(calcul_display, number);
////					btnNewButton.doClick();
//
//				}
//
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//
//		}
//
//	}
//
//	@Override
//	public void keyReleased(KeyEvent e) {
//		// TODO Auto-generated method stub
//
//	}

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
