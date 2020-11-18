package calculator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import calculator.Button;
import calculator.Calculator;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class CalculatorFrame {

	private JFrame frame;
	JButton btnNewButton;
	JLabel calcul_display;

	Calculator calculate = new Calculator();

	/**
	 * Create the frame.
	 */
	public CalculatorFrame() {
		frame = new JFrame();
		frame.setBounds(100, 100, 448, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("SplitPaneDivider.draggingColor"));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_calcul = new JPanel();
		panel_calcul.setBackground(Color.LIGHT_GRAY);
		
		panel_calcul.setBounds(14, 78, 405, 99);
		panel.add(panel_calcul);
		panel_calcul.setLayout(new CardLayout(0, 0));

		calcul_display = new JLabel("");
		calcul_display.setFont(new Font("Tahoma", Font.BOLD, 26));
		calcul_display.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_calcul.add(calcul_display, "name_58360375741700");
		calcul_display.setBackground(Color.RED);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(150, 22, 133, 38);
		panel.add(panel_1);

		JPanel panel_button = new JPanel();
		panel_button.setBackground(Color.DARK_GRAY);
		panel_button.setBounds(0, 188, 419, 352);
		panel.add(panel_button);
		panel_button.setLayout(null);

		

		String values[] = { "MRC", "M+", "M-", "CE", "ON-C", "7", "8", "9", "%", "\u221A", "4", "5", "6", "X", "\u00F7", "1", "2", "3","+", "-", "0", ".", "+/-", "=" };
		String[] command = { "0", "0", "0", "1", "1","2","2","2","3","3","2","2","2","4","4","2","2","2","4","4","2", "5", "6","4" };
		int[] operand = { 0,1 , 2, 0, 1, 0, 0, 0, 2, 1, 0,0, 0, 3, 4, 0, 0, 0,1, 2, 0, 0, 0, 0 };
		Button[] newButton = new Button[values.length];
		int x = 10;
		int y = 11;
		int nbcolunn = 0;
		for (int i = 0; i < newButton.length; i++) {

			
			if(i==23) {
				x=342;
				y=287;
//				newButton[i] = new Button(calculate,calcul_display, panel_2, b[i],command[i], 342, 287);
			}
				newButton[i] = new Button(panel_calcul,calculate,calcul_display, panel_button, values[i],command[i],operand[i], x, y);
			
				
			nbcolunn++;
			if(nbcolunn==5) {
				x=10;
				y+=69;
				nbcolunn=0;
			}else {
				x += 83;
			}
//			JButton btnNewButton = newButton[i].getBtnNewButton() ;
//			
//			btnNewButton.addKeyListener(new KeyListener() {
//
//				@Override
//				public void keyTyped(KeyEvent e) {
//					// TODO Auto-generated method stub
//					
//				}
//
//				@Override
//				public void keyPressed(KeyEvent e) {
//					// TODO Auto-generated method stub
//					btnNewButton.doClick();
//					
//				}
//
//				@Override
//				public void keyReleased(KeyEvent e) {
//					// TODO Auto-generated method stub
//					
//				}});
		}
		
		calcul_display.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int key = e.getKeyCode();
				String number = "" + e.getKeyChar();
		
				System.out.println(number);
				if (key == KeyEvent.VK_0 || key == KeyEvent.VK_NUMPAD0 || key == KeyEvent.VK_1 || key == KeyEvent.VK_NUMPAD1
						|| key == KeyEvent.VK_2 || key == KeyEvent.VK_NUMPAD2 || key == KeyEvent.VK_3
						|| key == KeyEvent.VK_NUMPAD3 || key == KeyEvent.VK_4 || key == KeyEvent.VK_NUMPAD4
						|| key == KeyEvent.VK_5 || key == KeyEvent.VK_NUMPAD5 || key == KeyEvent.VK_6
						|| key == KeyEvent.VK_NUMPAD6 || key == KeyEvent.VK_8 || key == KeyEvent.VK_NUMPAD7
						|| key == KeyEvent.VK_7 || key == KeyEvent.VK_NUMPAD8 || key == KeyEvent.VK_9
						|| key == KeyEvent.VK_NUMPAD9) {
		
 					try {
		
						
						if (Integer.parseInt(number) == 0) {
//							calculate.addNumber(calcul_display, number);
//							btnNewButton.doClick();
							newButton[20].getBtnNewButton().doClick();
	
						}
						if (Integer.parseInt(number) == 1) {
//							calculate.addNumber(calcul_display, number);
//							btnNewButton.doClick();
							newButton[15].getBtnNewButton().doClick();
	
						}
						if (Integer.parseInt(number) == 2) {
//							calculate.addNumber(calcul_display, number);
//							btnNewButton.doClick();
							newButton[16].getBtnNewButton().doClick();
	
						}
						if (Integer.parseInt(number) == 3) {
//							calculate.addNumber(calcul_display, number);
//							btnNewButton.doClick();
							newButton[17].getBtnNewButton().doClick();
	
						}
						if (Integer.parseInt(number) == 4) {
//							calculate.addNumber(calcul_display, number);
//							btnNewButton.doClick();
							newButton[10].getBtnNewButton().doClick();
	
						}
						if (Integer.parseInt(number) == 5) {
//							calculate.addNumber(calcul_display, number);
//							btnNewButton.doClick();
							newButton[11].getBtnNewButton().doClick();
	
						}
						if (Integer.parseInt(number) == 6) {
//							calculate.addNumber(calcul_display, number);
//							btnNewButton.doClick();
							newButton[12].getBtnNewButton().doClick();
	
						}
						if (Integer.parseInt(number) == 7) {
//							calculate.addNumber(calcul_display, number);
//							btnNewButton.doClick();
							newButton[5].getBtnNewButton().doClick();
	
						}
						if (Integer.parseInt(number) == 8) {
//							calculate.addNumber(calcul_display, number);
//							btnNewButton.doClick();
							newButton[6].getBtnNewButton().doClick();
	
						}
						if (Integer.parseInt(number) == 9) {
//							calculate.addNumber(calcul_display, number);
//							btnNewButton.doClick();
							newButton[7].getBtnNewButton().doClick();
	
						}
	
					} catch (Exception e2) {
						// TODO: handle exception
					}
		
				}else {
					System.out.println(key + "et" + KeyEvent.VK_ADD);
					switch (key) {
					case KeyEvent.VK_ADD: {
//						calculate.doOperation(calcul_display, 1);
						newButton[18].getBtnNewButton().doClick();
						break;
					}
					case KeyEvent.VK_SUBTRACT: {
//						calculate.doOperation(calcul_display, 2);
						newButton[19].getBtnNewButton().doClick();
						break;
					}
					case KeyEvent.VK_MULTIPLY: {
//						calculate.doOperation(calcul_display, 3);
						newButton[13].getBtnNewButton().doClick();
						break;
					}
					case KeyEvent.VK_DIVIDE: {
//						calculate.doOperation(calcul_display, 4);
						newButton[14].getBtnNewButton().doClick();
						break;
					}
					case KeyEvent.VK_ENTER: {
//						calculate.doOperation(calcul_display, 0);
						newButton[23].getBtnNewButton().doClick();
						break;
					}
					case KeyEvent.VK_DECIMAL: {
//						calculate.addDot(calcul_display);
						newButton[21].getBtnNewButton().doClick();
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
		
			
		});
		
		frame.setVisible(true);
	

	}

}
