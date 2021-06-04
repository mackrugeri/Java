
class Node
{
    int data;
    Node next;
    Node Pervious;

    // Part 1
    //  Initial Constructor
    Node(int data) {

        this.data = data;
        this.next = null;
        this.Pervious = null;

    }
}

class shoppinglist
{
    // Helper function to print a given linked list
    public static void printList(Node head)
    {

        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println("null");

    }

    public static int numItem(Node head)
    {

        int counter =0;
        Node ptr = head;
        while (ptr != null)
        {
            counter = counter +1;
            ptr = ptr.next;
        }
        return counter;

    }
    public static void removeItem(Node head, int value)
    {

        Node Temp = head;
        while (Temp != null)
        {
            if(Temp.next.data == value)
            {
                Temp.next = Temp.next.next;
                return ;
            }
            Temp = Temp.next;
        }
    }


    // Naive function for linked list implementation containing three nodes
    public static Node AddingNode()
    {


        // construct linked list nodes
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);


        // rearrange the references to construct a list
        Node head = first;
        first.next = second;
        second.Pervious = first;
        second.next = third;
        third.Pervious = second;
        third.next = fourth;
        fourth.Pervious = third;
        fourth.next = null;

        // return reference to the first node in the list
        return head;


    }

    public static void main(String[] args)
    {
        // Part 2
        // 'head' points to the head node of the linked list
        Node head = AddingNode();
        Node temp = head;

        // Part 4
        // print linked list
        printList(head);

        // Part 5
        // numItem function
        System.out.println(numItem(head));


        // Part 3
        // removing of node
        int a =5;
        if (head.data == a)
        {
            temp = head.next;
            printList(temp);

        }
        else{
            removeItem(temp, 4);
        }

        // print linked list
        printList(head);

    }

}