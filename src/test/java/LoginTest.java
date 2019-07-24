import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"features/Login.feature","features/Spam.feature"})
public class LoginTest  {

//,"features/Spam.feature"
}
