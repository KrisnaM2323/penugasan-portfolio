/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class_input;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author KRISNA
 */
public class cls_register {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String username;
    public String password;
    
    public void registrasi( )throws SQLException{
        conn = koneksi.getKoneksi();
        sql = "INSERT INTO log_in(username,password)VALUE(?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, username);
        pst.setString(2, password);
        pst.execute();
        pst.close();
    }
    
    
    
    public  ResultSet SearchTextList(String kdb)throws SQLException{
        conn = koneksi.getKoneksi();
        sql = "select * from inputdata where kode_barang like ?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, "%" + kdb);
        rs = pst.executeQuery();
        return rs;
    }
    
}
