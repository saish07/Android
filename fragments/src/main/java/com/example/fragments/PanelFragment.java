package com.example.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class PanelFragment extends Fragment {


    public PanelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


              final View rootView = inflater.inflate(R.layout.fragment_panel, container, false);
              final MainActivity activity = (MainActivity) getActivity();

            rootView.findViewById(R.id.btnOne).setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(FirstFragment.KEY_FRAG_NUM, R.drawable.ic_hospital);
                    FirstFragment fragment = new FirstFragment();
                    fragment.setArguments(bundle);
                    activity.loadFragment(fragment);
                }
        });

                       rootView.findViewById(R.id.btnTwo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                       activity.loadFragment(FirstFragment.getInstance(R.drawable.ic_student));
                                    }
        });

                        rootView.findViewById(R.id.btnThree).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                        activity.loadFragment(FirstFragment.getInstance(R.drawable.ic_wifi_signal));
                            }
        });

        return rootView;
    }

}
