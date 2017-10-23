package src.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.android.parrot.parrot.R;

import src.adapter.BottomNavigationViewHelper;
import src.adapter.SectionsStatePagerAdapter;
import src.dao.DaoFrase;
import src.util.Util;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SectionsStatePagerAdapter mSectionsStatePagerAdapter;
    private ViewPager mViewPager;
    private Util util;
    public SharedPreferences prefs = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity);

        prefs = getSharedPreferences("com.android.parrot.parrot", MODE_PRIVATE);
        Log.d(TAG, "ON CREATE STARTED");

        mSectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);

        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_main);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_categorias);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_build);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.action_add:
                        startActivity(new Intent(getApplication(), AdicionarFraseActivity.class).putExtra("From", "Main"));
                        break;
                    case R.id.favoritos:
                        startActivity(new Intent(getApplication(), ListaFavoritosActivity.class).putExtra("From", "Main"));
                        break;
                    case R.id.exit:
                        finish();
                        break;
                }
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (prefs.getBoolean("firstRun", true)) {
            DaoFrase dao = new DaoFrase(getApplicationContext());
            dao.openDB();
            dao.createTable();
            Intent intent = new Intent(MainActivity.this, AdicionarFraseActivity.class);
            startActivity(intent);
            prefs.edit().putBoolean("firstRun", false).commit();
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsStatePagerAdapter adapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentMain(), "FragmentMain");
        adapter.addFragment(new FragmentCategorias(), "FragmentCategorias");
        adapter.addFragment(new FragmentConfiguracao(), "FragmentConfiguracao");
        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentNumber) {
        mViewPager.setCurrentItem(fragmentNumber);
    }

    @Override
    public void onBackPressed() {
        if(mViewPager.getCurrentItem() == 0) {
            finish();
        } else {
            setViewPager(0);
        }
    }
}
