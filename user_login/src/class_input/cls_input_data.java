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
public class cls_input_data {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String kode_barang;
    public String nama_barang;
    public String kondisi;
    public String jumlah;
    
    public void simpan( )throws SQLException{
        conn = koneksi.getKoneksi();
        sql = "INSERT INTO inputdata(kode_barang,nama_barang,kondisi,jumlah)VALUE(?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, kode_barang);
        pst.setString(2, nama_barang);
        pst.setString(3, kondisi);
        pst.setString(4, jumlah);
        pst.execute();
        pst.close();
    }
    
    public ResultSet UpdateJTable()throws SQLException{
        conn = koneksi.getKoneksi();
        sql = "select*from inputdata";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
    
    public void hapus()throws SQLException{
        conn = koneksi.getKoneksi();
        String sql = "delete from inputdata where kode_barang=?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, kode_barang);
            pst.execute();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void edit ()throws SQLException{
        conn = koneksi.getKoneksi();
        String sql = "Update inputdata set nama_barang=?, kondisi=?, jumlah=? where kode_barang=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, nama_barang);
        pst.setString(2, kondisi);
        pst.setString(3, jumlah);
        pst.setString(4, kode_barang);
        pst.executeUpdate();
        pst.close();
    }
    
    public  ResultSet SearchTextList(String nma)throws SQLException{
        conn = koneksi.getKoneksi();
        sql = "select * from inputdata where nama_barang like ?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, nma + "%");
        rs = pst.executeQuery();
        return rs;
    }
}
