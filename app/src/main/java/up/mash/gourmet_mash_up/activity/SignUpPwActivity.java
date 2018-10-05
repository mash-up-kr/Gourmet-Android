package up.mash.gourmet_mash_up.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;
import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.data.remote.api.GourmatRestManager;
import up.mash.gourmet_mash_up.data.remote.model.login.RegisterRes;
import up.mash.gourmet_mash_up.data.remote.model.login.SignInCommand;
import up.mash.gourmet_mash_up.item.UserInfo;
import up.mash.gourmet_mash_up.util.ActivityConstants;

import static android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD;

public class SignUpPwActivity extends AppCompatActivity {

    TextView mainText;
    TextView subText;
    TextView subText2;
    EditText passwordEt;
    EditText passwordConfirmEditText;
    ImageView errorCheck;
    ImageView errorCheckConfirm;
    Button confirmButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        Intent intent = getIntent();

        UserInfo userInfo = (UserInfo) intent.getSerializableExtra(ActivityConstants.USERINFO);

        mainText = findViewById(R.id.main_text);
        mainText.setText(R.string.put_in_pw);

        subText = findViewById(R.id.tv1);
        subText.setText(R.string.password);

        subText2 = findViewById(R.id.tv2);
        subText2.setText(R.string.password_confirm);

        passwordEt = findViewById(R.id.ed1);
        passwordEt.setInputType(TYPE_TEXT_VARIATION_PASSWORD);

        passwordEt.setTransformationMethod(PasswordTransformationMethod.getInstance());
        passwordConfirmEditText = findViewById(R.id.ed2);
        passwordConfirmEditText.setInputType(TYPE_TEXT_VARIATION_PASSWORD);
        passwordConfirmEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());

        errorCheck = findViewById(R.id.error1);
        errorCheckConfirm = findViewById(R.id.error2);

        errorCheck.setVisibility(View.INVISIBLE);
        errorCheckConfirm.setVisibility(View.INVISIBLE);

        confirmButton = findViewById(R.id.enterNext);

        passwordConfirmEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String passwordData = passwordEt.getText().toString();

                if (!TextUtils.equals(passwordData, s.toString())) {
                    errorCheck.setVisibility(View.VISIBLE);
                    errorCheckConfirm.setVisibility(View.VISIBLE);
                } else {
                    errorCheck.setVisibility(View.INVISIBLE);
                    errorCheckConfirm.setVisibility(View.INVISIBLE);
                }
            }
        });

        confirmButton.setOnClickListener((View v) -> {

            String passwordData = passwordEt.getText().toString();
            String passwordDataConfirm = passwordConfirmEditText.getText().toString();

            if (TextUtils.isEmpty(passwordData) || TextUtils.isEmpty(passwordDataConfirm)) {
                Toast.makeText(getApplicationContext(), "insert password you would.", Toast.LENGTH_SHORT).show();
                return;
            }

            userInfo.setPw(passwordEt.getText().toString());
            SignInCommand command = new SignInCommand(userInfo.getId(), userInfo.getPw());
            GourmatRestManager
                    .setRegister(command)
                    .subscribe(new Observer<RegisterRes>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onNext(RegisterRes registerRes) {
                            Timber.d("onNext -> ");
                            startActivity(new Intent(getApplicationContext(), PostMainActivity.class));
                        }

                        @Override
                        public void onError(Throwable e) {
                            Timber.d("onError -> ");
                            startActivity(new Intent(getApplicationContext(), PostMainActivity.class));
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        });
    }
}
