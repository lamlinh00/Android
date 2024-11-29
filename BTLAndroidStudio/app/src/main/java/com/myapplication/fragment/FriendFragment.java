package com.myapplication.fragment;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.myapplication.R;
import com.myapplication.databinding.ChatFragmentBinding;
import com.myapplication.utilities.PreferenceManager;

public class FriendFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.friend_fragment,container,false);
        return view;
    }
}
