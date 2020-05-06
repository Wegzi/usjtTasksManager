package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Noticia;

import java.sql.ResultSet;

public class NoticiaDAO {

	private Connection conexao;

	public NoticiaDAO() {
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Noticia noticia) {
		System.out.println(noticia.getTitulo());
		String inserir = "INSERT INTO noticia (descricao, texto, titulo) VALUES (?, ?, ?) ";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			pst.setString(1, noticia.getDescricao());
			pst.setString(2, noticia.getTexto());
			pst.setString(3, noticia.getTitulo());
			pst.execute();
		} catch (SQLException ex) {
			System.err.println("Não foi possível manipular a tabela noticia.");
			ex.printStackTrace();
		}
	}

	public void alterar(Noticia noticia) {

		String inserir = "UPDATE noticia SET descricao = ?, texto = ?, titulo = ? WHERE id = ? ";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			pst.setString(1, noticia.getDescricao());
			pst.setString(2, noticia.getTexto());
			pst.setString(3, noticia.getTitulo());
			pst.setInt(4, noticia.getId());

			pst.execute();

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular a tabela Professor.");
			ex.printStackTrace();

		}
	}

	public void excluir(Noticia noticia) {

		String inserir = "DELETE FROM comentario WHERE fk_noticia_id  = ?";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {
			pst.setInt(1, noticia.getId());
			pst.execute();
		} catch (SQLException ex) {
			System.err.println("Não foi possível manipular a tabela Professor.");
			ex.printStackTrace();
		}
		inserir = "DELETE FROM noticia WHERE id = ?";
		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {
			pst.setInt(1, noticia.getId());
			pst.execute();
		} catch (SQLException ex) {
			System.err.println("Não foi possível manipular a tabela Professor.");
			ex.printStackTrace();
		}
	}

	public Noticia consultar(int id) {

		String inserir = "SELECT * FROM noticia WHERE id = ?";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			pst.setInt(1, id);
			ResultSet resultado = pst.executeQuery();
			/**
			 * Eu sei que poderia fazer um join no select, criar um arrayList comentáros na
			 * class Noticia mas fiquei com preguiça
			 * 
			 */
			Noticia n = new Noticia();
			if (resultado.next()) {
				n.setId(id);
				n.setDescricao(resultado.getString("descricao"));
				n.setTexto(resultado.getString("texto"));
				n.setTitulo(resultado.getString("titulo"));
			}
			return n;

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular a tabela Professor.");
			ex.printStackTrace();

			return null;
		}
	}

	public ArrayList<Noticia> listarNoticias() {

		String inserir = "SELECT * FROM noticia";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			ResultSet resultado = pst.executeQuery();

			ArrayList<Noticia> lista = new ArrayList<>();
			while (resultado.next()) {
				Noticia n = new Noticia();
				n.setId(resultado.getInt("id"));
				n.setDescricao(resultado.getString("descricao"));
				n.setTexto(resultado.getString("texto"));
				n.setTitulo(resultado.getString("titulo"));
				lista.add(n);
			}
			return lista;

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular a tabela Professor.");
			ex.printStackTrace();

			return null;
		}
	}

}
