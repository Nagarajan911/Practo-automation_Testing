package utility;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;

import org.testng.annotations.ITestAnnotation;



@SuppressWarnings({"rawtypes"})
public class FailureRetryListener implements IAnnotationTransformer {
	public void transform(ITestAnnotation testAnnotation,Class testClass,Constructor testConstructor,Method testMethod){
		testAnnotation.setRetryAnalyzer(RetryAnalyzer.class);
		}
	
}
