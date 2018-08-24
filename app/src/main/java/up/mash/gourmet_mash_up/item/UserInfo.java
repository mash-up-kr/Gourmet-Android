package up.mash.gourmet_mash_up.item;

import java.io.Serializable;

/**
 * Created by derba on 2018-08-25.
 */

public class UserInfo implements Serializable {

    private String id;
    private String pw;
    private String intro;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
