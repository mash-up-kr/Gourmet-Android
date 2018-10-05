package up.mash.gourmet_mash_up.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import timber.log.Timber;
import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.data.local.WishList;
import up.mash.gourmet_mash_up.data.remote.api.GourmatRestManager;

public class AddWishList_3 extends AppCompatActivity {

    private ImageView iv_back_button;
    private TextView tv_question_no;
    private TextView tv_ask_question;
    private ImageView iv_picture_for_food;
    private EditText et_contents_stamp_wishList;
    private Button enter_next;
    private File imageFile;
    private Context mContext;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_wish_common);

        init_common_stamp_wishlist();
        mContext = getApplicationContext();
        tv_question_no.setText(R.string.q3);
        tv_ask_question.setText(R.string.where_the_shop_is_located);

        iv_picture_for_food.setVisibility(View.GONE);

        et_contents_stamp_wishList.setHint(R.string.hint_write_address);

        enter_next.setOnClickListener(v -> {

            String a = et_contents_stamp_wishList.getText().toString();
            WishList.getIntance().setAddress(a);

            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mContext);
            String user_token = preferences.getString("auth_token", "");
            Timber.d(user_token);

            RequestBody restaurant = RequestBody.create(MediaType.parse("multipart/form-data"), WishList.getIntance().getWhere());
            RequestBody address = RequestBody.create(MediaType.parse("multipart/form-data"), WishList.getIntance().getAddress());
            RequestBody menu = RequestBody.create(MediaType.parse("multipart/form-data"), WishList.getIntance().getWhat());
            RequestBody price = RequestBody.create(MediaType.parse("multipart/form-data"), "1000");
            imageFile = WishList.getIntance().getImageFile();
            MultipartBody.Part imageProfilePart;

            Timber.d("ImageFile%s", imageFile.getName());
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), imageFile);
            imageProfilePart = MultipartBody.Part.createFormData("image", imageFile.getName(), requestFile);
            GourmatRestManager.addSingleWishList(user_token, imageProfilePart, restaurant, address, menu, price)
                    .subscribe(
                            (onNext) -> {
                                startActivity(new Intent(AddWishList_3.this, MainActivity.class));
                                WishList.getIntance().clear();
                                finish();
                            },
                            Timber::d,
                            () -> Timber.d("onWishListComplete")
                    );
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
