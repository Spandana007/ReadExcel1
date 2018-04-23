package demo;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class BalanceComputation1
{
   
    	
    
	 
	  
  
  
  CustomerVO computeBalance(String id) throws Exception 
  {
	  CustomerVO cvo=new CustomerVO();
	  
		//BalanceComputation bc=new BalanceComputation();
	String url = "jdbc:ucanaccess://C:/Users/688714/workspace/Balance/WebContent/HTMLAccess.mdb";    
    Connection conn = null;
    conn = DriverManager.getConnection(url,"","");
    PreparedStatement st ;
    
    
  //  System.out.println("****BALANCECOMPUTATION1******\n\n");   
    
    
    String query = "SELECT * FROM [CustomerData] WHERE ID="+id+" ";
  //  System.out.println("query " + query);
    
    
    try 
    {
    	st = conn.prepareStatement(query);
        
        ResultSet  rs = st.executeQuery();
    	    
    	if(rs.next())
    	{
    		
    	     rs=st.executeQuery();
    			
    		  while(rs.next())
    		  {
    		  String id1=rs.getString("ID");
    		  String FirstName=rs.getString("FIRSTNAME");
    		  String LastName=rs.getString("LASTNAME");
    		  String CurrentYr=rs.getString("CURRENTYR");
    		  double LastYrBalance1=rs.getDouble("LASTYRBALANCE");
    		  double CurrentYrDeposit=rs.getDouble("CurrentYrDeposit");
    		  double CurrentYrWithdrawal=rs.getDouble("CurrentYrWithdrawal");
              cvo.setCustId(id1);
              cvo.setFirstName(FirstName);
              cvo.setLastName(LastName);
    	      cvo.setCurrentYr(CurrentYr);
              
    	      cvo.setLastyrDeposit(LastYrBalance1);
    	       
    	      cvo.setLastyrDeposit(CurrentYrDeposit);
    	      
              cvo.setLastyrDeposit(CurrentYrWithdrawal);
             double computedBalance=LastYrBalance1+CurrentYrDeposit-CurrentYrWithdrawal;
    	      cvo.setComputedBalance(computedBalance);
            
        
        
      //  System.out.println("In BalanceComputation1.java");
        System.out.println("Details of CUSTOMER WITH id "+id1);
         System.out.println("Cust Id: "+id1);
        System.out.println("Customer First Name: "+FirstName);
        System.out.println("Customer Last Name: "+LastName);
        System.out.println("End of Yr balance of id "+ id +" is : Rs. "+computedBalance);
        
    	   }
    	}
    	
    	else	
    	{
    			System.out.println("no record found!!");
    	}
    
    	    
      
    
    
   	
  }
    catch(NumberFormatException e)
    {
    	System.out.println(e);
    }
        
    return cvo;
    
  }
    
    
  
	 
 }
  
