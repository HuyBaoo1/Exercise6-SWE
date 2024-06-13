import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final Database database = new Database();
    private static final Scanner inp = new Scanner(System.in);
    private static boolean run = true;

    public static void main(String[] args) throws IOException {
        while(run) {
            User user;
            user = AuthenticationService.authentication(database);
            boolean options = true;
            if(user == null){
                run=false;
                options =false;
            }
            while(options) {
                System.out.println("Do you want to update your Preferences, edit your Subscriptions, watch your Monitor or Exit?");
                String input = inp.nextLine();
                switch (input) {
                    case "Preferences": {
                        PreferenceService.preferences(user);
                        break;
                    }
                    case "Subscriptions": {
                        SubscriptionService.subscriptions(user, database);
                        break;
                    }
                    case "Monitor":{
                        MonitorService.monitor(user);
                        break;
                    }
                    case "Exit":{
                        options = false;
                        break;
                    }
                }
            }
        }
    }
}
