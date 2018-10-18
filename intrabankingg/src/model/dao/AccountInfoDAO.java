package model.dao;

import java.sql.PreparedStatement;
import model.to.AccountInfoTO;
import utility.ErrorHandling;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountInfoDAO {
     private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }
     public boolean insertrecord(AccountInfoTO record){
         try{
             String query="insert into accountinfo ";
             query+=" (accountid,branchid,openingdate,initial_balance,current_balance,name,fathername,dob,contactno,address) ";
             query+="values(?,?,?,?,?,?,?,?,?,?)";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,record.getAccountid());
             stmt.setString(2,record.getBranchid());
             stmt.setDate(3,record.getOpeningdate());
             stmt.setFloat(4,record.getInitial_balance());
             stmt.setFloat(5,record.getCurrent_balance());
             stmt.setString(6,record.getName());
             stmt.setString(7,record.getFathername());
             stmt.setDate(8,record.getDob());
             stmt.setString(9,record.getContactno());
             stmt.setString(10,record.getAddress());
             boolean result=stmt.executeUpdate()>0;
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return false;
         }
     }
 public boolean updaterecord(AccountInfoTO record) {
         try{
             String query="update accountinfo ";
             query+=" set branchid=?,openingdate=?,initial_balance=?,current_balance=?,name=?,fathername=?,dob=?,contactno=?,address=? ";
             query+=" where accountid=?";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,record.getBranchid());
             stmt.setDate(2,record.getOpeningdate());
             stmt.setFloat(3,record.getInitial_balance());
             stmt.setFloat(4,record.getCurrent_balance());
             stmt.setString(5,record.getName());
             stmt.setString(6,record.getFathername());
             stmt.setDate(7,record.getDob());
             stmt.setString(8,record.getContactno());
             stmt.setString(9,record.getAddress());
             stmt.setString(10,record.getAccountid());
             boolean result=stmt.executeUpdate()>0;
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return false;
         }
     }
 public boolean deleterecord(String accountid) {
         try{
             String query="delete from accountinfo ";
             query+=" where accountid=?";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,accountid);
             boolean result=stmt.executeUpdate()>0;
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return false;
         }
 }
 public AccountInfoTO getrecord(String accountid) {
         try{
             String query="select accountid,branchid,openingdate,initial_balance,current_balance,name,fathername,dob,contactno,address from AccountInfo ";
             query+=" where accountid=?";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,accountid);
             AccountInfoTO result=null;
             ResultSet rs=stmt.executeQuery();
             if(rs.next()) {
                 result=new AccountInfoTO();
             result.setAccountid(rs.getString("accountid"));
             result.setBranchid(rs.getString("branchid"));
             result.setOpeningdate(rs.getDate("openingdate"));
             result.setInitial_balance(rs.getFloat("initial_balance"));
             result.setCurrent_balance(rs.getFloat("current_balance"));
             result.setName(rs.getString("name"));
             result.setFathername(rs.getString("fathername"));
             result.setDob(rs.getDate("dob"));
             result.setContactno(rs.getString("contactno"));
             result.setAddress(rs.getString("address"));
             }
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return null;
         }
 }
 public List<AccountInfoTO> getAllRecord() {
         try{
             String query="select accountid,branchid,openingdate,initial_balance,current_balance,name,fathername,dob,contactno,address from AccountInfo ";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             List<AccountInfoTO> result=null;
             ResultSet rs=stmt.executeQuery();
             if(rs.next()) {
                 result=new ArrayList<>();
                 do{
                 AccountInfoTO record=new AccountInfoTO();
             record.setAccountid(rs.getString("accountid"));
             record.setBranchid(rs.getString("branchid"));
             record.setOpeningdate(rs.getDate("openingdate"));
             record.setInitial_balance(rs.getFloat("initial_balance"));
             record.setCurrent_balance(rs.getFloat("current_balance"));
             record.setName(rs.getString("name"));
             record.setFathername(rs.getString("fathername"));
             record.setDob(rs.getDate("dob"));
             record.setContactno(rs.getString("contactno"));
             record.setAddress(rs.getString("address"));
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