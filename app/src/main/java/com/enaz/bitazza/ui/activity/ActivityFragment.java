package com.enaz.bitazza.ui.activity;

import androidx.activity.OnBackPressedCallback;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.enaz.bitazza.R;
import com.enaz.bitazza.base.BaseFragment;
import com.enaz.bitazza.util.ViewModelFactory;

import javax.inject.Inject;

public class ActivityFragment extends BaseFragment {

    private ActivityViewModel mViewModel;

    @Inject
    ViewModelFactory viewModelFactory;

    @Override
    protected int layoutRes() {
        return R.layout.activity_fragment;
    }

    public static ActivityFragment newInstance() {
        return new ActivityFragment();
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this, viewModelFactory).get(ActivityViewModel.class);
        // TODO: Use the ViewModel
    }

}