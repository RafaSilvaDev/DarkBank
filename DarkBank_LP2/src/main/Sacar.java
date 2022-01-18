package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sacar {

	public static Conta cliente;
	public static void main(String[] args) {
		initialize(cliente);
	}
	public Sacar(Conta cliente) {
		this.cliente = cliente;
		initialize(cliente);
	}
	
	public static void initialize(Conta cliente) {
		JFrame frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSaque = new JLabel("Saque");
		lblSaque.setToolTipText("");
		lblSaque.setForeground(Color.WHITE);
		lblSaque.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSaque.setBounds(10, 11, 139, 33);
		frame.getContentPane().add(lblSaque);
		
		JLabel lblValor = new JLabel("Digite abaixo o valor que deseja sacar:");
		lblValor.setToolTipText("");
		lblValor.setForeground(Color.WHITE);
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValor.setBounds(10, 58, 285, 25);
		frame.getContentPane().add(lblValor);
		
		JTextField txt_saque = new JTextField();
		txt_saque.setBounds(10, 86, 208, 33);
		frame.getContentPane().add(txt_saque);
		txt_saque.setColumns(10);
		
		JButton btnConfirmarSaque = new JButton("Confirmar saque");
		btnConfirmarSaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double valor = 0.0;
				
				try {
					valor = Double.parseDouble(txt_saque.getText());
					if(valor > cliente.getSaldo()) {
						JOptionPane.showMessageDialog(btnConfirmarSaque, "Desculpe, mas a sua transferência é inválida! :(");
					}else {
						cliente.sacar(valor);
						JOptionPane.showMessageDialog(btnConfirmarSaque, "O saque foi realizado!");
					}
					frame.setVisible(false);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(btnConfirmarSaque, "Por favor, digite caracteres válidos para realizar esta ação.");
				}
			}
		});
		btnConfirmarSaque.setForeground(Color.WHITE);
		btnConfirmarSaque.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnConfirmarSaque.setBackground(Color.BLACK);
		btnConfirmarSaque.setBounds(10, 159, 275, 42);
		frame.getContentPane().add(btnConfirmarSaque);
		
		JLabel lblNewLabel = new JLabel("← Voltar");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
			}
		});
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel.setBounds(220, 24, 65, 14);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(100, 100, 313, 251);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	}
}
