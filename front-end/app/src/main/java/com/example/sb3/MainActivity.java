package com.example.sb3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity{
    //툴바
    private TextView toolbarTitle;
    private Toolbar toolbar;
    private ActionBar actionbar;
    private DrawerLayout mDrawerLayout;
    private Context context = this;  //토스트를 위한 컨텍스트...?
    private NavigationView navigationView;

    //프레그먼트
    private FragmentManager fragmentManager;
    private MainFragment mainFragment;
    private FragmentTransaction transaction;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();

        //툴바 설정
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();
        actionbar.setDisplayShowTitleEnabled(false); //기존 타이틀 지우기
        actionbar.setDisplayHomeAsUpEnabled(true);  //뒤로가기 버튼 만들기
        actionbar.setHomeAsUpIndicator(R.drawable.menubutton);  //뒤로가기 버튼 지정(이미지)

        //프레그먼트
        fragmentManager=getSupportFragmentManager();

        mainFragment=new MainFragment();

        transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.main_fragment_container, MainFragment.newInstance()).commit();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                mDrawerLayout.closeDrawers();  //드로어 숨기기

                //확인용
                int id=item.getItemId();
                String title = item.getTitle().toString();

                //
                FragmentTransaction ft = fragmentManager.beginTransaction();

                if(id==R.id.ranking){
                    currentFragment=fragmentManager.findFragmentById(R.id.main_fragment_container);
                    ft.remove(currentFragment);     //아마 이거 아닐까...오류의 문제...이거 제거해야할듯;;
                    toolbarTitle.setText("RANKING BEST");

                    ft.add(R.id.main_fragment_container, new Ranking2Fragment()).commit();
                }else if(id==R.id.scoreedit){
                    currentFragment=fragmentManager.findFragmentById(R.id.main_fragment_container);
                    ft.remove(currentFragment);
                    toolbarTitle.setText("SCORE EDIT");

                    ft.add(R.id.main_fragment_container, new ScoreEditFragment()).commit();
                }else if(id==R.id.gamemanagement){
                    currentFragment=fragmentManager.findFragmentById(R.id.main_fragment_container);
                    ft.remove(currentFragment);
                    toolbarTitle.setText("GAME MANAGEMENT");

                    ft.add(R.id.main_fragment_container, new GameManagementFragment()).commit();
                }else if(id==R.id.newplayer){
                    currentFragment=fragmentManager.findFragmentById(R.id.main_fragment_container);
                    ft.remove(currentFragment);
                    toolbarTitle.setText("NEW PLAYER");

                    ft.add(R.id.main_fragment_container, new NewPlayerFragment()).commit();
                }

                return true;
            }
        });

    }


    public void onBackPressed() {
        currentFragment=fragmentManager.findFragmentById(R.id.main_fragment_container);
        FragmentTransaction ft = fragmentManager.beginTransaction();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        
        //메인 페이지 돌아가기
        if(currentFragment!=mainFragment){
            ft.remove(currentFragment);
            ft.add(R.id.main_fragment_container, new MainFragment()).commit();
            toolbarTitle.setText("SCORE BOARD");
        }
        else {
            super.onBackPressed();
        }
    
        //드로어 닫기
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    //상단 메뉴 버튼으로 메뉴 드로어 열기
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home: mDrawerLayout.openDrawer(GravityCompat.START); return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void initComponent(){
        //툴바
        toolbarTitle=(TextView) findViewById(R.id.toolbar_title);
        toolbar =(Toolbar) findViewById(R.id.toolbar_main);
        mDrawerLayout=(DrawerLayout) findViewById(R.id.main_drawer_layout);
        navigationView=(NavigationView) findViewById(R.id.nav_view);
    }
}