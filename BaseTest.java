package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    private final WebDriver driver;

    public CartPage(WebDriver driver) { this.driver = driver; }

    public void open() {
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
    }

    public int getBooksCount() {
        return driver.findElements(By.cssSelector("td.td_left")).size();
    }

    public Double getDiscount() {
        List<WebElement> cells = driver.findElements(By.xpath("//table//tr[2]/td"));

        String discountText = cells.get(6).getText();
        return  Double.parseDouble(discountText);
    }
    public Double getPrice() {
        List<WebElement> cells = driver.findElements(By.xpath("//table//tr[2]/td"));

        String priceText = cells.get(4).getText();
        return Double.parseDouble(priceText);
    }
    public Double getTotal() {
        List<WebElement> cells = driver.findElements(By.xpath("//table//tr[2]/td"));

        String totalText = cells.get(7).getText();
        return Double.parseDouble(totalText);
    }

    public boolean isEmpty() {
        return driver.getPageSource().contains("Cart is empty");
    }
}