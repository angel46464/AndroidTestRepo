package mx.udg.aplicacion1.componets.goodviewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.udg.aplicacion1.R;
import mx.udg.aplicacion1.componets.Util.Util;
import mx.udg.aplicacion1.componets.goodviewpager.fragments.FragmentOne;
import mx.udg.aplicacion1.componets.goodviewpager.fragments.FragmentThree;
import mx.udg.aplicacion1.componets.goodviewpager.fragments.FragmentTwo;

public class GoodViewPager extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private static final String TAG = GoodViewPager.class.getSimpleName();

    @BindView(R.id.viewPager2)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_view_pager);
        ButterKnife.bind(this);
        setUpViewPager();
    }

    private void setUpViewPager(){
        GoodViewPagerAdapter goodViewPagerAdapter = new GoodViewPagerAdapter(getSupportFragmentManager());
        goodViewPagerAdapter.addFragment(FragmentOne.newInstance(),FragmentOne.TAG);
        goodViewPagerAdapter.addFragment(FragmentTwo.newInstance("Prueba de enviar datos a fragments"),FragmentTwo.TAG);
        goodViewPagerAdapter.addFragment(FragmentThree.newInstance(),FragmentThree.TAG);
        viewPager.setAdapter(goodViewPagerAdapter);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        Util.showLog(TAG,"Page Selected: " +i);
    }

    @Override
    public void onPageScrollStateChanged(int i) {
        Util.showLog(TAG,"On Page Scroll: "+i);
    }
}
