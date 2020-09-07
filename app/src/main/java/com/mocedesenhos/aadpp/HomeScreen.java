package com.mocedesenhos.aadpp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.mocedesenhos.aadpp.Adapters.FragPagerAdapter;
import com.mocedesenhos.aadpp.Fragments.LearningLeadersFragment;
import com.mocedesenhos.aadpp.Fragments.SkillsIQFragment;
import com.mocedesenhos.aadpp.QuickHelp.QuickHelp;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeScreen extends AppCompatActivity {


    FragPagerAdapter fragPagerAdapter;

    @BindView(R.id.SearchActivityCategorySliderPager)
    ViewPager SearchActivityCategorySliderPager;

    @BindView(R.id.SearchActivityCategoryTabLayout)
    TabLayout SearchActivityCategoryTabLayout;

    @BindView(R.id.HomeSubmitBtn)
    TextView HomeSubmitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        ButterKnife.bind(this); //Bind Activity with ButterKnife
        QuickHelp.EnterActivityWithSlideAnimation(this);

        fragPagerAdapter=new FragPagerAdapter(getSupportFragmentManager());
        SearchActivityCategoryTabLayout.setupWithViewPager(SearchActivityCategorySliderPager,true);
        HomeSubmitBtn.setOnClickListener(v->QuickHelp.GotoActivity(this,SubmissionScreen.class));
        initPager();

    }

    @Override
    public void onBackPressed() {

        if(SearchActivityCategorySliderPager.getCurrentItem()==2)
        {
            SearchActivityCategorySliderPager.setCurrentItem(1);

        }
        else if(SearchActivityCategorySliderPager.getCurrentItem()==1)
        {
            SearchActivityCategorySliderPager.setCurrentItem(0);

        }
        else
        {
            super.onBackPressed();
        }


    }
    private void initPager()
    {
        fragPagerAdapter.AddFragment(new LearningLeadersFragment(),"Learning Leaders");
        fragPagerAdapter.AddFragment(new SkillsIQFragment(),"Skill IQ Leaders");


        SearchActivityCategorySliderPager.setAdapter(fragPagerAdapter);
        SearchActivityCategoryTabLayout.setupWithViewPager(SearchActivityCategorySliderPager);

    }

    @Override
    public void finish() {
        super.finish();
        QuickHelp.ExitActivityWithSlideAnimation(this);
    }
}