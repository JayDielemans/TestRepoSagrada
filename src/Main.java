import database.DatabaseConnection;

public class Main {

	public static void main(String[] args) {

		DatabaseConnection database = new DatabaseConnection();
		if ((database.loadDataBaseDriver()) && (database.makeConnection())) {
			database.showAccountQuery();
		}
	}

}
