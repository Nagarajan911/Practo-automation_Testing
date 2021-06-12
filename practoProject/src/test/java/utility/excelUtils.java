package utility;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

//import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
                                //practo


public class excelUtils

{

public static File src;

public static String exfilepath = "E:\\Java Workspace\\practoProject\\src\\test\\resources\\excel\\Excel.xlsx";

public static FileInputStream fileip;

public static FileOutputStream fileop;
public static FileOutputStream fileop1;
public static FileOutputStream fileop2;
public static XSSFWorkbook workbook;

public static XSSFSheet sheet;

public static String val1;

public static int row;

public static XSSFCell Cell;
public static XSSFCell Cell1;

public static XSSFRow Row;

public static String category1;

public static String category2,name,organization,validMailId,invalidMailId;

public static String url,chrome,firefox;

public static int readexcel() throws IOException {

try

{

src=new File(exfilepath);

fileip = new FileInputStream(src);

workbook = new XSSFWorkbook(fileip);

sheet = workbook.getSheetAt(0);



for(int i=1; i<=sheet.getLastRowNum(); i++)

{

if(i==1)

{

category1 = (sheet.getRow(i).getCell(0)).getStringCellValue();  // Reading the location from Excel sheet


category2 = (sheet.getRow(i).getCell(1)).getStringCellValue();   // Reading the category name from the excel sheet

name = (sheet.getRow(i).getCell(2)).getStringCellValue();   // NAME

organization = (sheet.getRow(i).getCell(3)).getStringCellValue();  //ORGANIZATION

invalidMailId= (sheet.getRow(i).getCell(4)).getStringCellValue();  //INVALID MAIL ID

validMailId = (sheet.getRow(i).getCell(5)).getStringCellValue(); // VALID MAIL ID
url=(sheet.getRow(i).getCell(7)).getStringCellValue();
chrome=(sheet.getRow(i).getCell(8)).getStringCellValue();
firefox=(sheet.getRow(i).getCell(9)).getStringCellValue();

row=i;

break;

}

}

}

catch (FileNotFoundException e)

{

e.printStackTrace();

}

catch (IOException e)

{

e.printStackTrace();

}

return row;

}



public static void writeexcel(String arr[]) throws InterruptedException {
	// TODO Auto-generated method stub
	
	try

	{

	//Close input stream

	//fileip.close();

	//Create an object of FileOutputStream class to create write data in excel file

	fileop =new FileOutputStream(new File(exfilepath));
	
   
for(int i=2;i<=11;i++)
	{    int j=i+5;
	    
	
	Cell=sheet.createRow(j).createCell(0);       // Creating cell
	String nval=arr[i];    
	
	Cell.setCellValue(nval);                     //  Writing Hospital names in the excel sheet
	    
	}





workbook.write(fileop);
fileop.close();

}

	catch (FileNotFoundException e)

	{

	e.printStackTrace();

	} catch (IOException e)

	{

	e.printStackTrace();

	}

	}
public static void writeexcels(List<WebElement> cities) throws InterruptedException {
	// TODO Auto-generated method stub
	
	try

	{

	//Close input stream

	

	//Create an object of FileOutputStream class to create write data in excel file

	fileop1 =new FileOutputStream(new File(exfilepath));
	
   

int k=18;
for(WebElement a:cities)
{
	//System.out.println(a.getText());
	Cell=sheet.createRow(k++).createCell(0);   // Creating a cell
	Cell.setCellValue(a.getText());            // writing the top cities name in the excel file
} 






workbook.write(fileop1);
fileop1.close();

}

	catch (FileNotFoundException e)

	{

	e.printStackTrace();

	} catch (IOException e)

	{

	e.printStackTrace();

	}

	}
public static void writeexcelDemo(String firstErrorMsg,String secondErrorMsg,String thirdErrorMsg,String fourthErrorMsg,String fifthErrorMsg) throws InterruptedException {
	// TODO Auto-generated method stub
	
	try

	{

	//Close input stream



	//Create an object of FileOutputStream class to create write data in excel file

	fileop2 =new FileOutputStream(new File(exfilepath));
	
   


int p=28;
Cell=sheet.createRow(p++).createCell(0);       //Creating a cell
Cell.setCellValue(firstErrorMsg);              // Writing first Error Message in the excel file
Cell=sheet.createRow(p++).createCell(0);       //Creating a cell
Cell.setCellValue(secondErrorMsg);             // Writing second Error Message in the excel file
Cell=sheet.createRow(p++).createCell(0);       //Creating a cell
Cell.setCellValue(thirdErrorMsg);              // Writing third Error Message in the excel file
Cell=sheet.createRow(p++).createCell(0);       //Creating a cell
Cell.setCellValue(fourthErrorMsg);             // Writing fourth Error Message in the excel file
Cell=sheet.createRow(p++).createCell(0);       //Creating a cell
Cell.setCellValue(fifthErrorMsg);              // Writing fifth Error Message in the excel file

workbook.write(fileop2);
fileop2.close();               

}

	catch (FileNotFoundException e)

	{

	e.printStackTrace();

	} catch (IOException e)

	{

	e.printStackTrace();

	}
	
	
	
	

	}
}






