package _JDBC.Gun1;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Intro {

    @Test
    public void test1() throws SQLException {
        String hostUrl = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        // connection açılıyor,  fileInputstream
        Connection connection = DriverManager.getConnection(hostUrl, username, password); // bağlantıya click  1.madde

        // sql lerin yazılacağı sayfa
        Statement statement = connection.createStatement(); // sorguları çalıştırmak için sorgu gönderme ortamı

        // sorguyu yazdım ve çalıştırdım
        ResultSet rs = statement.executeQuery("select * from customer"); //sorgu çalıştı sonuçları nerde ? rs de

        // ilk satırımı istiyorsun, son satırımı, 5. satırımı
        rs.next(); // sıradaki ilk satıra gitti

        String firstName=rs.getString("first_name");
        String lastName=rs.getString("last_name");
        System.out.println("1.Satırın müşteri adı ve soyadı ="+ firstName+" "+lastName);

        rs.next(); // 2.satıra

        firstName=rs.getString("first_name");
        lastName=rs.getString("last_name");
        System.out.println("2.Satırın müşteri adı ve soyadı ="+ firstName+" "+lastName);

        connection.close();
    }


}
