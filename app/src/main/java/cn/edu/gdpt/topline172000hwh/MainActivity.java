package cn.edu.gdpt.topline172000hwh;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.gdpt.topline172000hwh.fragment.CountFragment;
import cn.edu.gdpt.topline172000hwh.fragment.HomeFragment;
import cn.edu.gdpt.topline172000hwh.fragment.MeFragment;
import cn.edu.gdpt.topline172000hwh.fragment.VideoFragment;

public class MainActivity extends AppCompatActivity {

    private TextView tv_main_title;
    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private List<Fragment> alFragment = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initViewPager();
        initListener();
    }

    private void initListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }
            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        tv_main_title.setText("首页");
                        radioGroup.check(R.id.rb_home);
                        break;
                    case 1:
                        tv_main_title.setText("统计");
                        radioGroup.check(R.id.rb_count);
                        break;
                    case 2:
                        tv_main_title.setText("视频");
                        radioGroup.check(R.id.rb_video);
                        break;
                    case 3:
                        tv_main_title.setText("我的模块");
                        radioGroup.check(R.id.rb_me);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        viewPager.setCurrentItem(0,false);
                        break;
                    case R.id.rb_count:
                        viewPager.setCurrentItem(1,false);
                        break;
                    case R.id.rb_video:
                        viewPager.setCurrentItem(2,false);
                        break;
                    case R.id.rb_me:
                        viewPager.setCurrentItem(3,false);
                        break;
                }
            }
        });
    }

    private void initViewPager() {
        alFragment.add(new HomeFragment());
        alFragment.add(new CountFragment());
        alFragment.add(new VideoFragment());
        alFragment.add(new MeFragment());
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return alFragment.get(i);
            }
            @Override
            public int getCount() {
                return alFragment.size();
            }
        });
    }
    private void initView() {
        tv_main_title = (TextView) findViewById(R.id.tv_main_title);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
    }
}
