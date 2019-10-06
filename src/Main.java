import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            String fileName = "FILENAME";
            Integer index = 0;
            File fileXml = new File(fileName);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(fileXml);
            doc.getDocumentElement().normalize();
            NodeList lst = doc.getChildNodes();
            String data;
            Element child = (Element) lst.item(0).getChildNodes().item(index);
            System.out.println(child.getFirstChild().getNodeValue());
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
