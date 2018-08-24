package up.mash.gourmet_mash_up.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.item.UserInfo;
import up.mash.gourmet_mash_up.util.ActivityConstants;

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
        button.setOnClickListener(v -> {
            Intent intent1 = new Intent(getApplicationContext(), SignInActivity.class);
            startActivity(intent1);
        });
    }

    public void selectProfileImage(View v) {
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
}
