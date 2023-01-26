package com.example.sb3;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class NewPlayerFragment extends Fragment {
    //버튼
    private Button createPlayerBtn;
    private Button maleBtn;
    private Button femaleBtn;
    private boolean maleb=true, femaleb=false;

    //에디트텍스트
    private EditText newPlayerID, newPlayerAge;
    private String newplayerid, newplayerage, newplayersex;

    /*public NewPlayerFragment() {
        // Required empty public constructor
    }*/

    // TODO: Rename and change types and number of parameters
    public static NewPlayerFragment newInstance(String param1, String param2) {
        return new NewPlayerFragment();
    }

   /* @Override
    public void onCreate(Bundle savedInstanceState) {
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup newPlayerView= (ViewGroup) inflater.inflate(R.layout.fragment_new_player, container, false);

        //버튼
        maleBtn=(Button) newPlayerView.findViewById(R.id.newplayer_male_btn);
        femaleBtn=(Button) newPlayerView.findViewById(R.id.newplayer_female_btn);
        createPlayerBtn= (Button) newPlayerView.findViewById(R.id.newplayer_create_player_btn);

        //male, female 버튼 색변환
        maleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!maleb){
                    femaleBtn.setTextColor(Color.parseColor("#747474"));
                    femaleb=false;
                    maleb=true;
                    maleBtn.setTextColor(Color.parseColor("#3268fd"));
                }
            }
        });
        femaleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!femaleb){
                    maleBtn.setTextColor(Color.parseColor("#747474"));
                    maleb=false;
                    femaleb=true;
                    femaleBtn.setTextColor(Color.parseColor("#3268fd"));
                }
            }
        });

        //새 플레이어 아이디, 나이, 성별 받아오기
        newPlayerID = (EditText) newPlayerView.findViewById(R.id.newplayer_id);
        newPlayerAge = (EditText) newPlayerView.findViewById(R.id.newplayer_age);

        createPlayerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newplayerid=String.valueOf(newPlayerID.getText());
                newplayerage=String.valueOf(newPlayerAge.getText());
                if(maleb){
                    newplayersex="male";
                }else{
                    newplayersex="female";
                }

                //입력 초기화
                newPlayerID.setText(null);
                newPlayerAge.setText(null);
                maleb=true; femaleb=false;
                maleBtn.setTextColor(Color.parseColor("#3268fd"));
                femaleBtn.setTextColor(Color.parseColor("#747474"));

                //아이디, 나이, 성별 전달하기

            }
        });



       return newPlayerView;
    }
}