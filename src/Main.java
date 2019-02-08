import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Main {

    static WebDriver webDriver;

    public static void main(String[] args){

        System.setProperty("webdriver.gecko.driver", "C:/geckoDriver/geckodriver.exe");

        //Enabling Media Playing the Web Driver
        FirefoxOptions firefoxOptions=new FirefoxOptions().addPreference("media.gmp-manager.updateEnabled",true);

        webDriver=new FirefoxDriver(firefoxOptions);

        try {
            webDriver.navigate().to("https://open.spotify.com");

            webDriver.findElement(By.xpath("//button[text()='Log in']")).click();

            webDriver.findElement(By.xpath("//a[text()='Log in with Facebook']")).click();

            //Add your Email and Password
            webDriver.findElement(By.id("email")).sendKeys("email");
            webDriver.findElement(By.id("pass")).sendKeys("password");

            webDriver.findElement(By.id("loginbutton")).click();

            webDriver.manage().window().setSize(new Dimension(1020,180));
            webDriver.manage().window().setPosition(new Point(300,650));


            System.out.println(webDriver);

            while(true){
                try {
                    webDriver.getCurrentUrl();
                }catch (Exception e)
                {
                    System.out.println("quitting");
                    webDriver.quit();
                    System.out.println("done");
                    System.exit(0);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
