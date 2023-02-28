package hw_07_04;

import javax.xml.bind.annotation.XmlElement;

public class Building {

    private int number;
    private String name;

    public Building() { }

    public Building(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }
    @XmlElement(name =  "building_number")
    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }
    @XmlElement(name = "institution_name")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Building: " + " number = " + number +", name = " + name;
    }
}
