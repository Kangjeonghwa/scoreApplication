package com.example.sb3;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainFragment extends Fragment{
    //리사이클러 뷰
    private RecyclerView recyclerView;
    ArrayList<ScoreItem> ScoreItems=new ArrayList<ScoreItem>();

    //버튼
    private Button Allbtn, Gamebtn, Playerbtn;
    private boolean allb=true, gameb=false, playerb=false;
    private Button Searchbtn;
    private Button DateSortbtn, GameSortbtn;
    private boolean dateb=false, gamesb=false;

    //검색어 입력
    private EditText searchText;
    private String searchtext;
    private ArrayList<ScoreItem> gameFilteritems=new ArrayList<ScoreItem>();
    private ArrayList<ScoreItem> playerFilteritems=new ArrayList<ScoreItem>();

    public static MainFragment newInstance(){
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView=(ViewGroup) inflater.inflate(R.layout.main_fragment, container,false);

        //컴포넌트 초기화화
        //리사이클러 뷰
        recyclerView = (RecyclerView) rootView.findViewById(R.id.main_recyclerView);
        //리사이클러 뷰 데이터 (임시)
        ScoreItems.add(new ScoreItem("10.12","soccer","gabe","jane","3","2"));
        ScoreItems.add(new ScoreItem("10.12","soccer","james","rop","2","2"));
        ScoreItems.add(new ScoreItem("10.13","soccer","gabe","jennie","1","2"));
        ScoreItems.add(new ScoreItem("10.27","baseball","gabe","lucy","3","2"));
        ScoreItems.add(new ScoreItem("10.31","basketball","alex","jane","3","2"));
        ScoreItems.add(new ScoreItem("11.01","rocksissorpaper","james","jane","2","2"));
        ScoreItems.add(new ScoreItem("11.09","table tennis","cloy","anna","1","2"));
        ScoreItems.add(new ScoreItem("12.12","baseball","jake","jane","3","2"));
        ScoreItems.add(new ScoreItem("12.12","soccer","gabe","jane","3","2"));
        ScoreItems.add(new ScoreItem("12.13","soccer","james","rop","2","2"));
        ScoreItems.add(new ScoreItem("12.13","hockey","gabe","jennie","1","2"));
        ScoreItems.add(new ScoreItem("12.27","baseball","gabe","lucy","3","2"));
        ScoreItems.add(new ScoreItem("12.31","basketball","alex","jane","3","2"));
        ScoreItems.add(new ScoreItem("12.01","rocksissorpaper","james","jane","2","2"));
        ScoreItems.add(new ScoreItem("01.09","table tennis","cloy","anna","1","2"));
        ScoreItems.add(new ScoreItem("02.12","baseball","jake","jane","3","2"));


        //버튼
        Allbtn = (Button) rootView.findViewById(R.id.main_all_btn);
        Gamebtn = (Button) rootView.findViewById(R.id.main_game_btn);
        Playerbtn = (Button) rootView.findViewById(R.id.main_player_btn);
        Searchbtn = (Button) rootView.findViewById(R.id.search_player_btn);
        DateSortbtn = (Button) rootView.findViewById(R.id.dateSort_btn);
        GameSortbtn = (Button) rootView.findViewById(R.id.gameSort_btn);

        //리사이클러 뷰 설정
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);   //getActivity 사용
        recyclerView.setLayoutManager(layoutManager);

        ScoreAdapter scoreAdapter=new ScoreAdapter(getActivity());      //getActivity 사용

        //임시 data
        /*scoreAdapter.addItem(new ScoreItem("10/12","soccer","gabe","jane","3","2"));
        scoreAdapter.addItem(new ScoreItem("10/12","soccer","james","rop","2","2"));
        scoreAdapter.addItem(new ScoreItem("10/13","soccer","gabe","jennie","1","2"));
        scoreAdapter.addItem(new ScoreItem("10/27","baseball","gabe","lucy","3","2"));
        scoreAdapter.addItem(new ScoreItem("10/31","basketball","alex","jane","3","2"));
        scoreAdapter.addItem(new ScoreItem("11/1","rocksissorpaper","james","jane","2","2"));
        scoreAdapter.addItem(new ScoreItem("11/9","table tennis","cloy","anna","1","2"));
        scoreAdapter.addItem(new ScoreItem("12/12","baseball","jake","jane","3","2"));
        scoreAdapter.addItem(new ScoreItem("12/12","soccer","gabe","jane","3","2"));
        scoreAdapter.addItem(new ScoreItem("12/13","soccer","james","rop","2","2"));
        scoreAdapter.addItem(new ScoreItem("12/13","hockey","gabe","jennie","1","2"));
        scoreAdapter.addItem(new ScoreItem("12/27","baseball","gabe","lucy","3","2"));
        scoreAdapter.addItem(new ScoreItem("12/31","basketball","alex","jane","3","2"));
        scoreAdapter.addItem(new ScoreItem("12/1","rocksissorpaper","james","jane","2","2"));
        scoreAdapter.addItem(new ScoreItem("1/9","table tennis","cloy","anna","1","2"));
        scoreAdapter.addItem(new ScoreItem("2/12","baseball","jake","jane","3","2"));*/
        scoreAdapter.addItems(ScoreItems);


        recyclerView.setAdapter(scoreAdapter);

        //all,game,player 버튼 색 변경
        Allbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(allb==false){
                    Gamebtn.setTextColor(Color.parseColor("#747474"));
                    gameb=false;
                    Playerbtn.setTextColor(Color.parseColor("#747474"));
                    playerb=false;
                    Allbtn.setTextColor(Color.parseColor("#3268fd"));
                    allb=true;

                    //필터링 안된 스코어리스트
                    scoreAdapter.addItems(ScoreItems);
                    recyclerView.setAdapter(scoreAdapter);
                }
            }
        });
        Gamebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameb==false){
                    Allbtn.setTextColor(Color.parseColor("#747474"));
                    allb=false;
                    Playerbtn.setTextColor(Color.parseColor("#747474"));
                    playerb=false;
                    Gamebtn.setTextColor(Color.parseColor("#3268fd"));
                    gameb=true;
                }
            }
        });
        Playerbtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if(playerb==false){
                    Allbtn.setTextColor(Color.parseColor("#747474"));
                    allb=false;
                    Gamebtn.setTextColor(Color.parseColor("#747474"));
                    gameb=false;
                    Playerbtn.setTextColor(Color.parseColor("#3268fd"));
                    playerb=true;
                }
            }
        });

        //검색 버튼
        searchText=(EditText) rootView.findViewById(R.id.main_search_textbox);
        Searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchtext= String.valueOf(searchText.getText());

                if(gameb){
                    //게임 버튼이 선택되었을 때, 검색어로 게임필터링
                    searchFilterGame(searchtext);
                }else if(playerb){
                    //플레이어 버튼이 선택되었을 때, 검색어로 게임필터링
                    searchFilterPlayer(searchtext);
                }

                //입력 초기화
                searchText.setText(null);
            }
        });

        //date, game 정렬 버튼
        DateSortbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dateb==false){
                    DateSortbtn.setBackgroundResource(R.drawable.sortbutton_down);
                    dateb=true;

                    //날짜 오름차순 정렬
                    Collections.sort(ScoreItems, new Comparator<ScoreItem>(){
                        @Override
                        public int compare(ScoreItem i1, ScoreItem i2) {
                            int i = i1.getDate().compareTo(i2.getDate());
                            return i;
                        }
                    });
                    recyclerView.setAdapter(scoreAdapter);

                }else{
                    DateSortbtn.setBackgroundResource(R.drawable.sortbutton_up);
                    dateb=false;

                    //날짜 내림차순 정렬
                    Collections.sort(ScoreItems, new Comparator<ScoreItem>(){
                        @Override
                        public int compare(ScoreItem i1, ScoreItem i2) {
                            int i = i2.getDate().compareTo(i1.getDate());
                            return i;
                        }
                    });
                    recyclerView.setAdapter(scoreAdapter);
                }
            }
        });
        GameSortbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gamesb==false){
                    GameSortbtn.setBackgroundResource(R.drawable.sortbutton_down);
                    gamesb=true;

                    //게임이름 오름차순 정렬
                    Collections.sort(ScoreItems, new Comparator<ScoreItem>(){
                        @Override
                        public int compare(ScoreItem i1, ScoreItem i2) {
                            int i = i1.getGame().compareTo(i2.getGame());
                            return i;
                        }
                    });
                    recyclerView.setAdapter(scoreAdapter);

                }else{
                    GameSortbtn.setBackgroundResource(R.drawable.sortbutton_up);
                    gamesb=false;

                    //게임이름 내림차순 정렬
                    Collections.sort(ScoreItems, new Comparator<ScoreItem>(){
                        @Override
                        public int compare(ScoreItem i1, ScoreItem i2) {
                            int i = i2.getGame().compareTo(i1.getGame());
                            return i;
                        }
                    });
                    recyclerView.setAdapter(scoreAdapter);

                }
            }
        });
        
        return rootView;
    }

    //검색어로 게임필터링
    public void searchFilterGame(String searchtext){
        gameFilteritems.clear();

        for(int i=0;i<ScoreItems.size();i++){
            if(ScoreItems.get(i).getGame().toLowerCase().contains(searchtext.toLowerCase())){
                gameFilteritems.add(ScoreItems.get(i));
            }
        }
        ScoreAdapter gameFilteredScoreAdapter=new ScoreAdapter(getActivity());
        gameFilteredScoreAdapter.addItems(gameFilteritems);
        recyclerView.setAdapter(gameFilteredScoreAdapter);

    }

    //검색어로 플레이어 필터링
    public void searchFilterPlayer(String searchtext){
        playerFilteritems.clear();

        for(int i=0;i<ScoreItems.size();i++){
            if(ScoreItems.get(i).getPlayer1().toLowerCase().contains(searchtext.toLowerCase())){
                playerFilteritems.add(ScoreItems.get(i));
            }else if(ScoreItems.get(i).getPlayer2().toLowerCase().contains(searchtext.toLowerCase())){
                playerFilteritems.add(ScoreItems.get(i));
            }
        }
        ScoreAdapter playerFilteredScoreAdapter=new ScoreAdapter(getActivity());
        playerFilteredScoreAdapter.addItems(playerFilteritems);
        recyclerView.setAdapter(playerFilteredScoreAdapter);

    }
}
