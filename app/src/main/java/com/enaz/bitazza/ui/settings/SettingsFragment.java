package com.enaz.bitazza.ui.settings;

import androidx.activity.OnBackPressedCallback;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.enaz.bitazza.R;
import com.enaz.bitazza.base.BaseFragment;
import com.enaz.bitazza.util.ViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;

public class SettingsFragment extends BaseFragment {

    private SettingsViewModel mViewModel;
    private OnSettingsFragmentListener listener = null;

    @BindView(R.id.logout_button)
    Button logout;

    @Inject
    ViewModelFactory viewModelFactory;

    @Override
    protected int layoutRes() {
        return R.layout.settings_fragment;
    }

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
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
        mViewModel = new ViewModelProvider(this, viewModelFactory).get(SettingsViewModel.class);
        // TODO: Use the ViewModel
        initUI();
    }

    private void initUI() {
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.logout();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSettingsFragmentListener) {
            listener = (OnSettingsFragmentListener) context;
        }
    }

    public interface OnSettingsFragmentListener {
        void logout();
    }
}
