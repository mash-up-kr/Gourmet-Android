package up.mash.gourmet_mash_up.data.remote.model.login;

import com.google.gson.annotations.SerializedName;

public class RegisterRes {

    /**
     * Fail
     */
    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
