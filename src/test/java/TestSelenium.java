import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;

import java.io.File;

import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL;

public class TestSelenium {

    @Rule
    public BrowserWebDriverContainer chrome = new BrowserWebDriverContainer()
            .withDesiredCapabilities(DesiredCapabilities.chrome())
            .withRecordingMode(RECORD_ALL, new File("target"));

    @Test
    public void searchTitleTest() {
        RemoteWebDriver driver = chrome.getWebDriver();

        driver.get("http://www.google.com");

        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("bumin");

        element.submit();

        Assert.assertTrue(driver.getTitle().contains("bumin"));

        driver.quit();
    }
}
