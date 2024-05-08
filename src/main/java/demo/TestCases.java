package demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void navigate() {
        driver.get(
                "https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        String url = driver.getCurrentUrl();
        if (url.contains("forms")) {
            System.out.println("Navigated to the page successfully");
        } else {
            System.out.println("Navigation to the page is Unsuccessfull");
        }

    }

    public void name(String name) {
        WebElement nameTextBox = driver.findElement(
                By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div/div[1]/input"));
        nameTextBox.sendKeys(name);
    }

    public void automation() {
        long epoch = System.currentTimeMillis() / 1000;
        WebElement practicingAutomation = driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']"));
        practicingAutomation.sendKeys("I want to be the best QA Engineer!" + epoch);

    }

    public void experience(int exp) {
        WebElement experienceRadioButtons = driver
                .findElement(By.xpath("(//div[@class=\"AB7Lab Id5V1\"])[" + exp + "]"));
        experienceRadioButtons.click();

    }

    public void skills(String skills) {
        WebElement skillsButton1 = driver.findElement(By.xpath("//span[text()='" + skills + "']"));
        skillsButton1.click();

    }

    public void addressed() throws InterruptedException {
        WebElement adresseddropdown = driver.findElement(By.xpath("//div[@class='ry3kXd']"));
        adresseddropdown.click();
        Thread.sleep(1000);
        WebElement selectingMr = driver.findElement(By.xpath("(//span[text()='Mr'])[2]"));
        selectingMr.click();

    }

    public void date() {
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, -7);
        Date previousDate = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formatedDate = dateFormat.format(previousDate);
        WebElement date = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[2]"));
        date.sendKeys(formatedDate);

    }

    public void time() {
        Calendar cal = Calendar.getInstance();
        int hours = cal.get(Calendar.HOUR);
        int minutes = cal.get(Calendar.MINUTE);
        int amPm = cal.get(Calendar.AM_PM);
        WebElement timeHr = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[3]"));
        timeHr.sendKeys(String.valueOf(hours));
        WebElement timeMin = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[4]"));
        timeMin.sendKeys(String.valueOf(minutes));
        // WebElement am_pm =
        // driver.findElement(By.xpath("(//div[@class=\"ry3kXd\"])[2]"));
        // am_pm.sendKeys(String.valueOf(amPm));
    }

    public void navigateToAmazon() throws InterruptedException {
        driver.navigate().to("https://www.amazon.in/");
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

    }

    public void clickOnSubmitButton() {
        WebElement SubmitButton = driver.findElement(By.xpath("//span[text()='Submit']"));
        SubmitButton.click();
    }

    public void successMessage() {
        WebElement getText = driver.findElement(By.xpath("//div[@class='vHW8K']"));
        String text = getText.getText();
        System.out.println(text);

    }

    public void testCase01() throws InterruptedException {
        // 1.Navigate to this google form.
        System.out.println("Start Test case: testCase01");
        navigate();
        Thread.sleep(2000);

        // 2.Fill in your name in the 1st text box
        name("Gourav Kumar");
        Thread.sleep(1000);

        // 3. Write down “I want to be the best QA Engineer! 1710572021''
        automation();
        Thread.sleep(1000);

        // 4.Enter your Automation Testing experience in the next radio button
        experience(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");

        // 5. Select Java, Selenium and TestNG from the next check-box
        skills("Java");
        Thread.sleep(1000);
        skills("Selenium");
        Thread.sleep(1000);
        skills("TestNG");
        Thread.sleep(1000);

        // 6.Provide how you would like to be addressed in the next dropdown
        addressed();
        Thread.sleep(1000);

        // 7. Provided the current date minus 7 days in the next date field, it should
        // be dynamically calculated and not hardcoded.

        date();
        Thread.sleep(1000);

        // 8. Provided the current date minus 7 days in the next date field, it should
        // be dynamically calculated and not hardcoded.

        time();
        Thread.sleep(1000);

        // 9. Change the URL of the tab (amazon.in) and you will find the pop up as
        // follows. Click on cancel.
        navigateToAmazon();
        Thread.sleep(1000);

        // 10. Submit the form
        clickOnSubmitButton();
        Thread.sleep(2000);

        // 11. You will see a success message on the website. Print the same message on
        // the console upon successful completion
        successMessage();
        System.out.println("end Test case: testCase01");
    }

}
