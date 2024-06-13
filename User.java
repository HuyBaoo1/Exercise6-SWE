
import java.util.ArrayList;
import java.util.List;

public class User implements Observer {
    private final String username;
    private final String password;
    private Preference preference;
    private final List<Website> subscriptions;

    public User(String name, String password){
        this.username = name;
        this.password = password;
        this.preference = new Preference();
        this.subscriptions = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword(){
        return password;
    }

    public void addPreference(int frequency, String type){
        this.preference = new Preference(frequency, type);
    }

    public Preference getPreference(){
        return this.preference;
    }

    public void addSubscription(Website website){
        this.subscriptions.add(website);
        website.registerObserver(this);
    }

    public void deleteSubscription(String url){
        subscriptions.removeIf(website -> website.getUrl().equals(url));
        for(Website website: subscriptions){
            if( website.getUrl().equals(url)){
                website.removeObserver(this);
            }
        }
    }

    public List<Website> getSubscription(){
        return this.subscriptions;
    }

    @Override
    public void update() {
        System.out.println("subscribed by " + this.getUsername());
    }
}
