package up.mash.gourmet_mash_up.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.item.UserInfo;

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

        Intent intent = getIntent();

        UserInfo userInfo = (UserInfo) intent.getSerializableExtra("USERINFO");

        Log.e("USERINFO", "pw : " + userInfo.getPw() );

        mainText = findViewById(R.id.main_text);
        mainText.setText("한 줄 자기소개를 입력해주세요.");

        subText = findViewById(R.id.tv1);
        subText.setText("한 줄 소개");

        inputText = findViewById(R.id.ed1);

        linearLayout = findViewById(R.id.input_type_2);
        linearLayout.setVisibility(View.GONE);

        button = findViewById(R.id.enterNext);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( inputText.getText().toString() == ""  ) return;

                userInfo.setIntro( inputText.getText().toString() );
                Intent intent = new Intent(SignUpInActivity.this, SignUpPrActivity.class);
                intent.putExtra("USERINFO", userInfo);
                startActivity(intent);
            }
        });


    }
}
