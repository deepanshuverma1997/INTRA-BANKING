package model.dao;

import java.sql.PreparedStatement;
import model.to.*;
import utility.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TransactionInfoDAO {
     private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }
     public boolean insertrecord(TransactionInfoTO record){
         try{
             String query="insert into transactioninfo ";
             query+=" (amount,accountid,transactiondate,transactiontype,description,isapprove) ";
             query+="values(?,?,?,?,?,?)";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setFloat(1,record.getAmount());
             stmt.setString(2,record.getAccountid());
             stmt.setDate(3,record.getTransactiondate());
             stmt.setString(4,record.getTransactiontype());
             stmt.setString(5,record.getDescription());
             stmt.setString(6,record.getIsapprove());
             boolean result=stmt.executeUpdate()>0;
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return false;
         }
     }
 public boolean updaterecord(TransactionInfoTO record) {
         try{
             String query="update transactioninfo ";
             query+=" set amount=?,accountid=?,transactiondate=?,transactiontype=?,description=?,isapprove=? ";
             query+=" where transactionid=?";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setFloat(1,record.getAmount());
             stmt.setString(2,record.getAccountid());
             stmt.setDate(3,record.getTransactiondate());
              stmt.setString(4,record.getTransactiontype());
              stmt.setString(5,record.getDescription());
              stmt.setString(6,record.getIsapprove());
              stmt.setInt(7,record.getTransactionid());
             boolean result=stmt.executeUpdate()>0;
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return false;
         }
     }
 public boolean deleterecord(String transactionid) {
         try{
             String query="delete from transactioninfo ";
             query+=" where transactionid=?";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,transactionid);
             boolean result=stmt.executeUpdate()>0;
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return false;
         }
 }
 public TransactionInfoTO getrecord(String transactionid) {
         try{
             String query="select transactionid,amount,accountid,transactiondate,transactiontype,description,isapprove from TransactionInfo ";
             query+=" where transactionid=?";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,transactionid);
             TransactionInfoTO result=null;
             ResultSet rs=stmt.executeQuery();
             if(rs.next()) {
                 result=new TransactionInfoTO();
             result.setTransactionid(rs.getInt("transactionid"));
             result.setAmount(rs.getFloat("amount"));
             result.setAccountid(rs.getString("accountid"));
             result.setTransactiondate(rs.getDate("transactiondate"));
             result.setTransactiontype(rs.getString("transactiontype"));
             result.setDescription(rs.getString("Description"));
             result.setIsapprove(rs.getString("Isapprove"));
             }
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return null;
         }
 }
 public List<TransactionInfoTO> getAllRecord() {
         try{
             String query=" select transactionid,amount,accountid,transactiondate,transactiontype,description,isapprove from TransactionInfo ";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             List<TransactionInfoTO> result=null;
             ResultSet rs=stmt.executeQuery();
             if(rs.next()) {
                 result=new ArrayList<>();
                 do{
                 TransactionInfoTO record=new TransactionInfoTO();
             record.setTransactionid(rs.getInt("transactionid"));
             record.setAmount(rs.getFloat("amount"));
             record.setAccountid(rs.getString("accountid"));
             record.setTransactiondate(rs.getDate("transactiondate"));
             record.setTransactiontype(rs.getString("transactiontype"));
             record.setDescription(rs.getString("Description"));
             record.setIsapprove(rs.getString("Isapprove"));
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