package model.dao;

import java.sql.PreparedStatement;
import model.to.BranchInfoTO;
import utility.ErrorHandling;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BranchInfoDAO {
    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }
     public boolean insertrecord(BranchInfoTO record){
         try{
             String query="insert into branchinfo ";
             query+=" (branchid,IFSC,address,contactno) ";
             query+="values(?,?,?,?)";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,record.getBranchid());
             stmt.setString(2,record.getIFSC());
             stmt.setString(3,record.getAddress());
             stmt.setString(4,record.getContactno());
             boolean result=stmt.executeUpdate()>0;
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return false;
         }
     }
 public boolean updaterecord(BranchInfoTO record) {
         try{
             String query="update branchinfo ";
             query+=" set IFSC=?,address=?,contactno=? ";
             query+=" where branchid=?";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,record.getIFSC());
             stmt.setString(2,record.getAddress());
             stmt.setString(3,record.getContactno());
             stmt.setString(4,record.getBranchid());
             boolean result=stmt.executeUpdate()>0;
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return false;
         }
     }
 public boolean deleterecord(String branchid) {
         try{
             String query="delete from branchinfo ";
             query+=" where branchid=?";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,branchid);
             boolean result=stmt.executeUpdate()>0;
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return false;
         }
 }
 public BranchInfoTO getrecord(String branchid) {
         try{
             String query="select branchid,IFSC,address,contactno from BranchInfo ";
             query+=" where branchid=?";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             stmt.setString(1,branchid);
             BranchInfoTO result=null;
             ResultSet rs=stmt.executeQuery();
             if(rs.next()) {
                 result=new BranchInfoTO();
             result.setBranchid(rs.getString("branchid"));
             result.setIFSC(rs.getString("IFSC"));
             result.setAddress(rs.getString("address"));
             result.setContactno(rs.getString("contactno"));
             }
             stmt.close();
             return result;
         }catch(Exception ex){
             errormessage=ex.toString();
             ErrorHandling.displaystacktrace(ex);
             return null;
         }
 }
 public List<BranchInfoTO> getAllRecord() {
         try{
             String query=" select branchid,IFSC,address,contactno from BranchInfo ";
             PreparedStatement stmt=DataConnection.getstStatement(query);
             List<BranchInfoTO> result=null;
             ResultSet rs=stmt.executeQuery();
             if(rs.next()) {
                 result=new ArrayList<>();
                 do{
                 BranchInfoTO record=new BranchInfoTO();
             record.setBranchid(rs.getString("branchid"));
             record.setIFSC(rs.getString("IFSC"));
             record.setAddress(rs.getString("address"));
             record.setContactno(rs.getString("contactno"));
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