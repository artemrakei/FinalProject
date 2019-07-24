import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.Eyes;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Attachment;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.sql.SQLException;

public class MailRuLoginSteps {
    private Eyes eyes;
    private static String API_KEY = "RFy678rDfd7Jtb0LlJJsxgoyohmMAL4Upgu0L7mcKN4110";
    private static final String MAIN_URL = "http://mail.ru";
    private MailRuLoginPage mailRuLoginPage;
    private WebDriver webDriver;

    public MailRuLoginSteps() throws SQLException {
        webDriver = Singleton.getInstance().getWebDriver();
        mailRuLoginPage = new MailRuLoginPage(webDriver);
    }

    @Before
    public void beforeClass () {
        eyes = new Eyes();
        eyes.setApiKey(API_KEY);
    }

    @Given("^I am on main application page$")
    public void loadMainPage() {
        eyes.open(webDriver, "MAIL", "MailSendTest");
        webDriver.get(MAIN_URL);
        eyes.checkWindow("Mailbox");
        eyes.close();

    }

    @Given("^I am on main Mail.ru page and login as correct user$")
    public void loadMainPage1() throws SQLException {
        webDriver.get(MAIN_URL);
        mailRuLoginPage.enterLogin(1);
        mailRuLoginPage.enterPass(1);
        mailRuLoginPage.clickEnterButton();

    }

    @Given("^I am moving in spam$")
    public void loadSpamPage() {
        mailRuLoginPage.moveToSpam();
    }

    @When("^I login as correct user$")
    public void loginAsCorrectUser() throws SQLException {
        mailRuLoginPage.enterLogin(1);
        mailRuLoginPage.enterPass(1);
        mailRuLoginPage.clickEnterButton();
    }

    @When("^I login as user with \"([^\"]*)\" XML$")
    public void loginAsCorrectUserXML(String id) throws Exception {
        saveScreenshotPNG(webDriver);
        mailRuLoginPage.enterLoginXML(Integer.parseInt(id));
        mailRuLoginPage.enterPassXML(Integer.parseInt(id));
        mailRuLoginPage.clickEnterButton();
    }

    @When("^I login as user with \"([^\"]*)\"$")
    public void loginCorrectUser(String number) throws SQLException {
        mailRuLoginPage.enterLogin(Integer.parseInt(number));
        mailRuLoginPage.enterPass(Integer.parseInt(number));
        mailRuLoginPage.clickEnterButton();
    }

    @When("^I login as user with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void loginAsUserWithCredentials(String number) throws SQLException {
        mailRuLoginPage.enterLogin(Integer.parseInt(number));
        mailRuLoginPage.clickEnterButton();
    }

    @When("I see logout link")
    public void seeLogoutLink() {
        Assert.assertTrue(mailRuLoginPage.logoutLinkPresents());
    }

    @When("I click logout link")
    public void clickLogoutLink() {
        mailRuLoginPage.clickLogoutLink();
    }

    @When("^I choice contacts$")
    public void choiceContacts() {
        mailRuLoginPage.clickContactsLink();
        mailRuLoginPage.clickSelectedToContacts();
    }

    @When("^I write message$")
    public void writeMessage() {
        mailRuLoginPage.clickButtonWrite();
        mailRuLoginPage.enterTheme("Test message");
        mailRuLoginPage.clickSendGroupMessage();
    }

    @When("^I mark flags messages$")
    public void markMessage() {
        mailRuLoginPage.choiceLetter();
        mailRuLoginPage.markFlagMessages();
    }

    @When("^I choice marked messages$")
    public void markedMessage() {
        mailRuLoginPage.markedMessage();
        mailRuLoginPage.chooseAllMessage();
    }

    @When("^I choice three messages$")
    public void choiceMessages() {
        mailRuLoginPage.choiceLetter();
    }

    @When("^I unmarked message$")
    public void unmarkedMessage() {
        mailRuLoginPage.unmarkFlagMessages();
    }

    @When("^I move message in archive$")
    public void movingInArchive() throws InterruptedException {
        mailRuLoginPage.movingInArchive();
//        mailRuLoginPage.confirmMovingInArchive();
    }

    @When("^I choice three letters$")
    public void choiceThreeLetter() {
        mailRuLoginPage.choiceLetter();
    }

    @When("^I choice three letters in spam$")
    public void choiceThreeLetterInSpam() {
        mailRuLoginPage.choiceLetterInSpam();
    }

    @When("^I moving selected letters in or out spam$")
    public void movingInSpam() {
        mailRuLoginPage.movingInSpam();
    }

    @Then("I see decrease incoming letters")
    public void seeDecreaseLetters() {
        Assert.assertTrue(mailRuLoginPage.decreaseLetters());
    }

    @Then("I see increase incoming letters")
    public void seeIncreaseLetters() throws InterruptedException {
        Assert.assertTrue(mailRuLoginPage.increaseLetters());
    }

    @Then("I see registration link")
    public void seeRegLink() {
        Assert.assertTrue(mailRuLoginPage.seeRegLink());
    }

    @Then("I see error message")
    public void seeErrorMessage() {
        Assert.assertTrue(mailRuLoginPage.logoutLinkErrorPresents());
    }

    @Then("I see that message was send")
    public void seeSendMessage() {
        Assert.assertTrue(mailRuLoginPage.sendMessagePresents());
    }

    @Then("I see marked messages")
    public void markedMessages() {
        Assert.assertTrue(mailRuLoginPage.visibleFlag());
    }

    @Then("I dont see marked messages")

    public void unmarkedMessages() {
        Assert.assertFalse(mailRuLoginPage.visibleFlag());
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @After
    public void afterClass() {
        eyes.abortIfNotClosed();
        saveScreenshotPNG(webDriver);
        Singleton.quit();
    }
}
