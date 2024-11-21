import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonalInfoServiceImpl extends UnicastRemoteObject implements PersonalInfoService {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/PersonalInfoDB";
    private static final String USER = "root";
    private static final String PASS = "";

    public PersonalInfoServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public boolean registerPersonalInfo(String name, String email, int age) throws RemoteException {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "INSERT INTO PersonalInfo (name, email, age) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setInt(3, age);

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
