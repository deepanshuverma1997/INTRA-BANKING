package model.dao;

import java.sql.PreparedStatement;
import model.to.AccountTypeTO;
import utility.ErrorHandling;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountTypeDAO {
     private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }
     public boolean insertrecord(AccountTypeTO record){
         try{
             String query="insert into accounttype ";
             query+=" (typeid,typename,interestrate,minimum) ";
             query+="values(?,?,?,?)";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,record.getTypeid());
             stmt.setString(2,record.getTypename());
             stmt.setFloat(3,record.getInterestrate());
             stmt.setFloat(4,record.getMinimum());
             boolean result=stmt.executeUpdate()>0;
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return false;
         }
     }
 public boolean updaterecord(AccountTypeTO record) {
         try{
             String query="update accounttype ";
             query+=" set typename=?,interestrate=?,minimum=? ";
             query+=" where typeid=?";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,record.getTypename());
             stmt.setFloat(2,record.getInterestrate());
             stmt.setFloat(3,record.getMinimum());
             stmt.setString(4,record.getTypeid());
             boolean result=stmt.executeUpdate()>0;
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return false;
         }
     }
 public boolean deleterecord(String typeid) {
         try{
             String query="delete from accounttype ";
             query+=" where typeid=?";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,typeid);
             boolean result=stmt.executeUpdate()>0;
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return false;
         }
 }
 public AccountTypeTO getrecord(String typeid) {
         try{
             String query="select typeid,typename,interestrate,minimum from AccountType ";
             query+=" where typeid=?";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,typeid);
             AccountTypeTO result=null;
             ResultSet rs=stmt.executeQuery();
             if(rs.next()) {
                 result=new AccountTypeTO();
             result.setTypeid(rs.getString("typeid"));
             result.setTypename(rs.getString("typename"));
             result.setInterestrate(rs.getFloat("interestrate"));
             result.setMinimum(rs.getFloat("minimum"));
             }
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return null;
         }
 }
 public List<AccountTypeTO> getAllRecord() {
         try{
             String query="select typeid,typename,interestrate,minimum from AccountType ";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             List<AccountTypeTO> result=null;
             ResultSet rs=stmt.executeQuery();
             if(rs.next()) {
                 result=new ArrayList<>();
                 do{
                 AccountTypeTO record=new AccountTypeTO();
             record.setTypeid(rs.getString("typeid"));
             record.setTypename(rs.getString("typename"));
             record.setInterestrate(rs.getFloat("interestrate"));
             record.setMinimum(rs.getFloat("minimum"));
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