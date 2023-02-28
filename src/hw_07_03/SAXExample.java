package hw_07_03;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class SAXExample extends DefaultHandler {
    public static void main(String[] args) {

        String patch = "I:\\Education JAVA\\Task_07\\Assignment\\src\\hw_07_03\\XML_07_03.xml";

        DefaultHandler handler = new DefaultHandler() {
            boolean tag = false;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes){
                System.out.println("<" + qName + ">");

                if (qName.equalsIgnoreCase("definition_city")) {
                    tag = true;
                } else if (qName.equalsIgnoreCase("city")) {
                    tag = true;
                    System.out.print("\tSize = " + attributes.getValue("size"));
                } else if (qName.equalsIgnoreCase("street_name")) {
                    tag = true;
                } else if (qName.equalsIgnoreCase("definition")) {
                    tag = true;
                } else if (qName.equalsIgnoreCase("building_number")) {
                    tag = true;
                } else if (qName.equalsIgnoreCase("institution_name")) {
                    tag = true;
                }
            }


            public void characters(char ch[], int start, int length){
                if (tag) {
                    System.out.print("\t " + new String(ch, start, length) + "\n");
                    tag = false;
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName)
                    throws SAXException {
                super.endElement(uri, localName, qName);
            }
        };


        try {
            SAXParserFactory factory;
            factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            System.out.println("Начало разбора файла: ");
            saxParser.parse(patch, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

        new SAXExample();
            System.out.println("Разбор файла завершен!");
            System.exit(0);
    }
}
