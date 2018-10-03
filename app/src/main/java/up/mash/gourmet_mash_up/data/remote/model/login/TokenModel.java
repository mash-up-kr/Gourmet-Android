package up.mash.gourmet_mash_up.data.remote.model.login;

import com.google.gson.annotations.SerializedName;

public class TokenModel {

    /**
     * Success
     */
    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("token_type")
    private String tokenType;
    @SerializedName("refresh_token")
    private String refreshToken;
    @SerializedName("expires_in")
    private int expiresIn;
    @SerializedName("scope")
    private String scope;

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

    public String getTokenType() {
        return tokenType;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public String getScope() {
        return scope;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
