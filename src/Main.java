import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("dog.dat");
        Dog dog = new Dog("dog", 4);
        Cat cat = new Cat("cat", 61);
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(cat);
        writeObjectInFile(file, animals);
        readObjectInFile(file);
    }

    public static void writeObjectInFile(File file, ArrayList<Animal> animals) throws IOException { // the better use collections than arrays;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));) {
            for (Animal value : animals) {
                oos.writeObject(value);
            }
        } catch (FileNotFoundException e) {
            throw new UsersException("Something to wrong",  e.fillInStackTrace());
        }
    }

    public static void readObjectInFile(File file) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Animal obj = null;
            while ((obj = (Animal) ois.readObject()) != null) {
                System.out.println(obj.getAge());
                System.out.println(obj.getName());
            }
        } catch (Exception e) {
            throw new UsersException("Something to wrong",  e.fillInStackTrace());
        }
    }
}