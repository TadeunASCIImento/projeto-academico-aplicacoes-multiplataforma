package br.com.desaparecidos.daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.desaparecidos.entities.Entitie;
import br.com.desaparecidos.entities.Identificacao;

public class DaoIdentificacao extends DaoConnection implements DaoFunctions {

	@Override
	public boolean add(Entitie entitie) {
		Identificacao identificacao = (Identificacao) entitie;
		String SQL = "INSERT INTO identificacao(cpf,nome,pai,mae,id_instituicao_fk,observacao,foto)"
				+ "VALUES(?,?,?,?,?,?,?)";
		try {
			this.obterConexao();
			this.pstm = this.conn.prepareStatement(SQL);
			this.pstm.setString(1, identificacao.getDocumento());
			this.pstm.setString(2, identificacao.getNome());
			this.pstm.setString(3, identificacao.getNomePai());
			this.pstm.setString(4, identificacao.getNomeMae());
			this.pstm.setInt(5, identificacao.getIdInstituicaofk());
			this.pstm.setString(6, identificacao.getObservacao());
			this.pstm.setString(7, identificacao.getFotoBase64());
			this.pstm.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public Entitie findOne(Entitie entitie) {
		Identificacao identificacao = (Identificacao) entitie;
		String SQL = "SELECT * FROM Identificacao WHERE cpf = ? AND pai = ? AND mae = ?";
		try {
			this.obterConexao();
			this.pstm = this.conn.prepareStatement(SQL);
			this.pstm.setString(1, identificacao.getDocumento());
			this.pstm.setString(2, identificacao.getNomePai());
			this.pstm.setString(3, identificacao.getNomeMae());
			this.resultado = this.pstm.executeQuery();
			while (this.resultado.next()) {
				identificacao.setIdIdentificacao(this.resultado.getInt("id_identificacao"));
				identificacao.setNome(this.resultado.getString("nome"));
				identificacao.setDocumento(this.resultado.getString("cpf"));
				identificacao.setNomePai(this.resultado.getString("pai"));
				identificacao.setNomeMae(this.resultado.getString("mae"));
				identificacao.setDataRegistro(this.resultado.getDate("data_registro"));
				identificacao.setIdInstituicaofk(this.resultado.getInt("id_instituicao_fk"));
				identificacao.setObservacao(this.resultado.getString("observacao"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return identificacao;
	}

	@Override
	public List<Entitie> findAll(Entitie entitie) {
		Identificacao identidade = (Identificacao) entitie;
		List<Entitie> lstIdentificacao = new ArrayList<>();
		String SQL = "SELECT * FROM Identificacao WHERE cpf = ? AND pai = ? AND mae = ?";
		try {
			this.obterConexao();
			this.pstm = this.conn.prepareStatement(SQL);
			this.pstm.setString(1, identidade.getDocumento());
			this.pstm.setString(2, identidade.getNomePai());
			this.pstm.setString(3, identidade.getNomeMae());
			this.resultado = this.pstm.executeQuery();
			while (this.resultado.next()) {
				Identificacao identificacao = new Identificacao();
				identificacao.setIdIdentificacao(this.resultado.getInt("id_identificacao"));
				identificacao.setNome(this.resultado.getString("nome"));
				identificacao.setDocumento(this.resultado.getString("cpf"));
				identificacao.setNomePai(this.resultado.getString("pai"));
				identificacao.setNomeMae(this.resultado.getString("mae"));
				identificacao.setDataRegistro(this.resultado.getTimestamp("data_registro"));
				identificacao.setIdInstituicaofk(this.resultado.getInt("id_instituicao_fk"));
				identificacao.setObservacao(this.resultado.getString("observacao"));
				lstIdentificacao.add(identificacao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lstIdentificacao;
	}

	@Override
	public String findImage(Integer id) {
		String SQL = "SELECT foto FROM Identificacao WHERE id_identificacao = ? ";
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
		} finally {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return codeBase64;
	}

}
