package dao;

import model.Task;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    private Connection conexao;

    public UserDAO() {
        this.conexao = ConnectionFactory.conectar();
    }

    public User auth(User user) {

        String inserir = "SELECT * FROM usuario WHERE email = ? AND senha = ?";

        try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

            pst.setString(1, user.getEmail());
            pst.setString(2, user.getSenha());
            ResultSet resultado = pst.executeQuery();
            User u = new User();
            if (resultado.next()) {
                u.setEmail(resultado.getString("email"));
                u.setNome(resultado.getString("nome"));
            }
            return u;
        } catch (SQLException ex) {
            System.err.println("Não foi possível manipular a tabela Professor.");
            ex.printStackTrace();
            return null;
        }
    }


}
