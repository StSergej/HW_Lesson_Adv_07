package hw_07_04;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "catalog_city")
public class City {

    @XmlElement(name = "city")

    private final List<Town> towns = new ArrayList<>();

    public void add(Town town){
        towns.add(town);
    }

    @XmlElement(name = "street")
    private final List<Street> streets = new ArrayList<>();

    public void addStreet(Street street){
        streets.add(street);
    }

    @XmlElement(name = "building")
    private final List<Building> buildings = new ArrayList<>();

    public void addBuilding(Building building){
        buildings.add(building);
    }

    @Override
    public String toString() {
        return "catalog_city: \n\t" + towns + ",\n\t" + streets + ",\n\t" + buildings;
    }
}
