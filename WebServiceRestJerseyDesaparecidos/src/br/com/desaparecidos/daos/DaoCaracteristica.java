package br.com.desaparecidos.daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.desaparecidos.entities.Caracteristica;
import br.com.desaparecidos.entities.Entitie;

public class DaoCaracteristica extends DaoConnection implements DaoFunctions {

	@Override
	public List<Entitie> findAll(Entitie entitie) {
		Caracteristica caracteristica = (Caracteristica) entitie;
		List<Entitie> lista = new ArrayList<>();
		String SQL = " SELECT * FROM Caracteristicas " + "WHERE " + "sexo = ? " + "AND pele = ? " + "AND olhos = ? "
				+ "AND idade = ? " + "AND cor_cabelo = ? " + "AND fisico = ? " + "AND tipo_cabelo = ? "
				+ "AND altura = ? " + "AND barba = ? " + "AND tatuagens = ?" + "AND cicatrizes = ? "
				+ "AND deficiencias = ? ";
		try {
			this.obterConexao();
			this.pstm = this.conn.prepareStatement(SQL);
			this.pstm.setString(1, caracteristica.getSexo());
			this.pstm.setString(2, caracteristica.getPele());
			this.pstm.setString(3, caracteristica.getOlhos());
			this.pstm.setInt(4, caracteristica.getIdade());
			this.pstm.setString(5, caracteristica.getCorCabelo());
			this.pstm.setString(6, caracteristica.getFisico());
			this.pstm.setString(7, caracteristica.getTipoCabelo());
			this.pstm.setDouble(8, caracteristica.getAltura());
			this.pstm.setString(9, caracteristica.getBarba());
			this.pstm.setString(10, caracteristica.getTatuagens());
			this.pstm.setString(11, caracteristica.getCicatrizes());
			this.pstm.setString(12, caracteristica.getDeficiencia());
			this.resultado = this.pstm.executeQuery();
			while (this.resultado.next()) {
				Caracteristica caract = new Caracteristica();
				caract.setIdCaracteristica(this.resultado.getInt("id_caracteristicas"));
				caract.setDataRegistro(this.resultado.getDate("data_registro"));
				caract.setIdInstituicaofk(this.resultado.getInt("id_instituicao_fk"));
				caract.setObservacao(this.resultado.getString("observacao"));
				lista.add(caract);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public String findImage(Integer id) {
		String SQL = "SELECT foto FROM Caracteristicas WHERE id_caracteristicas = ? ";
		String codeBase64 = null;
		try {
			this.obterConexao();
			this.pstm = this.conn.prepareStatement(SQL);
			this.pstm.setInt(1, id);
			this.resultado = this.pstm.executeQuery();
			while (this.resultado.next()) {
				codeBase64 = this.resultado.getString("foto");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codeBase64;
	}

	@Override
	public boolean add(Entitie entitie){
		Caracteristica caracteristica = (Caracteristica) entitie;
		String SQL = "INSERT INTO Caracteristicas(sexo,pele,olhos,idade,cor_cabelo,fisico,tipo_cabelo,altura,barba,"
				+ "tatuagens,cicatrizes,deficiencias,id_instituicao_fk,observacao,foto)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			this.obterConexao();
			this.pstm = this.conn.prepareStatement(SQL);
			this.pstm.setString(1, caracteristica.getSexo());
			this.pstm.setString(2, caracteristica.getPele());
			this.pstm.setString(3, caracteristica.getOlhos());
			this.pstm.setInt(4, caracteristica.getIdade());
			this.pstm.setString(5, caracteristica.getCorCabelo());
			this.pstm.setString(6, caracteristica.getFisico());
			this.pstm.setString(7, caracteristica.getTipoCabelo());
			this.pstm.setDouble(8, caracteristica.getAltura());
			this.pstm.setString(9, caracteristica.getBarba());
			this.pstm.setString(10, caracteristica.getTatuagens());
			this.pstm.setString(11, caracteristica.getCicatrizes());
			this.pstm.setString(12, caracteristica.getDeficiencia());
			this.pstm.setInt(13, caracteristica.getIdInstituicaofk());
			this.pstm.setString(14, caracteristica.getObservacao());
			this.pstm.setString(15, caracteristica.getFotoBase64());
			this.pstm.execute();
            return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Entitie findOne(Entitie entitie) {

		return null;
	}

}
