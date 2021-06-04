import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//1. normal 
//2. marker interface OR No method interface
//3. single method interface

class state implements Serializable{
    public int x,y; 
}

public class week3 {
    public static void main(String[] args) {
        String address="./Output.txt";
        state obj=new state();
        obj.x=10;
        obj.y=20;

        // save or Serialization
        try{
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(address));
            objectOutputStream.writeObject(obj);
            objectOutputStream.write(obj.x);
            objectOutputStream.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        //Load or Deserialization
        try {
            ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(address));
            state load;
            load=(state)objectInputStream.readObject();
            System.out.println("x="+load.x+" , y="+load.y);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
