package up.mash.gourmet_mash_up.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import up.mash.gourmet_mash_up.R;

/**
 * Created by derba on 2018-08-24.
 */

public class MenuItemPageActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu_item_page);

        toolbar = findViewById(R.id.menu_item_page_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setCustomView(R.menu.menu_item_page_top);
    }
}
