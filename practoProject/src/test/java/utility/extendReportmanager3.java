package utility;

import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extendReportmanager3{

	public static ExtentReports report;
		
	public static ExtentReports getReportInstance() {
	
	if(report==null) {
		
		ExtentHtmlReporter htmlReporter =new ExtentHtmlReporter("./Report/report3.html");
		report=new ExtentReports();
		report.attachReporter(htmlReporter);  
	}
	return report;
	}
}