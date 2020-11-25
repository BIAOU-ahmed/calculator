/**
 * 
 */
package calculator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;

/**
 * @author ahmed
 *
 */
public class Keyboard implements KeyListener {

	Button[] newButton;
	JLabel calcul_display;

	/**
	 * keyboard constructor
	 * 
	 * @param newButton
	 * @param calcul_display
	 */
	public Keyboard(Button[] newButton, JLabel calcul_display) {

		this.newButton = newButton;
		this.calcul_display = calcul_display;

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		String number = "" + e.getKeyChar();

		if (key == KeyEvent.VK_0 || key == KeyEvent.VK_NUMPAD0 || key == KeyEvent.VK_1 || key == KeyEvent.VK_NUMPAD1
				|| key == KeyEvent.VK_2 || key == KeyEvent.VK_NUMPAD2 || key == KeyEvent.VK_3
				|| key == KeyEvent.VK_NUMPAD3 || key == KeyEvent.VK_4 || key == KeyEvent.VK_NUMPAD4
				|| key == KeyEvent.VK_5 || key == KeyEvent.VK_NUMPAD5 || key == KeyEvent.VK_6
				|| key == KeyEvent.VK_NUMPAD6 || key == KeyEvent.VK_8 || key == KeyEvent.VK_NUMPAD7
				|| key == KeyEvent.VK_7 || key == KeyEvent.VK_NUMPAD8 || key == KeyEvent.VK_9
				|| key == KeyEvent.VK_NUMPAD9) {

			try {
				numberPressed(Integer.parseInt(number));

			} catch (Exception e2) {

			}

		} else {
		
			switch (key) {
			case KeyEvent.VK_ADD: {

				newButton[18].getBtnNewButton().doClick();
				break;
			}
			case KeyEvent.VK_SUBTRACT: {

				newButton[19].getBtnNewButton().doClick();
				break;
			}
			case KeyEvent.VK_MULTIPLY: {

				newButton[13].getBtnNewButton().doClick();
				break;
			}
			case KeyEvent.VK_DIVIDE: {

				newButton[14].getBtnNewButton().doClick();
				break;
			}
			case KeyEvent.VK_ENTER: {

				newButton[23].getBtnNewButton().doClick();
				break;
			}
			case KeyEvent.VK_DECIMAL: {

				newButton[21].getBtnNewButton().doClick();
				break;
			}
			case KeyEvent.VK_BACK_SPACE: {
				// this part is to delete the last number pressed
				String str = calcul_display.getText();

				if (str != null && str.length() > 0) {
					str = str.substring(0, str.length() - 1);
				}
				calcul_display.setText(str);
				break;
			}

			default:

			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Method to do a click according of the number pressed on the keyboard
	 * @param number
	 */
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
