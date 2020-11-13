package calculator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

	private JPanel contentPane;
	JFrame frame;
	Calculator calculate = new Calculator();
	double memorieValue = 0;
	boolean isValueInMemorie = false;

	/**
	 * Create the frame.
	 */
	public CalculatorFrame() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 475, 615);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 462, 576);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_solar = new JPanel();
		panel_solar.setBackground(Color.BLACK);
		panel_solar.setForeground(Color.BLACK);
		panel_solar.setBounds(182, 34, 104, 30);
		panel.add(panel_solar);

		JPanel display_panel = new JPanel();
		display_panel.setBackground(Color.LIGHT_GRAY);
		display_panel.setBounds(20, 88, 419, 81);
		panel.add(display_panel);
		display_panel.setLayout(new BorderLayout(0, 0));

		JLabel calcul_display = new JLabel("");
		calcul_display.setFont(new Font("Tahoma", Font.BOLD, 26));
		calcul_display.setBackground(Color.WHITE);
		calcul_display.setHorizontalAlignment(SwingConstants.RIGHT);
		display_panel.add(calcul_display);

		JPanel panel_buttons = new JPanel();
		panel_buttons.setLayout(null);
		panel_buttons.setBackground(Color.DARK_GRAY);
		panel_buttons.setBounds(20, 213, 419, 352);
		panel.add(panel_buttons);

		JButton btnMemorieShow = new JButton("MRC");
		btnMemorieShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (calculate.isOn) {
					if (isValueInMemorie) {
						calcul_display.setText("" + memorieValue);
					}

				}
				btnMemorieShow.requestFocus();

			}
		});
		btnMemorieShow.setBackground(Color.LIGHT_GRAY);
		btnMemorieShow.setBounds(10, 11, 73, 55);
		panel_buttons.add(btnMemorieShow);

		JButton btnMplus = new JButton("M+");
		btnMplus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (calculate.isOn) {
					memorieValue += Double.parseDouble(calcul_display.getText());
					isValueInMemorie = true;
				}
				btnMemorieShow.requestFocus();
			}
		});
		btnMplus.setBackground(Color.LIGHT_GRAY);
		btnMplus.setBounds(93, 11, 73, 55);
		panel_buttons.add(btnMplus);

		JButton btnMMoins = new JButton("M-");
		btnMMoins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (calculate.isOn) {
					memorieValue -= Double.parseDouble(calcul_display.getText());
					isValueInMemorie = true;
				}
				btnMemorieShow.requestFocus();
			}
		});
		btnMMoins.setBackground(Color.LIGHT_GRAY);
		btnMMoins.setBounds(176, 11, 73, 55);
		panel_buttons.add(btnMMoins);

		JButton btnCe = new JButton("CE");
		btnCe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcul_display.setText("");
				btnMemorieShow.requestFocus();
			}
		});
		btnCe.setBackground(Color.LIGHT_GRAY);
		btnCe.setBounds(259, 11, 73, 55);
		panel_buttons.add(btnCe);

		JButton btnOnc = new JButton("ON-C");
		btnOnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!calculate.isOn) {
					calculate.setOn(true);
					display_panel.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));

				}
				btnMemorieShow.requestFocus();
				calcul_display.setText("");
				calculate.setResult("");
				calculate.changeCurrentOpe(0);
			}
		});
		btnOnc.setBackground(Color.RED);
		btnOnc.setBounds(342, 11, 73, 55);
		panel_buttons.add(btnOnc);

		JButton btn_7 = new JButton("7");
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.addNumber(calcul_display, btn_7.getText());
				btnMemorieShow.requestFocus();
			}
		});
		btn_7.setBackground(Color.LIGHT_GRAY);
		btn_7.setBounds(10, 80, 73, 55);
		panel_buttons.add(btn_7);

		JButton btn_8 = new JButton("8");
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.addNumber(calcul_display, btn_8.getText());
				btnMemorieShow.requestFocus();
			}
		});
		btn_8.setBackground(Color.LIGHT_GRAY);
		btn_8.setBounds(93, 80, 73, 55);
		panel_buttons.add(btn_8);

		JButton btn_9 = new JButton("9");
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.addNumber(calcul_display, btn_9.getText());
				btnMemorieShow.requestFocus();
			}
		});
		btn_9.setBackground(Color.LIGHT_GRAY);
		btn_9.setBounds(176, 80, 73, 55);
		panel_buttons.add(btn_9);

		JButton btn_pct = new JButton("%");
		btn_pct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.cheickTypeMonoOperator(calcul_display,2);
				btnMemorieShow.requestFocus();
			}
		});
		btn_pct.setBackground(Color.LIGHT_GRAY);
		btn_pct.setBounds(259, 80, 73, 55);
		panel_buttons.add(btn_pct);

		JButton btn_racine = new JButton("\u221A");
		btn_racine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				calculate.cheickTypeMonoOperator(calcul_display,1);

				btnMemorieShow.requestFocus();
			}
		});
		btn_racine.setBackground(Color.LIGHT_GRAY);
		btn_racine.setBounds(342, 80, 73, 55);
		panel_buttons.add(btn_racine);

		JButton btn_4 = new JButton("4");
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.addNumber(calcul_display, btn_4.getText());
				btnMemorieShow.requestFocus();
			}
		});
		btn_4.setBackground(Color.LIGHT_GRAY);
		btn_4.setBounds(10, 146, 73, 55);
		panel_buttons.add(btn_4);

		JButton btn_5 = new JButton("5");
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.addNumber(calcul_display, btn_5.getText());
				btnMemorieShow.requestFocus();
			}
		});
		btn_5.setBackground(Color.LIGHT_GRAY);
		btn_5.setBounds(93, 146, 73, 55);
		panel_buttons.add(btn_5);

		JButton btn_6 = new JButton("6");
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.addNumber(calcul_display, btn_6.getText());
				btnMemorieShow.requestFocus();
			}
		});
		btn_6.setBackground(Color.LIGHT_GRAY);
		btn_6.setBounds(176, 146, 73, 55);
		panel_buttons.add(btn_6);

		JButton btnX = new JButton("x");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.doOperation(calcul_display, 3);
				btnMemorieShow.requestFocus();
			}
		});
		btnX.setBackground(Color.LIGHT_GRAY);
		btnX.setBounds(259, 146, 73, 55);
		panel_buttons.add(btnX);

		JButton btn_division = new JButton("\u00F7");
		btn_division.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.doOperation(calcul_display, 4);
				btnMemorieShow.requestFocus();
			}
		});
		btn_division.setBackground(Color.LIGHT_GRAY);
		btn_division.setBounds(342, 146, 73, 55);
		panel_buttons.add(btn_division);

		JButton btn_1 = new JButton("1");
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.addNumber(calcul_display, btn_1.getText());
				btnMemorieShow.requestFocus();
			}
		});
		btn_1.setBackground(Color.LIGHT_GRAY);
		btn_1.setBounds(10, 212, 73, 55);
		panel_buttons.add(btn_1);

		JButton btn_2 = new JButton("2");
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.addNumber(calcul_display, btn_2.getText());
				btnMemorieShow.requestFocus();
			}
		});
		btn_2.setBackground(Color.LIGHT_GRAY);
		btn_2.setBounds(93, 212, 73, 55);
		panel_buttons.add(btn_2);

		JButton btn_3 = new JButton("3");
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.addNumber(calcul_display, btn_3.getText());
				btnMemorieShow.requestFocus();
			}
		});
		btn_3.setBackground(Color.LIGHT_GRAY);
		btn_3.setBounds(176, 212, 73, 55);
		panel_buttons.add(btn_3);

		JButton btn_addition = new JButton("+");
		btn_addition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.doOperation(calcul_display, 1);
				btnMemorieShow.requestFocus();
			}
		});
		btn_addition.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_addition.setBackground(Color.LIGHT_GRAY);
		btn_addition.setBounds(259, 212, 73, 121);
		panel_buttons.add(btn_addition);

		JButton btn_soustration = new JButton("-");
		btn_soustration.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btn_soustration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.doOperation(calcul_display, 2);
				btnMemorieShow.requestFocus();
			}
		});
		btn_soustration.setBackground(Color.LIGHT_GRAY);
		btn_soustration.setBounds(342, 212, 73, 55);
		panel_buttons.add(btn_soustration);

		JButton btn_result = new JButton("=");
		btn_result.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_result.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				calculate.doOperation(calcul_display, 0);

				btnMemorieShow.requestFocus();
			}
		});
		btn_result.setBackground(Color.LIGHT_GRAY);
		btn_result.setBounds(342, 278, 73, 55);
		panel_buttons.add(btn_result);

		JButton btn_0 = new JButton("0");
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate.addNumber(calcul_display, btn_0.getText());

				btnMemorieShow.requestFocus();
			}
		});
		btn_0.setBackground(Color.LIGHT_GRAY);
		btn_0.setBounds(10, 278, 73, 55);
		panel_buttons.add(btn_0);

		JButton btn_dot = new JButton(".");
		btn_dot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				calculate.addDot(calcul_display);

				btnMemorieShow.requestFocus();
			}
		});
		btn_dot.setBackground(Color.LIGHT_GRAY);
		btn_dot.setBounds(93, 278, 73, 55);
		panel_buttons.add(btn_dot);

		JButton btn_signe = new JButton("+/-");
		btn_signe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				calculate.addSigne(calcul_display);
				btnMemorieShow.requestFocus();
			}
		});
		btn_signe.setBackground(Color.LIGHT_GRAY);
		btn_signe.setBounds(176, 278, 73, 55);
		panel_buttons.add(btn_signe);

		btnMemorieShow.addKeyListener(new KeyListener() {

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
				if (key == KeyEvent.VK_0 || key == KeyEvent.VK_NUMPAD0 || key == KeyEvent.VK_1
						|| key == KeyEvent.VK_NUMPAD1 || key == KeyEvent.VK_2 || key == KeyEvent.VK_NUMPAD2
						|| key == KeyEvent.VK_3 || key == KeyEvent.VK_NUMPAD3 || key == KeyEvent.VK_4
						|| key == KeyEvent.VK_NUMPAD4 || key == KeyEvent.VK_5 || key == KeyEvent.VK_NUMPAD5
						|| key == KeyEvent.VK_6 || key == KeyEvent.VK_NUMPAD6 || key == KeyEvent.VK_8
						|| key == KeyEvent.VK_NUMPAD7 || key == KeyEvent.VK_7 || key == KeyEvent.VK_NUMPAD8
						|| key == KeyEvent.VK_9 || key == KeyEvent.VK_NUMPAD9) {

					try {

						if (Integer.parseInt(number) >= 0 || Integer.parseInt(number) <= 9) {
							calculate.addNumber(calcul_display, number);
							
						}

					} catch (Exception e2) {
						// TODO: handle exception
					}

				} else {
					System.out.println(key + "et" + KeyEvent.VK_ADD);
					switch (key) {
					case KeyEvent.VK_ADD: {
						calculate.doOperation(calcul_display, 1);

						break;
					}
					case KeyEvent.VK_SUBTRACT: {
						calculate.doOperation(calcul_display, 2);

						break;
					}
					case KeyEvent.VK_MULTIPLY: {
						calculate.doOperation(calcul_display, 3);
						
						break;
					}
					case KeyEvent.VK_DIVIDE: {
						calculate.doOperation(calcul_display, 4);
						
						break;
					}
					case KeyEvent.VK_ENTER: {
						calculate.doOperation(calcul_display, 0);
						
						break;
					}
					case KeyEvent.VK_DECIMAL: {
						calculate.addDot(calcul_display);
						
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
