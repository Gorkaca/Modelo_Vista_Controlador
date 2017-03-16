import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Modelo extends Conector {

	Modelo(String zoo) {
		super(zoo);
		// TODO Auto-generated constructor stub
	}
	public ArrayList select() {
		
		ArrayList<Animal> arrayList = new ArrayList();
		Statement statement;
		try {
			statement = super.getConexion().createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Animales");
			while (resultSet.next()) {
				arrayList.add(new Animal(resultSet.getInt("id"), resultSet.getString("nombre")));

			}
			return arrayList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void insert(Animal animal) {
		Statement statement;
		try {
			statement = super.getConexion().createStatement();
			statement.execute("INSERT INTO animales (id,nombre) " + "VALUES ('"  + " "
					+ animal.getId() + " " + animal.getNombre() + "')");

		} catch (SQLException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}

	}
	


}
