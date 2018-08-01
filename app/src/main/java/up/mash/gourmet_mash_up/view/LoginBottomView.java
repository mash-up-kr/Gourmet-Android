package up.mash.gourmet_mash_up.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import up.mash.gourmet_mash_up.R;

public class LoginBottomView extends LinearLayout {

    private static final String TAG = LoginBottomView.class.getSimpleName();

    @BindView(R.id.view_background)
    View viewBackground;
    @BindView(R.id.main_background)
    ConstraintLayout mainBackground;

    @BindView(R.id.layout_sub_main_background)
    ConstraintLayout subMainBackground;

    @BindView(R.id.exit_login)
    ImageView ivExitLogin;
    @BindView(R.id.tv_already_have_account)
    TextView tvAlreadyHaveButton;
    @BindView(R.id.tv_sign_in)
    TextView tvSignIn;
    @BindView(R.id.et_user_id)
    AutoCompleteTextView userId;
    @BindView(R.id.et_password)
    EditText password;
    @BindView(R.id.btn_signin)
    Button signIn;

    private BottomSheetBehavior bottomSheetBehavior;


    public LoginBottomView(Context context) {
        this(context, null);
    }

    public LoginBottomView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoginBottomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View view = inflate(getContext(), R.layout.view_sign_in, this);
        ButterKnife.bind(this, view);

        viewBackground = findViewById(R.id.view_background);
        mainBackground = findViewById(R.id.main_background);
        subMainBackground = findViewById(R.id.layout_sub_main_background);
        ivExitLogin = findViewById(R.id.exit_login);
        tvAlreadyHaveButton = findViewById(R.id.tv_already_have_account);
        tvSignIn = findViewById(R.id.tv_sign_in);
        userId = findViewById(R.id.et_user_id);
        password = findViewById(R.id.et_password);
        signIn = findViewById(R.id.btn_signin);

        viewBackground.setAlpha(0f);
        subMainBackground.setAlpha(0.8f);
        mainBackground.setAlpha(1f);

        bottomSheetBehavior = BottomSheetBehavior.from(subMainBackground);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                mainBackground.setAlpha(1f - slideOffset);

                if (slideOffset > 0.8f) {
                    mainBackground.setAlpha(slideOffset);
                }

                if (slideOffset < 0.7f) {
                    viewBackground.setAlpha(slideOffset);
                }

                if (slideOffset > 0.75f) {
                    ivExitLogin.setVisibility(View.INVISIBLE);
                } else {
                    ivExitLogin.setVisibility(View.VISIBLE);
                }
            }
        });


    }
}
