package _JDBC.Gun1;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _02_NextPrevAbsRel extends JDBCParent {

    @Test
    public void textNextPrev() throws SQLException {
        ResultSet rs= statement.executeQuery("select * from language");

        rs.next(); // ilk satır 1.satır
        System.out.println("1. satir dilAdi="+ rs.getString(2));  // 2 column sırası English
                                           //  rs.getString(name)

        rs.next(); // 2.satır
        System.out.println("2. satir dilAdi="+ rs.getString(2));  // italian

        rs.next(); // 3.satır
        System.out.println("2. satir dilAdi="+ rs.getString(2)); // Japanese

        rs.previous(); // -> 2.satıra gitti
        System.out.println("1 geri satır dilAdi="+ rs.getString(2));  // italian
    }



}
