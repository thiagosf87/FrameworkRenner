package br.com.renner.web.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "br.com.renner.web.steps",
        tags = "@pedido",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false,
        plugin = {
                "pretty",
                "html:reports/cucumber.html",
                "json:reports/cucumber.json",
                "junit:reports/cucumber.xml",
        }
)

public class WebRunnerTest {

}
