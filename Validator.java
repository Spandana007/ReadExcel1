package demo;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Iterator;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Boolean;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Validator 
{
	
  public static void main(String args[]) throws Exception
  {
	  
	     
		 validate();
		// BalanceComputation1 bc=new BalanceComputation1();
		  
		  
  }
  
  public static void validate() throws Exception
  {
	    String url = "jdbc:ucanaccess://C:/Users/688714/workspace/Balance/WebContent/HTMLAccess.mdb";    
	    Connection conn = null;
	    conn = DriverManager.getConnection(url,"","");
	    PreparedStatement st ;
	   	    
	    System.out.println("****VALIDATOR******\n\n");  
	    	    	    
	    String query = "SELECT * FROM [CustomerData] ";
	    
	  //  System.out.println("query " + query);
	    st = conn.prepareStatement(query);
	    
	    ResultSet  rs = st.executeQuery();
	   
	    if(rs.next())
	    {
	    	
	    	String id=rs.getString("ID");
	    	
	        int id1=Integer.parseInt(id);
	        BalanceComputation1 bc=new BalanceComputation1();
	        int balance1=bc.computeBalance(id1);
	        System.out.println("Rs. "+balance1);
	        
	        ReadExcelFile r=new ReadExcelFile();
	        int balance2=r.readExcel();
	        
	        
	        
	        
	        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("C:/Users/688714/Desktop/Validation.xls"));
	        
            WritableSheet writableSheet = writableWorkbook.createSheet("Sheet1",1);
 
            //Create Cells with contents of different data types. 
            //Also specify the Cell coordinates in the constructor
            Label hlabel=new Label(0,0,"ID");
            writableSheet.addCell(hlabel);
            Label hlabel1=new Label(1,0,"From Database");
            writableSheet.addCell(hlabel1);
            Label hlabel2=new Label(2,0,"From Excel");
            writableSheet.addCell(hlabel2);
            Label label1=new Label(0,1,id);
            writableSheet.addCell(label1);
            Label label2=new Label(1,1,Integer.toString(balance1));
            writableSheet.addCell(label2);
            Label label3 = new Label(2,1,Integer.toString(balance2));
            writableSheet.addCell(label3);
 
            //Add the created Cells to the sheet
              
           
           
            
 
           
			//Write and close the workbook
            writableWorkbook.write();
            writableWorkbook.close();
	        if(balance1==balance2)
	        {
	        	System.out.println("equal");
	        }
	        else
	        {
	        	System.out.println("not equal");
	        }
	        
	    }
	       
	        
	     
	}
  }
  

