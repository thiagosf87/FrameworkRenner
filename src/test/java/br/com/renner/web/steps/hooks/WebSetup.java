package br.com.renner.web.steps.hooks;

import br.com.renner.robots.SeleniumRobotsTool;
import br.com.renner.robots.builder.SeleniumRobotsBuilder;
import br.com.renner.toolbox.GlobalTools;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static br.com.renner.toolbox.GlobalTools.*;

public class WebSetup {
    public static SeleniumRobotsTool seleniumRobotsTool;
    public static WebDriver driver;
    public static String baseUrl = getExecutionUrl();

    @Before()
    public void initiate(Scenario scenario) throws IOException {
        System.out.printf("TESTE %s is started%n", scenario.getName());
        switch (getExecutionNavegador()) {
            default:
            case "chrome": {
                System.out.println("Chrome");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");

                WebDriverManager.chromedriver().setup();
                seleniumRobotsTool = new SeleniumRobotsBuilder()
                        .pollingSeconds(60)
                        .timeoutSeconds(30)
                        .pollingSeconds(5)
                        .setChromeOptions(chromeOptions)
                        .build();
                break;
            }
            case "remote": {
                SeleniumRobotsBuilder seleniumRobotsBuild = new SeleniumRobotsBuilder()
                        .pollingSeconds(60)
                        .timeoutSeconds(30)
                        .pollingSeconds(5)
                        .remoteExec("http://localhost:4444/wd/hub")
                        .chrome();
                WebDriverManager.chromedriver().setup();
                HashMap<String, Object> chromePrefs = new HashMap<>();
                chromePrefs.put("profile.default_content_settings.popups", 0);
                chromePrefs.put("download.prompt_for_download", "false");
                chromePrefs.put("plugins.plugins_disabled", new String[]{"Adobe Flash Player", "Chrome PDF Viewer"});
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", chromePrefs);
                options.addArguments("--lang=pt");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--aggressive-cache-discard");
                options.addArguments("--disable-cache");
                options.addArguments("--disable-application-cache");
                options.addArguments("--disable-offline-load-stale-cache");
                options.addArguments("--disk-cache-size=0");
                options.addArguments("--disable-gpu");
                options.addArguments("--dns-prefetch-disable");
                options.addArguments("--no-proxy-server");
                options.addArguments("--log-level=3");
                options.addArguments("--silent");
                options.addArguments("--disable-browser-side-navigation");
                options.setPageLoadStrategy(PageLoadStrategy.EAGER);
                options.setAcceptInsecureCerts(true);
                options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
                options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                options.setProxy(null);
                System.setProperty("webdriver.chrome.silentOutput", "true");
                seleniumRobotsTool = seleniumRobotsBuild.setChromeOptions(options).build();
                break;
            }
        }
        driver = seleniumRobotsTool.getDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After()
    public void tearDown(Scenario scenario) throws IOException {
        System.out.printf("TESTE %s is %s%n", scenario.getName(), scenario.getStatus().name());
        if (driver != null) {
//            driver.quit();
            driver = null;
        }
    }
}
