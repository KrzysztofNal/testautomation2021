package pl.tmobile.prepaidqa.qagui.bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "classpath:pl.tmobile.prepaidqa.qagui.bdd",
        plugin = { "pretty", "summary", "html:target/cucumber/report.html", "json:target/cucumber.json",
                "junit:target/cucumber.xml",
                "rerun:target/rerun.txt"
        },
        tags =
//                "not "
//                        +
//                        "@login"
                          "@website_3"
//                        +
//                        " and "
//                        +
//                        " not "
//                        +
//                        "@login "
//        +
//                        " @wordpress "
//                        +
//                        "@userpanel"
)
public class RunTest {
}
