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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import up.mash.gourmet_mash_up.R;

/**
 * Created by derba on 2018-08-24.
 */

public class SignUpIdActivity extends AppCompatActivity {

    TextView mainText;
    TextView subText;
    TextView subText2;
    TextView button;
    EditText inputText;
    EditText InputText2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        ButterKnife.bind(this);

        mainText = findViewById(R.id.main_text);
        mainText.setText("패스워드를 입력해주세요.");

        subText = findViewById(R.id.tv1);
        subText.setText("패스워드");

        subText2 = findViewById(R.id.tv2);
        subText2.setText("패스워드 확인");

        button = findViewById(R.id.enterNext);
    }
}
