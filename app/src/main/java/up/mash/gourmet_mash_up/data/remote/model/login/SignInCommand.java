package up.mash.gourmet_mash_up.data.remote.model.login;

public class SignInCommand {

    private String username;
    private String password;

    public SignInCommand(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
