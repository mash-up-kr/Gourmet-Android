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

import up.mash.gourmet_mash_up.R;

import static android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD;

/**
 * Created by derba on 2018-08-24.
 */

public class SignInActivity extends AppCompatActivity {


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
        button.setOnClickListener(v -> {
            startActivity(new Intent(SignInActivity.this, MainActivity.class));
            finish();
        });
    }
}
