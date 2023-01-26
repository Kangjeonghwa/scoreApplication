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

    //스피너
    private Spinner gameSpinner;
    private ArrayAdapter<String> gameSpinnerAdapter;
    private String selectedGame;

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
                Toast.makeText(getActivity(), selectedGame, Toast.LENGTH_LONG).show();
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

        //리사이클러 뷰 설정
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rankingrecyclerView.setLayoutManager(layoutManager);

        RankingAdapter rankingAdapter=new RankingAdapter(getActivity());

        //임시 data
        rankingAdapter.addItem(new RankingItem("1", "125","James"));
        rankingAdapter.addItem(new RankingItem("2", "123","jUNE"));
        rankingAdapter.addItem(new RankingItem("3", "102","Jenny"));
        rankingAdapter.addItem(new RankingItem("4", "99","ADAM"));
        rankingAdapter.addItem(new RankingItem("5", "86","LISA"));
        rankingAdapter.addItem(new RankingItem("6", "75","GABE"));
        rankingAdapter.addItem(new RankingItem("7", "55","JANE"));
        rankingAdapter.addItem(new RankingItem("8", "43","BILLIE"));
        rankingAdapter.addItem(new RankingItem("9", "37","ANNA"));
        rankingAdapter.addItem(new RankingItem("10", "22","JACK"));
        rankingAdapter.addItem(new RankingItem("11", "20","DANIEL"));
        rankingAdapter.addItem(new RankingItem("12", "19","DAVID"));
        rankingAdapter.addItem(new RankingItem("13", "17","SONYA"));
        rankingAdapter.addItem(new RankingItem("14", "16","AMY"));

        rankingrecyclerView.setAdapter(rankingAdapter);



        // Inflate the layout for this fragment
        return rankingView;
    }
}