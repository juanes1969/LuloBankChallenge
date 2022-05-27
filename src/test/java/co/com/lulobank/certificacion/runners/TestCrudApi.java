package co.com.lulobank.certificacion.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/test_crud_api.feature",
        glue = "co.com.lulobanck.certificacion.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@HU-DELETE"
)

public class TestCrudApi {
}
