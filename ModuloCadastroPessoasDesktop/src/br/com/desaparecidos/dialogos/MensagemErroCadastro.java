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

public class MensagemErroCadastro extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel erroPreenchimento = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MensagemErroCadastro dialog = new MensagemErroCadastro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MensagemErroCadastro() {
		setType(Type.POPUP);
		setFont(new Font("Lucida Console", Font.PLAIN, 16));
		setAlwaysOnTop(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		erroPreenchimento.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(erroPreenchimento, BorderLayout.CENTER);
		SpringLayout sl_erroPreenchimento = new SpringLayout();
		erroPreenchimento.setLayout(sl_erroPreenchimento);

		JTextArea txtMensagem = new JTextArea();
		sl_erroPreenchimento.putConstraint(SpringLayout.NORTH, txtMensagem, 54, SpringLayout.NORTH, erroPreenchimento);
		sl_erroPreenchimento.putConstraint(SpringLayout.WEST, txtMensagem, 31, SpringLayout.WEST, erroPreenchimento);
		sl_erroPreenchimento.putConstraint(SpringLayout.SOUTH, txtMensagem, -78, SpringLayout.SOUTH, erroPreenchimento);
		sl_erroPreenchimento.putConstraint(SpringLayout.EAST, txtMensagem, 0, SpringLayout.EAST, erroPreenchimento);
		txtMensagem.setEditable(false);
		txtMensagem.setForeground(new Color(255, 0, 0));
		txtMensagem.setBackground(SystemColor.control);
		txtMensagem.setColumns(2);
		txtMensagem.setRows(5);
		txtMensagem.setTabSize(10);
		txtMensagem.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		txtMensagem
				.setText("Não foi possível realizar o cadastro.\n\nPor favor verifique os campos,\n\ne tente novamente.");
		erroPreenchimento.add(txtMensagem);
	}
}
