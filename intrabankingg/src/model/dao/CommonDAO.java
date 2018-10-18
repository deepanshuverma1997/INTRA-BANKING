package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CommonDAO {
    public static int getLastInsertID(){
        try{
            String query="select last_insert_id()";
            PreparedStatement stmt=DataConnection.getstStatement(query);
            ResultSet rs=stmt.executeQuery();
            int result=0;
            if(rs.next()){
                result=rs.getInt(1);
            }
            rs.close();
            stmt.close();
            return result;
          }catch(Exception ex){
            return 0;
        }
    }
}