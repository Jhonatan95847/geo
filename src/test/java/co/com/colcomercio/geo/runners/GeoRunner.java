package co.com.colcomercio.geo.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features= "src/test/resources/features/login.feature",
        glue = {"co.com.colcomercio.geo.stepdefinitions"},
        snippets= CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true
)
public class GeoRunner {
}
