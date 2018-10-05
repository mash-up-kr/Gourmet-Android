package up.mash.gourmet_mash_up.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;

import java.io.File;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import timber.log.Timber;
import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.data.remote.api.GourmatRestManager;
import up.mash.gourmet_mash_up.util.ActivityConstants;
import up.mash.gourmet_mash_up.util.Glide4Engine;

/**
 * 회원가입 완료페이지
 */
public class SignUpPrActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;
    File imageFile;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_image);

        Intent intent = getIntent();

        String oneLineIntroduce = (String) intent.getSerializableExtra(ActivityConstants.USERINFO);

        imageView = findViewById(R.id.select_image);
        imageView.setScaleType(ImageView.ScaleType.CENTER);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String user_token = preferences.getString("auth_token", "");

        button = findViewById(R.id.enterNext);
        button.setText(R.string.complete);
        button.setOnClickListener((View v) -> {

            RequestBody introduce = RequestBody.create(MediaType.parse("multipart/form-data"), oneLineIntroduce);
            MultipartBody.Part imageProfilePart;
            Timber.d("ImageFile%s", imageFile.getName());
            if (imageFile.exists()) {
                RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), imageFile);
                imageProfilePart = MultipartBody.Part.createFormData("profile", imageFile.getName(), requestFile);
                GourmatRestManager.setMe(user_token, imageProfilePart, introduce)
                        .subscribe((a) -> {
                            startActivity(new Intent(SignUpPrActivity.this, MainActivity.class));
                            finish();
                        });
            } else {
                GourmatRestManager.setMeWithoutImage(user_token, introduce)
                        .subscribe();
            }
        });
    }

    public void selectProfileImage(View v) {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        if (aBoolean) {
                            switch (v.getId()) {
                                case R.id.select_image:
                                    Matisse.from(SignUpPrActivity.this)
                                            .choose(MimeType.ofImage(), false)
                                            .maxSelectable(1)
                                            .gridExpectedSize(
                                                    getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                                            .thumbnailScale(0.85f)
                                            .imageEngine(new Glide4Engine())
                                            .originalEnable(true)
                                            .maxOriginalSize(10)
                                            .setOnCheckedListener(isChecked -> Timber.e("onCheck: isChecked=%s", isChecked))
                                            .forResult(100);
                                    break;
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            imageFile = new File(Matisse.obtainPathResult(data).get(0));

            Glide.with(SignUpPrActivity.this)
                    .load(imageFile)
                    .into(imageView);

            Timber.e(String.valueOf(Matisse.obtainOriginalState(data)));
        }
    }
}
