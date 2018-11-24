package mx.udg.aplicacion1.componets.goodviewpager.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import mx.udg.aplicacion1.R;
import mx.udg.aplicacion1.componets.Util.KeysConstants;

public class FragmentTwo extends Fragment {

    String message;

    public static String TAG = FragmentTwo.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two,container,false);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        message = getArguments().getString(KeysConstants.FRAGMENTS_ARG_FLAG);
        Log.e(TAG,"Message received "+message);
    }

    public static FragmentTwo newInstance(String someString){
        FragmentTwo myFragment = new FragmentTwo();
        Bundle args = new Bundle();
        args.putString(KeysConstants.FRAGMENTS_ARG_FLAG, someString);
        myFragment.setArguments(args);
        return myFragment;
    }
}
