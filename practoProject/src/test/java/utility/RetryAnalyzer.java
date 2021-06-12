package utility;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class RetryAnalyzer implements IRetryAnalyzer  {
	 int retryAttemptsCounter = 0;
	 int maxRetryLimit = 2;
	 
	 //Method to attempt retries for failure tests
	 public boolean retry(ITestResult result) {
	 if (!result.isSuccess()) {
	 if(retryAttemptsCounter < maxRetryLimit){
		 System.out.println("Failed testcase name===>"+result.getName());
         System.out.println("Retry #" + (retryAttemptsCounter+1) + " for test: " + result.getMethod().getMethodName() + ", on thread: " + Thread.currentThread().getName());
	     retryAttemptsCounter++;

	 return true;
	 }
	 }
	 return false;
	 } 

}
