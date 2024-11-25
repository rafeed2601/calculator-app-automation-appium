import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CalcTestRunner extends Setup {
    CalcScreen calcScreen;
    @Test(priority = 1, description = "validate adding two numbers")
    public void doAddTwoNumbers(){
        calcScreen = new CalcScreen(driver);
        String sum = calcScreen.doSum(4,5);
        String expectedResult="9";
        Assert.assertTrue(sum.contains(expectedResult));
        System.out.println(sum);
        Allure.description("Sum of two numbers asserted successfully");
    }
    @Test(priority = 2, description = "validate calculating series")
    public void doSeries(){
        calcScreen=new CalcScreen(driver);
        String result = calcScreen.calcSeries("100/10*5-10+60");
        String expectedResult="100";
        Assert.assertTrue(result.contains(expectedResult));
        System.out.println(result);
        Allure.description("Assertion of series is successful");
    }

    @Test(priority = 3, description = "Validate calculating series from csv data", dataProvider = "seriesCSVData", dataProviderClass = seriesDataSet.class)
    public void doSeriesWithCSVSeries(String series, String expectedResult){
        calcScreen=new CalcScreen(driver);
        String result = calcScreen.calcSeries(series);
        Assert.assertTrue(result.contains(expectedResult));
        System.out.println(result);
        Allure.description("Assertion of series from CSV data is successful");
    }

    @AfterMethod
    public void clearScreen(){
        calcScreen = new CalcScreen(driver);
        calcScreen.btnClear.click();
    }
}
