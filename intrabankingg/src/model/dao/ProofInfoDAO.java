package model.dao;

import java.sql.PreparedStatement;
import model.to.*;
import utility.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProofInfoDAO {
      private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }
     public boolean insertrecord(ProofInfoTO record){
         try{
             String query=" insert into proofinfo ";
             query+=" (proofname,totaldigits) ";
             query+="values(?,?)";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,record.getProofname());
             stmt.setString(2,record.getTotaldigits());
             boolean result=stmt.executeUpdate()>0;
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return false;
         }
     }
 public boolean updaterecord(ProofInfoTO record) {
         try{
             String query="update proofinfo ";
             query+=" set proofname=?,totaldigits=? ";
             query+=" where proofid=?";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,record.getProofname());
             stmt.setString(2,record.getTotaldigits());
             stmt.setInt(3,record.getProofid());
             boolean result=stmt.executeUpdate()>0;
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return false;
         }
     }
 public boolean deleterecord(String proofid) {
         try{
             String query="delete from proofinfo ";
             query+=" where proofid=?";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,proofid);
             boolean result=stmt.executeUpdate()>0;
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return false;
         }
 }
 public ProofInfoTO getrecord(String proofid) {
         try{
             String query="select proofid,proofname,totaldigits from ProofInfo ";
             query+=" where proofid=?";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,proofid);
             ProofInfoTO result=null;
             ResultSet rs=stmt.executeQuery();
             if(rs.next()) {
                 result=new ProofInfoTO();
             result.setProofid(rs.getInt("proofid"));
             result.setProofname(rs.getString("Proofname"));
             result.setTotaldigits(rs.getString("Totaldigits"));
             }
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return null;
         }
 }
 public List<ProofInfoTO> getAllRecord() {
         try{
             String query=" select proofid,proofname,totaldigits from ProofInfo ";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             List<ProofInfoTO> result=null;
             ResultSet rs=stmt.executeQuery();
             if(rs.next()) {
                 result=new ArrayList<>();
                 do{
                 ProofInfoTO record=new ProofInfoTO();
             record.setProofid(rs.getInt("proofid"));
             record.setProofname(rs.getString("proofname"));
             record.setTotaldigits(rs.getString("totaldigits"));
             result.add(record);
             }while(rs.next());
             }
             stmt.close();
             rs.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return null;
         }
 }
}