package hw_07_02;

/*Необходимо осуществить десериализацию с файла предыдущего проекта(Animal)
 и вывести на экран содержимое.
 */


import java.io.*;

class Animal implements Serializable {
    private String name = "Tom";
    protected transient Boolean breed = false;
    public int age = 5;

    public Animal() { }

    public Animal(String name, Boolean breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }


    @Override
    public String toString() {
        return "Animal { " + "name ='" + name + '\'' +
                ", breed ='" + breed + '\'' + ", age = " + age + " }";
    }
}

public class AnimalDeserialization {
    public static void main(String[] args) {

        File myFile = new File("I:\\Education JAVA\\Task_07\\Assignment\\src\\hw_07_02\\animalDes_07_02.txt");
        Animal animal = new Animal();
        System.out.println(animal.toString());

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(myFile));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(myFile))){

            oos.writeObject(animal);
            System.out.println("Файл записан.");


            Animal newAnimal = (Animal) ois.readObject();
            System.out.println("Десериализация файла: " + newAnimal);

        } catch (IOException  | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
