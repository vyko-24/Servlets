package mx.edu.utez.vbo_servlets3a.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MySQLConnection {
    final String host = "localhost",
            port = "3306",
            DBname = "utex",
            username = "root",
            passwd = "root",
            timezone = "America/Mexico_City",
            usessl = "false",
            publickey = "true",
            DDLauto = "true";

    public Connection getConnection() {
        String dataSource = String.format(
                "jdbc:mysql://%s:%s/%s?user=%s&password=%s" +
                        "&serverTimezone=%s&useSSL=%s&allowPublicKeyRetrieval=%s&createDatabaseIfNoExist=%s",
                host, port, DBname, username, passwd, timezone, usessl, publickey, DDLauto
        );
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection(dataSource);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
        try {
            Connection conn = new MySQLConnection().getConnection();
            if (conn != null){
                System.out.println("Felicidades :) ");
                conn.close();
            }else{
                System.out.println("Jajaj que wey");
            }
        }catch (SQLException i){
            i.printStackTrace();
        }
    }
}
