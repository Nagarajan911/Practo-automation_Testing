package utility;


import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

//import org.openqa.selenium.support.PageFactory;

public class TakeScreenshot   //Practo

{

public static void screenShotTC(WebDriver ldriver)throws IOException{

File src=((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);

try

{ 

FileUtils.copyFile(src, new File("E:\\Java Workspace\\practoProject\\src\\test\\resources\\screenshots\\"+System.currentTimeMillis()+".png"));

}catch (IOException e)

{

System.out.println(e.getMessage());

}

}

}