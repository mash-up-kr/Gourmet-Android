package up.mash.gourmet_mash_up.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import up.mash.gourmet_mash_up.R;

/**
 * A login screen that offers login via email/password.
 */
public class SignUpActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);
    }

    public void goSingIn(View v)
    {
        Intent it = new Intent( SignUpActivity.this, SignInActivity.class );
        startActivity(it);
    }
}

