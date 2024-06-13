import java.util.Scanner;

public class PreferenceService {
    private static final Scanner inp = new Scanner(System.in);

    public static void preferences(User user) {
        System.out.println("Please enter your wished frequency in minutes");
        int frequency = 60 * 1000 * Integer.parseInt(inp.nextLine());
        System.out.println("Please enter your preferred notification type");
        String type = inp.nextLine();
        user.addPreference(frequency, type);
        System.out.println("Successfully changed preferences");
    }
}
