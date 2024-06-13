import java.util.ArrayList;
import java.util.List;

public class Database {
    private final List<User> userList;
    private final List<Website> websiteList;

    public Database() {
        this.userList = new ArrayList<>();
        this.websiteList = new ArrayList<>();
    }


    public void addUser(User user){
        userList.add(user);
    }
    public void addWebsite(Website website){websiteList.add(website);}

    public User getUser(String userName){
        for(User user: this.userList){
            if(user.getUsername().equals(userName)){
                return user;
            }
        }
        return null;
    }

    public boolean websiteExists(String url){
        for (Website website: websiteList){
            if(website.getUrl().equals(url)){
                return true;
            }
        }
        return false;
    }

    public Website getWebsite(String url){
        for (Website website: websiteList){
            if(website.getUrl().equals(url)){
                return website;
            }
        }
        return null;
    }
}
