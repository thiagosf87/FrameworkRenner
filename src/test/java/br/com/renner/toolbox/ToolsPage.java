package br.com.renner.toolbox;

import br.com.renner.web.steps.hooks.WebSetup;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class ToolsPage {

    private static final Duration MAX_DURATION = Duration.ofSeconds(30L);
    private static final Duration POOL_DURATION = Duration.ofSeconds(5L);

    public static String getJsonInput(String nomefeature, String file, String key)
            throws IOException, ParseException {

        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
                File.separator + "resources" + File.separator + "json" + File.separator + "Inputs" + File.separator;

        JSONParser jsonParse = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParse
                .parse(new FileReader(path + file + ".json"));

        JSONObject getKey = (JSONObject) jsonObject.get(nomefeature);

        return String.valueOf(getKey.get(key));
    }

    public static String getJsonValidation(String nomefeature, String file, String key)
            throws IOException, ParseException {

        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
                File.separator + "resources" + File.separator + "json" + File.separator + "Validation" + File.separator;

        JSONParser jsonParse = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParse
                .parse(new FileReader(path + file + ".json"));

        JSONObject getKey = (JSONObject) jsonObject.get(nomefeature);

        return String.valueOf(getKey.get(key));
    }

    public static String getUserEmail() {
        String user = "automacao_teste@db.com";

        return user;
    }

    public static String getPassword() {
        String senha = "123@automacao";

        return senha;
    }

    public static String getCPF() {
        String cpf = "75697802994";

        return cpf;
    }

    public static WebElement esperarElement(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(WebSetup.driver)
                .withTimeout(MAX_DURATION)
                .pollingEvery(POOL_DURATION)
                .ignoring(NoSuchElementException.class);

        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static String getTimestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String date = new SimpleDateFormat("yyyy.MM.dd-HH:mm:ss").format(timestamp.getTime());
        System.out.println();

        return date;
    }

}
