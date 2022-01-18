package main;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Transferir {

	private JFrame frame;
	public static Conta cliente;
	private static JTextField txt_valor;
	private static JTextField txt_cpf;
	public static void main(String[] args) {
		initialize(cliente);
	}
	public Transferir(Conta cliente) {
		this.cliente = cliente;
		initialize(cliente);
	}
	public static void initialize(Conta cliente) {
		JFrame frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 356, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTransferir = new JLabel("Transferir");
		lblTransferir.setToolTipText("");
		lblTransferir.setForeground(Color.WHITE);
		lblTransferir.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTransferir.setBounds(10, 11, 157, 33);
		frame.getContentPane().add(lblTransferir);
		
		JLabel lblDigiteAbaixo = new JLabel("Digite abaixo o valor que deseja transferir:");
		lblDigiteAbaixo.setToolTipText("");
		lblDigiteAbaixo.setForeground(Color.WHITE);
		lblDigiteAbaixo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDigiteAbaixo.setBounds(10, 58, 316, 25);
		frame.getContentPane().add(lblDigiteAbaixo);
		
		JTextField txt_valor = new JTextField();
		txt_valor.setColumns(10);
		txt_valor.setBounds(10, 86, 208, 33);
		frame.getContentPane().add(txt_valor);
		
		JTextField txt_cpf = new JTextField();
		txt_cpf.setColumns(10);
		txt_cpf.setBounds(10, 174, 208, 33);
		frame.getContentPane().add(txt_cpf);
		
		JButton btnConfirmarTransferncia = new JButton("Confirmar transferência");
		btnConfirmarTransferncia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double valor = 0.0;
				String text = txt_cpf.getText();
				
				try {
					valor = Double.parseDouble(txt_valor.getText());
					
					if(valor > cliente.getSaldo() || text.equals(cliente.getCpf())) {
						JOptionPane.showMessageDialog(btnConfirmarTransferncia, "Desculpe, mas a sua transferência é inválida! :(");
					}else {
						cliente.transferir(valor, txt_cpf.getText().toString()); //REALIZANDO TRANSFERÊNCIA
						JOptionPane.showMessageDialog(btnConfirmarTransferncia, "A transferência foi realizada!");
					}
					frame.setVisible(false);
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(btnConfirmarTransferncia, "Por favor, digite caracteres válidos para realizar esta ação.");
				}
			}
		});
		btnConfirmarTransferncia.setForeground(Color.WHITE);
		btnConfirmarTransferncia.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnConfirmarTransferncia.setBackground(Color.BLACK);
		btnConfirmarTransferncia.setBounds(10, 245, 320, 42);
		frame.getContentPane().add(btnConfirmarTransferncia);
		
		JLabel lblDigiteAbaixoO = new JLabel("Digite abaixo o CPF da conta de destino:");
		lblDigiteAbaixoO.setToolTipText("");
		lblDigiteAbaixoO.setForeground(Color.WHITE);
		lblDigiteAbaixoO.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDigiteAbaixoO.setBounds(10, 146, 316, 25);
		frame.getContentPane().add(lblDigiteAbaixoO);
		
		JLabel lblNewLabel = new JLabel("← Voltar");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
			}
		});
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel.setBounds(261, 23, 65, 14);
		frame.getContentPane().add(lblNewLabel);
		
		frame.setVisible(true);
	}
}
