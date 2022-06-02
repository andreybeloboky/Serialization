import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("dog.dat");
        Dog dog = new Dog("dog", 4);
        Cat cat = new Cat("cat", 61);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        try {
            oos.writeObject(dog);
            oos.writeObject(cat);
            oos.writeObject(cat);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            oos.close();
        }
        readObjectInFile(file);
    }

    /**
     * @param file - file path;
     * @throws IOException - the exception who may be throw because of making mistake;
     */
    public static void readObjectInFile(File file) throws IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        try {
            Animal obj = null;
            while ((obj = (Animal) ois.readObject()) != null) {
                System.out.println(obj.getAge());
                System.out.println(obj.getName());
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ois.close();
        }
    }
}