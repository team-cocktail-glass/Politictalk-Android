/*
package politictalk.dsm;

import android.arch.lifecycle.ReportFragment;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
*/

/*
public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    private ViewPager viewPager;

    HomeFragment homeFragment;
    FactionFragment reportFragment;
    MeetingFragment meetingFragment;
    ProposalFragment proposalFragment;
    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_one:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.action_two:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.action_three:
                                viewPager.setCurrentItem(2);
                                break;
                            case R.id.action_four:
                                viewPager.setCurrentItem(3);
                                break;
                        }
                        return false;
                    }
                });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected " + position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        homeFragment = new HomeFragment();
        reportFragment = new FactionFragment();
        meetingFragment = new MeetingFragment();
        proposalFragment = new ProposalFragment();

        adapter.addFragment(homeFragment);
        adapter.addFragment(reportFragment);
        adapter.addFragment(meetingFragment);
        adapter.addFragment(proposalFragment);
        viewPager.setAdapter(adapter);
    }
}
*/
