package calculator;

import java.awt.Font;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 * @author ahmed
 *
 */
public class Calculator {

	boolean isOn = false;

	int currentOperator = 0;
//	int newMemoriesOperator = 0;
	String result = "0";
	boolean operatorPressed = false;
	double memorieValue = 0;
	boolean isValueInMemorie = false;
	double number = 0;
	boolean equalPressed = false;
	boolean specialEqualPressed = false;

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

	/**
	 * @return the memorieValue
	 */
	public double getMemorieValue() {
		return memorieValue;
	}

	/**
	 * @param memorieValue the memorieValue to set
	 */
	public void setMemorieValue(double memorieValue) {
		this.memorieValue = memorieValue;
	}

	/**
	 * @return the isValueInMemorie
	 */
	public boolean isValueInMemorie() {
		return isValueInMemorie;
	}

	/**
	 * @param isValueInMemorie the isValueInMemorie to set
	 */
	public void setValueInMemorie(boolean isValueInMemorie) {
		this.isValueInMemorie = isValueInMemorie;
	}

	/**
	 * @return the number
	 */
	public double getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(double number) {
		this.number = number;
	}

	/**
	 * @return the equalPressed
	 */
	public boolean isEqualPressed() {
		return equalPressed;
	}

	/**
	 * @param equalPressed the equalPressed to set
	 */
	public void setEqualPressed(boolean equalPressed) {
		this.equalPressed = equalPressed;
	}

	public void operation(JLabel calcul_display, int newOperator) {

		if (newOperator != 0) {
			setOperatorPressed(true);

		}

		System.out.println("current result " + result);
		System.out.println(currentOperator);
		Double d = (double) 0;
		if (currentOperator != 0) {
			d = Double.parseDouble(result);
		}
		System.out.println("zqual pressed " + equalPressed + " and operator pressed " + operatorPressed);

		
		System.out.println("number beffor change " + number);
		System.out.println("special equals "+specialEqualPressed);
		if(specialEqualPressed) {
			equalPressed=true;
			result=calcul_display.getText();
			d = Double.parseDouble(result);
			specialEqualPressed=false;
		}
		if (!equalPressed) {

			try {
				System.out.println("in equals");
				number = Double.parseDouble(calcul_display.getText());
				equalPressed = false;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
//		System.out.println("number inter change " + number);
//		if (!equalPressed &&currentOperator!=0&& newOperator==0) {
//			System.out.println("changement");
//			String intvalue = "" + number;
//			number = Double.parseDouble(result);
//			result = intvalue;
//
//		}
		System.out.println("number afetr change " + number);
		if (equalPressed && operatorPressed) {
			System.out.println("inr ");
			number = Double.parseDouble(calcul_display.getText());
			currentOperator = 0;
		}

		if (newOperator == 0) {

			equalPressed = true;

		} else {
			equalPressed = false;
		}

		System.out.println("resultat " + result + " number " + number + " et new operateur " + newOperator
				+ " et current est " + currentOperator);
		switch (currentOperator) {
		case 0: {
			d = number;

			break;
		}
		case 1: {
			d += number;
			break;
		}
		case 2: {
			d -= number;
			break;
		}
		case 3: {
			d *= number;
			break;
		}
		case 4: {
			d /= number;
			break;
		}
		default:
			System.out.println("error");
		}
		System.out.println("resultat " + result + " number " + number + " et new operateur " + newOperator
				+ " et current est " + currentOperator);
//		if (equalPressed && !operatorPressed) {
//			if (!result.isEmpty()) {
//				System.out.println("change number");
//				number = Double.parseDouble(result);
//			}
//
//		}

		result = "" + d;

		cheickType(calcul_display, newOperator);

	}

	public void cheickType(JLabel calcul_display, int newOperator) {

		try {

			result = makeInt(result);
			calcul_display.setText(result);
			changeCurrentOpe(newOperator);
		} catch (ArrayIndexOutOfBoundsException e) {
			calcul_display.setFont(new Font("Tahoma", Font.BOLD, 18));
			result = "0";
			calcul_display.setText("Nous ne pouvons pas diviser par zéro");
			currentOperator = 0;
			setOperatorPressed(true);

		}

	}

	public void cheickTypeMonoOperator(JLabel calcul_display, int operator) {

		if (!calcul_display.getText().isEmpty()) {

			if (!isOperatorPressed() || getCurrentOperator() == 0) {
				Double d = null;
				if (operator == 1) {
					d = Math.sqrt(Double.parseDouble(calcul_display.getText()));

				}

				if (operator == 2) {
					d = Double.parseDouble(calcul_display.getText()) / 100;

				}

				if (equalPressed) {

					result = "" + d;

				} else {
					number = d;
				}
				String newValue = "" + d;

				try {
					calcul_display.setText(makeInt(newValue));

				} catch (ArrayIndexOutOfBoundsException f) {
					calcul_display.setFont(new Font("Tahoma", Font.BOLD, 18));

					setOperatorPressed(true);
					currentOperator = 0;
					calcul_display.setText("Entrée non valide");

				}

			}

		}

	}

	public String makeInt(String number) {

		String value = number.replace(".", ",");
		String[] arrOfStr = value.split(",");
		System.out.println(Arrays.toString(arrOfStr));
		if (arrOfStr[1].equals("0")) {

			number = arrOfStr[0];
		}

		return number;
	}

	public void changeCurrentOpe(int newOperator) {

		if (newOperator != 0) {

			currentOperator = newOperator;
		}

	}

	public void addNumber(JLabel calcul_display, String numberAdd) {
		if (isOn()) {
			if (calcul_display.getText().equals("0") || equalPressed) {
				calcul_display.setText("");
				if (!equalPressed) {
					number = 0;
					specialEqualPressed=false;
				}else {
					specialEqualPressed=true;
					System.out.println("in the not");
				}
				result = "0";
//				currentOperator = 0;
			}

			String value = numberAdd;
			if (!isOperatorPressed()) {

				value = calcul_display.getText() + numberAdd;
			}
			setOperatorPressed(false);
			setEqualPressed(false);
			calcul_display.setText(value);
		}
	}

	public void doOperation(JLabel calcul_display, int newOperator) {
		if (isOn()) {
			if (!result.equals("") || !calcul_display.getText().isEmpty()) {

				if (!isOperatorPressed()) {

					operation(calcul_display, newOperator);

				} else {

					if (newOperator == 0) {
						operation(calcul_display, currentOperator);
						setEqualPressed(true);
						setOperatorPressed(false);

					} else {
						currentOperator = newOperator;
					}

				}
				specialEqualPressed=false;
			}

		}
	}

	public void addSigne(JLabel calcul_display) {
		if (isOn()) {
			if (isEqualPressed()) {

				result = "0";
			}
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
			setEqualPressed(false);
			setOperatorPressed(false);
			calcul_display.setText(value);
		}
	}

	public void addDot(JLabel calcul_display) {
		if (isOn()) {

			if (isOperatorPressed() || isEqualPressed()) {

				calcul_display.setText("");
			}

			String value = calcul_display.getText();
			if (calcul_display.getText().indexOf('.') == -1) {
				value = calcul_display.getText() + ".";
				if (calcul_display.getText().isEmpty()) {
					value = "0.";
				}

				if (isOperatorPressed()) {

					value = "0.";
				}
			}
			setOperatorPressed(false);
			setEqualPressed(false);
			calcul_display.setText(value);
		}
	}

	public void memorieValue(JLabel calcul_display, int action) {
		if (isOn()) {
			switch (action) {
			case 0: {

				if (isValueInMemorie) {
					calcul_display.setText(makeInt("" + memorieValue));
					setOperatorPressed(false);
					number = memorieValue;
					System.out.println(memorieValue);
				}
				break;
			}
			case 1: {
				memorieValue += Double.parseDouble(calcul_display.getText());
				isValueInMemorie = true;
				System.out.println(memorieValue);
				break;
			}
			case 2: {
				memorieValue -= Double.parseDouble(calcul_display.getText());
				isValueInMemorie = true;
				if (memorieValue == 0) {
					isValueInMemorie = false;
				}
				System.out.println(memorieValue);
				break;
			}
			default:
				System.out.println("erreur");
			}

		}
	}

	public void resetOn(JLabel calcul_display, JPanel panel_calcul, int action) {

		if (!isOn()) {
			setOn(true);
			// display_panel.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
			panel_calcul.setBackground(UIManager.getColor("Table.selectionBackground"));
		}
		if (isOn()) {
			calcul_display.setText("");
		}
		if (action == 1) {
			equalPressed=false;
			setResult("");
			setCurrentOperator(0);
		}
	}

}
