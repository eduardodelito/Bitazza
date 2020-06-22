package com.enaz.bitazza.ui.login;

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

public class LoginFragment extends BaseFragment {

    private LoginViewModel mViewModel;
    private OnLoginFragmentListener listener = null;

    @BindView(R.id.login_button)
    Button login;

    @Inject
    ViewModelFactory viewModelFactory;

    @Override
    protected int layoutRes() {
        return R.layout.login_fragment;
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this, viewModelFactory).get(LoginViewModel.class);
        // TODO: Use the ViewModel
        initUI();
    }

    private void initUI() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.authenticate();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnLoginFragmentListener) {
            listener = (OnLoginFragmentListener) context;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        listener.hideNavBottom();
    }

    public interface OnLoginFragmentListener {
        void hideNavBottom();
        void login();
    }
}