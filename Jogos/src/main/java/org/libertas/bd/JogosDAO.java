package org.libertas.bd;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;


public class JogosDAO {
	public void inserir(Jogos j) {
		Conexao con = new Conexao();
		try {
			String sql = "INSERT INTO jogos"
					+ " (nome, plataforma, lancamento, modoonline, quantidadejogadores ) VALUES (?, ?, ?, ?, ?) ";
			PreparedStatement prep = con.getConexao().prepareStatement(sql);
			prep.setString(1, j.getNome());
			prep.setString(2, j.getPlataforma());
			prep.setString(3, j.getLancamento());
			prep.setString(4, j.getModoonline());
			prep.setString(5, j.getQuantidadejogadores());
			prep.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconectar();
	}
	public void alterar(Jogos j) {
		Conexao con = new Conexao();
		try {
			String sql = "UPDATE jogos"
					+ " SET nome = ?, plataforma = ?, lancamento = ?, modoonline = ?, quantidadejogadores = ?  "
					+ " WHERE id = ? ";
			PreparedStatement prep = con.getConexao().prepareStatement(sql);
			prep.setString(1, j.getNome());
			prep.setString(2, j.getPlataforma());
			prep.setString(3, j.getLancamento());
			prep.setString(4, j.getModoonline());
			prep.setString(5, j.getQuantidadejogadores());
			prep.setInt(6, j.getId());
			prep.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconectar();
		
	}
	
	public void excluir(Jogos j) {
		Conexao con = new Conexao();
		try {
			String sql = " DELETE FROM jogos "
					+ " WHERE id = ? ";
			PreparedStatement prep = con.getConexao().prepareStatement(sql);
			prep.setInt(1, j.getId());
			
			prep.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconectar();
		
	}

	public Jogos consultar(int id) {

		Jogos j = new Jogos();
		Conexao con = new Conexao();
		try {
			String sql = "SELECT * FROM jogos WHERE id = " + id;
			Statement sta = con.getConexao().createStatement();
			ResultSet res = sta.executeQuery(sql);
			while (res.next()) {
				j.setId(res.getInt("id"));
				j.setNome(res.getString("nome"));
				j.setPlataforma(res.getString("plataforma"));
				j.setLancamento(res.getString("lancamento"));
				j.setModoonline(res.getString("modoonline"));
				j.setQuantidadejogadores(res.getString("quantidadejogadores"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconectar();
		return j;
	}
		
	public List<Jogos> listar(){
		List<Jogos> lista = new LinkedList<Jogos>();
			Conexao con = new Conexao();
		
		try {
			String sql = "SELECT * FROM jogos ORDER BY id";
			Statement sta = con.getConexao().createStatement();
			ResultSet res = sta.executeQuery(sql);
			while (res.next()) {
				Jogos j = new Jogos();
				j.setId(res.getInt("id"));
				j.setNome(res.getString("nome"));
				j.setPlataforma(res.getString("plataforma"));
				j.setLancamento(res.getString("lancamento"));
				j.setModoonline(res.getString("modoonline"));
				j.setQuantidadejogadores(res.getString("quantidadejogadores"));
				
				lista.add(j);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconectar();
		return lista;
	}
}

