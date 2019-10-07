import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            final String TAGNAME = "text";
            String fileName = "files/rustih(1).xml";
            String text;
            XmlRead xml = new XmlRead(fileName, TAGNAME);
            text = xml.getTextFromTag();
            System.out.println(text);
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
