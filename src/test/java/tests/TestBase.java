package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase {

    @BeforeAll
    public static void beforeSettings() {

        String[] browserParams = System.getProperty("browser", "chrome 100").split(" ");

        Configuration.baseUrl = System.getProperty("base_url", "https://demoqa.com");
        Configuration.browser = browserParams[0];
        Configuration.browserVersion = browserParams[1];
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");
        Configuration.timeout = 10000;
        Configuration.remote = System.getProperty("remote_url", "https://user1:1234@selenoid.autotests.cloud/wd/hub"); // ссылка на selenoid

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    public void beforeEach() {

        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    public void addAttach() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        Date date = new Date();

        Attach.screenshotAs("screenshot_" + dateFormat.format(date));
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}