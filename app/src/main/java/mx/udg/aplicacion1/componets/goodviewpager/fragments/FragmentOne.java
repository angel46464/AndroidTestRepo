package mx.udg.aplicacion1.componets.goodviewpager.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import mx.udg.aplicacion1.R;

public class FragmentOne extends Fragment {

    public static final String TAG = FragmentOne.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one,container,false);
        return view;
    }

    public static FragmentOne newInstance(){
        FragmentOne myFragment = new FragmentOne();
        return myFragment;
    }

}
