package jiyun.lwj.com.mvp;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import java.util.ArrayList;

import jiyun.lwj.com.mvp.base.BaseActivity;
import jiyun.lwj.com.mvp.fragment.RibaoFragment;
import jiyun.lwj.com.mvp.fragment.WeixinFragment;
import jiyun.lwj.com.mvp.presenter.MainPresenter;
import jiyun.lwj.com.mvp.view.MainView;

public class MainActivity extends BaseActivity<MainView, MainPresenter> implements MainView {

    private Toolbar mToolbar;
    private FrameLayout mMainContainer;
    private NavigationView mNv;
    private DrawerLayout mDl;

    int Last_type ;
    int type_ribao = 0;
    int type_weixin = 1;
    private FragmentManager mManager;
    private ArrayList<Fragment> mFragments;


    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        //碎片管理器
        mManager = getSupportFragmentManager();

        mMainContainer = (FrameLayout) findViewById(R.id.main_container);
        mNv = (NavigationView) findViewById(R.id.nv);
        mDl = (DrawerLayout) findViewById(R.id.dl);
        mToolbar = (Toolbar) findViewById(R.id.main_toolb);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDl, mToolbar, R.string.app_name, R.string.app_name);
        mDl.addDrawerListener(toggle);
        toggle.syncState();

        FragmentTransaction transaction = mManager.beginTransaction();
        transaction.add(R.id.main_container,mFragments.get(0));
        transaction.commit();
    }

    @Override
    protected void initData() {
        super.initData();
        mFragments = new ArrayList<>();
        mFragments.add(new RibaoFragment());
        mFragments.add(new WeixinFragment());
    }

    @Override
    protected void initListener() {
        super.initListener();
        //侧滑图片显示正常
        mNv.setItemIconTintList(null);
        mNv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                switch (item.getItemId()) {
                    case R.id.ribao:
                        switchFragment(type_ribao);
                        break;
                    case R.id.weixin:
                        switchFragment(type_weixin);
                        break;
                }
                //关闭侧滑
                mDl.closeDrawer(Gravity.LEFT);
                return false;
            }
        });
    }

    private void switchFragment(int type_ribao) {
        FragmentTransaction transaction = mManager.beginTransaction();
        Fragment fragment = mFragments.get(type_ribao);
        if(!fragment.isAdded()){
            transaction.add(R.id.main_container,fragment);
        }
        Last_type = type_ribao;
        transaction.hide(mFragments.get(Last_type));
        transaction.show(fragment);

        transaction.commit();
    }

}
