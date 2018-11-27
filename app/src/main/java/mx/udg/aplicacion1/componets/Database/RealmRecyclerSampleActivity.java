package mx.udg.aplicacion1.componets.Database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import mx.udg.aplicacion1.R;
import mx.udg.aplicacion1.componets.Database.adapter.DogShopAdapter;
import mx.udg.aplicacion1.componets.Database.adapter.DogShopClick;
import mx.udg.aplicacion1.componets.Database.adapter.DogShopLongClick;
import mx.udg.aplicacion1.componets.Database.model.DogShop;
import mx.udg.aplicacion1.componets.Util.KeysConstants;
import mx.udg.aplicacion1.componets.Util.Util;

public class RealmRecyclerSampleActivity extends AppCompatActivity implements DogShopClick,DogShopLongClick {

    private static String TAG = RealmRecyclerSampleActivity.class.getSimpleName();

    private RealmList<DogShop> dogShopList = new RealmList<>();

    private DogShopAdapter dogShopAdapter;

    @BindView(R.id.shopsRecyclerView) RecyclerView mDogShopRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm_recycler_sample);
        ButterKnife.bind(this);
        setUpRecyclerView(mDogShopRecyclerView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getRealmObjects();
    }

    private void getRealmObjects() {
        dogShopList.clear();
        Realm realm = Realm.getDefaultInstance();
        RealmResults<DogShop> dogShopsResults = realm.where(DogShop.class).findAll();
        dogShopList.addAll(dogShopsResults.subList(0,dogShopsResults.size()));
        dogShopAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.floatingActionButton) public void createDogShop(){
        Intent intent = new Intent(this,EditShopActivity.class);
        intent.putExtra(KeysConstants.MODE_KEY,KeysConstants.CREATE_MODE);
        startActivity(intent);
    }

    private void setUpRecyclerView(RecyclerView mDogShopRecyclerView) {
        dogShopAdapter = new DogShopAdapter(dogShopList,getApplicationContext(),this,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mDogShopRecyclerView.setAdapter(dogShopAdapter);
        mDogShopRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }


    @Override
    public void onDogShopClickListener(DogShop dogShop) {
        Intent intent = new Intent(this,EditShopActivity.class);
        intent.putExtra(KeysConstants.DOG_SHOP_ID,dogShop.dogShopID);
        intent.putExtra(KeysConstants.MODE_KEY,KeysConstants.EDIT_MODE);
        startActivity(intent);
    }

    @Override
    public void onDogShopLongClickListener(DogShop dogShop) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realmTransaction) {
                dogShopList.remove(dogShop);
                dogShopAdapter.notifyDataSetChanged();
                RealmResults<DogShop> shops = realmTransaction.where(DogShop.class)
                        .equalTo(KeysConstants.DOG_SHOP_ID,dogShop.dogShopID)
                        .findAll();
                shops.deleteAllFromRealm();
            }
        });
    }

    public DogShop createDommie(){
        return new DogShop("Test","calle vidrio 1792",
                Util.setRandomImage(), String.valueOf(Util.getRandomNumber()));
    }

}
