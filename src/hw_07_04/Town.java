package hw_07_04;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Town {

    private String definition;
    private String city;
    private String size;

    public Town() { }

    public Town(String definition, String city, String size) {
        this.definition = definition;
        this.city = city;
        this.size = size;
    }

    @Override
    public String toString() {
        return "City: " + city + ", " + "size = " + size + ", " + definition ;
    }


    public String getDefinition() {
        return definition;
    }
    @XmlElement(name = "definition_city")
    public void setDefinition(String definitionTown) {
        this.definition = definitionTown;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @XmlAttribute(name = "size")
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }


}
