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

		}
		
		calcul_display.addKeyListener(new Keyboard(newButton,calcul_display) );

	
		frame.setVisible(true);
	

	}

}
