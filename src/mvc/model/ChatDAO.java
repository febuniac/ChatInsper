	package mvc.model;


import java.sql.Date;
import java.sql.*;
import java.util.*;


public class ChatDAO {


    private Connection connection = null;
	
    public ChatDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost/meus_dados", "root", "123456");
        } catch (SQLException | ClassNotFoundException e) {e.printStackTrace();}
    }


    public void adicionaMensagem(Parametros parametro) {
        try {
            String sql = "INSERT INTO Mensagem (mensagem) values(?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,parametro.getMensagem());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {e.printStackTrace();}
    }


    public void adiciona(Parametros parametro) {
        try {
            String sql = "INSERT INTO Mensagem" +
                         "(mensagem,usuario) values(?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,parametro.getMensagem());
            stmt.setString(2, parametro.getUsuario());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {e.printStackTrace();}
    }
	
    public List<Parametros> getLista() {
        List<Parametros> parametros = new ArrayList<Parametros>();
        try {	
            PreparedStatement stmt = connection.
					prepareStatement("SELECT * FROM Mensagem");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Parametros parametro = new Parametros();
                parametro.setId(rs.getLong("id"));
                parametro.setMensagem(rs.getString("mensagem"));
                parametro.setUsuario(rs.getString("usuario"));

                parametros.add(parametro);
            }
            rs.close();
            stmt.close();
        } catch(SQLException e) {System.out.println(e);}
        return parametros;
    }
	
    public void remove(Parametros parametro) {
        try {
            PreparedStatement stmt = connection
	                .prepareStatement("DELETE FROM Mensagem WHERE id=?");
            stmt.setLong(1, parametro.getId());
            stmt.execute();
            stmt.close();
        } catch(SQLException e) {System.out.println(e);}
    }


    public Parametros buscaPorId(Long id) {
        Parametros parametro = new Parametros();
        try {	
            PreparedStatement stmt = connection.
                                    prepareStatement("SELECT * FROM Mensagem WHERE id=? ");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                parametro.setId(rs.getLong("id"));
                parametro.setMensagem(rs.getString("mensagem"));
                parametro.setUsuario(rs.getString("usuario"));
            }
            rs.close();
            stmt.close();
        } catch(SQLException e) {System.out.println(e);}
        return parametro;
    }


    public void altera(Parametros parametro) {
        try {
            String sql = "UPDATE Mensagem SET mensagem=?, finalizado=?, " +
            "dataFinalizacao=? WHERE id=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, parametro.getMensagem());

            stmt.setLong(4, parametro.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch(SQLException e) {System.out.println(e);}
    }
	
    public void finaliza(Long id) {
        try {
            String sql = "UPDATE Mensagem SET finalizado=?, dataFinalizacao=? " +
		            "WHERE id=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setBoolean(1, true);
            stmt.setDate(2, new Date(Calendar.getInstance().getTimeInMillis()));
            stmt.setLong(3, id);
            stmt.executeUpdate();
            stmt.close();
        } catch(SQLException e) {System.out.println(e);}
    }

    public void apaga() {
        try {
            String sql = "TRUNCATE table Mensagem";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
        } catch(SQLException e) {System.out.println(e);}
    }
    
    public void close() {
        try { connection.close();}
        catch (SQLException e) {e.printStackTrace();}		
    }


}