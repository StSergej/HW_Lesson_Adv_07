package hw_07_04;

import javax.xml.bind.annotation.XmlElement;

public class Street {

    private String streetName;
    private String definition;

    public Street() { }

    public Street(String streetName, String definition) {
        this.streetName = streetName;
        this.definition = definition;
    }

    public String getStreetName() {
        return streetName;
    }
    @XmlElement(name = "street_name")
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getDefinition() {
        return definition;
    }
    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public String toString() {
        return "Street: " + streetName + ", " + definition;
    }

}
