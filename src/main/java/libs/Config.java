package libs;

public class Config {

    public long timeForDefaultWait;
    public long timeForWaitElement;
    public String timeForExplicitWaitLow;
    public String timeForExplicitWaitHeight;

    public String title;

    //  URLs
    public String baseURL;
    public String relativeURLRegistrationForm;
    public String googleFormURL;
    public String relativeURLResponsePage;


    //  WebDriver info
    public String driverName;
    public String driverPath;

    //  User
    public String validEmail;
    public String userName;
    public String userGender;

    public Config() {
    }
}
