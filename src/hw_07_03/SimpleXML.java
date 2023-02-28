package hw_07_03;

/*  Создайте класс, используя SAXParser, в котором опишите иерархию XML файла.
    Необходимо, чтобы проект создавал XML файл и строил дерево (город, название улицы, дом).
    В городе используйте аттрибут(например, <city size=”big>Kiev</city>).
*/


import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class SimpleXML {
    public static void main(String[] args) {

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("catalog_town");
            doc.appendChild(rootElement);

            Element city = doc.createElement("town");
            rootElement.appendChild(city);

            Element city1 = doc.createElement("city");
            Attr attrName = doc.createAttribute("size");
            attrName.setValue("big");
            city1.setAttributeNode(attrName);
            city1.appendChild(doc.createTextNode("Kiev"));
            city.appendChild(city1);

            Element definition = doc.createElement("definition_city");
            definition.appendChild(doc.createTextNode("Capital"));
            city.appendChild(definition);


            Element street = doc.createElement("street");
            city.appendChild(street);

            Element streetName = doc.createElement("street_name");
            streetName.appendChild(doc.createTextNode("Khreshchatyk"));
            street.appendChild(streetName);

            Element definition1 = doc.createElement("definition");
            definition1.appendChild(doc.createTextNode("Kiev's main street"));
            street.appendChild(definition1);

            Element building = doc.createElement("building");
            street.appendChild(building);

            Element number = doc.createElement("building_number");
            number.appendChild(doc.createTextNode("38"));
            building.appendChild(number);

            Element instName = doc.createElement("institution_name");
            instName.appendChild(doc.createTextNode("Central Department Store"));
            building.appendChild(instName);


            TransformerFactory tranFormFactory = TransformerFactory.newInstance();
            Transformer transformer = tranFormFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("I:\\Education JAVA\\Task_07" +
                                                                        "\\Assignment\\src\\hw_07_03\\XML_07_03.xml"));
            transformer.transform(source, result);


            } catch (Exception ex) {
                ex.printStackTrace();
            }

        System.out.println("XML файл создан.");

    }
}
