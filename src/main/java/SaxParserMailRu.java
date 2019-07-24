import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SaxParserMailRu extends DefaultHandler {
    private static final String USERS_DATAS_XML = "UserDatas.xml";


    public String saxParserLogin(int numberID) throws Exception {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        WebElementsHandler webElementsHandler = new WebElementsHandler();
        saxParser.parse(new File(USERS_DATAS_XML), webElementsHandler);
        List<UsersDatas> webElements = webElementsHandler.getWebElements();

        return webElements.get(numberID - 1).getLogin();
    }

    public String saxParserPassword(int numberID) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        WebElementsHandler webElementsHandler = new WebElementsHandler();
        saxParser.parse(new File(USERS_DATAS_XML), webElementsHandler);
        List<UsersDatas> webElements = webElementsHandler.getWebElements();

        return webElements.get(numberID - 1).getPassword();
    }
}
