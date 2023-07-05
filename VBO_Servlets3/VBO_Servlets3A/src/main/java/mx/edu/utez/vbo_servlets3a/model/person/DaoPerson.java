package mx.edu.utez.vbo_servlets3a.model.person;

import mx.edu.utez.vbo_servlets3a.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPerson {
    private static Connection conn;
    private static PreparedStatement pstm;
    private static ResultSet rs;

    private static final String GET_PERSONS = "SELECT * FROM person " +
            "JOIN user ON person.id=user.person";

    public static List<BeanPerson> findPersons(){
        List<BeanPerson> personList = new  LinkedList <>();
        BeanPerson person = null;
        try{
            conn = new MySQLConnection().getConnection();
            pstm= conn.prepareStatement(GET_PERSONS);
            rs = pstm.executeQuery();
            while (rs.next()){
                person = new BeanPerson();
                person.setId(rs.getLong("person.id"));
                person.setName(rs.getString("name"));
                person.setLastname(rs.getString("lastname"));
                person.setAge(rs.getInt("age"));
                person.setEmail(rs.getString("email"));
                person.setPhone(rs.getString("phone"));
                person.setBirthday(rs.getDate("birthday"));

                byte[] image = rs.getBytes("image");
                String imgStr = Base64.getEncoder().encodeToString(image);
                person.setImage(imgStr);

                person.setUsername(rs.getString("username"));
                person.setPassword(rs.getString("password"));
                person.setRole(rs.getString("role"));
                person.setIdU(rs.getLong("user.id"));

                personList.add(person);
            }
        }catch(SQLException e){
            Logger.getLogger(DaoPerson.class.getName()).log(Level.SEVERE, "Error en findPersons -> ", e);
        }finally{
            closeConnection();
        }
        return personList;
    }

    public static void closeConnection(){
        try{
            if (conn!=null){
                conn.close();
            }
            if (pstm!=null){
                pstm.close();
            }
            if (rs!=null){
                rs.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
