
public class DAOsaverDB {

    public String[] cars = new String[10];
    public void setting_all_car_detail(String[] car)
    {
        int a =0;
        for(String i:car)
        {
            cars[a] = i;
            a++;
        }
    }

    public String[] get_all_cars()
    {
        return cars;
    }

}
