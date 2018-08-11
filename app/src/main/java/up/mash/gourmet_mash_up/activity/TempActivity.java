package up.mash.gourmet_mash_up.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.fragment.MyPageFragment;

/**
 * Created by derba on 2018-08-11.
 */

public class TempActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        ButterKnife.bind(this);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.temp_fragment, new MyPageFragment())
                .commit();
    }
}
