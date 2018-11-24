package mx.udg.aplicacion1.componets.ViewPager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.udg.aplicacion1.R;

public class ViewPager extends AppCompatActivity {

    @BindView(R.id.viewPager)
    android.support.v4.view.ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ButterKnife.bind(this);
        viewPager.setAdapter(new CustomPagerAdapter(this));
    }
}
