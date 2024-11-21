import java.rmi.Naming;

public class PersonalInfoClient {

    public static void main(String[] args) {
        try {
            // Look up the service in the RMI registry
            PersonalInfoService service = (PersonalInfoService) Naming.lookup("rmi://localhost:1099/PersonalInfoService");

            // Call the remote method
            boolean result = service.registerPersonalInfo("Mesay Aschalew", "mesayaschalew3@gmail.com", 31);

            // Print the result
            if (result) {
                System.out.println("Personal information registered successfully!");
            } else {
                System.out.println("Failed to register personal information.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
