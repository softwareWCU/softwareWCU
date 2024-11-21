import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class PersonalInfoServer {

    public static void main(String[] args) {
        try {
            // Start RMI registry on port 1099
            LocateRegistry.createRegistry(1099);

            // Create an instance of the service implementation
            PersonalInfoService service = new PersonalInfoServiceImpl();

            // Bind the service to the registry with the name "PersonalInfoService"
            Naming.rebind("rmi://localhost:1099/PersonalInfoService", service);

            System.out.println("PersonalInfoService is running...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
