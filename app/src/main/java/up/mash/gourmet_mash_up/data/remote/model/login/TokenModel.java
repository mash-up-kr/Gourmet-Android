package up.mash.gourmet_mash_up.data.remote.model.login;

import com.google.gson.annotations.SerializedName;

public class TokenModel {

    /**
     * Success
     */
    @SerializedName("accessToken")
    private String accessToken;
    @SerializedName("refreshToken")
    private String refreshToken;
    @SerializedName("expiresIn")
    private long expiresIn;

    /**
     * Fail
     */
    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
