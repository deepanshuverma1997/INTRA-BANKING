package model.dao;

import java.sql.PreparedStatement;
import model.to.*;
import utility.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoginInfoDAO {
    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }
     public boolean insertrecord(LoginInfoTO record){
         try{
             String query="insert into logininfo ";
             query+=" (username,password,rolename,lastlogin) ";
             query+="values(?,?,?,null)";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,record.getUsername());
             stmt.setString(2,record.getPassword());
             stmt.setString(3,record.getRolename());
             boolean result=stmt.executeUpdate()>0;
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return false;
         }
     }
 public boolean updaterecord(LoginInfoTO record) {
         try{
             String query="update logininfo ";
             query+=" set password=?,rolename=?,lastlogin=? ";
             query+=" where username=?";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,record.getPassword());
             stmt.setString(2,record.getRolename());
             stmt.setTimestamp(3,record.getLastlogin());
             stmt.setString(4,record.getUsername());
             boolean result=stmt.executeUpdate()>0;
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return false;
         }
     }
 public boolean deleterecord(String username) {
         try{
             String query="delete from logininfo ";
             query+=" where username=?";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,username);
             boolean result=stmt.executeUpdate()>0;
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return false;
         }
 }
public LoginInfoTO getrecord(String username) {
         try{
             String query="select username,password,rolename,lastlogin from logininfo ";
             query+=" where username=?";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,username);
             LoginInfoTO result=null;
             ResultSet rs=stmt.executeQuery();
             if(rs.next()) {
                 result=new LoginInfoTO();
             result.setUsername(rs.getString("username"));
             result.setPassword(rs.getString("password"));
             result.setRolename(rs.getString("rolename"));
             result.setLastlogin(rs.getTimestamp("lastlogin"));
             }
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return null;
         }
 }
public List<LoginInfoTO> getAllRecord() {
         try{
             String query=" select username,password,rolename,lastlogin from logininfo ";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             List<LoginInfoTO> result=null;
             ResultSet rs=stmt.executeQuery();
             if(rs.next()) {
                 result=new ArrayList<>();
                 do{
                 LoginInfoTO record=new LoginInfoTO();
             record.setUsername(rs.getString("username"));
             record.setPassword(rs.getString("password"));
             record.setRolename(rs.getString("rolename"));
             record.setLastlogin(rs.getTimestamp("lastlogin"));
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