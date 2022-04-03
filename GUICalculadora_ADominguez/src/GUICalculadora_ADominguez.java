import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;

public class GUICalculadora_ADominguez {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUICalculadora_ADominguez window = new GUICalculadora_ADominguez();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUICalculadora_ADominguez() {
		initialize();
	}

	private double valor1 = 0.0;
	private double valor2 = 0.0;
	private String operacion = "0";
	private Calculadora c = new Calculadora();
	private boolean consecutiva = false;
	private boolean afterResult;
	private boolean run = false;
	private String pre_operacion = "0";
	private boolean factorial = false;
	private boolean primo = false;
	private boolean clear = false;
	
	public void selectionNumber() {
		if (operacion != "0") {
			valor2 = Double.parseDouble(textField.getText());
		} else {
			valor1 = Double.parseDouble(textField.getText());
		}
		afterResult = false;
		consecutiva = false;
		clear = false;
	}

	public void actualizaValor() throws ArithmeticException {

		if (consecutiva == false) {
			if (operacion == "+") {
				valor1 = c.suma(valor1, valor2);
			} else if (operacion == "-") {
				if (pre_operacion == "*") {
					valor1 = c.mult(valor1, (-1) * valor2);
				} else if (pre_operacion == "/") {
					valor1 = c.divide(valor1, (-1) * valor2);
				} else {
					valor1 = c.resta(valor1, valor2);
				}
			} else if (operacion == "*") {
				if (run == false) {
					valor1 = c.mult(valor1, 1);
				} else {
					valor1 = c.mult(valor1, valor2);
				}
			} else if (operacion == "/") {
				if (run == false) {
					valor1 = c.divide(valor1, 1);
				} else {
					valor1 = c.divide(valor1, valor2);
				}
			}

		}

		clear = false;
		valor2 = 0.0;
		factorial = false;

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 422, 331);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("\uF0E7");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String backnull = null;
				String valor;

				if (textField.getText().length() > 0) {
					StringBuilder str = new StringBuilder(textField.getText());
					str.deleteCharAt(textField.getText().length() - 1);
					backnull = str.toString();
					textField.setText(backnull);

				}
				if (textField.getText().length() == 0) {
					textField.setText("0");
				}
				if (operacion != "0") {
					valor2 = Double.parseDouble(textField.getText());

				} else {
					valor1 = Double.parseDouble(textField.getText());

				}
				afterResult=false;
			}

		});
		btnNewButton.setBounds(10, 75, 89, 35);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_c = new JButton("C");
		btnNewButton_c.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_c.setForeground(new Color(255, 0, 0));
		btnNewButton_c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				if (operacion != "0" & clear == true) {
					valor1 = 0.0;
					operacion = "0";

				} else if (operacion == "0") {
					valor1 = 0.0;

				} else {
					valor2 = 0.0;
				}
				clear = true;
			}
		});
		btnNewButton_c.setBounds(109, 75, 89, 35);
		frame.getContentPane().add(btnNewButton_c);

		
		JButton btnNewButton_00 = new JButton("00");
		btnNewButton_00.setForeground(new Color(0, 0, 255));
		btnNewButton_00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number;
				if (afterResult) {
					number = btnNewButton_00.getText();
					valor1 = 0.0;
				} else {
					number = textField.getText() + btnNewButton_00.getText();

				}
				textField.setText(number);
				selectionNumber();

				
			}
		});
		btnNewButton_00.setBounds(208, 75, 89, 35);
		frame.getContentPane().add(btnNewButton_00);

		JButton btnNewButton_mas = new JButton("+");
		btnNewButton_mas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_mas.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				actualizaValor();
				pre_operacion = operacion;
				operacion = "+";
				textField.setText("");
				consecutiva = true;
				afterResult = false;
				primo = false;

			}
		});
		JButton btnNewButton_doc = new JButton(".");
		btnNewButton_doc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_doc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().contains(".")) {
					textField.setText("ERROR.");
					afterResult = true;
				} else {
					String number = textField.getText() + btnNewButton_doc.getText();
					textField.setText(number);
					if (operacion != "0") {
						valor2 = Double.parseDouble(textField.getText());
					} else {
						valor1 = Double.parseDouble(textField.getText());
					}
				}
			}
		});

		JButton btnNewButton_18 = new JButton("P");
		btnNewButton_18.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				primo = true;

			}

		});

		JButton btnNewButton_19 = new JButton("!");
		btnNewButton_19.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (consecutiva == false) {
						if (operacion != "0") {
							if (operacion == "-" & valor1 == 0.0 & valor2 % 1 == 0) {
								c.fact((int) valor2 * (-1));
							} else if (operacion == "-" & valor1 == 0.0 & valor2 % 1 != 0) {
								textField.setText("Operación factorial no permitida a números decimales y negativos");
							} else if (operacion != "-" & valor1 == 0.0 & valor2 % 1 != 0) {
								textField.setText("Operación factorial no permitida a números decimales");
							} else {
								valor2 = c.fact((int) valor2);
							}
						} else {
							if (valor1 % 1 == 0) {
								valor1 = c.fact((int) valor1);
							} else {
								textField.setText("Operación factorial no permitida a números decimales");
							}

						}
					}

					factorial = true;
					primo = false;

				} catch (IllegalArgumentException ex) {
					textField.setText(ex.getMessage());
					operacion = "0";
					valor1 = 0.0;
					valor2 = 0.0;
				}

			}
		});

		JButton btnNewButton_rest = new JButton("-");
		btnNewButton_rest.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_rest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizaValor();
				pre_operacion = operacion;
				consecutiva = true;
				afterResult = false;
				operacion = "-";
				textField.setText("");
				primo = false;

			}
		});

		JButton btnNewButton_15 = new JButton("/");
		btnNewButton_15.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizaValor();
				consecutiva = true;
				afterResult = false;
				pre_operacion = operacion;
				operacion = "/";
				textField.setText("");
				run = true;
				primo = false;
			}
		});

		JButton btnNewButton_11 = new JButton("*");
		btnNewButton_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizaValor();
				consecutiva = true;
				afterResult = false;
				pre_operacion = operacion;
				operacion = "*";
				textField.setText("");
				run = true;
				primo = false;

			}
		});

		JButton btnNewButton_20 = new JButton("=");
		btnNewButton_20.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_20.setBackground(new Color(173, 216, 230));
		btnNewButton_20.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					if (primo == true) {
						actualizaValor();
						if (valor1 % 1 != 0) {
							textField.setText("Los números decimales no pueden ser primos");
						} else {
							textField.setText("Primo = " + Boolean.toString(c.esPrimo((int) valor1)));
						}
					} else if (operacion == "-") {
						actualizaValor();
						textField.setText(Double.toString(valor1));

					} else if (operacion == "*") {
						actualizaValor();
						textField.setText(Double.toString(valor1));
					} else if (operacion == "/") {

						actualizaValor();
						textField.setText(Double.toString(valor1));

					} else if (operacion == "+") {
						actualizaValor();
						textField.setText(Double.toString(valor1));

					} else if (factorial = true) {
						textField.setText(Double.toString(valor1));
					} else {

					}
				} catch (ArithmeticException ex) {
					textField.setText(ex.getMessage());
					operacion = "0";
					valor1 = 0.0;
					valor2 = 0.0;
				} catch (IllegalStateException ex) {
					textField.setText(ex.getMessage());
					operacion = "0";
					valor1 = 0.0;
					valor2 = 0.0;
				}
				valor2 = 0.0;
				operacion = "0";
				pre_operacion = "0";
				afterResult = true;
				consecutiva = false;
				primo = false;

			}

		});
		btnNewButton_mas.setBounds(307, 75, 89, 35);
		frame.getContentPane().add(btnNewButton_mas);

		JButton btnNewButton_7 = new JButton("7");
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_7.setForeground(new Color(0, 0, 255));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number;
				if (afterResult) {
					number = btnNewButton_7.getText();
					valor1 = 0.0;
				} else {
					number = textField.getText() + btnNewButton_7.getText();

				}
				textField.setText(number);
				selectionNumber();


			}
		});
		btnNewButton_7.setBounds(10, 109, 89, 35);
		frame.getContentPane().add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("8");
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_8.setForeground(new Color(0, 0, 255));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number;
				if (afterResult) {
					number = btnNewButton_8.getText();
					valor1 = 0.0;
				} else {
					number = textField.getText() + btnNewButton_8.getText();

				}
				textField.setText(number);
				selectionNumber();

			}
		});
		btnNewButton_8.setBounds(109, 109, 89, 35);
		frame.getContentPane().add(btnNewButton_8);

		JButton btnNewButton_9 = new JButton("9");
		btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_9.setForeground(new Color(0, 0, 255));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number;
				if (afterResult) {
					number = btnNewButton_9.getText();
					valor1 = 0.0;
				} else {
					number = textField.getText() + btnNewButton_9.getText();

				}
				textField.setText(number);
				selectionNumber();


			}
		});
		btnNewButton_9.setBounds(208, 109, 89, 35);
		frame.getContentPane().add(btnNewButton_9);

		btnNewButton_rest.setBounds(307, 109, 89, 35);
		frame.getContentPane().add(btnNewButton_rest);

		JButton btnNewButton_4 = new JButton("4");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_4.setForeground(new Color(0, 0, 255));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number;
				if (afterResult) {
					number = btnNewButton_4.getText();
					valor1 = 0.0;
				} else {
					number = textField.getText() + btnNewButton_4.getText();

				}
				textField.setText(number);
				selectionNumber();


			}
		});
		btnNewButton_4.setBounds(10, 143, 89, 35);
		frame.getContentPane().add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("5");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_5.setForeground(new Color(0, 0, 255));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number;
				if (afterResult) {
					number = btnNewButton_5.getText();
					valor1 = 0.0;
				} else {
					number = textField.getText() + btnNewButton_5.getText();

				}
				textField.setText(number);
				selectionNumber();


			}
		});
		btnNewButton_5.setBounds(109, 143, 89, 35);
		frame.getContentPane().add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("6");
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_6.setForeground(new Color(0, 0, 255));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number;
				if (afterResult) {
					number = btnNewButton_6.getText();
					valor1 = 0.0;
				} else {
					number = textField.getText() + btnNewButton_6.getText();

				}
				textField.setText(number);
				selectionNumber();


			}
		});
		btnNewButton_6.setBounds(208, 143, 89, 35);
		frame.getContentPane().add(btnNewButton_6);

		btnNewButton_11.setBounds(307, 143, 89, 35);
		frame.getContentPane().add(btnNewButton_11);

		JButton btnNewButton_2 = new JButton("2");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setForeground(new Color(0, 0, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number;
				if (afterResult) {
					number = btnNewButton_2.getText();
					valor1 = 0.0;
				} else {
					number = textField.getText() + btnNewButton_2.getText();

				}
				textField.setText(number);
				selectionNumber();


			}
		});
		btnNewButton_2.setBounds(109, 177, 89, 35);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_1 = new JButton("1");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setForeground(new Color(0, 0, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number;
				if (afterResult) {
					number = btnNewButton_1.getText();
					valor1 = 0.0;
				} else {
					number = textField.getText() + btnNewButton_1.getText();

				}
				textField.setText(number);
				selectionNumber();


			}
		});
		btnNewButton_1.setBounds(10, 177, 89, 35);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_3 = new JButton("3");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setForeground(new Color(0, 0, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number;
				if (afterResult) {
					number = btnNewButton_3.getText();
					valor1 = 0.0;
				} else {
					number = textField.getText() + btnNewButton_3.getText();

				}
				textField.setText(number);
				selectionNumber();


			}
		});
		btnNewButton_3.setBounds(208, 177, 89, 35);
		frame.getContentPane().add(btnNewButton_3);

		btnNewButton_15.setBounds(307, 177, 89, 35);
		frame.getContentPane().add(btnNewButton_15);

		JButton btnNewButton_0 = new JButton("0");
		btnNewButton_0.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_0.setForeground(new Color(0, 0, 255));
		btnNewButton_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number;
				if (afterResult) {
					number = btnNewButton_0.getText();
					valor1 = 0.0;
				} else {
					number = textField.getText() + btnNewButton_0.getText();

				}
				textField.setText(number);
				selectionNumber();

			}
		});
		btnNewButton_0.setBounds(10, 211, 89, 35);
		frame.getContentPane().add(btnNewButton_0);

		btnNewButton_doc.setBounds(109, 211, 89, 35);
		frame.getContentPane().add(btnNewButton_doc);

		btnNewButton_18.setBounds(208, 211, 89, 35);
		frame.getContentPane().add(btnNewButton_18);

		btnNewButton_19.setBounds(307, 211, 89, 35);
		frame.getContentPane().add(btnNewButton_19);

		btnNewButton_20.setBounds(10, 245, 386, 37);
		frame.getContentPane().add(btnNewButton_20);

		textField = new JTextField();
		textField.setBounds(10, 29, 386, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

	}
}
