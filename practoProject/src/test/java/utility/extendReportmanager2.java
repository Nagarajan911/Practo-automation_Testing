package utility;



import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extendReportmanager2{

	public static ExtentReports report;
		
	public static ExtentReports getReportInstance() {
	
	if(report==null) {
		
		ExtentHtmlReporter htmlReporter =new ExtentHtmlReporter("./Report/smokeTestReport.html");
		report=new ExtentReports();
		report.attachReporter(htmlReporter);  
	}
	return report;
	}
}