
public class Main {

	public static void main(String[] args) {

		DAOsaver daoSaver = new DAOsaver();
		daoSaver.setSource("DB");
		daoSaver.saveInfoDB("Hello");
		daoSaver.saveInfoXML("people.xml");
		String[] cars;
		cars = daoSaver.get_all_car();

		System.out.print("Here is Car list ");
		for(String i : cars)
		{
			if (i == null)
			{
				break;
			}
			System.out.print(" " +i);
		}

	}

}
