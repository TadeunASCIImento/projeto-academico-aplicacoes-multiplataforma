package br.com.desaparecidos.dialogos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class MensagemErroLogin extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MensagemErroLogin dialog = new MensagemErroLogin();
			dialog.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MensagemErroLogin() {
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		
		JTextArea txtMensagem = new JTextArea(); 
		sl_contentPanel.putConstraint(SpringLayout.NORTH, txtMensagem, 77, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, txtMensagem, 59, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, txtMensagem, -70, SpringLayout.SOUTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, txtMensagem, -56, SpringLayout.EAST, contentPanel);
		txtMensagem.setText("Usuário e senha incorretos!,\n\nTente novamente.");
		txtMensagem.setTabSize(10);
		txtMensagem.setRows(5);
		txtMensagem.setForeground(Color.RED);
		txtMensagem.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		txtMensagem.setEditable(false);
		txtMensagem.setColumns(2);
		txtMensagem.setBackground(SystemColor.menu);
		contentPanel.add(txtMensagem);
	
	}

}
