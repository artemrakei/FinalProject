import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;


public class Json {
    private static final String jsonInput = "UserData.json";
    public String name;


    public void adapter() throws Exception {


        ObjectMapper jsonMapper = new ObjectMapper();
        UserData json = jsonMapper.readValue(new File(jsonInput), UserData.class);

        XmlMapper xmlMapper = new XmlMapper();
        File file = new File("UserDatas.xml");
        FileUtils.writeStringToFile(file, xmlMapper.writeValueAsString(json));
    }
}



