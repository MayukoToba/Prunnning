package com.example.owner.keikaku;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String > mstring;
    SubjectAdapter mSubjectAdapter;
    ListView mlistView;

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mlistView = (ListView)findViewById(R.id.listView);
        mstring = new ArrayList<String>();

        mstring.add(new String(getString(R.string.math_title)));

        mSubjectAdapter = new SubjectAdapter(this,R.layout.card,mstring);
        mlistView.setAdapter(mSubjectAdapter);

        //(Button)findViewById(R.id.drawer_button)).setOnClickListener(this);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer,
                R.drawable.ic_drawer, R.string.drawer_open,
                R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                // ActionBarDrawerToggleクラス内の同メソッドにてアイコンのアニメーションの処理をしている。
                // overrideするときは気を付けること。
                super.onDrawerSlide(drawerView, slideOffset);

            }

            @Override
            public void onDrawerStateChanged(int newState) {
                // 表示済み、閉じ済みの状態：0
                // ドラッグ中状態:1
                // ドラッグを放した後のアニメーション中：2

            }
        };

        mDrawer.setDrawerListener(mDrawerToggle);

        // UpNavigationアイコン(アイコン横の<の部分)を有効に
        // NavigationDrawerではR.drawable.drawerで上書き
        getActionBar().setDisplayHomeAsUpEnabled(true);
        // UpNavigationを有効に
        getActionBar().setHomeButtonEnabled(true);







    }
}
