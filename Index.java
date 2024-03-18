import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Index{
    public static void main(String a[]){
        
        
        String fileName = "employee.ser";
        //serializeObject(fileName);
        deserialization(fileName);
    }

    private static void deserialization(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(fileName)))) {
            Object object = ois.readObject();
            Employee employee = (Employee)object;
            System.out.println(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void serializeObject(String fileName) {
        Address address = new Address(01, "line 1", "line 2", "Nairobi", 00100);
        Employee employee = new Employee(02, "Abiud Sokomi", 29, "abiudsokomi@gmail.com", "001Abiud", address);
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(fileName)))) {
            oos.writeObject(employee);
            System.out.println("Object is serialized");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 }