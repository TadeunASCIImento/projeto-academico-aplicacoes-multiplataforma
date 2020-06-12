package br.com.desaparecidos.dialogos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class MensagemSucessoCadastro extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel msgConfirmacao = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MensagemSucessoCadastro dialog = new MensagemSucessoCadastro();
			dialog.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MensagemSucessoCadastro() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		msgConfirmacao.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(msgConfirmacao, BorderLayout.CENTER);
		SpringLayout sl_msgConfirmacao = new SpringLayout();
		msgConfirmacao.setLayout(sl_msgConfirmacao);
		{
			JTextArea txtMensagem = new JTextArea();
			sl_msgConfirmacao.putConstraint(SpringLayout.NORTH, txtMensagem, -159, SpringLayout.SOUTH, msgConfirmacao);
			sl_msgConfirmacao.putConstraint(SpringLayout.SOUTH, txtMensagem, -38, SpringLayout.SOUTH, msgConfirmacao);
			sl_msgConfirmacao.putConstraint(SpringLayout.EAST, txtMensagem, -22, SpringLayout.EAST, msgConfirmacao);
			txtMensagem.setText("O cadastro foi realizado com sucesso.");
			txtMensagem.setTabSize(10);
			txtMensagem.setRows(5);
			txtMensagem.setForeground(new Color(0, 0, 0));
			txtMensagem.setFont(new Font("Lucida Console", Font.PLAIN, 16));
			txtMensagem.setEditable(false);
			txtMensagem.setColumns(2);
			txtMensagem.setBackground(SystemColor.menu);
			msgConfirmacao.add(txtMensagem);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		}
	}

}
