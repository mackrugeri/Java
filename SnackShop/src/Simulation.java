import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;


/**
 *   The account balance is the amount of money that is in a customers account,
 * which should be a posive number that is reduced by the appropriate amount when a product
 * is purchased. Your constructors should throw an InvalidCustomerExcepon
 */
class InvalidCustomerException extends Exception{
    InvalidCustomerException(String s){
        super(s);
    }
}

/**
 *  the
 * first character of the product ID must be ‘F’ for food items and the constructor should
 * throw an InvalidProductException if this is not the case.
 */
class InvalidProductException extends Exception{
    InvalidProductException(String s){
        super(s);
    }
}

/**
 *   , if the customer does not
 * have enough money in their account, an InsufficientBalanceException excepon should
 * be thrown
 */
class InsufficientBalanceException extends  Exception
{
    InsufficientBalanceException(String s){super(s);}
}


/**
 *  Products are split into two different categories: food and drinks. You will model this using an
 * abstract base class for products and subclasses for food and d
 */
abstract class Product
{
    public String ProductId;
    public String name;
    public int basePrice;

    /**
     * @param id
     * @param nam
     * @param Price
     * @throws InvalidProductException
     */
    Product(String id, String nam, int Price) throws InvalidProductException {
        ProductId = id;
        if (ProductId.contains("-")) {
            String[] arrOfStr = ProductId.split("-");
            if (arrOfStr[1].length() == 7)
            {
                if(Price > 0)
                {
                    name = nam;
                    basePrice = Price;
                }
                else
                    {
                        throw new InvalidProductException("Invalid Base price");
                }
            }
            else
            {
                throw new InvalidProductException("Invalid Product Id 7 numeric value not found");
            }
        }
        else
        {
            throw new InvalidProductException("Invalid Product Id - not found");
        }
    }
    public abstract int calculatePrice() throws InvalidProductException;
}

/**
 *  Drink should include an addional field to determine whether the item in queson has
 * sugar content that is considered high, low, or none.
 */
class Drink extends Product {
    String ProductId;
    Vector v1;

    /**
     * @param id
     * @param nam
     * @param Price
     * @throws InvalidProductException
     */
    Drink(String id, String nam, int Price) throws InvalidProductException {
        super(id, nam, Price);
        ProductId = id;
    }

    /**
     * @param check
     */
    public void get_List(Vector check) {
        v1 = check;
    }

    /**
     * @return
     * @throws InvalidProductException
     */
    @Override
    public int calculatePrice() throws InvalidProductException {
        String id;
        String check;
        int price = 0;
        if (ProductId.contains("-")) {
            String[] arrOfStr = ProductId.split("-");
            if (arrOfStr[1].length() == 7) {
                id = ProductId;

            } else {
                throw new InvalidProductException("Invalid id of product");
            }
        }
        else {
            throw new InvalidProductException("Invalid id of product");
        }
        for (int i = 0; i < v1.size(); i++) {
            String[] array = (String[]) v1.get(i);
            if (id == array[0]) {
                if (array[2].contains("high")) {
                    price = Integer.parseInt(array[3]);
                    price = price + 24;
                } else if (array[2].contains("low")) {
                    price = Integer.parseInt(array[3]);
                    price = price + 18;
                } else {
                    price = Integer.parseInt(array[3]);
                    price = price + 0;
                }
            }


        }
        return price;
    }
}

/**
 *   Food should have an extra field to determine whether it is a hot food item (true if so,
 * false otherwise). Food should also have a public final class variable to store the current
 * surcharge percentage that is to be applied to sales of hot food items
 */
class Food extends Product
{
    String  ProductId;
    Vector v;

    /**
     * @param id
     * @param nam
     * @param Price
     * @throws InvalidProductException
     */
    Food(String id, String nam, int Price) throws InvalidProductException {
        super(id, nam, Price);
        ProductId = id;

    }

    /**
     * @param check
     */
    public void get_List(Vector check)
    {
        v = check;
    }


    /**
     * @return
     * @throws InvalidProductException
     */
    @Override
    public int calculatePrice() throws InvalidProductException {
        String id;
        String check;
        int price =0;
        if (ProductId.contains("-"))
        {
            String[] arrOfStr = ProductId.split("-");
            if (arrOfStr[1].length() == 7)
            {
                id = ProductId;

            }
            else
            {
                throw new InvalidProductException("Invalid Product id");
            }
        }
        else
        {
            throw new InvalidProductException("Invalid Product id");
        }
        System.out.println(id);
        for(int i=0; i<v.size(); i++)
        {
            String [] array = (String []) v.get(i);

            if (id.contains( array[0]))
            {

                if (array[2].contains("hot"))
                {
                    price=Integer.parseInt(array[3]);
                    int percent = (int) (price * 0.1);
                    price = price + percent;

                }
                else
                {
                    price=Integer.parseInt(array[3]);
                }
            }


        }
        return price;
    }

}


/**
 *   The Customer class should store informaon about a customer‘s account. This includes basic
 * informaon such as their account ID (an 6 digit alphanumeric idenfier), their name and their
 * account balance (as an integer in pence, e.g. 1000 for £10)
 */
abstract class Customer
{
    String account;
    String name;
    int balance;

    /**
     *
     */
    Customer()
    {

        balance =0;
    }

    /**
     * @param acc
     * @param nam
     */
    Customer(String acc, String nam)
    {
        account = acc;
        name = nam;
    }

    /**
     * @param balance
     * @throws InvalidCustomerException
     */
    void check_balance(int balance) throws InvalidCustomerException {
        if(balance <0)
        {
            throw  new InvalidCustomerException("Balance Is invalid Balance showing is "+ balance);
        }
    }

    /**
     * @param bal
     */
    void add_Funds(int bal)
    {
        balance = balance + bal;
    }

    /**
     * @return
     */
    int get_balances()
    {
        return balance;
    }

    /**
     * @param productPrice
     * @throws InsufficientBalanceException
     */
    void chargeAccount(int productPrice) throws InsufficientBalanceException {
        if (balance - productPrice < 0)
        {
            throw  new InsufficientBalanceException("Insufficient balance Sorry no Transaction is excuted");
        }
        else
        {
            balance = balance - productPrice;
            System.out.print("The deducted price is" + productPrice);
            System.out.println("Now your Balance is" + balance);
        }

    }

}

/**
 *   The StudentCustomer class should extend the Customer class. It should have two constructors (as Customer did)
 */
class StudentCustomer extends Customer
{
    String account;
    String name;
    int balance;
    Vector v1;

    /**
     *
     */
    StudentCustomer()
    {

        balance =0;
    }

    /**
     * @param acc
     * @param nam
     */
    StudentCustomer(String acc, String nam)
    {
        account = acc;
        name = nam;
    }

    /**
     * @param v
     */
    void set_vector(Vector v)
    {
        v1= v;
    }

    /**
     * @return
     */
    int get_balance()
    {
        return balance;
    }

    /**
     * @param productPrice
     * @throws InsufficientBalanceException
     */
    void chargeAccount(int productPrice) throws InsufficientBalanceException {

        for(int i =0; i<v1.size(); i++) {
            String[] array = (String[]) v1.get(i);
            if (account == array[0]) {
                if (array[3].contains("STUDENT")) {
                    int balance = get_balance();

                    if (balance - productPrice < -500) {
                        throw new InsufficientBalanceException("Insufficient balance Sorry no Transaction is excuted");
                    } else {
                        balance = balance - (int) (productPrice * 0.05);
                        System.out.print("The deducted price is" + productPrice);
                        System.out.println("Now your Balance is" + balance);
                    }
                }
            } else {
                System.out.println("Account is not found");
            }
        }
    }

}

/**
 *   The StaffCustomer class should also extend the Customer class. It should include an addi-
 * onal field to store the school that the staff member works in (which could either be CMP, BIO,
 * MTH, or other).
 */
class StaffCustomer extends Customer
{
    String account;
    String name;
    int balance;
    Vector v1;

    /**
     *
     */
    StaffCustomer()
    {

        balance =0;
    }

    /**
     * @param acc
     * @param nam
     */
    StaffCustomer(String acc, String nam)
    {
        account = acc;
        name = nam;
    }

    /**
     * @return
     */
    int get_balance()
    {
        return balance;
    }

    /**
     * @param v
     */
    void set_vector(Vector v)
    {
        v1= v;
    }

    /**
     * @param productPrice
     * @throws InsufficientBalanceException
     */
    void chargeAccount(int productPrice) throws InsufficientBalanceException {
        for(int i =0; i<v1.size(); i++)
        {
            String [] array = (String []) v1.get(i);
            if(account == array[0])
            {
                if(array[3].contains( "STAFF" ))
                {
                    if (array.length == 5)
                    {
                        if(array[4].contains( "CMP"))
                        {
                            balance = balance - (int) (productPrice * 0.1);
                        }
                        else if (array[4].contains( "MTH"))
                        {
                            balance = balance - (int) (productPrice * 0.025);
                        }
                        else if (array[4].contains( "BIO"))
                        {
                            balance = balance - (int) (productPrice * 0.025);
                        }
                    }
                    if(array.length == 4)
                    {
                        continue;
                    }
                    else
                    {
                        balance = balance - productPrice;
                    }

                }
            }
            else
            {
                System.out.println("Account is not found");
            }
        }


    }



}


/**
 *   This class should have fields for the
 * shop’s name, a field for the turnover of the shop, a collecon of the products that this shop
 * sells, and and a collecon of the customers that have accounts at this shop.
 */
class SnackShop {
    private static String ShopName;
    Vector V;
    Vector V1;
    Vector pricing = new Vector();
    Vector bala = new Vector();

    /**
     * @param name
     *
     */
    SnackShop(String name) {
        ShopName = name;
    }

    /**
     * @param name
     */
    public void setShopName(String name) {

        ShopName = name;
    }

    /**
     * @return
     */
    public String getShowName() {

        return ShopName;
    }

    /**
     * @param v
     */
    public void get_Customer_vector(Vector v)
    {
        V = v;
    }

    /**
     * @param v
     */
    public void get_Product_vector(Vector v)
    {
        V1 = v;
    }


    /**
     * @param customerid
     * @throws InvalidCustomerException
     */
    public void getCustomer(String customerid) throws InvalidCustomerException {
        if (customerid.length() == 6) {
            System.out.println("Customer Id is correct");
        } else {
            throw new InvalidCustomerException("The Product id " + customerid + " is not valid");
        }
    }

    /**
     * @param productid
     * @throws InvalidProductException
     */
    public void getProduct(String productid) throws InvalidProductException {

        if (productid.contains("-")) {
            String[] arrOfStr = productid.split("-");
            if (arrOfStr[1].length() == 7) {
                System.out.println("Product Id is correct");
            } else {
                throw new InvalidProductException("The Product id " + productid + " is not valid");
            }
        } else {
            throw new InvalidProductException("The Product id " + productid + " is not valid");
        }
    }

    /**
     *
     */
    public void findLargestBasePrice()
    {
        int max = (int) pricing.get(0);
        // loop to find maximum from ArrayList
        for (int i = 1; i < pricing.size(); i++) {
            if ((int)pricing.get(i) > max) {
                max = (int) pricing.get(i);
            }
        }
        System.out.println("Largest base Price is " + max);
    }

    /**
     *
     */
    public void countNegativeAccounts ()
    {
        for(int i =0; i<pricing.size();i++)
        {
            if ((int)pricing.get(i) < 0)
            {
                System.out.println((int)pricing.get(i));
            }
        }
    }

    /**
     *
     */
    public void calculateMedianCustomerBalance()
    {
        int a = bala.size() /2;
        System.out.println(bala.get(a));
    }

    /**
     * @param customerID
     * @param productID
     * @throws InvalidCustomerException
     * @throws InvalidProductException
     * @throws InsufficientBalanceException
     */
    public void processPurchase(String customerID, String productID) throws InvalidCustomerException, InvalidProductException, InsufficientBalanceException {
        getCustomer(customerID);
        getProduct(productID);

        int bal;
        for(int i=0; i<V.size();i++)
        {
            String [] array = (String []) V.get(i);
            if(array[0].contains(customerID))
            {
                if (array.length == 4)
                {
//                    Student
                    StudentCustomer S = new StudentCustomer(customerID,array[1]);
                    bal=Integer.parseInt(array[2]);
                    S.add_Funds(bal);

                    for(int j=0; j<V1.size();j++)
                    {
                        String [] arr = (String []) V1.get(j);
                        if(array[0].contains(productID))
                        {
                            if(array[0].contains("F"))
                            {

                                int price=Integer.parseInt(arr[3]);
                                Food F = new Food(productID,arr[1],price);
                                F.get_List(V1);
                                int p = F.calculatePrice();
                                pricing.add(p);
                                bala.add(S.get_balance());
                                System.out.println("Product Pricing is " + p);
                                break;
                            }
                            if(array[0].contains("D"))
                            {
                                int price=Integer.parseInt(array[3]);
                                Drink d = new Drink(productID,array[1],price);
                                d.get_List(V1);

                                int p = d.calculatePrice();
                                pricing.add(p);
                                bala.add(S.get_balance());
                                S.chargeAccount(p);
                                System.out.println("Your Product Price is " + p);
                                break;
                            }
                        }

                    }
                    break;
                }
                if(array.length == 5)
                {
//                    Staff
                    StaffCustomer S = new StaffCustomer(customerID,array[1]);
                    bal = Integer.parseInt(array[2]);
                    S.add_Funds(bal);

                    for(int j=0;j<V1.size();j++)
                    {
                        String [] arr = (String []) V1.get(j);
                        System.out.println();

                        if(arr[0].contains( productID)) {
                            if(arr[0].contains("F"))
                            {

                                int price=Integer.parseInt(arr[3]);
                                Food F = new Food(productID,arr[1],price);
                                F.get_List(V1);
                                int p = F.calculatePrice();
                                pricing.add(p);
                                bala.add(S.get_balance());
                                System.out.println("Product Pricing is " + p);
                                break;
                            }
                            if(arr[0].contains("D"))
                            {
                                int price=Integer.parseInt(arr[3]);
                                Drink d = new Drink(productID,arr[1],price);
                                d.get_List(V1);

                                int p = d.calculatePrice();
                                pricing.add(d.calculatePrice());
                                S.chargeAccount(p);
                                bala.add(S.get_balance());
                                System.out.println("Product Price is " + p);
                                break;
                            }
                        }
                        else
                        {
                            System.out.println("Not match" + arr[0] );
                        }
                    }
                    break;
                }
                else
                {
                    System.out.println("Not Found");
                }

            }
            else
            {
                System.out.println("Incorrect id" + array[0]);
            }
        }


    }

}


/**
 *    simulate the creaon and use of a snack shop
 */
public class Simulation {

    /**
     * @param shopName
     * @param productFile
     * @param customerFile
     * @throws FileNotFoundException
     * @throws InvalidCustomerException
     * @throws InvalidProductException
     * @throws InsufficientBalanceException
     */
    public static void initaliseShop(String shopName, File productFile, File customerFile) throws FileNotFoundException, InvalidCustomerException, InvalidProductException, InsufficientBalanceException {
        Vector v = new Vector();
        Vector v1 = new Vector();
        try {
            Scanner myReader = new Scanner(productFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arrOfStr = data.split("@");
                v.add(arrOfStr);
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            Scanner myReader = new Scanner(customerFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arrOfStr = data.split("#");
                v1.add(arrOfStr);
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error is present.");
            e.printStackTrace();
        }

        SnackShop S = new SnackShop("Hello");
        S.get_Customer_vector(v1);
        S.get_Product_vector(v);

        S.processPurchase("58R526","F-8547328");

    }

    /**
     * @param args
     * @throws FileNotFoundException
     * @throws InvalidCustomerException
     * @throws InvalidProductException
     * @throws InsufficientBalanceException
     */
    public static void main(String[] args) throws FileNotFoundException, InvalidCustomerException, InvalidProductException, InsufficientBalanceException {

        File customerFile = new File("./customers.txt");
        File productFile = new File("./products.txt");
        String shopName = "KitchenCorp";

        initaliseShop(shopName, productFile,customerFile);


    }
}
