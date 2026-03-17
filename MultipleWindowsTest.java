import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.awt.Robot;
import java.time.Duration;
import static org.testng.Assert.*;

public class ExitIntentTest extends BaseTest {
    private WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void testModalAppearsOnExit() throws Exception {
        driver.get(BASE_URL + "/exit_intent");
        Point location = driver.manage().window().getPosition();
        Robot robot = new Robot();
        robot.mouseMove(location.x + 400, location.y + 300);
        Thread.sleep(300);
        robot.mouseMove(location.x + 400, location.y - 10);
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("ouibounce-modal")));
        assertTrue(driver.findElement(By.id("ouibounce-modal")).isDisplayed());
    }

    @Test
    public void testModalClosesOnClick() throws Exception {
        driver.get(BASE_URL + "/exit_intent");
        Point location = driver.manage().window().getPosition();
        Robot robot = new Robot();
        robot.mouseMove(location.x + 400, location.y + 300);
        Thread.sleep(300);
        robot.mouseMove(location.x + 400, location.y - 10);
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("ouibounce-modal")));
        driver.findElement(By.cssSelector("#ouibounce-modal .modal-footer")).click();
        getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#ouibounce-modal .modal-footer")));
        assertFalse(driver.findElement(By.id("ouibounce-modal")).isDisplayed());
    }
}