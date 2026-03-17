import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BasicAuthTest extends BaseTest {
    @Test
    public void testBasicAuthSuccess() {
//        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        driver.get("http://admin:admin@localhost:5000/basic_auth");
        assertTrue(driver.getPageSource().contains("Congratulations! You must have the proper credentials."));
    }

    @Test
    public void testBasicAuthFailure() {
//        driver.get("https://wrong:wrong@the-internet.herokuapp.com/basic_auth");
        driver.get("http://wrong:wrong@localhost:5000/basic_auth");
        assertFalse(driver.getPageSource().contains("Congratulations"));
    }
}
