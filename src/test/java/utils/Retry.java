package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @return true if the test-method has to be re-tried, false otherwise
 * @param/result -> result of the test
 */
public class Retry implements IRetryAnalyzer {
    int counter=0;
    int retryLimit=2;

    @Override
    public boolean retry(ITestResult result) {
        if (counter<retryLimit){
            counter++;
            return true;
        }
        return false;
    }
}
