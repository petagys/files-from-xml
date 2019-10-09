import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlRead{
    String tagName;
    String fileName;

    public XmlRead(String tagName, String fileName) {
        this.tagName = tagName;
        this.fileName = fileName;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Document parseXml() throws ParserConfigurationException, IOException, SAXException {
        File fileXml = new File(fileName);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(fileXml);
        doc.getDocumentElement().normalize();
        return doc;
    }

    public String getTextFromTag() throws IOException, SAXException, ParserConfigurationException {
        Document document = parseXml();
        NodeList lst = document.getElementsByTagName(tagName);
        String data;
        Element child = (Element) lst.item(0);
        data = child.getFirstChild().getNodeValue();
        return data;
    }
}
