package com.enaz.bitazza.ui.market;

import androidx.activity.OnBackPressedCallback;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.TextView;

import com.enaz.bitazza.R;
import com.enaz.bitazza.base.BaseFragment;
import com.enaz.bitazza.util.ViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;

public class MarketFragment extends BaseFragment {

    private MarketViewModel mViewModel;

    @Inject
    ViewModelFactory viewModelFactory;

    @Override
    protected int layoutRes() {
        return R.layout.market_fragment;
    }

    public static MarketFragment newInstance() {
        return new MarketFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this, viewModelFactory).get(MarketViewModel.class);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // This callback will only be called when MyFragment is at least Started.
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                //Do nothing
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }
}
