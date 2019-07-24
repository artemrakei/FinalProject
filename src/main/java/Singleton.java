import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Singleton {
    private static Singleton INSTANCE;
    private static WebDriver webDriver;


    public Singleton() {
        webDriver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","C:\\Courses\\chromedriver.exe");
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public static void quit () {
        webDriver.quit();
        INSTANCE=null;
    }

}
