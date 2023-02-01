package com.example.sb3;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/*
 * A simple {@link Fragment} subclass.
 * Use the {@link Ranking2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Ranking2Fragment extends Fragment {
    //버튼
    private Button rankAllBtn;
    private Button rankGameBtn;
    private boolean rAllb=true, rgameb=false;

    //리사이클러 뷰
    private RecyclerView rankingrecyclerView;
    ArrayList<RankingItem> RankingItems=new ArrayList<RankingItem>();

    //스피너
    private Spinner gameSpinner;
    private ArrayAdapter<String> gameSpinnerAdapter;
    private String selectedGame;
    private ArrayList<RankingItem> spinnerFilteritems=new ArrayList<RankingItem>();

    //게임 스피너 임시 데이터
    private static String[] items=new String[]{"SOCCER","TENNIS", "TABLE TENNIS", "BASEBALL", "BASKETBALL", "HOCKEY","VOLLEYBALL"};

    // TODO: Rename and change types and number of parameters
    public static Ranking2Fragment newInstance() {
        return new Ranking2Fragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rankingView=(ViewGroup) inflater.inflate(R.layout.fragment_ranking2,container,false);

        //컴포넌트 초기화화
        //리사이클러 뷰
        rankingrecyclerView=(RecyclerView)rankingView.findViewById(R.id.ranking2_recyclerView);

        //버튼
        rankAllBtn=(Button) rankingView.findViewById(R.id.ranking2_all_btn);
        rankGameBtn=(Button) rankingView.findViewById(R.id.ranking2_game_btn);

        //리사이클러 뷰 설정
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rankingrecyclerView.setLayoutManager(layoutManager);

        RankingAdapter rankingAdapter=new RankingAdapter(getActivity());

        //임시 data
        RankingItems.add(new RankingItem("1", "125","James"));
        RankingItems.add(new RankingItem("2", "123","jUNE"));
        RankingItems.add(new RankingItem("3", "102","Jennie"));
        RankingItems.add(new RankingItem("4", "99","ADAM"));
        RankingItems.add(new RankingItem("5", "86","LISA"));
        RankingItems.add(new RankingItem("6", "75","GABE"));
        RankingItems.add(new RankingItem("7", "55","JANE"));
        RankingItems.add(new RankingItem("8", "43","BILLIE"));
        RankingItems.add(new RankingItem("9", "37","ANNA"));
        RankingItems.add(new RankingItem("10", "22","JACK"));
        RankingItems.add(new RankingItem("11", "20","DANIEL"));
        RankingItems.add(new RankingItem("12", "19","DAVID"));
        RankingItems.add(new RankingItem("13", "17","SONYA"));
        RankingItems.add(new RankingItem("14", "16","AMY"));

        rankingAdapter.addItems(RankingItems);

        rankingrecyclerView.setAdapter(rankingAdapter);

        //게임 스피너
        gameSpinner=(Spinner) rankingView.findViewById(R.id.ranking2_game_dropdown);
        gameSpinnerAdapter =new ArrayAdapter<String>(
                getActivity(), R.layout.spinner_text_selected2, items    //프래그먼트에서는 getActivity()로 컨텍스트 가져오는거 잊지말기
        );
        gameSpinnerAdapter.setDropDownViewResource(R.layout.spinner_text2);
        gameSpinner.setAdapter(gameSpinnerAdapter);

        gameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedGame = items[i];
                //Toast.makeText(getActivity(), selectedGame, Toast.LENGTH_LONG).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        gameSpinner.setVisibility(View.INVISIBLE);

        //all, game 버튼 색 변경
        rankAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!rAllb){
                    rankGameBtn.setTextColor(Color.parseColor("#747474"));
                    rgameb=false;
                    rAllb=true;
                    rankAllBtn.setTextColor(Color.parseColor("#3268fd"));

                    gameSpinner.setVisibility(View.INVISIBLE);
                }
            }
        });
        rankGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!rgameb){
                    rankAllBtn.setTextColor(Color.parseColor("#747474"));
                    rAllb=false;
                    rankGameBtn.setTextColor(Color.parseColor("#3268fd"));
                    rgameb=true;

                    gameSpinner.setVisibility(View.VISIBLE);
                }
            }
        });





        // Inflate the layout for this fragment
        return rankingView;
    }

    //스피너 선택 게임으로 게임필터링
    public void spinnerFilterGame(String selectedGame){
        spinnerFilteritems.clear();

        for(int i=0;i<RankingItems.size();i++){
            if(RankingItems.get(i).getGame().toLowerCase().contains(selectedGame.toLowerCase())){
                spinnerFilteritems.add(RankingItems.get(i));
            }
        }
        RankingAdapter spinnerFilteredScoreAdapter=new RankingAdapter(getActivity());
        spinnerFilteredScoreAdapter.addItems(spinnerFilteritems);
        rankingrecyclerView.setAdapter(spinnerFilteredScoreAdapter);

    }
}