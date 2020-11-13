package calculator;



import java.awt.Font;
import java.util.Arrays;

import javax.swing.JLabel;

/**
 * @author ahmed
 *
 */
public class Calculator {

	boolean isOn = false;

	int currentOperator = 0;
	String result;
	boolean operatorPressed = false;

	public Calculator() {

	}

	/**
	 * @return the isOn
	 */
	public boolean isOn() {
		return isOn;
	}

	/**
	 * @param isOn the isOn to set
	 */
	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	/**
	 * @return the currentOperator
	 */
	public int getCurrentOperator() {
		return currentOperator;
	}

	/**
	 * @param currentOperator the currentOperator to set
	 */
	public void setCurrentOperator(int currentOperator) {
		this.currentOperator = currentOperator;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @return the operatorPressed
	 */
	public boolean isOperatorPressed() {
		return operatorPressed;
	}

	/**
	 * @param operatorPressed the operatorPressed to set
	 */
	public void setOperatorPressed(boolean operatorPressed) {
		this.operatorPressed = operatorPressed;
	}

	public void operation(JLabel calcul_display, int newOperator) {
		operatorPressed = true;
		System.out.println(currentOperator);
		switch (currentOperator) {
		case 0: {
			resume(calcul_display, newOperator);
			break;
		}
		case 1: {
			addition(calcul_display, newOperator);
			break;
		}
		case 2: {
			subtraction(calcul_display, newOperator);
			break;
		}
		case 3: {
			multiplication(calcul_display, newOperator);
			break;
		}
		case 4: {
			division(calcul_display, newOperator);
			break;
		}
		default:
			System.out.println("error");
		}
	}

	public void resume(JLabel calcul_display, int newOperator) {

		System.out.println(result + "0 debut");

		result = "" + Double.parseDouble(calcul_display.getText());

		System.out.println(result);
		cheickType(calcul_display, newOperator);

		System.out.println(result + "0 fin");
	}

	public void addition(JLabel calcul_display, int newOperator) {

		System.out.println(result + "1");
		Double d = Double.parseDouble(result) + Double.parseDouble(calcul_display.getText());
		result = "" + d;

		cheickType(calcul_display, newOperator);
	}

	public void subtraction(JLabel calcul_display, int newOperator) {

		Double d = Double.parseDouble(result) - Double.parseDouble(calcul_display.getText());
		result = "" + d;
		cheickType(calcul_display, newOperator);
	}

	public void division(JLabel calcul_display, int newOperator) {

		Double d = Double.parseDouble(result) / Double.parseDouble(calcul_display.getText());
		result = "" + d;

		calcul_display.setFont(new Font("Tahoma", Font.BOLD, 26));
		cheickType(calcul_display, newOperator);
	}

	public void multiplication(JLabel calcul_display, int newOperator) {

		Double d = Double.parseDouble(result) * Double.parseDouble(calcul_display.getText());
		result = "" + d;

		cheickType(calcul_display, newOperator);
	}

	public void cheickType(JLabel calcul_display, int newOperator) {

		String value = result.replace(".", ",");
		String[] arrOfStr = value.split(",");
		System.out.println(Arrays.toString(arrOfStr));
		try {
			if (arrOfStr[1].equals("0")) {
				result = arrOfStr[0];
			}
			changeCurrentOpe(newOperator);
		} catch (ArrayIndexOutOfBoundsException e) {
			calcul_display.setFont(new Font("Tahoma", Font.BOLD, 18));
			result = "Nous ne pouvons pas diviser par zéro";
			currentOperator = 0;

		}

		calcul_display.setText(result);

	}
	
	public void cheickTypeMonoOperator(JLabel calcul_display,int operator) {
		
		if (!calcul_display.getText().isEmpty()) {
			Double d =null;
			if(operator==1) {
				d = Math.sqrt(Double.parseDouble(calcul_display.getText()));
			}
			
			if(operator==2) {
				d = Double.parseDouble(calcul_display.getText()) / 100;
			}
			
			String newValue = ""+d;
			String value = newValue.replace(".", ",");
			String[] arrOfStr = value.split(",");
			System.out.println(Arrays.toString(arrOfStr));
			try {
				calcul_display.setText(newValue);
				if (arrOfStr[1].equals("0")) {
					
					calcul_display.setText(arrOfStr[0]);
				}
				
			} catch (ArrayIndexOutOfBoundsException f) {
				calcul_display.setFont(new Font("Tahoma", Font.BOLD, 18));
				calcul_display.setText("erreur");
				currentOperator = 0;

			}
			
			
		}
		
	}

	public void changeCurrentOpe(int newOperator) {

		currentOperator = newOperator;

	}
	
	public void addNumber(JLabel calcul_display, String number) {
		if (isOn()) {
			if (calcul_display.getText().equals("0")) {
				calcul_display.setText("");
			}

			String value = number;
			if (!isOperatorPressed()) {

				value = calcul_display.getText() + number;
			}
			setOperatorPressed(false);
			calcul_display.setText(value);
		}
	}
	
	public void doOperation(JLabel calcul_display, int newOperator) {
		if (isOn()) {
			if (!result.equals("") || !calcul_display.getText().isEmpty()) {

				if (!isOperatorPressed()) {
					operation(calcul_display, newOperator);
				} else {
					currentOperator = newOperator;
				}
			}

		}
	}
	
	public void addSigne(JLabel calcul_display) {
		if (isOn()) {
			String value = calcul_display.getText();
			if (calcul_display.getText().indexOf('-') == -1) {
				value = "-";
				if (!isOperatorPressed()) {

					value = "-" + calcul_display.getText();
				}

			} else {
				value = "-";
				if (!isOperatorPressed()) {

					value = calcul_display.getText().replace("-", "");
				}

			}
			setOperatorPressed(false);
			calcul_display.setText(value);
		}
	}
	
	public void addDot(JLabel calcul_display) {
		if (isOn()) {

			if (isOperatorPressed()) {

				calcul_display.setText("");
			}

			String value = calcul_display.getText();
			if (calcul_display.getText().indexOf('.') == -1) {
				value = calcul_display.getText() + ".";
				if (calcul_display.getText().isEmpty()) {
					value = "0" + ".";
				}

				if (isOperatorPressed()) {

					value = "0.";
				}
			}
			setOperatorPressed(false);
			calcul_display.setText(value);
		}
	}

}
