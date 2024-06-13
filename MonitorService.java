import java.io.IOException;

public class MonitorService {
    public static void monitor(User user) throws IOException {
        System.out.println("Your subscribed websites are now being monitored. Just simulated 6 runs");
        int i = 0;
        while(i < 6) {
            for (Website website : user.getSubscription()) {
                if (website.websiteUpdate(i)) {
                    System.out.println(website.getUrl() + " has been changed");                                         //here a function to send a real notification would be necessary
                } else {
                    System.out.println("For " + website.getUrl() + " nothing has changed");
                }
            }
            try {
                // Sleep for user-defined frequency in milliseconds
                System.out.println("Waiting for " + user.getPreference().getFrequency() / 1000 + " seconds...");
                Thread.sleep(user.getPreference().getFrequency());
            } catch (InterruptedException e) {
                // Handle the exception if the thread is interrupted
                System.err.println("Thread was interrupted.");
            }
            i++;
        }
    }
}
