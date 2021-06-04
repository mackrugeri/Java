public class ShoppingList {

    public static class Node {
        public String element;
        public Node prev;
        public Node next;
        public Node(String e) {
            this.element = e;
            this.prev = null;
            this.next = null;
        }

//        public void print() {
//            System.out.println("Element stored is " + e );
//        }
    }

    public Node header;
    public Node tail;
    public int size = 0;

    // constructors follow per JAVA convention

    public ShoppingList() {
        // Initial Constructor
        // construct linked list nodes
        header = null;
        tail = null;
    }
    public void AddingNode()
    {


        // construct linked list nodes
        Node first = new Node("1");
        Node second = new Node("2");
        Node third = new Node("3");
        Node fourth = new Node("4");


        // rearrange the references to construct a list
        this.header= first;
        first.next = second;
        second.prev = first;
        second.next = third;
        third.prev = second;
        third.next = fourth;
        fourth.prev = third;
        fourth.next = null;



    }

    public void add(String newItem) {
        this.header.prev = new Node("1");
        Node Temp = this.header.prev;
        Temp.prev = null;
        Temp.next = this.header;

    }

    public void remove(String oldItem) {
        Node Temp = this.header;
        while (Temp != null)
        {
            if(Temp.next.element == oldItem)
            {
                Temp.next = Temp.next.next;
                Temp.next.next.prev = Temp;
                return ;
            }
            Temp = Temp.next;
        }
    }

    public void print() {
        System.out.println(header.element);

    }

    public int numItem() {
        int counter =0;
        Node ptr = this.header;
        while (ptr != null)
        {
            counter = counter +1;
            ptr = ptr.next;
        }
        return counter;
    }

}
