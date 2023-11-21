package Dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class AapeDao {

    static Connection conectado;

    private static Connection conectar() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_aape", "root", "Admin");
        return conectado;
    }

    public static ResultSet fazerLogin(String u, String e, String s) throws ClassNotFoundException, SQLException {
        conectado = conectar();
        PreparedStatement st = conectado.prepareStatement("SELECT * FROM usuario WHERE nome = ? AND email = ? AND senha = ?");
        st.setString(1, u);
        st.setString(2,e);
        st.setString(3, s);
        ResultSet resultado = st.executeQuery();
        return resultado;
    }

    public static void cadastrarUsuario (String n, String e, String s, int t, String c, String d) throws ClassNotFoundException, SQLException {
        conectado = conectar();
        PreparedStatement st = conectado.prepareStatement("INSERT INTO usuario VALUES(?,?,?,?,?,?)");
        st.setString(1, n);
        st.setString(2, e);
        st.setString(3, s);
        st.setInt(4, t);
        st.setString(5, c);
        st.setString(6,d);
        st.executeUpdate();
    }
    
    public static ResultSet redefinirSenha (String e, int t) throws ClassNotFoundException, SQLException {
        conectado = conectar();
        PreparedStatement st = conectado.prepareStatement("SELECT * FROM usuario WHERE email = ? AND telefone = ?");
        st.setString(1, e);
        st.setInt(2, t);
        ResultSet resultado = st.executeQuery();
        return resultado;
    }
    
    public static void editarDados(String n, String e, String s, int t, String dt, String c) throws ClassNotFoundException, SQLException {
        conectado = conectar();
        PreparedStatement st = conectado.prepareStatement("UPDATE usuario SET nome = ?, email = ?, senha = ?, telefone = ?, datanasc = ? WHERE cpf = ?");
        st.setString(1, n);
        st.setString(2, e);
        st.setString(3, s);
        st.setInt(4, t);
        st.setString(5, dt);
        st.setString(6,c);
        st.executeUpdate();
    }
    
}
