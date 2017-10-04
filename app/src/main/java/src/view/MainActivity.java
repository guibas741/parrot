package src.view;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.parrot.parrot.R;

import src.controller.BottomNavigationViewHelper;
import src.controller.SectionsStatePagerAdapter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SectionsStatePagerAdapter mSectionsStatePagerAdapter;
    private ViewPager mViewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity);
        Log.d(TAG, "ON CREATE STARTED");

        mSectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);

        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_main);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_categorias);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_add);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
    }



    private void setupViewPager(ViewPager viewPager) {
        SectionsStatePagerAdapter adapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentMain(), "FragmentMain");
        adapter.addFragment(new FragmentCategorias(), "FragmentCategorias");
        adapter.addFragment(new FragmentAdicionarFrase(), "FragmentAdicionarFrase");
        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentNumber) {
        mViewPager.setCurrentItem(fragmentNumber);
    }
}
