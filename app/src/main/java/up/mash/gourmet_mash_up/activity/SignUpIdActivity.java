package up.mash.gourmet_mash_up.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.item.UserInfo;

/**
 * Created by derba on 2018-08-24.
 */

public class SignUpIdActivity extends AppCompatActivity {


    LinearLayout linearLayout;
    TextView mainText;
    TextView subText;
    EditText inputText;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        linearLayout = findViewById(R.id.input_type_2);
        linearLayout.setVisibility(View.GONE);

        mainText = findViewById(R.id.main_text);
        mainText.setText("아이디를 입력해주세요.");

        subText = findViewById(R.id.tv1);
        subText.setText("아이디");

        inputText = findViewById(R.id.ed1);

        button = findViewById(R.id.enterNext);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( inputText.getText() == null ) return;

                UserInfo userInfo = new UserInfo();
                userInfo.setId( inputText.getText().toString() );
                Intent intent = new Intent(getApplicationContext(), SignUpPwActivity.class);
                intent.putExtra("USERINFO", userInfo);
                startActivity(intent);
            }
        });
    }
}
