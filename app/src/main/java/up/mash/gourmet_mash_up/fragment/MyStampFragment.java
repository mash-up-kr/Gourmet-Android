package up.mash.gourmet_mash_up.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import timber.log.Timber;
import up.mash.gourmet_mash_up.R;
import up.mash.gourmet_mash_up.adapter.MyStampRecyclerViewAdapter;
import up.mash.gourmet_mash_up.data.remote.api.GourmatRestManager;
import up.mash.gourmet_mash_up.data.remote.model.ReviewModel;

public class MyStampFragment extends Fragment {

    MyStampRecyclerViewAdapter myStampRecyclerViewAdapter;
    RecyclerView myStampRecyclerView;
    ArrayList<ReviewModel> mReviewModelArrayList;
    Context mContext;

    public static MyStampFragment newInstance() {
        return new MyStampFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_stamp, container, false);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String authToken = preferences.getString("auth_token", "");
        Timber.d(authToken);

        myStampRecyclerView = view.findViewById(R.id.my_stamp_recycler_view);
        mReviewModelArrayList = new ArrayList<>();

        myStampRecyclerViewAdapter = new MyStampRecyclerViewAdapter(mReviewModelArrayList, mContext);
        myStampRecyclerView.setAdapter(myStampRecyclerViewAdapter);
        myStampRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        GourmatRestManager.getStampListOnMe(authToken)
                .subscribe(
                        (res) -> myStampRecyclerViewAdapter.updateStamp(res),
                        Timber::d,
                        () -> Timber.d("onTotalMyStamps")
                );
    }
}
