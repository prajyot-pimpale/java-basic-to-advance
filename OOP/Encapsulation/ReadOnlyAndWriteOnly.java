public class Config {

    // Read-Only → only getter, no setter
    private final String appName = "MyApp";
    private final String version = "1.0.0";

    public String getAppName() { return appName; }
    public String getVersion()  { return version; }
    // no setters → cannot be changed


    // Write-Only → only setter, no getter (e.g. password)
    private String password;

    public void setPassword(String password) {
        if (password.length() >= 8)
            this.password = password;
        else
            System.out.println("Password too short (min 8 chars)");
    }
    // no getter → password can't be read directly
}

public class ReadOnlyAndWriteOnly {
    public static void main(String[] args) {
        Config c = new Config();
        System.out.println(c.getAppName());  // MyApp
        System.out.println(c.getVersion());  // 1.0.0

        c.setPassword("mypass123");  // set ok
        c.setPassword("abc");        // Password too short
    }
}