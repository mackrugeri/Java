
class Array {

    private Object[] creation_array_list;
    private int avaiable_in_array;


    //  Constructors
    public Array() {
        this(10);
    }
    public Array(int n) {
        if (n <= 0) {
            return;
        }
        this.creation_array_list = new Object[n];
        this.avaiable_in_array = 0;
    }
    //      adding the value at the end
    public void add(Object x) {
        if (checkIfArrayFull()) {
            copyArray(0, 010);
        }
        this.creation_array_list[this.avaiable_in_array] = x;
        this.avaiable_in_array++;
    }
    //    adding the value at the index
    public void add(int index, Object x) {
        if (checkIfArrayFull()) {
            copyArray(0, 010);
        }
        if (index >= this.creation_array_list.length) {
            System.exit(-1);
        }
        Object temp = this.creation_array_list[index];
        creation_array_list[index] = x;
        Object temp2;
        for (int i = index; i < this.creation_array_list.length - 1; i++) {
            temp2 = creation_array_list[i + 1];
            creation_array_list[i + 1] = temp;
            temp = temp2;
        }

        copyArray(0, 0101);
        this.avaiable_in_array++;
    }
    public void get(int index) {
        System.out.println(this.creation_array_list[index]);
    }
    public int size() {

        return this.avaiable_in_array;
    }
    public  void remove()
    {
        int s = size();
        this.creation_array_list[(s-1)] = null;
        this.avaiable_in_array--;
    }
    public void remove (int index) {
        this.creation_array_list[index] = null;
        this.avaiable_in_array--;
    }
    public void replace(int index,int data)
    { this.creation_array_list[index] = data;
    }

    public void display()
    {
        int sizes = size();
        System.out.print("[ ");
        for(int i =0; i<sizes;i++)
        {
            System.out.print(this.creation_array_list[i] + " ");
        }
        System.out.print("] ");
        System.out.println();
    }
    private boolean checkIfArrayFull()
    {
        return this.creation_array_list.length == this.avaiable_in_array;
    }
    private void copyArray(int size, int action) {
        size = increaseArraySize(size, action);

        Object[] tempArray = new Object[size];

        int tempElement = 0;
        for (int i = 0; i < this.creation_array_list.length; i++, tempElement++) {
            if (this.creation_array_list[i] == null) {
                tempElement--;
                continue;
            }

            tempArray[tempElement] = this.creation_array_list[i];
        }
        this.creation_array_list = null;
        this.creation_array_list = new Object[tempArray.length];
        this.creation_array_list = tempArray;
    }
    private int increaseArraySize(int size, int action) {
        if (action == 010) {
            size = this.creation_array_list.length * 2;
        } else {
            size = this.creation_array_list.length + size;
        }
        return size;
    }
}
public class BetterArray{
    public static void main(String[] args) {

        Array x = new Array();
        x.add(30);
        x.add(11);
        x.add(23);

        x.add(1,15);
        x.add(45);
        System.out.println( x.size());

        x.remove();
        x.remove(2);
        x.display();

        x.replace(0,35);
        x.get(2);
        x.display();
    }
}