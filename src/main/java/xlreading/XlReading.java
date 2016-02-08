/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xlreading;

import java.io.File;

public class XlReading {

    /**
     * @param args the command line arguments
     */
    //code application logic here
       public static void main(String[] args) {

		File file = new File("//home//ror//Desktop//XlReading//products.xlsx");
		XLReadImpl one=new XLSheetOne(file);
	      	one.fetchAllData();
		System.out.println("1st row:: "+one.fetchDataFrom("first"));
		System.out.println("2nd row is:  "+one.fetchDataFrom("second"));
		XLReadImpl two=new XLSheetTwo(file);
		two.fetchAllData();
	 
       
      }
}
