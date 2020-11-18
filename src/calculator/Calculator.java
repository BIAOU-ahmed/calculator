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
	String result="0";
	boolean operatorPressed = false;
	double memorieValue = 0;
	boolean isValueInMemorie = false;
	
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
		Double d=(double) 0;
		if(currentOperator!=0) {
			d = Double.parseDouble(result);
		}
		
		
		double number = 0;
		try {
			number = Double.parseDouble(calcul_display.getText());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		switch (currentOperator) {
		case 0: {
			d =  Double.parseDouble(calcul_display.getText());
			break;
		}
		case 1: {
			d += number;
			break;
		}
		case 2: {
			 d -=  number;
			break;
		}
		case 3: {
			d *=number;
			break;
		}
		case 4: {
			 d /=number;
			break;
		}
		default:
			System.out.println("error");
		}
		
		result = "" + d;
		cheickType(calcul_display, newOperator);
	}

//	public void resume(JLabel calcul_display, int newOperator) {
//
//		System.out.println(result + "0 debut");
//
//		result = "" + Double.parseDouble(calcul_display.getText());
//
//		System.out.println(result);
//		cheickType(calcul_display, newOperator);
//
//		System.out.println(result + "0 fin");
//	}
//
//	public void addition(JLabel calcul_display, int newOperator) {
//
//		System.out.println(result + "1");
//		double number = 0;
//		try {
//			number = Double.parseDouble(calcul_display.getText());
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		Double d = Double.parseDouble(result) + number;
//		result = "" + d;
//
//		cheickType(calcul_display, newOperator);
//	}
//
//	public void subtraction(JLabel calcul_display, int newOperator) {
//		double number = 0;
//		try {
//			number = Double.parseDouble(calcul_display.getText());
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		Double d = Double.parseDouble(result) - number;
//		result = "" + d;
//		cheickType(calcul_display, newOperator);
//	}
//
//	public void division(JLabel calcul_display, int newOperator) {
//
//		double number = 0;
//		try {
//			number = Double.parseDouble(calcul_display.getText());
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		Double d = Double.parseDouble(result) /number;
//		result = "" + d;
//
//		calcul_display.setFont(new Font("Tahoma", Font.BOLD, 26));
//		cheickType(calcul_display, newOperator);
//	}
//
//	public void multiplication(JLabel calcul_display, int newOperator) {
//
//		double number = 0;
//		try {
//			number = Double.parseDouble(calcul_display.getText());
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		Double d = Double.parseDouble(result) *number;
//		result = "" + d;
//
//		cheickType(calcul_display, newOperator);
//	}

	public void cheickType(JLabel calcul_display, int newOperator) {

		
		try {
			
			result = makeInt(result);
			calcul_display.setText(result);
			changeCurrentOpe(newOperator);
		} catch (ArrayIndexOutOfBoundsException e) {
			calcul_display.setFont(new Font("Tahoma", Font.BOLD, 18));
			result = "0";
			calcul_display.setText("Nous ne pouvons pas diviser par z�ro");
			currentOperator = 0;

		}

		
		

	}
	
	public void cheickTypeMonoOperator(JLabel calcul_display,int operator) {
		
		if (!calcul_display.getText().isEmpty()) {
			
			
			if(!isOperatorPressed()||getCurrentOperator()==0) {
				Double d =null;
				if(operator==1) {
					d = Math.sqrt(Double.parseDouble(calcul_display.getText()));
				}
				
				if(operator==2) {
					d = Double.parseDouble(calcul_display.getText()) / 100;
				}
				
				String newValue = ""+d;
				
				try {
					calcul_display.setText(makeInt(newValue));
					
					
				} catch (ArrayIndexOutOfBoundsException f) {
					calcul_display.setFont(new Font("Tahoma", Font.BOLD, 18));
					
					setOperatorPressed(true);
					currentOperator = 0;
					calcul_display.setText("Entr�e non valide");

				}
				
			}
		
			
			
			
			
		}
		
	}

	public String makeInt(String number) {
		
		String value = number.replace(".", ",");
		String[] arrOfStr = value.split(",");
		System.out.println(Arrays.toString(arrOfStr));
		if (arrOfStr[1].equals("0")) {
			
			number=arrOfStr[0];
		}
		
		return number;
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
					value = "0.";
				}

				if (isOperatorPressed()) {

					value = "0.";
				}
			}
			setOperatorPressed(false);
			calcul_display.setText(value);
		}
	}
	
	public void memorieValue(JLabel calcul_display,int action) {
		if (isOn()) {
			switch (action) {
			case 0: {
				
				if (isValueInMemorie) {
					calcul_display.setText(makeInt(""+memorieValue));
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
				System.out.println(memorieValue);
				break;
			}
			default:
				System.out.println("erreur");
			}
			

		}
	}
	
	public void resetOn(JLabel calcul_display,JPanel panel_calcul,int action) {
		
		if (!isOn()) {
			setOn(true);
			// display_panel.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
			panel_calcul.setBackground(UIManager.getColor("Table.selectionBackground"));
		}
		if (isOn()) {
			calcul_display.setText("");			
		}
		if(action==1) {
			setResult("");
			setCurrentOperator(0);
		}
	}
//	public void addMemorieValu(JLabel calcul_display) {
//		if (isOn()) {
//			memorieValue += Double.parseDouble(calcul_display.getText());
//			isValueInMemorie = true;
//			System.out.println(memorieValue);
//		}
//	}
//	public void substractMemorieValu(JLabel calcul_display) {
//		if (isOn) {
//			memorieValue -= Double.parseDouble(calcul_display.getText());
//			isValueInMemorie = true;
//			System.out.println(memorieValue);
//		}
//	}

}
