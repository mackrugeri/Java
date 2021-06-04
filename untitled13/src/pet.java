import java.util.ArrayList;

abstract class pets{
    private String myName;
    public pets (String name)

    {
        myName = name;
    }
    public abstract String speck();

}

class cat{
    cat()
    {
        System.out.println("meow");
    }
}

class Dog extends pets{
    public Dog(String name) {
        super(name);
    }

    public String speck()
    {
        return "dog-sound";
    }
    public String LoudDog()
    {
        return "dog-sound repeated two times";
    }

}
class LoudDog extends pets
{
    public LoudDog(String name) {
        super(name);
    }
    public pets speck()
    {
        return "dog-sound repeated two times";
    }


}

class kennel
{
    private ArrayList<pets> petlist;

    public void allSpeak()
    {
        petlist.add(new Dog("dog"));
        petlist.add(new Dog("Cat"));

        System.out.println(petlist.get(0));
        System.out.println(petlist.get(1));
    }
}





public class pet {
    public static void main(String[] args) {

    }

}
