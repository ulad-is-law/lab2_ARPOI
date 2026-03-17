package data;

import org.testng.annotations.DataProvider;

public class TestData {
    public static final String TEST_PASSWORD = "pass1234";

    @DataProvider(name = "invalidZip")
    public static Object[][] invalidZip() {
        return new Object[][] {
                {"abc"},
                {"123"},
                {"!@#"},
        };
    }

    @DataProvider(name = "invalidRegistration")
    public static Object[][] invalidRegistration() {
        return new Object[][] {
                {"", "Doe", "empty@test.com", "pass1234", "pass1234", "Пустое имя"},
                {"John", "Doe", "mismatch@test.com", "aaa", "aaa", "Недостаточно длинный пароль"},
                {"John", "Doe", "bademail", "pass1234", "pass1234", "Некорректный email"},
        };
    }

    @DataProvider(name = "successfulRegistration")
    public static Object[][] successfulRegistration() {
        return new Object[][] {
                {"John", "Doe", "user_" + System.currentTimeMillis() + "@test.com",
                        "pass1234", "pass1234", "Валидные данные"},
                {"John", "Doe", "user_" + System.currentTimeMillis() + 10 + "@test.com",
                        "pass1234", "pass", "Невалидный повторный пароль"},
        };
    }

    @DataProvider(name = "searchKeywords")
    public static Object[][] searchKeywords() {
        return new Object[][] {
                {"power", true},
                {"zzzqqqxxx999", false},
        };
    }
}