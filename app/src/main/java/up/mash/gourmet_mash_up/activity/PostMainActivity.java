package up.mash.gourmet_mash_up.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import up.mash.gourmet_mash_up.R;

/**
 * Created by derba on 2018-08-24.
 */

public class PostMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_first_main);

    }

    public void enterSignInActivity(View v) {
        Intent intent = new Intent(PostMainActivity.this, SignUpIdActivity.class);
        startActivity(intent);
    }
}
