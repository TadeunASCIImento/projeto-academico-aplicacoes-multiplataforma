package br.com.desaparecidos.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import br.com.desaparecidos.constants.URLConstants;
import br.com.desaparecidos.dialogos.MensagemErroLogin;
import br.com.desaparecidos.entities.Usuario;
import br.com.desaparecidos.resources.ServiceControllerHTTP;
import br.com.desaparecidos.resources.ServiceControllerHTTP.MinhaException;
import br.com.desaparecidos.util.XmlConversor;

public class FrameLoginUsuario implements URLConstants {

	private JFrame frmLogin;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLoginUsuario janelaLogin = new FrameLoginUsuario();
					janelaLogin.frmLogin.setLocationRelativeTo(null);
					janelaLogin.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrameLoginUsuario() {
		initialize();
	}

	public JFrame getFrmLogin() {
		return frmLogin;
	}

	public void setFrmLogin(JFrame frmLogin) {
		this.frmLogin = frmLogin;
	}

	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setTitle("Sistema de aux\u00EDlio na busca de pessoas desaparecidas vers\u00E3o - 1 . 0 . 0");
		frmLogin.setForeground(SystemColor.textHighlightText);
		frmLogin.setBounds(100, 100, 670, 435);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmLogin.getContentPane().setLayout(springLayout);

		JLabel lblEmail = new JLabel("EMAIL");
		springLayout.putConstraint(SpringLayout.WEST, lblEmail, 157, SpringLayout.WEST, frmLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblEmail, -269, SpringLayout.SOUTH, frmLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblEmail, -395, SpringLayout.EAST, frmLogin.getContentPane());
		lblEmail.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEmail.setFont(new Font("Lucida Console", Font.BOLD, 15));
		frmLogin.getContentPane().add(lblEmail);

		txtUsuario = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtUsuario, 6, SpringLayout.SOUTH, lblEmail);
		springLayout.putConstraint(SpringLayout.WEST, txtUsuario, 0, SpringLayout.WEST, lblEmail);
		springLayout.putConstraint(SpringLayout.SOUTH, txtUsuario, -233, SpringLayout.SOUTH, frmLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtUsuario, -165, SpringLayout.EAST, frmLogin.getContentPane());
		txtUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsuario.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		frmLogin.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblSenha = new JLabel("SENHA");
		springLayout.putConstraint(SpringLayout.NORTH, lblSenha, 6, SpringLayout.SOUTH, txtUsuario);
		springLayout.putConstraint(SpringLayout.WEST, lblSenha, 0, SpringLayout.WEST, lblEmail);
		springLayout.putConstraint(SpringLayout.SOUTH, lblSenha, -205, SpringLayout.SOUTH, frmLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblSenha, -380, SpringLayout.EAST, frmLogin.getContentPane());
		lblSenha.setForeground(new Color(51, 51, 51));
		lblSenha.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSenha.setFont(new Font("Lucida Console", Font.BOLD, 15));
		frmLogin.getContentPane().add(lblSenha);

		txtSenha = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, txtSenha, 6, SpringLayout.SOUTH, lblSenha);
		springLayout.putConstraint(SpringLayout.WEST, txtSenha, 0, SpringLayout.WEST, lblEmail);
		springLayout.putConstraint(SpringLayout.SOUTH, txtSenha, -169, SpringLayout.SOUTH, frmLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtSenha, -165, SpringLayout.EAST, frmLogin.getContentPane());
		txtSenha.setHorizontalAlignment(SwingConstants.LEFT);
		txtSenha.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		frmLogin.getContentPane().add(txtSenha);

		JLabel lblSubtitulo = new JLabel("Informe seu usu\u00E1rio e senha");
		springLayout.putConstraint(SpringLayout.NORTH, lblEmail, 6, SpringLayout.SOUTH, lblSubtitulo);
		springLayout.putConstraint(SpringLayout.SOUTH, lblSubtitulo, -305, SpringLayout.SOUTH,
				frmLogin.getContentPane());
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitulo.setFont(new Font("Lucida Console", Font.BOLD, 16));
		frmLogin.getContentPane().add(lblSubtitulo);

		JLabel lblNewLabel_3 = new JLabel("SISTEMA DE REGISTRO DE PESSOAS");
		springLayout.putConstraint(SpringLayout.NORTH, lblSubtitulo, 6, SpringLayout.SOUTH, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.WEST, lblSubtitulo, 0, SpringLayout.WEST, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.EAST, lblSubtitulo, 0, SpringLayout.EAST, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -349, SpringLayout.SOUTH,
				frmLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 26, SpringLayout.NORTH,
				frmLogin.getContentPane());
		lblNewLabel_3.setForeground(new Color(51, 51, 51));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 10, SpringLayout.WEST, frmLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_3, -10, SpringLayout.EAST, frmLogin.getContentPane());
		lblNewLabel_3.setFont(new Font("Lucida Console", Font.BOLD, 20));
		frmLogin.getContentPane().add(lblNewLabel_3);

		JButton btnEntrar = new JButton("ENTRAR");
		springLayout.putConstraint(SpringLayout.NORTH, btnEntrar, 57, SpringLayout.SOUTH, txtSenha);
		springLayout.putConstraint(SpringLayout.WEST, btnEntrar, 253, SpringLayout.WEST, frmLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnEntrar, -74, SpringLayout.SOUTH, frmLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnEntrar, -252, SpringLayout.EAST, frmLogin.getContentPane());
		btnEntrar.setForeground(SystemColor.textHighlightText);
		btnEntrar.setBackground(SystemColor.textHighlight);

		// Chama o serviço para validar o usuário e senha:

		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				MensagemErroLogin mensagem = new MensagemErroLogin();
				Usuario usuario = new Usuario();
				String usuarioXml = null;
				String resposta = null;
				if (txtUsuario.getText().toString().equalsIgnoreCase("")
						| txtSenha.getText().toString().equalsIgnoreCase("")) {
					mensagem.setLocationRelativeTo(frmLogin);
					mensagem.setVisible(true);
				} else {
					usuario.setEmail(txtUsuario.getText().toString());
					usuario.setSenha(txtSenha.getText().toString());
					usuarioXml = new XmlConversor().toXML(usuario);
					try {
						resposta = new ServiceControllerHTTP().sendPOST(URL_VALIDAR_USUARIO, usuarioXml);
					} catch (MinhaException e) {
						e.printStackTrace();
					}
					if ((resposta.contains(usuario.getSenha()) && (resposta.contains(usuario.getEmail())))) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									FrameCadastroPessoa janelaCadastro = new FrameCadastroPessoa();
									janelaCadastro.getFrmCadastroDePessoas().setVisible(true);
									frmLogin.setVisible(false);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					} else {
						mensagem.setLocationRelativeTo(frmLogin);
						mensagem.setVisible(true);
					}
				}
			}
		});
		frmLogin.getContentPane().add(btnEntrar);
	}
}
