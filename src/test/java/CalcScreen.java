import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalcScreen {
    @FindBy(id = "com.google.android.calculator:id/op_add")
    WebElement btnPlus;
    @FindBy(id = "com.google.android.calculator:id/eq")
    WebElement btnEqual;
    @FindBy(id = "com.google.android.calculator:id/op_sub")
    WebElement btnMinus;
    @FindBy(id = "com.google.android.calculator:id/op_mul")
    WebElement btnMultiplication;
    @FindBy(id = "com.google.android.calculator:id/op_div")
    WebElement btnDivision;
    @FindBy(id = "com.google.android.calculator:id/clr")
    WebElement btnClear;
    @FindBy(id = "com.google.android.calculator:id/result_final")
    WebElement txtResult;
    AndroidDriver driver;

    public CalcScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String doSum(int num1, int num2) {
        driver.findElement(By.id("com.google.android.calculator:id/digit_" + num1)).click();
        btnPlus.click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_" + num2)).click();

        btnEqual.click();
        String sum = txtResult.getText();
        return sum;
    }

    public String calcSeries(String series) {
        for (int i = 0; i < series.length(); i++) {
            if(series.charAt(i) == '+') {
                driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
            } else if (series.charAt(i) == '-'){
                driver.findElement(By.id("com.google.android.calculator:id/op_sub")).click();
            } else if (series.charAt(i) == '*'){
                driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
            } else if (series.charAt(i) == '/'){
                driver.findElement(By.id("com.google.android.calculator:id/op_div")).click();
            } else if(series.charAt(i) == 'p'){
                driver.findElement(By.id("com.google.android.calculator:id/const_pi")).click();
            }  else if(series.charAt(i) == 'i'){
                continue;
            } else if(series.charAt(i) == '^'){
                driver.findElement(By.id("com.google.android.calculator:id/op_pow")).click();
            }
            else{
                driver.findElement(By.id("com.google.android.calculator:id/digit_"+series.charAt(i))).click();
            }
        }
        btnEqual.click();
        String result = txtResult.getText();
        return result;
    }
}
