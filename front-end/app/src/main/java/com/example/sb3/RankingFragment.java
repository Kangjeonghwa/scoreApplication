package com.example.sb3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class RankingFragment extends Fragment {
    //버튼
    private Button rankAllBtn;
    private Button rankGameBtn;
    private boolean rAllb=true, rgameb=true;

    //리사이클러 뷰
    private RecyclerView rankingrecyclerView;

    public static RankingFragment newInstance(){
        return new RankingFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rankingView=(ViewGroup) inflater.inflate(R.layout.ranking_fragment,container,false);

        //컴포넌트 초기화화
        //리사이클러 뷰
        rankingrecyclerView=(RecyclerView)rankingView.findViewById(R.id.ranking_recyclerView);

        //버튼
        rankAllBtn=(Button) rankingView.findViewById(R.id.ranking_all_btn);
        rankGameBtn=(Button) rankingView.findViewById(R.id.ranking_game_btn);

        //all, game 버튼 색 변경
        rankAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rAllb==false){
                    rankGameBtn.setTextColor(Color.parseColor("#747474"));
                    rgameb=false;
                    rankAllBtn.setTextColor(Color.parseColor("#3268fd"));
                    rAllb=true;
                }
            }
        });
        rankGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rgameb==false){
                    rankAllBtn.setTextColor(Color.parseColor("#747474"));
                    rAllb=false;
                    rankGameBtn.setTextColor(Color.parseColor("#3268fd"));
                    rgameb=true;
                }
            }
        });

        //리사이클러 뷰 설정
        /*LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
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

        rankingrecyclerView.setAdapter(rankingAdapter);*/

        return rankingView;
    }
}
