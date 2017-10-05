package src.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.parrot.parrot.R;

import src.controller.BottomNavigationViewHelper;
import src.controller.SectionsStatePagerAdapter;
import src.util.Util;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SectionsStatePagerAdapter mSectionsStatePagerAdapter;
    private ViewPager mViewPager;
    private Util util;



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
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_fav);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        /*Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);*/

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.action_add:
                        startActivity(new Intent(getApplication(), AdicionarFraseActivity.class));
                        break;
                    case R.id.favoritos:
                        startActivity(new Intent(getApplication(), ListaFavoritosActivity.class));
                        break;
                    case R.id.exit:
                        Toast.makeText(getApplication(),"fechou", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
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
