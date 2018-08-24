package up.mash.gourmet_mash_up.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import butterknife.ButterKnife;
import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.item.UserInfo;

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

        UserInfo userInfo = (UserInfo) intent.getSerializableExtra("USERINFO");

        Log.e("USERINFO", "id : " + userInfo.getId());

        mainText = findViewById(R.id.main_text);
        mainText.setText("패스워드를 입력해주세요.");

        subText = findViewById(R.id.tv1);
        subText.setText("패스워드");

        subText2 = findViewById(R.id.tv2);
        subText2.setText("패스워드 확인");

        inputText = findViewById(R.id.ed1);
        inputText.setInputType(TYPE_TEXT_VARIATION_PASSWORD);
        inputText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        inputText2 = findViewById(R.id.ed2);
        inputText2.setInputType(TYPE_TEXT_VARIATION_PASSWORD);
        inputText2.setTransformationMethod(PasswordTransformationMethod.getInstance());

        button = findViewById(R.id.enterNext);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputText.getText().toString() == "" || inputText2.getText().toString() == "" || !Objects.equals(inputText.getText().toString(), inputText2.getText().toString()))
                    return;

                userInfo.setPw(inputText.getText().toString());
                Intent intent = new Intent(getApplicationContext(), SignUpInActivity.class);
                intent.putExtra("USERINFO", userInfo);
                startActivity(intent);
            }
        });
    }
}
