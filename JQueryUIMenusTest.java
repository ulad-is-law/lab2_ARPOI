import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.testng.Assert.*;

public class DynamicControlsTest extends BaseTest {
    private WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    @Test
    public void testRemoveAndAddCheckbox() {
        driver.get(BASE_URL + "/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        assertFalse(driver.findElements(By.id("checkbox")).stream().anyMatch(e -> e.isDisplayed()));

        driver.findElement(By.xpath("//button[text()='Add']")).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
        assertTrue(driver.findElement(By.id("checkbox")).isDisplayed());
    }

    @Test
    public void testEnableAndDisableInput() {
        driver.get(BASE_URL + "/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
        assertTrue(driver.findElement(By.xpath("//input[@type='text']")).isEnabled());

        driver.findElement(By.xpath("//button[text()='Disable']")).click();
        getWait().until(ExpectedConditions.not(
                ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']"))
        ));
        assertFalse(driver.findElement(By.xpath("//input[@type='text']")).isEnabled());
    }
}
