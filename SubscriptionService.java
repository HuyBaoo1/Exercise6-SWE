import java.io.IOException;
import java.util.Scanner;

public class SubscriptionService {
    private static final Scanner inp = new Scanner(System.in);

    public static void subscriptions(User user, Database database) throws IOException {
        System.out.println("Do you want to subscribe to a new Website or delete one?");
        String input = inp.nextLine();
        if(input.equals("subscribe")){
            System.out.println("Enter the URL of the Website you want to monitor");
            String url = inp.nextLine();
            if(database.websiteExists(url)){
                user.addSubscription(database.getWebsite(url));
            }else {
                Website newWebsite = new Website(url);
                user.addSubscription(newWebsite);
                database.addWebsite(newWebsite);
            }
            System.out.println("The Website " + url + " is now being monitored");
        } else if(input.equals("delete")){
            System.out.println("Enter the URL of the Website you want to delete");
            String url = inp.nextLine();
            user.deleteSubscription(url);
            System.out.println("The Website " + url + " has been removed from your subscriptions");
        }
    }
}
