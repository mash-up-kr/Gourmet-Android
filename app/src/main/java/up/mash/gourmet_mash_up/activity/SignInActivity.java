package up.mash.gourmet_mash_up.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;


import butterknife.BindView;
import up.mash.gourmet_mash_up.R;


/**
 * A login screen that offers login via email/password.
 */
public class SignInActivity extends AppCompatActivity
{
    Intent it;
    @BindView(R.id.et_id)
    EditText id;

    @BindView(R.id.et_pw)
    EditText pw;

    @BindView(R.id.et_pw_confirm)
    EditText pw_confirm;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_in);

        it  = new Intent(this.getIntent());

      //  ui_init();
    }

    public void goMain(View v)
    {
        it = new Intent( SignInActivity.this, MainActivity.class );
        startActivity(it);
    }

    public void ui_init()
    {
        id.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if ( hasFocus )
                {
                    id.setHintTextColor( Color.parseColor("#e84a5f"));
                    id.setTextColor( Color.parseColor("#e84a5f"));
                    }
                else
                {
                    id.setHintTextColor( Color.parseColor("#999999"));
                    id.setTextColor( Color.parseColor("#999999"));
                }
            }
        });

        pw.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if ( hasFocus )
                {
                    pw.setTextColor( Color.parseColor("#e84a5f"));
                    pw.setHintTextColor( Color.parseColor("#e84a5f"));
                }
                else
                {
                    pw.setTextColor( Color.parseColor("#999999"));
                    pw.setHintTextColor( Color.parseColor("#999999"));
                }
            }
        });

        pw_confirm.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if ( hasFocus )
                {
                    pw_confirm.setTextColor( Color.parseColor("#e84a5f"));
                    pw_confirm.setHintTextColor( Color.parseColor("#e84a5f"));
                }
                else
                {
                    pw_confirm.setTextColor( Color.parseColor("#999999"));
                    pw_confirm.setHintTextColor( Color.parseColor("#999999"));
                }
            }
        });
    }

    public void changeColor()
    {
        if ( id.getSelectionStart() > 0 )
        {
            id.setTextColor(Color.parseColor("#e84a5f"));
            pw.setTextColor(Color.parseColor("#999999"));
            pw_confirm.setTextColor(Color.parseColor("#999999"));
        }
        else if ( pw.getSelectionStart() > 0 )
        {
            id.setTextColor(Color.parseColor("#999999"));
            pw.setTextColor(Color.parseColor("#e84a5f"));
            pw_confirm.setTextColor(Color.parseColor("#999999"));
        }
        else if ( pw_confirm.getSelectionStart() > 0 )
        {
            id.setTextColor(Color.parseColor("#999999"));
            pw.setTextColor(Color.parseColor("#999999"));
            pw_confirm.setTextColor(Color.parseColor("#e84a5f"));
        }
        else
        {
            id.setTextColor(Color.parseColor("#999999"));
            pw.setTextColor(Color.parseColor("#999999"));
            pw_confirm.setTextColor(Color.parseColor("#999999"));

        }
    }




}


