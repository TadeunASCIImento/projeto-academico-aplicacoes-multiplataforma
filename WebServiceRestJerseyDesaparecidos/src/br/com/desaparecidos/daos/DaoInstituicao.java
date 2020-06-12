package br.com.desaparecidos.daos;

import java.sql.SQLException;
import java.util.List;

import br.com.desaparecidos.entities.Entitie;
import br.com.desaparecidos.entities.Instituicao;

public class DaoInstituicao extends DaoConnection implements DaoFunctions {

	@Override
	public Entitie findOne(Entitie entitie) {
		Instituicao instituicao = (Instituicao) entitie;
		String SQL = "SELECT * FROM Instituicao WHERE id_instituicao = ?";
		try {
			this.obterConexao();
			this.pstm = this.conn.prepareStatement(SQL);
			this.pstm.setInt(1, instituicao.getIdInstituicao());
			this.resultado = this.pstm.executeQuery();
			while (this.resultado.next()) {
				instituicao.setIdInstituicao(this.resultado.getInt("id_instituicao"));
				instituicao.setIdEnderecofk(this.resultado.getInt("id_endereco_fk"));
				instituicao.setNomeInstituicao(this.resultado.getString("nome"));
				instituicao.setTelefone(this.resultado.getString("telefone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return instituicao;
	}

	@Override
	public boolean add(Entitie entitie) {
		return false;
	}

	@Override
	public String findImage(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entitie> findAll(Entitie entitie) {
		// TODO Auto-generated method stub
		return null;
	}

}
