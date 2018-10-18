package model.dao;

import model.to.*;
import utility.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CompanyInfoDAO {
     private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }
     public boolean insertrecord(CompanyInfoTO record){
         try{
             String query="insert into companyinfo ";
             query+=" (companyid,companyname) ";
             query+="values(?,?)";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,record.getCompanyid());
             stmt.setString(2,record.getCompanyname());
             boolean result=stmt.executeUpdate()>0;
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return false;
         }
     }
 public boolean updaterecord(CompanyInfoTO record) {
         try{
             String query="update companyinfo ";
             query+=" set companyname=? ";
             query+=" where companyid=?";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,record.getCompanyname());
             stmt.setString(2,record.getCompanyid());
             boolean result=stmt.executeUpdate()>0;
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return false;
         }
     }
 public boolean deleterecord(String companyid) {
         try{
             String query="delete from companyinfo ";
             query+=" where companyid=?";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,companyid);
             boolean result=stmt.executeUpdate()>0;
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return false;
         }
 }
  public CompanyInfoTO getrecord(String companyid) {
         try{
             String query=" select companyid,companyname from CompanyInfo ";
             query+=" where companyid=?";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,companyid);
             CompanyInfoTO result=null;
             ResultSet rs=stmt.executeQuery();
             if(rs.next()) {
                 result=new CompanyInfoTO();
             result.setCompanyid(rs.getString("Companyid"));
             result.setCompanyname(rs.getString("Companyname"));
             }
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return null;
         }
 }
  public List<CompanyInfoTO> getAllRecord() {
         try{
             String query=" select companyid,companyname from CompanyInfo ";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             List<CompanyInfoTO> result=null;
             ResultSet rs=stmt.executeQuery();
             if(rs.next()) {
                 result=new ArrayList<>();
                 do{
                 CompanyInfoTO record=new CompanyInfoTO();
             record.setCompanyid(rs.getString("companyid"));
             record.setCompanyname(rs.getString("companyname"));
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