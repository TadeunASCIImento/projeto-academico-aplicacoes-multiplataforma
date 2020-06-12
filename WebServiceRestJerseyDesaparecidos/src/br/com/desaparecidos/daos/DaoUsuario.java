package br.com.desaparecidos.daos;

import java.sql.SQLException;
import java.util.List;

import br.com.desaparecidos.entities.Entitie;
import br.com.desaparecidos.entities.Usuario;

public class DaoUsuario extends DaoConnection implements DaoFunctions {

	public Usuario validate(Usuario usu) {
		Usuario usuario = new Usuario();
		String SQL = "SELECT id,nome,cpf,email,senha FROM Usuario WHERE email = ? AND senha = ?";
		try {
			this.obterConexao();
			this.pstm = this.conn.prepareStatement(SQL);
			this.pstm.setString(1, usu.getEmail());
			this.pstm.setString(2, usu.getSenha());
			this.resultado = this.pstm.executeQuery();
			while (this.resultado.next()) {
				usuario.setId(this.resultado.getInt("id"));
				usuario.setEmail(this.resultado.getString("email"));
				usuario.setSenha(this.resultado.getString("senha"));
				usuario.setNome(this.resultado.getString("nome"));
				usuario.setCpf(this.resultado.getString("cpf"));
			}
		} catch (SQLException exc) {
			exc.printStackTrace();
		} finally {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return usuario;
	}

	@Override
	public boolean add(Entitie entitie) {
		Usuario usuario = (Usuario) entitie;
		String SQL = "INSERT INTO Usuario (email,senha,nome,cpf) VALUES(?,?,?,?)";
		try {
			this.obterConexao();
			this.pstm = this.conn.prepareStatement(SQL);
			this.pstm.setString(1, usuario.getEmail());
			this.pstm.setString(2, usuario.getSenha());
			this.pstm.setString(3, usuario.getNome());
			this.pstm.setString(4, usuario.getCpf());
			this.pstm.execute();
			return true;
		} catch (SQLException exc) {
			exc.printStackTrace();
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
		// TODO Auto-generated method stub
		return null;
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
