import java.util.Objects;
import java.util.Scanner;

public class AuthenticationService {
    private static final Scanner inp = new Scanner(System.in);

    public static User authentication(Database database){
        while (true) {
            System.out.println("Do you want to register, log in or exit?");
            String input = inp.nextLine();
            switch (input) {
                case "log in": {
                    System.out.println("Please enter your username");
                    String userName = inp.nextLine();
                    if (database.getUser(userName) != null) {
                        System.out.println("Please enter your password");
                        String password = inp.nextLine();
                        if (Objects.equals(password, database.getUser(userName).getPassword())) {
                            System.out.println("Successful Login");
                            return database.getUser(userName);
                        }
                    } else {
                        System.out.println("Username does not exist.");
                    }
                    break;
                }
                case "register": {
                    System.out.println("Please enter your username");
                    String userName = inp.nextLine();
                    if (database.getUser(userName) == null) {
                        System.out.println("Please enter your password");
                        String password = inp.nextLine();
                        User user = new User(userName, password);
                        database.addUser(user);
                        System.out.println("Successfully registered");
                        return user;
                    } else {
                        System.out.println("Username already exists.");
                    }
                    break;
                }
                case "exit":
                    System.out.println("Exit Successful");
                    return null;
            }
        }
    }
}
