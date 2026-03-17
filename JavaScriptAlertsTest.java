import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class DropdownTest extends BaseTest {
    @Test
    public void testSelectOption1() {
        driver.get(BASE_URL + "/dropdown");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByValue("1");
        assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 1");
    }

    @Test
    public void testSelectOption2() {
        driver.get(BASE_URL + "/dropdown");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByValue("2");
        assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2");
    }
}
