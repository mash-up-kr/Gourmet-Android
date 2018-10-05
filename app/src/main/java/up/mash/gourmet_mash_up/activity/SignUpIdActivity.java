package up.mash.gourmet_mash_up.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.item.UserInfo;
import up.mash.gourmet_mash_up.util.ActivityConstants;

public class SignUpIdActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    TextView mainText;
    TextView subText;
    ImageView errorImage;
    EditText inputText;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        linearLayout = findViewById(R.id.input_type_2);
        linearLayout.setVisibility(View.GONE);

        errorImage = findViewById(R.id.error1);
        errorImage.setVisibility(View.GONE);

        mainText = findViewById(R.id.main_text);
        mainText.setText(R.string.put_in_id);

        subText = findViewById(R.id.tv1);
        subText.setText(R.string.id);

        inputText = findViewById(R.id.ed1);
        button = findViewById(R.id.enterNext);

        button.setOnClickListener(v -> {

            if (TextUtils.isEmpty(inputText.getText())) {
                Toast.makeText(SignUpIdActivity.this, "아이디를 입력해주세요.", Toast.LENGTH_LONG).show();
                return;
            }

            if (inputText.getText().length() <= 6) {
                Toast.makeText(SignUpIdActivity.this, "적어도 6글자 이상을 입력해주시기 바랍니다.", Toast.LENGTH_LONG).show();
                return;
            }

            UserInfo userInfo = new UserInfo();
            userInfo.setId(inputText.getText().toString());
            Intent intent = new Intent(getApplicationContext(), SignUpPwActivity.class);
            intent.putExtra(ActivityConstants.USERINFO, userInfo);
            startActivity(intent);
        });
    }
}
