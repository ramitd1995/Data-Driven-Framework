package testUtility;

import java.util.ArrayList;
import testUtility.Xls_Reader;

public class TestUtils {
	 static Xls_Reader reader; 
	 
	 public static ArrayList<Object[]> getDataFromExcel()
	 {
		 ArrayList<Object[]> myData = new ArrayList<Object[]>();
		 
		 try
		 {
			 reader = new Xls_Reader("src\\test\\java\\testData\\lambdatestSignUp.xlsx");
		 }
		 
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
		 for(int rowNum = 2; rowNum <= reader.getRowCount("mysheet1"); rowNum++ )
		 {
			 String org_name = reader.getCellData("mysheet1", "organisation", rowNum);
			 String name = reader.getCellData("mysheet1", "full name", rowNum);
			 String eMail = reader.getCellData("mysheet1", "email", rowNum);
			 String passWord = reader.getCellData("mysheet1", "password", rowNum);
			 String phoNe = reader.getCellData("mysheet1", "phone", rowNum);
			 
			 Object obj[] = {org_name,name,eMail,passWord,phoNe};
			 myData.add(obj);	 
		 }
		return myData;
	 }

}
