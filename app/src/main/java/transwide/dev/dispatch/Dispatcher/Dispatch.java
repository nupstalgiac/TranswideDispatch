package transwide.dev.dispatch.Dispatcher;

public class Dispatch {

    String Name;
    String Password;


    public Dispatch() {
    }

    public Dispatch(String name, String password) {
        Name = name;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}