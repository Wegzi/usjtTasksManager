package dao;

import model.Noticia;
import model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaskDAO {

    private Connection conexao;

    public TaskDAO() {
        this.conexao = ConnectionFactory.conectar();
    }

    public void cadastrar(Task task) {
        System.out.println(task.getTitulo());
        String inserir = "INSERT INTO tarefas (titulo,descricao, fk_usuario_email) VALUES (?, ?, ?) ";

        try (PreparedStatement pst = conexao.prepareStatement(inserir)) {
            pst.setString(1, task.getTitulo());
            pst.setString(2, task.getDescricao());
            pst.setString(3, task.getUser_email());
            pst.execute();
        } catch (SQLException ex) {
            System.err.println("Não foi possível manipular a tabela noticia.");
            ex.printStackTrace();
        }
    }

    public void alterar(Task task) {
        String inserir = "UPDATE tarefas SET descricao = ?, titulo = ? WHERE id = ? ";

        try (PreparedStatement pst = conexao.prepareStatement(inserir)) {
            pst.setString(1, task.getDescricao());
            pst.setString(2, task.getTitulo());
            pst.setInt(3, task.getId());
            pst.execute();
        } catch (SQLException ex) {
            System.err.println("Não foi possível manipular a tabela Professor.");
            ex.printStackTrace();
        }
    }

    public void excluir(int id) {
        String inserir = "DELETE FROM tarefas WHERE id  = ?";

        try (PreparedStatement pst = conexao.prepareStatement(inserir)) {
            pst.setInt(1, id);
            pst.execute();
        } catch (SQLException ex) {
            System.err.println("Não foi possível manipular a tabela Professor.");
            ex.printStackTrace();
        }
    }

    public Task consultar(int id) {

        String inserir = "SELECT * FROM tarefas WHERE id = ?";

        try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

            pst.setInt(1, id);
            ResultSet resultado = pst.executeQuery();

            Task t = new Task();
            if (resultado.next()) {
                t.setId(id);
                t.setDescricao(resultado.getString("descricao"));
                t.setTitulo(resultado.getString("titulo"));
            }
            return t;

        } catch (SQLException ex) {
            System.err.println("Não foi possível manipular a tabela Professor.");
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Task> listarTask(String email) {

        String inserir = "SELECT * FROM tarefas WHERE fk_usuario_email = ?";

        try (PreparedStatement pst = conexao.prepareStatement(inserir)) {
            pst.setString(1, email);
            ResultSet resultado = pst.executeQuery();
            ArrayList<Task> lista = new ArrayList<>();
            while (resultado.next()) {
                Task t = new Task();
                t.setId(resultado.getInt("id"));
                t.setDescricao(resultado.getString("descricao"));
                t.setTitulo(resultado.getString("titulo"));
                lista.add(t);
            }
            return lista;

        } catch (SQLException ex) {
            System.err.println("Não foi possível manipular a tabela Professor.");
            ex.printStackTrace();
            return null;
        }
    }
}