public class Preference {
    private final int frequency;
    private final String notificationType;

    public Preference(){
        this.frequency = 10000;                                                                                          //default value = 10s
        this.notificationType = "email";
    }

    public Preference(int frequency, String type){
        this.frequency = frequency;
        this.notificationType = type;
    }

    public int getFrequency(){
        return this.frequency;
    }

    public String getNotificationType(){
        return this.notificationType;
    }
}
