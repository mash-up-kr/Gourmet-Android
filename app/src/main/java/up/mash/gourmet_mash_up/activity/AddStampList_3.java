package up.mash.gourmet_mash_up.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import up.mash.gourmet_mash_up.R;

public class AddStampList_3 extends AppCompatActivity {

    private ImageView iv_back_button;
    private TextView tv_question_no;
    private TextView tv_ask_question;
    private EditText et_contents_stamp_wishList;
    private Button enter_next;
    private View select_containar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_good_bad_stamp);

        init_common_stamp_wishlist();

        tv_question_no.setText(R.string.q3);
        tv_ask_question.setText(R.string.how_the_taste);

        et_contents_stamp_wishList.setVisibility(View.GONE);

        select_containar = findViewById(R.id.select_container_view);
        ImageView iv_good = select_containar.findViewById(R.id.good);
        ImageView iv_bac = select_containar.findViewById(R.id.bad);


        enter_next.setOnClickListener(v -> {
            //TODO 인터넷 연결
            startActivity(new Intent(AddStampList_3.this, MainActivity.class));
            finish();

        });

        iv_back_button.setOnClickListener(v -> onBackPressed());

    }

    public void init_common_stamp_wishlist() {
        iv_back_button = findViewById(R.id.back_button);
        tv_question_no = findViewById(R.id.tv_question_no);
        tv_ask_question = findViewById(R.id.tv_ask_question);
        et_contents_stamp_wishList = findViewById(R.id.et_contents_stamp_wishList);
        enter_next = findViewById(R.id.enterNext);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
