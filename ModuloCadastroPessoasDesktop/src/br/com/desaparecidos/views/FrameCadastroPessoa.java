package br.com.desaparecidos.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import br.com.desaparecidos.constants.URLConstants;
import br.com.desaparecidos.dialogos.MensagemErroCadastro;
import br.com.desaparecidos.dialogos.MensagemSucessoCadastro;
import br.com.desaparecidos.entities.Caracteristica;
import br.com.desaparecidos.entities.Identificacao;
import br.com.desaparecidos.resources.ServiceControllerHTTP;
import br.com.desaparecidos.resources.ServiceControllerHTTP.MinhaException;
import br.com.desaparecidos.util.Base64Conversor;
import br.com.desaparecidos.util.XmlConversor;

public class FrameCadastroPessoa implements URLConstants {

	private JFrame frmCadastroDePessoas;
	private JTextField txtNome;
	private JTextField txtDocumento;
	private JTextField txtFiliacaoPai;
	private JTextField txtFiliacaoMae;
	private JLabel lblNome;
	private JLabel lblDocumento;
	private JLabel lblFiliacaoPai;
	private JLabel lblFiliacaoMae;
	private JComboBox cboSexo;
	private JLabel lblCaracteristicas;
	private JLabel lblSexo;
	private JLabel lblBarba;
	private JComboBox cboBarba;
	private JComboBox cboPele;
	private JLabel lblPele;
	private JLabel lblDeficiencia;
	private JComboBox cboDeficiencia;
	private JComboBox cboTipoCabelo;
	private JComboBox cboAltura;
	private JLabel lblAltura;
	private JComboBox cboOlhos;
	private JComboBox cboCorCabelo;
	private JComboBox cboFisico;
	private JComboBox cboTatuagens;
	private JComboBox cboCicatrizes;
	private JComboBox cboIdade;
	private JLabel lblOlhos;
	private JLabel lblCorCabelo;
	private JLabel lblFisico;
	private JLabel lblTatuagens;
	private JLabel lblCicatrizes;
	private JLabel lblIdade;
	private JButton btnIncluirFoto;
	private JLabel lblFoto;
	private JTextArea txtObservacao;
	private JLabel lblObservacao;
	private byte[] bytesImagem;
	private JCheckBox chkIdentificacao;

	public FrameCadastroPessoa() {
		initialize();
	}

	public byte[] getBytesImagem() {
		return bytesImagem;
	}

	public void setBytesImagem(byte[] bytesImagem) {
		this.bytesImagem = bytesImagem;
	}

	public JFrame getFrmCadastroDePessoas() {

		return frmCadastroDePessoas;
	}

	private void initialize() {
		frmCadastroDePessoas = new JFrame();
		frmCadastroDePessoas.setResizable(false);
		frmCadastroDePessoas.getContentPane().setFont(new Font("Lucida Console", Font.PLAIN, 16));
		frmCadastroDePessoas.setTitle("Sistema de Cadastro de Pessoas vers\u00E3o - 1.0.0");
		frmCadastroDePessoas.setBounds(100, 100, 1020, 555);
		frmCadastroDePessoas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmCadastroDePessoas.getContentPane().setLayout(springLayout);

		JLabel lblDados = new JLabel("INFORME OS DADOS PESSOAIS");
		springLayout.putConstraint(SpringLayout.NORTH, lblDados, 22, SpringLayout.NORTH,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblDados, 20, SpringLayout.WEST,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblDados, -465, SpringLayout.SOUTH,
				frmCadastroDePessoas.getContentPane());
		lblDados.setFont(new Font("Lucida Console", Font.BOLD, 18));
		frmCadastroDePessoas.getContentPane().add(lblDados);

		txtNome = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtNome, 253, SpringLayout.WEST,
				frmCadastroDePessoas.getContentPane());
		txtNome.setFont(new Font("Lucida Console", Font.BOLD, 15));
		txtNome.setForeground(Color.DARK_GRAY);
		txtNome.setHorizontalAlignment(SwingConstants.LEFT);
		frmCadastroDePessoas.getContentPane().add(txtNome);
		txtNome.setColumns(10);

		txtDocumento = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtDocumento, 20, SpringLayout.WEST,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtDocumento, -406, SpringLayout.SOUTH,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtDocumento, -6, SpringLayout.WEST, txtNome);
		txtDocumento.setForeground(Color.DARK_GRAY);
		txtDocumento.setFont(new Font("Lucida Console", Font.BOLD, 14));
		txtDocumento.setColumns(10);
		frmCadastroDePessoas.getContentPane().add(txtDocumento);

		txtFiliacaoPai = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtFiliacaoPai, 153, SpringLayout.NORTH,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtFiliacaoPai, 20, SpringLayout.WEST,
				frmCadastroDePessoas.getContentPane());
		txtFiliacaoPai.setForeground(Color.DARK_GRAY);
		txtFiliacaoPai.setFont(new Font("Lucida Console", Font.BOLD, 15));
		frmCadastroDePessoas.getContentPane().add(txtFiliacaoPai);
		txtFiliacaoPai.setColumns(10);

		txtFiliacaoMae = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, txtFiliacaoPai, -6, SpringLayout.WEST, txtFiliacaoMae);
		springLayout.putConstraint(SpringLayout.NORTH, txtFiliacaoMae, 153, SpringLayout.NORTH,
				frmCadastroDePessoas.getContentPane());
		txtFiliacaoMae.setFont(new Font("Lucida Console", Font.BOLD, 15));
		txtFiliacaoMae.setForeground(Color.DARK_GRAY);
		frmCadastroDePessoas.getContentPane().add(txtFiliacaoMae);
		txtFiliacaoMae.setColumns(10);

		lblNome = new JLabel("Nome completo");
		springLayout.putConstraint(SpringLayout.NORTH, txtNome, 6, SpringLayout.SOUTH, lblNome);
		springLayout.putConstraint(SpringLayout.NORTH, lblNome, 6, SpringLayout.SOUTH, lblDados);
		springLayout.putConstraint(SpringLayout.WEST, lblNome, 0, SpringLayout.WEST, txtNome);
		lblNome.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		frmCadastroDePessoas.getContentPane().add(lblNome);

		lblDocumento = new JLabel("Doc.identifica\u00E7\u00E3o");
		springLayout.putConstraint(SpringLayout.NORTH, txtDocumento, 5, SpringLayout.SOUTH, lblDocumento);
		springLayout.putConstraint(SpringLayout.NORTH, lblDocumento, 68, SpringLayout.NORTH,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblDocumento, 20, SpringLayout.WEST,
				frmCadastroDePessoas.getContentPane());
		lblDocumento.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		frmCadastroDePessoas.getContentPane().add(lblDocumento);

		lblFiliacaoPai = new JLabel("Filia\u00E7\u00E3o ( pai )");
		springLayout.putConstraint(SpringLayout.WEST, lblFiliacaoPai, 0, SpringLayout.WEST, lblDados);
		springLayout.putConstraint(SpringLayout.SOUTH, lblFiliacaoPai, -6, SpringLayout.NORTH, txtFiliacaoPai);
		lblFiliacaoPai.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		frmCadastroDePessoas.getContentPane().add(lblFiliacaoPai);

		lblFiliacaoMae = new JLabel("Filia\u00E7\u00E3o ( m\u00E3e )");
		springLayout.putConstraint(SpringLayout.SOUTH, txtNome, -10, SpringLayout.NORTH, lblFiliacaoMae);
		springLayout.putConstraint(SpringLayout.WEST, lblFiliacaoMae, 0, SpringLayout.WEST, txtFiliacaoMae);
		springLayout.putConstraint(SpringLayout.SOUTH, lblFiliacaoMae, -6, SpringLayout.NORTH, txtFiliacaoMae);
		lblFiliacaoMae.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFiliacaoMae.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		frmCadastroDePessoas.getContentPane().add(lblFiliacaoMae);

		cboSexo = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, cboSexo, 20, SpringLayout.WEST,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, cboSexo, -248, SpringLayout.SOUTH,
				frmCadastroDePessoas.getContentPane());
		cboSexo.setForeground(Color.DARK_GRAY);
		springLayout.putConstraint(SpringLayout.NORTH, cboSexo, 252, SpringLayout.NORTH,
				frmCadastroDePessoas.getContentPane());
		cboSexo.setFont(new Font("Lucida Console", Font.BOLD, 14));
		cboSexo.setModel(new DefaultComboBoxModel(new String[] { "", "Masculino", "Feminino" }));
		cboSexo.setToolTipText("");
		frmCadastroDePessoas.getContentPane().add(cboSexo);

		lblCaracteristicas = new JLabel("SELECIONE AS CARACTER\u00CDSTICAS");
		springLayout.putConstraint(SpringLayout.SOUTH, txtFiliacaoPai, -17, SpringLayout.NORTH, lblCaracteristicas);
		springLayout.putConstraint(SpringLayout.SOUTH, txtFiliacaoMae, -17, SpringLayout.NORTH, lblCaracteristicas);
		springLayout.putConstraint(SpringLayout.NORTH, lblCaracteristicas, 200, SpringLayout.NORTH,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblCaracteristicas, 20, SpringLayout.WEST,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblCaracteristicas, 44, SpringLayout.EAST, lblDados);
		lblCaracteristicas.setFont(new Font("Lucida Console", Font.BOLD, 18));
		frmCadastroDePessoas.getContentPane().add(lblCaracteristicas);

		lblSexo = new JLabel("Sexo");
		springLayout.putConstraint(SpringLayout.SOUTH, lblCaracteristicas, -6, SpringLayout.NORTH, lblSexo);
		springLayout.putConstraint(SpringLayout.NORTH, lblSexo, 229, SpringLayout.NORTH,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblSexo, 20, SpringLayout.WEST,
				frmCadastroDePessoas.getContentPane());
		lblSexo.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		frmCadastroDePessoas.getContentPane().add(lblSexo);

		lblBarba = new JLabel("Barba");
		springLayout.putConstraint(SpringLayout.NORTH, lblBarba, 0, SpringLayout.NORTH, lblSexo);
		springLayout.putConstraint(SpringLayout.WEST, lblBarba, 122, SpringLayout.EAST, lblSexo);
		lblBarba.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		frmCadastroDePessoas.getContentPane().add(lblBarba);

		cboBarba = new JComboBox();
		springLayout.putConstraint(SpringLayout.EAST, cboSexo, -6, SpringLayout.WEST, cboBarba);
		springLayout.putConstraint(SpringLayout.EAST, cboBarba, -665, SpringLayout.EAST,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, cboBarba, 0, SpringLayout.SOUTH, cboSexo);
		cboBarba.setForeground(Color.DARK_GRAY);
		springLayout.putConstraint(SpringLayout.WEST, cboBarba, 182, SpringLayout.WEST,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, cboBarba, 6, SpringLayout.SOUTH, lblBarba);
		cboBarba.setFont(new Font("Lucida Console", Font.BOLD, 14));
		cboBarba.setModel(new DefaultComboBoxModel(new String[] { "", "Sem barba", "N\u00E3o se aplica", "Barba cheia",
				"Bigode", "Barba por fazer", "Cavanhaque" }));
		frmCadastroDePessoas.getContentPane().add(cboBarba);

		cboPele = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, cboPele, 20, SpringLayout.WEST,
				frmCadastroDePessoas.getContentPane());
		cboPele.setForeground(Color.DARK_GRAY);
		cboPele.setFont(new Font("Lucida Console", Font.BOLD, 14));
		cboPele.setModel(new DefaultComboBoxModel(
				new String[] { "", "Amarela", "Branca", "Parda", "Negra", "Vermelha", "Indefinida" }));
		frmCadastroDePessoas.getContentPane().add(cboPele);

		lblPele = new JLabel("Cor da pele");
		springLayout.putConstraint(SpringLayout.NORTH, cboPele, 6, SpringLayout.SOUTH, lblPele);
		springLayout.putConstraint(SpringLayout.NORTH, lblPele, 285, SpringLayout.NORTH,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblPele, 20, SpringLayout.WEST,
				frmCadastroDePessoas.getContentPane());
		lblPele.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		frmCadastroDePessoas.getContentPane().add(lblPele);

		cboDeficiencia = new JComboBox();
		springLayout.putConstraint(SpringLayout.EAST, cboPele, -6, SpringLayout.WEST, cboDeficiencia);
		springLayout.putConstraint(SpringLayout.NORTH, cboDeficiencia, 0, SpringLayout.NORTH, cboPele);
		springLayout.putConstraint(SpringLayout.WEST, cboDeficiencia, 182, SpringLayout.WEST,
				frmCadastroDePessoas.getContentPane());
		cboDeficiencia.setForeground(Color.DARK_GRAY);
		springLayout.putConstraint(SpringLayout.EAST, cboDeficiencia, -665, SpringLayout.EAST,
				frmCadastroDePessoas.getContentPane());
		cboDeficiencia.setFont(new Font("Lucida Console", Font.BOLD, 14));
		cboDeficiencia.setModel(new DefaultComboBoxModel(new String[] { "", "Sem defici\u00EAncia", "Abd\u00F4men",
				"Cabe\u00E7a", "Pesco\u00E7o", "Costas", "Perna direita", "Perna esquerda", "Bra\u00E7o direito",
				"Bra\u00E7o esquerdo", "Dedos m\u00E3o direita", "Dedos m\u00E3o esquerda", "M\u00E3o direita",
				"M\u00E3o esquerda", "P\u00E9 direito", "P\u00E9 esquerdo" }));
		frmCadastroDePessoas.getContentPane().add(cboDeficiencia);

		lblDeficiencia = new JLabel("Defici\u00EAncia");
		springLayout.putConstraint(SpringLayout.NORTH, lblDeficiencia, 6, SpringLayout.SOUTH, cboBarba);
		springLayout.putConstraint(SpringLayout.WEST, lblDeficiencia, 0, SpringLayout.WEST, lblBarba);
		lblDeficiencia.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		frmCadastroDePessoas.getContentPane().add(lblDeficiencia);

		cboTipoCabelo = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, cboTipoCabelo, 20, SpringLayout.WEST,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, cboTipoCabelo, -128, SpringLayout.SOUTH,
				frmCadastroDePessoas.getContentPane());
		cboTipoCabelo.setForeground(Color.DARK_GRAY);
		springLayout.putConstraint(SpringLayout.NORTH, cboTipoCabelo, 372, SpringLayout.NORTH,
				frmCadastroDePessoas.getContentPane());
		cboTipoCabelo.setFont(new Font("Lucida Console", Font.BOLD, 14));
		cboTipoCabelo.setModel(new DefaultComboBoxModel(new String[] { "", "Calv\u00EDcie total",
				"Calv\u00EDcie parcial", "Carapinha", "Liso", "Encaracolado", "Ondulado", "Carapinha", "Outro" }));
		frmCadastroDePessoas.getContentPane().add(cboTipoCabelo);

		cboAltura = new JComboBox();
		springLayout.putConstraint(SpringLayout.EAST, cboTipoCabelo, -6, SpringLayout.WEST, cboAltura);
		cboAltura.setForeground(Color.DARK_GRAY);
		springLayout.putConstraint(SpringLayout.WEST, cboAltura, 182, SpringLayout.WEST,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, cboAltura, -665, SpringLayout.EAST,
				frmCadastroDePessoas.getContentPane());
		cboAltura.setFont(new Font("Lucida Console", Font.BOLD, 14));
		cboAltura.setModel(new DefaultComboBoxModel(new String[] { "", "1.10", "1.20", "1.30", "1.40", "1.50", "1.60",
				"1.70", "1.80", "1.90", "2.00", "2.10", "2.20" }));
		frmCadastroDePessoas.getContentPane().add(cboAltura);

		lblAltura = new JLabel("Altura aprox");
		springLayout.putConstraint(SpringLayout.NORTH, cboAltura, 6, SpringLayout.SOUTH, lblAltura);
		springLayout.putConstraint(SpringLayout.SOUTH, cboDeficiencia, -14, SpringLayout.NORTH, lblAltura);
		springLayout.putConstraint(SpringLayout.SOUTH, lblAltura, -160, SpringLayout.SOUTH,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblAltura, 349, SpringLayout.NORTH,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblAltura, 0, SpringLayout.WEST, lblBarba);
		lblAltura.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		frmCadastroDePessoas.getContentPane().add(lblAltura);

		cboOlhos = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, txtFiliacaoMae, 0, SpringLayout.WEST, cboOlhos);
		springLayout.putConstraint(SpringLayout.WEST, cboOlhos, 6, SpringLayout.EAST, cboBarba);
		cboOlhos.setForeground(Color.DARK_GRAY);
		cboOlhos.setFont(new Font("Lucida Console", Font.BOLD, 14));
		cboOlhos.setModel(new DefaultComboBoxModel(new String[] { "", "Azuis", "Verdes", "Castanhos claros",
				"Castanhos escuros", "Cinzentos", "Pretos", "Desiguais", "Verdes", "Outros" }));
		frmCadastroDePessoas.getContentPane().add(cboOlhos);

		cboCorCabelo = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, cboCorCabelo, 6, SpringLayout.EAST, cboDeficiencia);
		cboCorCabelo.setForeground(Color.DARK_GRAY);
		cboCorCabelo.setModel(new DefaultComboBoxModel(new String[] { "", "Castanhos escuros", "Castanhos claros",
				"Pretos", "Brancos", "Grisalho total", "Grisalho parcial", "Louros", "Ruivos" }));
		cboCorCabelo.setFont(new Font("Lucida Console", Font.BOLD, 14));
		frmCadastroDePessoas.getContentPane().add(cboCorCabelo);

		cboFisico = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, cboFisico, 6, SpringLayout.EAST, cboAltura);
		cboFisico.setForeground(Color.DARK_GRAY);
		cboFisico.setFont(new Font("Tahoma", Font.BOLD, 14));
		cboFisico.setModel(new DefaultComboBoxModel(new String[] { "", "Forte", "Magro", "Atl\u00E9tico", "Gordo" }));
		frmCadastroDePessoas.getContentPane().add(cboFisico);

		cboTatuagens = new JComboBox();
		springLayout.putConstraint(SpringLayout.EAST, cboOlhos, -6, SpringLayout.WEST, cboTatuagens);
		springLayout.putConstraint(SpringLayout.WEST, cboTatuagens, 531, SpringLayout.WEST,
				frmCadastroDePessoas.getContentPane());
		cboTatuagens.setForeground(Color.DARK_GRAY);
		springLayout.putConstraint(SpringLayout.EAST, cboTatuagens, -317, SpringLayout.EAST,
				frmCadastroDePessoas.getContentPane());
		cboTatuagens.setFont(new Font("Lucida Console", Font.BOLD, 14));
		cboTatuagens.setModel(new DefaultComboBoxModel(new String[] { "", "Sem tatuagens", "Abd\u00F4men",
				"Cabe\u00E7a", "Pesco\u00E7o", "Costas", "Perna direita", "Perna esquerda", "Bra\u00E7o direito",
				"Bra\u00E7o esquerdo", "Dedos m\u00E3o direita", "Dedos m\u00E3o esquerda", "M\u00E3o direita",
				"M\u00E3o esquerda", "P\u00E9 direito", "P\u00E9 esquerdo" }));
		frmCadastroDePessoas.getContentPane().add(cboTatuagens);

		cboCicatrizes = new JComboBox();
		springLayout.putConstraint(SpringLayout.EAST, cboCorCabelo, -6, SpringLayout.WEST, cboCicatrizes);
		springLayout.putConstraint(SpringLayout.WEST, cboCicatrizes, 531, SpringLayout.WEST,
				frmCadastroDePessoas.getContentPane());
		cboCicatrizes.setForeground(Color.DARK_GRAY);
		springLayout.putConstraint(SpringLayout.EAST, cboCicatrizes, 0, SpringLayout.EAST, cboTatuagens);
		cboCicatrizes.setFont(new Font("Lucida Console", Font.BOLD, 14));
		cboCicatrizes.setModel(new DefaultComboBoxModel(new String[] { "", "Sem cicatrizes", "Abd\u00F4men",
				"Cabe\u00E7a", "Pesco\u00E7o", "Costas", "Perna direita", "Perna esquerda", "Bra\u00E7o direito",
				"Bra\u00E7o esquerdo", "Dedos m\u00E3o direita", "Dedos m\u00E3o esquerda", "M\u00E3o direita",
				"M\u00E3o esquerda", "P\u00E9 direito", "P\u00E9 esquerdo" }));
		frmCadastroDePessoas.getContentPane().add(cboCicatrizes);

		cboIdade = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, cboIdade, 531, SpringLayout.WEST,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, cboFisico, -6, SpringLayout.WEST, cboIdade);
		springLayout.putConstraint(SpringLayout.EAST, cboIdade, -317, SpringLayout.EAST,
				frmCadastroDePessoas.getContentPane());
		cboIdade.setForeground(Color.DARK_GRAY);
		cboIdade.setFont(new Font("Lucida Console", Font.BOLD, 14));
		cboIdade.setModel(new DefaultComboBoxModel(new String[] { "", "05", "10", "15", "20", "25", "30", "35", "40",
				"55", "60", "65", "75", "75", "80", "85", "90", "95" }));
		frmCadastroDePessoas.getContentPane().add(cboIdade);

		lblOlhos = new JLabel("Cor dos olhos");
		springLayout.putConstraint(SpringLayout.WEST, lblOlhos, 127, SpringLayout.EAST, lblBarba);
		springLayout.putConstraint(SpringLayout.EAST, lblOlhos, -515, SpringLayout.EAST,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, cboOlhos, 6, SpringLayout.SOUTH, lblOlhos);
		springLayout.putConstraint(SpringLayout.NORTH, lblOlhos, 6, SpringLayout.SOUTH, lblCaracteristicas);
		lblOlhos.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		frmCadastroDePessoas.getContentPane().add(lblOlhos);

		lblCorCabelo = new JLabel("Cor do cabelo");
		springLayout.putConstraint(SpringLayout.WEST, lblCorCabelo, 67, SpringLayout.EAST, lblDeficiencia);
		springLayout.putConstraint(SpringLayout.NORTH, cboCorCabelo, 6, SpringLayout.SOUTH, lblCorCabelo);
		springLayout.putConstraint(SpringLayout.SOUTH, cboOlhos, -6, SpringLayout.NORTH, lblCorCabelo);
		springLayout.putConstraint(SpringLayout.NORTH, lblCorCabelo, 0, SpringLayout.NORTH, lblPele);
		lblCorCabelo.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		frmCadastroDePessoas.getContentPane().add(lblCorCabelo);

		lblFisico = new JLabel("Porte f\u00EDsico");
		springLayout.putConstraint(SpringLayout.NORTH, cboFisico, 6, SpringLayout.SOUTH, lblFisico);
		springLayout.putConstraint(SpringLayout.WEST, lblFisico, 57, SpringLayout.EAST, lblAltura);
		springLayout.putConstraint(SpringLayout.SOUTH, cboCorCabelo, -14, SpringLayout.NORTH, lblFisico);
		springLayout.putConstraint(SpringLayout.NORTH, lblFisico, 0, SpringLayout.NORTH, lblAltura);
		lblFisico.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		frmCadastroDePessoas.getContentPane().add(lblFisico);

		lblTatuagens = new JLabel("Tatuagens");
		springLayout.putConstraint(SpringLayout.NORTH, cboTatuagens, 6, SpringLayout.SOUTH, lblTatuagens);
		springLayout.putConstraint(SpringLayout.NORTH, lblTatuagens, 0, SpringLayout.NORTH, lblSexo);
		springLayout.putConstraint(SpringLayout.WEST, lblTatuagens, 26, SpringLayout.EAST, lblOlhos);
		lblTatuagens.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		frmCadastroDePessoas.getContentPane().add(lblTatuagens);

		lblCicatrizes = new JLabel("Cicatrizes");
		springLayout.putConstraint(SpringLayout.EAST, lblCorCabelo, -16, SpringLayout.WEST, lblCicatrizes);
		springLayout.putConstraint(SpringLayout.SOUTH, cboTatuagens, -6, SpringLayout.NORTH, lblCicatrizes);
		springLayout.putConstraint(SpringLayout.NORTH, cboCicatrizes, 6, SpringLayout.SOUTH, lblCicatrizes);
		springLayout.putConstraint(SpringLayout.NORTH, lblCicatrizes, 0, SpringLayout.NORTH, lblPele);
		springLayout.putConstraint(SpringLayout.WEST, lblCicatrizes, 0, SpringLayout.WEST, cboTatuagens);
		lblCicatrizes.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		frmCadastroDePessoas.getContentPane().add(lblCicatrizes);

		lblIdade = new JLabel("Idade aprox");
		springLayout.putConstraint(SpringLayout.EAST, lblFisico, -11, SpringLayout.WEST, lblIdade);
		springLayout.putConstraint(SpringLayout.NORTH, cboIdade, 6, SpringLayout.SOUTH, lblIdade);
		springLayout.putConstraint(SpringLayout.NORTH, lblIdade, 349, SpringLayout.NORTH,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, cboCicatrizes, -14, SpringLayout.NORTH, lblIdade);
		springLayout.putConstraint(SpringLayout.WEST, lblIdade, 0, SpringLayout.WEST, cboTatuagens);
		lblIdade.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		frmCadastroDePessoas.getContentPane().add(lblIdade);

		JButton btnCadastrar = new JButton("CADASTRAR");
		springLayout.putConstraint(SpringLayout.NORTH, btnCadastrar, 104, SpringLayout.NORTH, lblAltura);
		springLayout.putConstraint(SpringLayout.SOUTH, btnCadastrar, -47, SpringLayout.SOUTH,
				frmCadastroDePessoas.getContentPane());

		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MensagemErroCadastro erro = new MensagemErroCadastro();
				erro.setLocationRelativeTo(frmCadastroDePessoas);
				MensagemSucessoCadastro confirmacao = new MensagemSucessoCadastro();
				confirmacao.setLocationRelativeTo(frmCadastroDePessoas);

				if ((txtDocumento.getText().equals("") && txtNome.getText().equals("")
						&& txtFiliacaoPai.getText().equals("") && txtFiliacaoMae.getText().equals(""))
						&& cboSexo.getSelectedItem().equals("") | cboPele.getSelectedItem().equals("")
								| cboAltura.getSelectedItem().equals("") | cboBarba.getSelectedItem().equals("")
								| cboCicatrizes.getSelectedItem().equals("")
								| cboDeficiencia.getSelectedItem().equals("") | cboFisico.getSelectedItem().equals("")
								| cboIdade.getSelectedItem().equals("") | cboOlhos.getSelectedItem().equals("")
								| cboPele.getSelectedItem().equals("") | cboTatuagens.getSelectedItem().equals("")
								| cboTipoCabelo.getSelectedItem().equals("") | txtObservacao.getText().equals("")) {

					erro.setVisible(true);

				} else {

					String nome;
					String nomePai;
					String nomeMae;
					String observacao;
					String documento = txtDocumento.getText().toString();
					Identificacao identificacao = new Identificacao();
					Base64Conversor base64Conversor = new Base64Conversor();
					String base64 = base64Conversor.convertByteArrayToBase64String(bytesImagem);

					if (!(chkIdentificacao.isSelected())) {

						nome = txtNome.getText().toString();
						nomePai = txtFiliacaoPai.getText().toString();
						nomeMae = txtFiliacaoMae.getText().toString();
						observacao = txtObservacao.getText().toString();
						identificacao.setIdInstituicaofk(48);
						identificacao.setDocumento(documento);
						identificacao.setNome(nome);
						identificacao.setNomePai(nomePai);
						identificacao.setNomeMae(nomeMae);
						identificacao.setObservacao(observacao);
						identificacao.setFotoBase64(base64);
						String identificacaoXml = new XmlConversor().toXML(identificacao);
						try {
							String resposta = new ServiceControllerHTTP().sendPOST(URL_CADASTRAR_IDENTIFICACAO,
									identificacaoXml);
							if (resposta.equalsIgnoreCase("true")) {
								confirmacao.setVisible(true);
								txtDocumento.setText("");
								txtNome.setText("");
								txtFiliacaoPai.setText("");
								txtFiliacaoMae.setText("");
								txtObservacao.setText("");
							} else {
								erro.setVisible(true);
							}
						} catch (MinhaException e) {
							e.printStackTrace();
						}

					} else if (chkIdentificacao.isSelected()) {

						Caracteristica caracteristica = new Caracteristica();
						caracteristica.setSexo((String) cboSexo.getSelectedItem());
						caracteristica.setPele((String) cboPele.getSelectedItem());
						caracteristica.setOlhos((String) cboOlhos.getSelectedItem());
						caracteristica.setCorCabelo((String) cboCorCabelo.getSelectedItem());
						caracteristica.setIdade(Integer.parseInt((String) cboIdade.getSelectedItem()));
						caracteristica.setAltura(Double.parseDouble((String) cboAltura.getSelectedItem()));
						caracteristica.setBarba((String) cboBarba.getSelectedItem());
						caracteristica.setCicatrizes((String) cboCicatrizes.getSelectedItem());
						caracteristica.setDeficiencia((String) cboDeficiencia.getSelectedItem());
						caracteristica.setFisico((String) cboFisico.getSelectedItem());
						caracteristica.setIdInstituicaofk(74);
						caracteristica.setTatuagens((String) cboTatuagens.getSelectedItem());
						caracteristica.setTipoCabelo((String) cboTipoCabelo.getSelectedItem());
						caracteristica.setObservacao(txtObservacao.getText());
						caracteristica.setFotoBase64(base64);
						String caracterisitcasXml = new XmlConversor().toXML(caracteristica);
						try {
							String resposta = new ServiceControllerHTTP().sendPOST(URL_CADASTRAR_CARACTERISTICAS,
									caracterisitcasXml);
							if (resposta.equalsIgnoreCase("true")) {
								confirmacao.setVisible(true);
							} else {
								erro.setVisible(true);
							}
						} catch (MinhaException e) {
							e.printStackTrace();
						}

					}

				}
			}

		});
		btnCadastrar.setBackground(SystemColor.textHighlight);
		btnCadastrar.setForeground(SystemColor.controlLtHighlight);
		btnCadastrar.setFont(new Font("Lucida Console", Font.PLAIN, 16));

		frmCadastroDePessoas.getContentPane().add(btnCadastrar);

		btnIncluirFoto = new JButton("INCLUIR FOTO");
		springLayout.putConstraint(SpringLayout.EAST, btnCadastrar, 0, SpringLayout.EAST, btnIncluirFoto);
		springLayout.putConstraint(SpringLayout.WEST, btnIncluirFoto, 749, SpringLayout.WEST,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnIncluirFoto, -23, SpringLayout.EAST,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnIncluirFoto, 308, SpringLayout.NORTH,
				frmCadastroDePessoas.getContentPane());
		btnIncluirFoto.setForeground(SystemColor.text);
		btnIncluirFoto.setBackground(SystemColor.textHighlight);
		btnIncluirFoto.setFont(new Font("Lucida Console", Font.PLAIN, 16));

		btnIncluirFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChoser = new JFileChooser();
				fileChoser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				fileChoser.showOpenDialog(null);
				File imagem = fileChoser.getSelectedFile();
				if (imagem != null) {
					Base64Conversor base64Conversor = new Base64Conversor();
					bytesImagem = base64Conversor.convertImageToByte(imagem.getAbsolutePath());
					ImageIcon icon = new ImageIcon(bytesImagem);
					icon.setImage(icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), 1));
					lblFoto.setIcon(icon);
				}

			}
		});
		frmCadastroDePessoas.getContentPane().add(btnIncluirFoto);

		lblFoto = new JLabel(new ImageIcon("imagens/avatar_foto.png"));
		springLayout.putConstraint(SpringLayout.EAST, txtNome, -52, SpringLayout.WEST, lblFoto);
		springLayout.putConstraint(SpringLayout.EAST, txtFiliacaoMae, -52, SpringLayout.WEST, lblFoto);
		springLayout.putConstraint(SpringLayout.EAST, lblDados, -411, SpringLayout.WEST, lblFoto);
		springLayout.putConstraint(SpringLayout.SOUTH, lblFoto, -223, SpringLayout.SOUTH,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblFoto, 22, SpringLayout.NORTH,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblFoto, 52, SpringLayout.EAST, cboTatuagens);
		springLayout.putConstraint(SpringLayout.EAST, lblFoto, -23, SpringLayout.EAST,
				frmCadastroDePessoas.getContentPane());
		lblFoto.setFont(new Font("Lucida Console", Font.PLAIN, 20));
		frmCadastroDePessoas.getContentPane().add(lblFoto);

		JLabel lblTipoCabelo = new JLabel("Tipo do cabelo");
		springLayout.putConstraint(SpringLayout.SOUTH, lblTipoCabelo, -6, SpringLayout.NORTH, cboTipoCabelo);
		springLayout.putConstraint(SpringLayout.SOUTH, cboPele, -14, SpringLayout.NORTH, lblTipoCabelo);
		springLayout.putConstraint(SpringLayout.WEST, lblTipoCabelo, 20, SpringLayout.WEST,
				frmCadastroDePessoas.getContentPane());
		lblTipoCabelo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipoCabelo.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		frmCadastroDePessoas.getContentPane().add(lblTipoCabelo);

		txtObservacao = new JTextArea();
		springLayout.putConstraint(SpringLayout.WEST, btnCadastrar, 52, SpringLayout.EAST, txtObservacao);
		springLayout.putConstraint(SpringLayout.SOUTH, cboIdade, -36, SpringLayout.NORTH, txtObservacao);
		txtObservacao.setFont(new Font("Lucida Console", Font.BOLD, 15));
		txtObservacao.setForeground(Color.DARK_GRAY);
		springLayout.putConstraint(SpringLayout.NORTH, txtObservacao, -92, SpringLayout.SOUTH,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtObservacao, 0, SpringLayout.WEST, lblDados);
		springLayout.putConstraint(SpringLayout.SOUTH, txtObservacao, -24, SpringLayout.SOUTH,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtObservacao, 0, SpringLayout.EAST, cboTatuagens);
		frmCadastroDePessoas.getContentPane().add(txtObservacao);

		lblObservacao = new JLabel("DESCREVA O LOCAL ONDE A PESSOA FOI LOCALIZADA ");
		springLayout.putConstraint(SpringLayout.WEST, lblObservacao, 103, SpringLayout.WEST,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblObservacao, -561, SpringLayout.EAST,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, cboFisico, -17, SpringLayout.NORTH, lblObservacao);
		springLayout.putConstraint(SpringLayout.SOUTH, cboAltura, -17, SpringLayout.NORTH, lblObservacao);
		springLayout.putConstraint(SpringLayout.SOUTH, lblObservacao, -6, SpringLayout.NORTH, txtObservacao);
		lblObservacao.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		frmCadastroDePessoas.getContentPane().add(lblObservacao);

		JLabel lblNewLabel = new JLabel("OBSERVA\u00C7\u00D5ES");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -6, SpringLayout.NORTH, txtObservacao);
		lblNewLabel.setFont(new Font("Lucida Console", Font.ITALIC, 12));
		lblNewLabel.setForeground(Color.RED);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblDados);
		frmCadastroDePessoas.getContentPane().add(lblNewLabel);

		chkIdentificacao = new JCheckBox("MARCAR COMO NAO IDENTIFICADO");
		springLayout.putConstraint(SpringLayout.WEST, chkIdentificacao, 37, SpringLayout.EAST, lblNome);
		springLayout.putConstraint(SpringLayout.SOUTH, chkIdentificacao, -442, SpringLayout.SOUTH,
				frmCadastroDePessoas.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, chkIdentificacao, -52, SpringLayout.WEST, lblFoto);

		chkIdentificacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (chkIdentificacao.isSelected()) {
					txtDocumento.setEditable(false);
					txtNome.setEditable(false);
					txtFiliacaoPai.setEditable(false);
					txtFiliacaoMae.setEditable(false);
				} else {
					txtDocumento.setEditable(true);
					txtNome.setEditable(true);
					txtFiliacaoPai.setEditable(true);
					txtFiliacaoMae.setEditable(true);

				}

			}
		});
		chkIdentificacao.setFont(new Font("Lucida Console", Font.BOLD, 13));
		frmCadastroDePessoas.getContentPane().add(chkIdentificacao);
	}

}
