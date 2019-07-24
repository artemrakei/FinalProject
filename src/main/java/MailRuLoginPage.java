import com.sun.javafx.property.adapter.JavaBeanQuickAccessor;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;

public class MailRuLoginPage extends Xpath {
    Json json = new Json();
    private static final int LINK_PRESENSE_TIMEOUT = 10;
    private static final Logger log = Logger.getLogger(MailRuLoginPage.class);
    private WebDriver driver;
    private int numberIncomingLetters;
    private int numberIncomingLetters1;
    private boolean result = false;
    private Operations operations = new Operations();
    private SaxParserMailRu saxParserMailRu = new SaxParserMailRu();

    public MailRuLoginPage(WebDriver driver) throws SQLException {
        log.info("Initial WebDriver");
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public void enterLogin(int number) throws SQLException {
        log.info("Enter Login");
        String login = operations.getLogin(number);
        loginField.clear();
        loginField.sendKeys(login);
    }

    public void enterPass(int number) throws SQLException {
        log.info("Enter Password");
        String password = null;
        password = operations.getPassword(number);
        passwordField.clear();
        passwordField.sendKeys(password);

    }

    public void enterLoginXML(int id) throws Exception {
        json.adapter();
        log.info("Enter Login");
        String login = null;
        login = saxParserMailRu.saxParserLogin(id);
        loginField.clear();
        loginField.sendKeys(login);
    }

    public void enterPassXML(int id) throws IOException, SAXException, ParserConfigurationException {
        log.info("Enter Password");
        String password = null;
        password = saxParserMailRu.saxParserPassword(id);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickEnterButton() {
        log.info("Click Enter after entry Login and Password");
        buttonEnter.click();
    }

    public boolean logoutLinkPresents() {
        log.info("Here we see 'Logout Link'");
        return (new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT)).until(ExpectedConditions.visibilityOf(logoutLink))
                .isDisplayed();
    }

    public boolean logoutLinkErrorPresents() {
        log.info("Here we are not logged in");
        return (new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(logoutLinkError))
                .isDisplayed());
    }

    public void choiceLetter() {
        log.info("Choice three mails");
        new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT).until(ExpectedConditions.visibilityOf(choiceLetter1))
                .isDisplayed();
        choiceLetter1.click();
        choiceLetter2.click();
        choiceLetter3.click();
    }

    public void choiceLetterInSpam() {
        log.info("Choice three mails in Spam");
        new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT).until(ExpectedConditions.visibilityOf(choiceLetterInSpam1))
                .isDisplayed();
        choiceLetterInSpam1.click();
        choiceLetterInSpam2.click();
        choiceLetterInSpam3.click();
    }

    public void movingInSpam() {
        log.info("Moving mails in Spam");
        numberIncomingLetters = Integer.parseInt(incomingLetters.getText().trim());
        driver.switchTo().activeElement().sendKeys("j");
        new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT).until(ExpectedConditions.visibilityOf(driver.switchTo().activeElement()))
                .isDisplayed();
    }

    public boolean decreaseLetters() {
        log.info("Here we see decrease incoming mails");
        String incMes = String.valueOf(Integer.parseInt(incomingLetters.getText().trim()) - 3);
        new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT).until(ExpectedConditions.textToBePresentInElement
                (incomingLetters, incMes));
        numberIncomingLetters1 = Integer.parseInt(incomingLetters.getText().trim());
        if (numberIncomingLetters > numberIncomingLetters1) {
            result = true;
        }

        return result;
    }

    public boolean increaseLetters() throws InterruptedException {
        log.info("Here we see increase incoming mails");
        Thread.sleep(2000);
        if (numberIncomingLetters >= numberIncomingLetters1) {
            result = true;
        }

        return result;
    }

    public void moveToSpam() {
        log.info("Here we moving mails in Spam");
        new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT).until(ExpectedConditions.visibilityOf(spamLink))
                .isDisplayed();
        spamLink.click();
    }

    public void clickLogoutLink() {
        log.info("Here we click 'Logout Link'");
        new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT).until(ExpectedConditions.elementToBeClickable(logoutLink));
        logoutLink.click();
    }

    public boolean seeRegLink() {
        log.info("Here we see link of Registration");
        return (new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(regLink)).isDisplayed());
    }


    public void clickContactsLink() {
        new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT).until(ExpectedConditions.elementToBeClickable(contactsLink));
        contactsLink.click();
    }

    public void clickSelectedToContacts() {
        choiceContact1ToGroup.click();
        choiceContact2ToGroup.click();
    }

    public void clickButtonWrite() {
        buttonWriteGroupMessage.click();
    }

    public void enterTheme(String theme) {
        themeMail.click();
        themeMail.clear();
        themeMail.sendKeys(theme);
    }


    public void clickSendGroupMessage() {
        themeMail.submit();
        new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT).until(ExpectedConditions.elementToBeClickable(confirmSend));
        confirmSend.click();
    }

    public boolean sendMessagePresents() {
        return (new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT)).until(ExpectedConditions.visibilityOf(messageWasSend))
                .isDisplayed();
    }


    public void markFlagMessages() {
        beforeMarkFlag.click();
        driver.switchTo().activeElement().sendKeys("i");

    }

    public boolean visibleFlag() {
        return (new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT).until(ExpectedConditions.visibilityOf(flag))
                .isDisplayed());
    }

    public void markedMessage() {
        new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT).until(ExpectedConditions.elementToBeClickable(marked))
                .isDisplayed();
        marked.click();
    }

    public void chooseAllMessage() {
        new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT).until(ExpectedConditions.elementToBeClickable(chooseAllMessages))
                .isDisplayed();
        chooseAllMessages.click();
    }

    public void unmarkFlagMessages() {
        new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT).until(ExpectedConditions.elementToBeClickable(beforeMarkFlag))
                .isDisplayed();
        beforeMarkFlag.click();
        new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT).until(ExpectedConditions.elementToBeClickable(unmarkedFlag))
                .isDisplayed();
        unmarkedFlag.click();
    }

    public void  movingInArchive () throws InterruptedException {
        driver.switchTo().activeElement().sendKeys("e");
        Thread.sleep(2000);
    }
//    public void confirmMovingInArchive () {
//        if (messageInArchive.isDisplayed()) {
//        messageInArchive.click();}
//    }





}

