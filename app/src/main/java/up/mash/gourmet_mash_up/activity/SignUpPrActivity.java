package up.mash.gourmet_mash_up.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.listener.OnCheckedListener;

import java.io.File;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.item.UserInfo;
import up.mash.gourmet_mash_up.util.ActivityConstants;
import up.mash.gourmet_mash_up.util.Glide4Engine;

/**
 * Created by derba on 2018-08-24.
 */

public class SignUpPrActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_image);

        Intent intent = getIntent();

        UserInfo userInfo = (UserInfo) intent.getSerializableExtra(ActivityConstants.USERINFO);

        imageView = findViewById(R.id.select_image);
        imageView.setScaleType(ImageView.ScaleType.CENTER);

        button = findViewById(R.id.enterNext);
        button.setText(R.string.complete);
        //TODO REST API 통신
        button.setOnClickListener(v -> {
            Intent intent1 = new Intent(getApplicationContext(), SignInActivity.class);
            startActivity(intent1);
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
                                            .setOnCheckedListener(new OnCheckedListener() {
                                                @Override
                                                public void onCheck(boolean isChecked) {
                                                    Log.e("isChecked", "onCheck: isChecked=" + isChecked);
                                                }
                                            })
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
            File imageFile = new File(Matisse.obtainPathResult(data).get(0));
//            https://stackoverflow.com/questions/22105775/imageview-in-circular-through-xml
//            //TODO
            Glide.with(SignUpPrActivity.this)
                    .load(imageFile)
                    .into(imageView);
            Log.e("OnActivityResult ", String.valueOf(Matisse.obtainOriginalState(data)));
        }
    }
}
