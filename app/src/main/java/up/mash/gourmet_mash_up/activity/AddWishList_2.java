package up.mash.gourmet_mash_up.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;

import java.io.File;

import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.data.local.WishList;
import up.mash.gourmet_mash_up.util.Glide4Engine;

public class AddWishList_2 extends AppCompatActivity {

    private ImageView iv_back_button;
    private TextView tv_question_no;
    private TextView tv_ask_question;
    private ImageView iv_picture_for_food;
    private EditText et_contents_stamp_wishList;
    private Button enter_next;
    File imageFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_wish_common);

        init_common_stamp_wishlist();

        tv_question_no.setText(R.string.q2);
        tv_ask_question.setText(R.string.what_do_you_want_to_eat);

        iv_picture_for_food.setVisibility(View.VISIBLE);
        iv_picture_for_food.setOnClickListener(v -> Matisse.from(AddWishList_2.this)
                .choose(MimeType.ofImage(), false)
                .maxSelectable(1)
                .gridExpectedSize(
                        getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                .thumbnailScale(0.85f)
                .imageEngine(new Glide4Engine())
                .originalEnable(true)
                .maxOriginalSize(10)
                .forResult(101));

        et_contents_stamp_wishList.setHint(R.string.hint_write_menu_name);

        enter_next.setOnClickListener(v -> {
            String a = et_contents_stamp_wishList.getText().toString();
            WishList.getIntance().setWhere(a);

            startActivity(new Intent(AddWishList_2.this, AddWishList_3.class));
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == RESULT_OK) {
            imageFile = new File(Matisse.obtainPathResult(data).get(0));
            WishList.getIntance().setImageFile(imageFile);
            Glide.with(AddWishList_2.this)
                    .load(imageFile)
                    .into(iv_picture_for_food);
        }
    }
}
