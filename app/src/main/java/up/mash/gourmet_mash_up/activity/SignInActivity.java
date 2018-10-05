package up.mash.gourmet_mash_up.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.data.remote.api.GourmatRestManager;

import static android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD;

public class SignInActivity extends AppCompatActivity {

    private static final String TAG = SignInActivity.class.getSimpleName();
    TextView mainText;
    TextView subText;
    TextView subText2;
    EditText inputText;
    EditText inputText2;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        mainText = findViewById(R.id.main_text);
        mainText.setVisibility(View.GONE);

        subText = findViewById(R.id.tv1);
        subText.setText(R.string.id);

        subText2 = findViewById(R.id.tv2);
        subText2.setText(R.string.password);

        inputText = findViewById(R.id.ed1);
        inputText2 = findViewById(R.id.ed2);
        inputText2.setInputType(TYPE_TEXT_VARIATION_PASSWORD);
        inputText2.setTransformationMethod(PasswordTransformationMethod.getInstance());

        button = findViewById(R.id.enterNext);
        button.setText(R.string.Log_in);
        button.setOnClickListener((View v) -> {

            String id = inputText.getText().toString();
            String password = inputText.getText().toString();

            if (id.isEmpty() || password.isEmpty()) {
                Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
                return;
            }

            GourmatRestManager
                    .logInByUser(id, password)
                    .subscribe((authObject) -> {
                                if (setAuthToken(getApplicationContext(), authObject.getAccessToken())) {


                                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

                                        //자기소개로
                                        isFirstLogIn(getApplicationContext(), authObject.getAccessToken());
                                        startActivity(new Intent(getApplicationContext(), SignUpInActivity.class));
                                    } else {
                                        startActivity(new Intent(getApplicationContext(), PostMainActivity.class));
                                        finish();
                                    }
                            },
                            (t) -> Log.e(TAG, t.getMessage()),
                            () -> Log.d(TAG, "AuthComplete")
                    );
        });
    }

    private boolean setAuthToken(Context context, String auth) {
        if (!TextUtils.isEmpty(auth)) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("auth_token", auth);
            editor.apply();
            return true;
        }
        return false;
    }

    private boolean isFirstLogIn(Context context, String auth) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("first", auth);
            editor.apply();
            return true;
    }


}
