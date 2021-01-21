package com.e.myassignment.Fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.e.myassignment.R;

public class Fragment15 extends Fragment {
    private LinearLayout linear_background;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        linear_background = view.findViewById(R.id.linear_background);
        linear_background.setBackgroundColor(getResources().getColor(R.color.purple_700));

        Toast.makeText(getContext(),R.string.blue, Toast.LENGTH_SHORT).show();

        return view;
    }
}
