package up.mash.gourmet_mash_up.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.util.ActivityConstants;

/**
 * Created by derba on 2018-08-24.
 */

public class SignUpInActivity extends AppCompatActivity {

    TextView mainText;
    TextView subText;
    EditText inputText;
    LinearLayout linearLayout;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        mainText = findViewById(R.id.main_text);
        mainText.setText(R.string.put_in_your_PR);

        subText = findViewById(R.id.tv1);
        subText.setText(R.string.one_line_PR);

        inputText = findViewById(R.id.ed1);

        linearLayout = findViewById(R.id.input_type_2);
        linearLayout.setVisibility(View.GONE);

        button = findViewById(R.id.enterNext);
        button.setOnClickListener(v -> {

            if (TextUtils.isEmpty(inputText.getText().toString())) {
                Toast.makeText(SignUpInActivity.this, "자기를 소개할 수 있는 내용을 간략히 입력해주세요.", Toast.LENGTH_LONG).show();
                return;
            }

            Intent goToSignUpActivity = new Intent(SignUpInActivity.this, SignUpPrActivity.class);
            goToSignUpActivity.putExtra(ActivityConstants.USERINFO, inputText.getText().toString());
            startActivity(goToSignUpActivity);
        });


    }
}
