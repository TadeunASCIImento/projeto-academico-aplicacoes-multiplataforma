package br.com.desaparecidos.daos;

import java.sql.SQLException;
import java.util.List;

import br.com.desaparecidos.entities.Endereco;
import br.com.desaparecidos.entities.Entitie;

public class DaoEndereco extends DaoConnection implements DaoFunctions {

	@Override
	public Entitie findOne(Entitie entitie) {
		Endereco endereco = (Endereco) entitie;
		String SQL = "SELECT * FROM endereco WHERE id_endereco = ? ";
		try {
			this.obterConexao();
			this.pstm = this.conn.prepareStatement(SQL);
			this.pstm.setInt(1, endereco.getIdEndereco());
			this.resultado = this.pstm.executeQuery();
			while (this.resultado.next()) {
				endereco.setIdEndereco(this.resultado.getInt("id_endereco"));
				endereco.setCep(this.resultado.getString("cep"));
				endereco.setLogradouro(this.resultado.getString("logradouro"));
				endereco.setBairro(this.resultado.getString("bairro"));
				endereco.setCidade(this.resultado.getString("cidade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return endereco;
	}

	@Override
	public boolean add(Entitie entitie) {
		// TODO Auto-generated method stub
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
