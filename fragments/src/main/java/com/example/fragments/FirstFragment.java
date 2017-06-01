package com.example.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    public static final String KEY_FRAG_NUM = "fragNum";


    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment getInstance(int Image) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_FRAG_NUM, Image);
        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_first, container, false);
        Bundle bundle = getArguments();
                int img = bundle.getInt(KEY_FRAG_NUM);

                ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
                imageView.setImageResource(img);

        return rootView;
    }

}
