
public class DAOsaver {

	private String source;
	private String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
	DAOsaverDB DB = new DAOsaverDB();
	DAOsaverXML Xml = new DAOsaverXML();


	DAOsaver()
	{
		DB.setting_all_car_detail(cars);
	}

	public void saveInfoDB(String message) {

		System.out.println("I just saved in DB:" + message);
	}

	public void saveInfoXML(String message) {


		Xml.setSource(message);
	}
	public String[] get_all_car()
	{
		return DB.get_all_cars();
	}

	
	public void setSource(String source) {
		this.source = source;
		
	}

}
