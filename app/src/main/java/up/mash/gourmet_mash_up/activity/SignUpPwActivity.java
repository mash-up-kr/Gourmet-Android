package up.mash.gourmet_mash_up.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.data.remote.api.GourmatRestManager;
import up.mash.gourmet_mash_up.data.remote.model.login.RegisterRes;
import up.mash.gourmet_mash_up.data.remote.model.login.SignInCommand;
import up.mash.gourmet_mash_up.item.UserInfo;
import up.mash.gourmet_mash_up.util.ActivityConstants;

import static android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD;

/**
 * Created by derba on 2018-08-24.
 */

public class SignUpPwActivity extends AppCompatActivity {


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

        Intent intent = getIntent();

        UserInfo userInfo = (UserInfo) intent.getSerializableExtra(ActivityConstants.USERINFO);

        mainText = findViewById(R.id.main_text);
        mainText.setText(R.string.put_in_pw);

        subText = findViewById(R.id.tv1);
        subText.setText(R.string.password);

        subText2 = findViewById(R.id.tv2);
        subText2.setText(R.string.password_confirm);

        inputText = findViewById(R.id.ed1);
        inputText.setInputType(TYPE_TEXT_VARIATION_PASSWORD);
        inputText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        inputText2 = findViewById(R.id.ed2);
        inputText2.setInputType(TYPE_TEXT_VARIATION_PASSWORD);
        inputText2.setTransformationMethod(PasswordTransformationMethod.getInstance());

        button = findViewById(R.id.enterNext);

        button.setOnClickListener((View v) -> {
            if (inputText.getText().toString().equals("")
                    || inputText2.getText().toString().equals("")
                    || !Objects.equals(inputText.getText().toString(), inputText2.getText().toString())) {
                return;
            }

            userInfo.setPw(inputText.getText().toString());

            SignInCommand body = new SignInCommand(userInfo.getId(), userInfo.getPw());
            GourmatRestManager.setRegister(body)
//                    .subscribe(
//                            (response) -> {
//                                Toast.makeText(getApplicationContext(), "회원가입이 완료되었습니다. 로그인을 해주시기 바랍니다.", Toast.LENGTH_SHORT).show();
//                                startActivity(new Intent(getApplicationContext(), PostMainActivity.class));
//                                finish();
//                            },
//                            Throwable::getMessage,
//                            () -> {
//                                Toast.makeText(getApplicationContext(), "완성. 로그인을 해주시기 바랍니다.", Toast.LENGTH_SHORT).show();
//                            }
//                    );
                    .subscribe(new Observer<RegisterRes>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onNext(RegisterRes registerRes) {
                            startActivity(new Intent(getApplicationContext(), PostMainActivity.class));
                        }

                        @Override
                        public void onError(Throwable e) {
                            startActivity(new Intent(getApplicationContext(), PostMainActivity.class));
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        });
    }
}
