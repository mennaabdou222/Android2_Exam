package com.example.android2exam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class TabFragment extends Fragment {

    public TabFragment() {
    }

    public static TabFragment newInstance(String title) {

        TabFragment fragment = new TabFragment();

        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.fragment_tab, container, false);

        TextView text = view.findViewById(R.id.tab_text);

        if (getArguments() != null) {
            text.setText(getArguments().getString("title"));
        }

        return view;
    }
}
