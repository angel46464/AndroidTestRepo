package mx.udg.aplicacion1.componets.Database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mx.udg.aplicacion1.R;
import mx.udg.aplicacion1.componets.Database.adapter.DogShopAdapter;
import mx.udg.aplicacion1.componets.Database.adapter.DogShopClick;
import mx.udg.aplicacion1.componets.Database.adapter.DogShopLongClick;
import mx.udg.aplicacion1.componets.Database.model.DogShop;
import mx.udg.aplicacion1.componets.Util.Util;

public class RealmRecyclerSampleActivity extends AppCompatActivity implements DogShopClick,DogShopLongClick {

    private static String TAG = RealmRecyclerSampleActivity.class.getSimpleName();

    private List<DogShop> dogShops = new ArrayList<>();

    private DogShopAdapter dogShopAdapter;

    @BindView(R.id.shopsRecyclerView) RecyclerView mDogShopRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm_recycler_sample);
        ButterKnife.bind(this);
        setUpRecyclerView(mDogShopRecyclerView);
    }

    @OnClick(R.id.floatingActionButton) public void addDommie(){
        dogShops.add(createDommie());
        dogShopAdapter.notifyDataSetChanged();
    }

    private void setUpRecyclerView(RecyclerView mDogShopRecyclerView) {
        dogShopAdapter = new DogShopAdapter(dogShops,getApplicationContext(),this,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mDogShopRecyclerView.setAdapter(dogShopAdapter);
        mDogShopRecyclerView.setLayoutManager(linearLayoutManager);
    }


    @Override
    public void onDogShopClickListener(DogShop dogShop) {
        Util.showLog(TAG,"Click on "+dogShop.toString());
    }

    @Override
    public void onDogShopLongClickListener(DogShop dogShop) {
        Util.showLog(TAG,"Long click on "+dogShop.toString());
    }

    public DogShop createDommie(){
        return new DogShop("Test","calle vidrio 1792",
                Util.setRandomImage(), String.valueOf(Util.getRandomNumber()));
    }

}
