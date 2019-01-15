package com.mvcoder.materialdesignlibdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.util.ToastUtils;
import com.jaeger.library.StatusBarUtil;
import com.mvcoder.materialdesignlibdemo.coordinarylayout.CoordinaryLayou2tActivity;
import com.mvcoder.materialdesignlibdemo.coordinarylayout.CoordinaryLayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.constraint_layout)
    ConstraintLayout constraintLayout;
    @BindView(R.id.design_navigation_view)
    NavigationView navigationView;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.bt1)
    Button bt1;
    @BindView(R.id.bt2)
    Button bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        StatusBarUtil.setColorForDrawerLayout(this, drawerlayout, getResources().getColor(R.color.colorPrimary), 0);
        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        NavigationMenuView menuView = (NavigationMenuView) navigationView.getChildAt(0);
        if (menuView != null) {
            menuView.setVerticalScrollBarEnabled(false);
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                String menuTitle = menuItem.getTitle().toString();
                ToastUtils.showShort("menuId : " + id + " , menuTitle : " + menuTitle);
                Menu menu = navigationView.getMenu();
                for (int i = 0; i < menu.size(); i++) {
                    MenuItem item = menu.getItem(i);
                    if (item.getItemId() == menuItem.getItemId()) {
                        item.setChecked(true);
                    } else {
                        item.setChecked(false);
                    }
                }
                drawerlayout.closeDrawer(Gravity.START);
                return true;
            }
        });
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                drawerlayout.openDrawer(Gravity.START);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerlayout.isDrawerOpen(Gravity.START)) {
            drawerlayout.closeDrawer(Gravity.START);
        } else {
            super.onBackPressed();
        }
    }


    @OnClick({R.id.bt1, R.id.bt2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt1:
                joinToCoordinaryLayout();
                break;
            case R.id.bt2:
                joinToSecondCoordinaryLayout();
                break;
        }
    }

    private void joinToCoordinaryLayout(){
        Intent intent = new Intent(this, CoordinaryLayoutActivity.class);
        startActivity(intent);
    }

    private void joinToSecondCoordinaryLayout(){
        Intent intent = new Intent(this, CoordinaryLayou2tActivity.class);
        startActivity(intent);
    }

}
