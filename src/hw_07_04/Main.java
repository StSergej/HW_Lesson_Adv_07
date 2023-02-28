package hw_07_04;

//*  Используя JAXB выполнить задание №3


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) {

        City catalog = new City();

        Town town = new Town();
        town.setCity("Kiev");
        town.setSize("big");
        town.setDefinition("Capital");

        Street street = new Street();
        street.setStreetName("Khreshchatyk");
        street.setDefinition("Kiev's main street");

        Building building = new Building();
        building.setNumber(38);
        building.setName("Central Department Store");

        catalog.add(town);
        catalog.addStreet(street);
        catalog.addBuilding(building);

        try{
            File myFile = new File("I:\\Education JAVA\\Task_07\\Assignment\\src\\hw_07_04\\city_07_04.xml");
            JAXBContext context = JAXBContext.newInstance(City.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            System.out.println("Записываем  файл: ");
            marshaller.marshal(catalog,myFile);
            marshaller.marshal(catalog, System.out);

            System.out.println("==========================");

            System.out.println("Считываем из файла: ");
            Unmarshaller unmarshaller = context.createUnmarshaller();
            catalog = (City) unmarshaller.unmarshal(myFile);
            System.out.println(catalog);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
