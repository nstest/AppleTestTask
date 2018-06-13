
public class Main {

	public static void main(String[] args) {
		MySQLAccess dao = new MySQLAccess();
	    try {
			dao.readDataBase();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
