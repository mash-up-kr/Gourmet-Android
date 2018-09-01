package up.mash.gourmet_mash_up.data.remote.model.login;

/**
 * 유저 등록 또는 로그인할 떄 활용
 */
public class RegisterReq {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
