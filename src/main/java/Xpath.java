import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Xpath {
    @FindBy(id = "mailbox:login")

    protected WebElement loginField;

    @FindBy(id = "mailbox:password")
    protected WebElement passwordField;

    @FindBy(xpath = "//*[@id='mailbox:submit']/input")
    protected WebElement buttonEnter;

    @FindBy(id = "PH_logoutLink")
    protected WebElement logoutLink;

    @FindBy(xpath = "//*[@id='mailbox:error']")
    protected WebElement logoutLinkError;

    @FindBy(xpath = "(.//div[@class='b-datalist__item__body'])[1]/a/div/div/div")
    protected WebElement choiceLetter1;

    @FindBy(xpath = "(.//div[@class='b-datalist__item__body'])[2]/a/div/div/div")
    protected WebElement choiceLetter2;

    @FindBy(xpath = "(.//div[@class='b-datalist__item__body'])[3]/a/div/div/div")
    protected WebElement choiceLetter3;

    @FindBy(xpath = "(.//div[@class=\"b-datalist b-datalist_letters b-datalist_letters_from\"])[2]/div[2]/div[1]/div/a/div/div/div")
    protected WebElement choiceLetterInSpam1;

    @FindBy(xpath = "(.//div[@class=\"b-datalist b-datalist_letters b-datalist_letters_from\"])[2]/div[2]/div[2]/div/a/div/div/div")
    protected WebElement choiceLetterInSpam2;

    @FindBy(xpath = "(.//div[@class=\"b-datalist b-datalist_letters b-datalist_letters_from\"])[2]/div[2]/div[3]/div/a/div/div/div")
    protected WebElement choiceLetterInSpam3;

    @FindBy(xpath = "//*[@id=\"b-nav_folders\"]/div/div[1]/a/span[1]")
    protected WebElement incomingLetters;

    @FindBy(xpath = ".//div[@id=\"LEGO\"]/div[3]/div/div/div/div[6]/a")
    protected WebElement spamLink;

    @FindBy(id = "PH_regLink")
    protected WebElement regLink;

    @FindBy(xpath = "//*[@id=\"b-toolbar__left\"]/div/div/div[2]")
    protected WebElement buttonWrite;

    @FindBy(xpath = ".//div[@class='pm-menu__center']/div/span/span[2]/span[2]/a")
    protected WebElement contactsLink;

    @FindBy(xpath = "(.//div[@class=\"messagelist-wrapper\"]/div/div/div)[1]/label/input")
    protected WebElement choiceContact1ToGroup;

    @FindBy(xpath = "(.//div[@class=\"messagelist-wrapper\"]/div/div/div)[4]/label/input")
    protected WebElement choiceContact2ToGroup;

    @FindBy(xpath = "//*[@id=\"js-send-to-contacts\"]")
    protected WebElement buttonWriteGroupMessage;

    @FindBy(xpath = "(((.//div[@class=\"compose-head\"]/div)[3]/div)[4]/div/div/div)[2]/div/input")
    protected WebElement themeMail;

    @FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div/div/div[2]/div[1]/div")
    protected WebElement sendGroupMessage;

    @FindBy(xpath = "//*[@id=\"MailRuConfirm\"]/div/div[2]/form/div[2]/button[1]")
    protected WebElement confirmSend;

    @FindBy(xpath = ".//div[@class=\"message-sent message-sent_IsSocialConnect\"]")
    protected WebElement messageWasSend;

    @FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[2]/div/div[2]/div[5]/div/div[2]/div[1]")
    protected WebElement beforeMarkFlag;

    @FindBy(xpath = "//*[@id=\"b-letters\"]/div/div[2]/div/div[2]/div[1]/div/a/div[3]/div")
    protected WebElement flag;

    @FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[2]/div/div[1]/div[2]/div/div[2]")
    protected WebElement marked;

    @FindBy(xpath = "(.//div[@class=\"b-dropdown__ctrl\"])[2]/div/div[1]")
    protected WebElement chooseAllMessages;

    @FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[2]/div/div[2]/div[5]/div/div[2]/div[2]/a[4]")
    protected WebElement unmarkedFlag;

    @FindBy(xpath = "//*[@id=\"jsHtml\"]/body/div[9]/div/div[1]/div/div[3]/button[1]")
    protected WebElement messageInArchive;
}
