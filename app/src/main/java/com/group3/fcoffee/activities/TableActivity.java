package com.group3.fcoffee.activities;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.group3.fcoffee.R;
import com.group3.fcoffee.fragments.FragmentTableAdapter;

public class TableActivity extends AppCompatActivity implements View.OnClickListener {
    private FragmentTableAdapter mFragmentTableAdapter;
    private ViewPager mViewPager;
    private LinearLayout mLLTable, mLLStatistics, mLLAccount, mLLLogout;
    private TextView mTxtTable, mTxtStatistics, mTxtAccount, mTxtLogout;
    private ImageView mImgTable, mImgStatistics, mImgAccount, mImgLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initData();
    }

    private void initView() {
        mViewPager = findViewById(R.id.vp_home);
        mLLTable = findViewById(R.id.ll_button_table);
        mLLStatistics = findViewById(R.id.ll_button_statistics);
        mLLAccount = findViewById(R.id.ll_button_account);
        mLLLogout = findViewById(R.id.ll_button_logout);

        mImgTable = findViewById(R.id.img_icon_table);
        mImgStatistics = findViewById(R.id.img_icon_statistics);
        mImgAccount = findViewById(R.id.img_icon_account);
        mImgLogout = findViewById(R.id.img_icon_logout);

        mTxtTable = findViewById(R.id.txt_title_table);
        mTxtStatistics = findViewById(R.id.txt_title_statistics);
        mTxtAccount = findViewById(R.id.txt_title_account);
        mTxtLogout = findViewById(R.id.txt_title_logout);
    }

    private void initData() {
        mLLTable.setOnClickListener(this);
        mLLStatistics.setOnClickListener(this);
        mLLAccount.setOnClickListener(this);
        mLLLogout.setOnClickListener(this);

        mFragmentTableAdapter = new FragmentTableAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mFragmentTableAdapter);
        mViewPager.setCurrentItem(0);
        mImgTable.setImageResource(R.mipmap.ic_table_selected);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    setPageTable();
                } else if (position == 1) {
                    setPageStatistics();
                } else if (position == 2) {
                    setPageAccount();
                } else if (position == 3) {
                    setPageLogout();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setPageTable() {
        mImgTable.setImageResource(R.mipmap.ic_table_selected);
        mTxtTable.setTextColor(Color.parseColor("#FFFFFF"));

        mImgStatistics.setImageResource(R.mipmap.ic_statistics);
        mTxtStatistics.setTextColor(Color.parseColor("#1a2947"));

        mImgAccount.setImageResource(R.mipmap.ic_account);
        mTxtAccount.setTextColor(Color.parseColor("#1a2947"));

        mImgLogout.setImageResource(R.mipmap.ic_logout);
        mTxtLogout.setTextColor(Color.parseColor("#1a2947"));
    }

    private void setPageStatistics() {
        mImgTable.setImageResource(R.mipmap.ic_table);
        mTxtTable.setTextColor(Color.parseColor("#1a2947"));

        mImgStatistics.setImageResource(R.mipmap.ic_statistics_selected);
        mTxtStatistics.setTextColor(Color.parseColor("#FFFFFF"));

        mImgAccount.setImageResource(R.mipmap.ic_account);
        mTxtAccount.setTextColor(Color.parseColor("#1a2947"));

        mImgLogout.setImageResource(R.mipmap.ic_logout);
        mTxtLogout.setTextColor(Color.parseColor("#1a2947"));
    }

    private void setPageAccount() {
        mImgTable.setImageResource(R.mipmap.ic_table);
        mTxtTable.setTextColor(Color.parseColor("#1a2947"));

        mImgStatistics.setImageResource(R.mipmap.ic_statistics);
        mTxtStatistics.setTextColor(Color.parseColor("#1a2947"));

        mImgAccount.setImageResource(R.mipmap.ic_account_selected);
        mTxtAccount.setTextColor(Color.parseColor("#FFFFFF"));

        mImgLogout.setImageResource(R.mipmap.ic_logout);
        mTxtLogout.setTextColor(Color.parseColor("#1a2947"));
    }

    private void setPageLogout() {
        mImgTable.setImageResource(R.mipmap.ic_table);
        mTxtTable.setTextColor(Color.parseColor("#1a2947"));

        mImgStatistics.setImageResource(R.mipmap.ic_statistics);
        mTxtStatistics.setTextColor(Color.parseColor("#1a2947"));

        mImgAccount.setImageResource(R.mipmap.ic_account);
        mTxtAccount.setTextColor(Color.parseColor("#1a2947"));

        mImgLogout.setImageResource(R.mipmap.ic_logout_selected);
        mTxtLogout.setTextColor(Color.parseColor("#FFFFFF"));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_button_table:
                setPageTable();
                mViewPager.setCurrentItem(0);
                break;
            case R.id.ll_button_statistics:
                setPageStatistics();
                mViewPager.setCurrentItem(1);
                break;
            case R.id.ll_button_account:
                mViewPager.setCurrentItem(2);
                setPageAccount();
                break;
            case R.id.ll_button_logout:
                mViewPager.setCurrentItem(3);
                setPageLogout();
                break;
        }
    }
}