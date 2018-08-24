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
import up.mash.gourmet_mash_up.model.local.WishList;

public class AddWishList_3 extends AppCompatActivity {

    private ImageView iv_back_button;
    private TextView tv_question_no;
    private TextView tv_ask_question;
    private ImageView iv_picture_for_food;
    private EditText et_contents_stamp_wishList;
    private Button enter_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_wish_common);

        init_common_stamp_wishlist();

        tv_question_no.setText(R.string.q3);
        tv_ask_question.setText(R.string.where_the_shop_is_located);

        iv_picture_for_food.setVisibility(View.GONE);

        et_contents_stamp_wishList.setHint(R.string.hint_write_address);

        enter_next.setOnClickListener(v -> {
            String a = et_contents_stamp_wishList.getText().toString();
            WishList.getIntance().setAddress(a);
            //TODO 인터넷 연결
            startActivity(new Intent(AddWishList_3.this, MainActivity.class));
            finish();

        });

        iv_back_button.setOnClickListener(v -> onBackPressed());

    }

    public void init_common_stamp_wishlist() {
        iv_back_button = findViewById(R.id.back_button);
        tv_question_no = findViewById(R.id.tv_question_no);
        tv_ask_question = findViewById(R.id.tv_ask_question);
        iv_picture_for_food = findViewById(R.id.iv_picture_for_food);
        et_contents_stamp_wishList = findViewById(R.id.et_contents_stamp_wishList);
        enter_next = findViewById(R.id.enterNext);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}