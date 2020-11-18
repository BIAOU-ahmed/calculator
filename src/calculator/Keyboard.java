/**
 * 
 */
package calculator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

/**
 * @author ahmed
 *
 */
public class Keyboard implements KeyListener {

	
	Button[] newButton;
//	Calculate calculate;
	public Keyboard(Button[] newButton) {
		// TODO Auto-generated constructor stub
		this.newButton = newButton;
//		this.calculate = calculate;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		 //TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		 //TODO Auto-generated method stub
		
		
		int key = e.getKeyCode();
		String number = "" + e.getKeyChar();

		System.out.println(number);
		System.out.println("key"+key);
		if (key == KeyEvent.VK_0 || key == KeyEvent.VK_NUMPAD0 || key == KeyEvent.VK_1 || key == KeyEvent.VK_NUMPAD1
				|| key == KeyEvent.VK_2 || key == KeyEvent.VK_NUMPAD2 || key == KeyEvent.VK_3
				|| key == KeyEvent.VK_NUMPAD3 || key == KeyEvent.VK_4 || key == KeyEvent.VK_NUMPAD4
				|| key == KeyEvent.VK_5 || key == KeyEvent.VK_NUMPAD5 || key == KeyEvent.VK_6
				|| key == KeyEvent.VK_NUMPAD6 || key == KeyEvent.VK_8 || key == KeyEvent.VK_NUMPAD7
				|| key == KeyEvent.VK_7 || key == KeyEvent.VK_NUMPAD8 || key == KeyEvent.VK_9
				|| key == KeyEvent.VK_NUMPAD9) {

				try {
					numberPressed(Integer.parseInt(number));
				
//				if (Integer.parseInt(number) == 0) {
////					calculate.addNumber(calcul_display, number);
////					btnNewButton.doClick();
//					newButton[20].getBtnNewButton().doClick();
//
//				}
//				if (Integer.parseInt(number) == 1) {
////					calculate.addNumber(calcul_display, number);
////					btnNewButton.doClick();
//					newButton[15].getBtnNewButton().doClick();
//
//				}
//				if (Integer.parseInt(number) == 2) {
////					calculate.addNumber(calcul_display, number);
////					btnNewButton.doClick();
//					newButton[16].getBtnNewButton().doClick();
//
//				}
//				if (Integer.parseInt(number) == 3) {
////					calculate.addNumber(calcul_display, number);
////					btnNewButton.doClick();
//					newButton[17].getBtnNewButton().doClick();
//
//				}
//				if (Integer.parseInt(number) == 4) {
////					calculate.addNumber(calcul_display, number);
////					btnNewButton.doClick();
//					newButton[10].getBtnNewButton().doClick();
//
//				}
//				if (Integer.parseInt(number) == 5) {
////					calculate.addNumber(calcul_display, number);
////					btnNewButton.doClick();
//					newButton[11].getBtnNewButton().doClick();
//
//				}
//				if (Integer.parseInt(number) == 6) {
////					calculate.addNumber(calcul_display, number);
////					btnNewButton.doClick();
//					newButton[12].getBtnNewButton().doClick();
//
//				}
//				if (Integer.parseInt(number) == 7) {
////					calculate.addNumber(calcul_display, number);
////					btnNewButton.doClick();
//					newButton[5].getBtnNewButton().doClick();
//
//				}
//				if (Integer.parseInt(number) == 8) {
////					calculate.addNumber(calcul_display, number);
////					btnNewButton.doClick();
//					newButton[6].getBtnNewButton().doClick();
//
//				}
//				if (Integer.parseInt(number) == 9) {
////					calculate.addNumber(calcul_display, number);
////					btnNewButton.doClick();
//					newButton[7].getBtnNewButton().doClick();
//
//				}
//
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}else {
			System.out.println(key + "et" + KeyEvent.VK_ADD);
			switch (key) {
			case KeyEvent.VK_ADD: {
//				calculate.doOperation(calcul_display, 1);
				newButton[18].getBtnNewButton().doClick();
				break;
			}
			case KeyEvent.VK_SUBTRACT: {
//				calculate.doOperation(calcul_display, 2);
				newButton[19].getBtnNewButton().doClick();
				break;
			}
			case KeyEvent.VK_MULTIPLY: {
//				calculate.doOperation(calcul_display, 3);
				newButton[13].getBtnNewButton().doClick();
				break;
			}
			case KeyEvent.VK_DIVIDE: {
//				calculate.doOperation(calcul_display, 4);
				newButton[14].getBtnNewButton().doClick();
				break;
			}
			case KeyEvent.VK_ENTER: {
//				calculate.doOperation(calcul_display, 0);
				newButton[23].getBtnNewButton().doClick();
				break;
			}
			case KeyEvent.VK_DECIMAL: {
//				calculate.addDot(calcul_display);
				newButton[21].getBtnNewButton().doClick();
				break;
			}
			default:

			}
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		 //TODO Auto-generated method stub
		
	}

	
	public void numberPressed(int number) {
		switch (number) {
		case 0:
			newButton[20].getBtnNewButton().doClick();
			break;
		case 1:
			newButton[15].getBtnNewButton().doClick();
			break;
		case 2:
			newButton[16].getBtnNewButton().doClick();
			break;
		case 3:
			newButton[17].getBtnNewButton().doClick();
			break;
		case 4:
			newButton[10].getBtnNewButton().doClick();
			break;
		case 5:
			newButton[11].getBtnNewButton().doClick();
			break;
		case 6:
			newButton[12].getBtnNewButton().doClick();
			break;
		case 7:
			newButton[5].getBtnNewButton().doClick();
			break;
		case 8:
			newButton[6].getBtnNewButton().doClick();
			break;
		case 9:
			newButton[7].getBtnNewButton().doClick();
			break;

		default:
			break;
		}
	}
}
