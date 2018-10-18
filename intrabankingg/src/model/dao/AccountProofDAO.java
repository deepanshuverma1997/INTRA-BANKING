package model.dao;

import java.sql.PreparedStatement;
import model.to.AccountProofTO;
import utility.ErrorHandling;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountProofDAO {
      private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }
     public boolean insertrecord(AccountProofTO record){
         try{
             String query="insert into accountproof ";
             query+=" (proofid,accountid,proofvalue) ";
             query+="values(?,?,?)";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setInt(1,record.getProofid());
             stmt.setString(2,record.getAccountid());
             stmt.setString(3,record.getProofvalue());
             boolean result=stmt.executeUpdate()>0;
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return false;
         }
     }
 public boolean updaterecord(AccountProofTO record) {
         try{
             String query="update accountproof ";
             query+=" set proofid=?,accountid=?,proofvalue=? ";
             query+=" where srno=?";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setInt(1,record.getProofid());
             stmt.setString(2,record.getAccountid());
             stmt.setString(3,record.getProofvalue());
              stmt.setInt(4,record.getSrno());
             boolean result=stmt.executeUpdate()>0;
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return false;
         }
     }
 public boolean deleterecord(String srno) {
         try{
             String query="delete from accountproof ";
             query+=" where srno=?";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,srno);
             boolean result=stmt.executeUpdate()>0;
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return false;
         }
 }
 public AccountProofTO getrecord(String srno) {
         try{
             String query="select srno,proofid,accountid,proofvalue from AccountProof ";
             query+=" where srno=?";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,srno);
             AccountProofTO result=null;
             ResultSet rs=stmt.executeQuery();
             if(rs.next()) {
                 result=new AccountProofTO();
             result.setSrno(rs.getInt("srno"));
             result.setProofid(rs.getInt("proofid"));
             result.setAccountid(rs.getString("accountid"));
             result.setProofvalue(rs.getString("proofvalue"));
             }
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return null;
         }
 }
 public List<AccountProofTO> getAllRecord() {
         try{
             String query="select srno,proofid,accountid,proofvalue from AccountProof ";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             List<AccountProofTO> result=null;
             ResultSet rs=stmt.executeQuery();
             if(rs.next()) {
                 result=new ArrayList<>();
                 do{
                 AccountProofTO record=new AccountProofTO();
             record.setSrno(rs.getInt("srno"));
             record.setProofid(rs.getInt("proofid"));
             record.setAccountid(rs.getString("accountid"));
             record.setProofvalue(rs.getString("proofvalue"));
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