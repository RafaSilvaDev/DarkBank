package main;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Main {
	private JFrame frame;
	public static String username, usercpf;
	public static Conta user;
	
	public static void main(String[] args) {
		user = account();
		initialize();
	}
	
	public static Conta account() {
		JOptionPane.showMessageDialog(null, "Antes de começarmos, precisamos de algumas informações suas, ok?");
		do {
			try {
				Conta conta = new Conta(
						JOptionPane.showInputDialog("Insira seu nome abaixo:"),
						JOptionPane.showInputDialog("Digite seu CPF abaixo:"),
						0001,
						123456,
						0.0
				);
				username = conta.getNome();
				usercpf = conta.getCpf();
				if(username.isEmpty() || usercpf.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Parece que as informações solicitadas não foram passadas corretamente. Por favor, tente novamente.");
				}else {
					JOptionPane.showMessageDialog(null, "Prontinho, "+conta.getNome()+", é uma alegria receber você! ❤️\nAgora faça bom uso de nossa plataforma da maneira que preferir, ok?");
					user = conta;
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Parece que as informações solicitadas não foram passadas corretamente. Por favor, tente novamente.");
				username = "";
				usercpf = "";
			}			
		}while(username.isEmpty() || usercpf.isEmpty());
		return user;
	}
	
	public Main() {
		initialize();
	}
	
	public static void initialize() {
		JFrame frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Bem vindo(a) a sua conta, "+username+"!");
		lblTitle.setToolTipText("");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(10, 11, 414, 33);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblSubtitle = new JLabel("Selecione uma ação que deseja realizar:");
		lblSubtitle.setToolTipText("");
		lblSubtitle.setForeground(Color.WHITE);
		lblSubtitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSubtitle.setBounds(10, 44, 382, 25);
		frame.getContentPane().add(lblSubtitle);
		
		JButton btnTransferir = new JButton("Transferir");
		btnTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transferir transfere = new Transferir(user);
			}
		});
		btnTransferir.setForeground(Color.WHITE);
		btnTransferir.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTransferir.setBackground(Color.BLACK);
		btnTransferir.setBounds(10, 111, 171, 42);
		frame.getContentPane().add(btnTransferir);
		
		JButton btnDepositar = new JButton("Depositar");
		btnDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double valor = 0.0;
				
				try {
					valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor que deseja depositar: "));
					user.depositar(valor);
					JOptionPane.showMessageDialog(btnDepositar, "Valor depositado com sucesso! Confira seu saldo.");
				}catch (Exception ex){
					JOptionPane.showMessageDialog(btnDepositar, "Ação inválida. Tente novamente.");
				}
			}
		});
		btnDepositar.setForeground(Color.WHITE);
		btnDepositar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDepositar.setBackground(Color.BLACK);
		btnDepositar.setBounds(253, 111, 171, 42);
		frame.getContentPane().add(btnDepositar);
		
		JButton btnSacar = new JButton("Sacar");
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sacar saque = new Sacar(user);
			}
		});
		btnSacar.setForeground(Color.WHITE);
		btnSacar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSacar.setBackground(Color.BLACK);
		btnSacar.setBounds(10, 190, 171, 42);
		frame.getContentPane().add(btnSacar);
		
		JButton btnConsultarSaldo = new JButton("Consultar Saldo");
		btnConsultarSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnConsultarSaldo, "Seu saldo é de R$"+user.getSaldo()+".");
			}
		});
		btnConsultarSaldo.setForeground(Color.WHITE);
		btnConsultarSaldo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnConsultarSaldo.setBackground(Color.BLACK);
		btnConsultarSaldo.setBounds(253, 190, 171, 42);
		frame.getContentPane().add(btnConsultarSaldo);
		
		frame.setVisible(true);
	}

}
