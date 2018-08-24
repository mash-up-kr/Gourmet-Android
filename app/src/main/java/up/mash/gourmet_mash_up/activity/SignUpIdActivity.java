package up.mash.gourmet_mash_up.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import up.mash.gourmet_mash_up.R;

/**
 * Created by derba on 2018-08-24.
 */

public class SignUpIdActivity extends AppCompatActivity {

    @BindView(R.id.input_type_2)
    LinearLayout linearLayout;

    @BindView(R.id.main_text)
    TextView mainText;

    @BindView(R.id.tv1)
    TextView subText;

    @BindView(R.id.ed1)
    EditText inputText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_first_main);

        Intent intent = new Intent(this.getIntent());

        linearLayout.setVisibility(View.GONE);
        mainText.setText("아이디를 입력해주세요.");
        subText.setText("아이디");
    }
}
