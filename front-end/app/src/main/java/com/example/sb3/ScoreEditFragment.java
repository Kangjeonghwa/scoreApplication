package com.example.sb3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ScoreEditFragment extends Fragment {
    //스피너
    private Spinner gameSpinner1, player1Spinner, player2Spinner, gameSpinner2, scoreListSpinner;
    private ArrayAdapter<String> gameSpinnerAdapter, player1SpinnerAdapter, player2SpinnerAdapter, gameSpinnerAdapter2, scoreListSpinnerAdapter;
    private String selectedGame1, selectedPlayer1, selectedPlayer2, selectedGame2, selectedScoreItem;

    //게임 스피너 임시 데이터
    private static String[] games=new String[]{"SOCCER","TENNIS", "TABLE TENNIS", "BASEBALL", "BASKETBALL", "HOCKEY","VOLLEYBALL"};

    //player 스피너 임시 데이터
    private static String[] players=new String[]{"gabe","jane","james","rop","jennie","lucy","alex","cloy","anna","Billie","bob","adam","june","lisa","jack","Daniel","sonya","amy","john"};

    //스코어 리스트 임시 데이터
    private static String[] scoreList=new String[]{"gabe:jane   3:2","james:rop   2:2", "gabe:jennie   1:2","gabe:lucy   3:2", "alex:jane   3:2", "james:jane   2:2", "cloy:anna   1:2", "jake:jane   3:2", "gabe:jane   3:2", "james:rop   2:2", "gabe:jennie   1:2", "gabe:lucy   3:2", "alex:jane   3:2"};

    //새 스코어 에디트텍스트, 버튼
    private EditText player1Score, player2Score;
    private String player1score, player2score;
    private Button addNewScoreBtn;


    //스코어 삭제 에디트 텍스트, 버튼
    private EditText dateMonth, dateDay;
    private String datemonth, dateday;
    private Button deleteScoreBtn;


    public ScoreEditFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ScoreEditFragment newInstance(String param1, String param2) {

        return new ScoreEditFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup scoreEditView = (ViewGroup) inflater.inflate(R.layout.fragment_score_edit, container, false);

        //게임 스피너1
        gameSpinner1 = (Spinner) scoreEditView.findViewById(R.id.scoreedit_game_dropdown1);
        gameSpinnerAdapter =new ArrayAdapter<String>(
                getActivity(), R.layout.spinner_text_selected, games    //프래그먼트에서는 getActivity()로 컨텍스트 가져오는거 잊지말기
        );
        gameSpinnerAdapter.setDropDownViewResource(R.layout.spinner_text);
        gameSpinner1.setAdapter(gameSpinnerAdapter);

        gameSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedGame1 = games[i];
                Toast.makeText(getActivity(), selectedGame1, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //player1 스피너
        player1Spinner = (Spinner) scoreEditView.findViewById(R.id.scoreedit_player1_name);
        player1SpinnerAdapter =new ArrayAdapter<String>(
                getActivity(), R.layout.spinner_text_selected3, players    //프래그먼트에서는 getActivity()로 컨텍스트 가져오는거 잊지말기
        );
        player1SpinnerAdapter.setDropDownViewResource(R.layout.spinner_text3);
        player1Spinner.setAdapter(player1SpinnerAdapter);

        player1Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedPlayer1 = players[i];
                Toast.makeText(getActivity(), selectedPlayer1, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //player2 스피너
        player2Spinner = (Spinner) scoreEditView.findViewById(R.id.scoreedit_player2_name);
        player2SpinnerAdapter =new ArrayAdapter<String>(
                getActivity(), R.layout.spinner_text_selected3, players    //프래그먼트에서는 getActivity()로 컨텍스트 가져오는거 잊지말기
        );
        player2SpinnerAdapter.setDropDownViewResource(R.layout.spinner_text3);
        player2Spinner.setAdapter(player2SpinnerAdapter);

        player2Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedPlayer2 = players[i];
                Toast.makeText(getActivity(), selectedPlayer2, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //새 스코어 입력
        player1Score = (EditText) scoreEditView.findViewById(R.id.scoreedit_player1_score);
        player2Score = (EditText) scoreEditView.findViewById(R.id.scoreedit_player2_score);

        addNewScoreBtn=(Button) scoreEditView.findViewById(R.id.add_new_score_btn);

        addNewScoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player1score=String.valueOf(player1Score.getText());
                player2score=String.valueOf(player2Score.getText());

                //입력 초기화
                gameSpinner1.setSelection(0);
                player1Spinner.setSelection(0);
                player2Spinner.setSelection(0);
                player1Score.setText(null);
                player2Score.setText(null);

                //게임, 플레이어 이름, 점수 등 스코어보드에 추가

            }
        });


        //게임 스피너2
        gameSpinner2 = (Spinner) scoreEditView.findViewById(R.id.scoreedit_game_dropdown2);
        gameSpinnerAdapter2 =new ArrayAdapter<String>(
                getActivity(), R.layout.spinner_text_selected, games
        );
        gameSpinnerAdapter2.setDropDownViewResource(R.layout.spinner_text);
        gameSpinner2.setAdapter(gameSpinnerAdapter2);

        gameSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedGame2 =games[i];
                Toast.makeText(getActivity(), selectedGame2, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //스코어리스트 스피너
        scoreListSpinner = (Spinner) scoreEditView.findViewById(R.id.scoreedit_scorelist_dropdown);
        scoreListSpinnerAdapter=new ArrayAdapter<String>(
                getActivity(), R.layout.spinner_text_selected, scoreList
        );
        scoreListSpinnerAdapter.setDropDownViewResource(R.layout.spinner_text);
        scoreListSpinner.setAdapter(scoreListSpinnerAdapter);

        scoreListSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedScoreItem=scoreList[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //스코어 삭제
        dateMonth = (EditText) scoreEditView.findViewById(R.id.scoreedit_date_month);
        dateDay=(EditText)scoreEditView.findViewById(R.id.scoreedit_date_day);

        deleteScoreBtn = (Button) scoreEditView.findViewById(R.id.delete_score_btn);

        deleteScoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datemonth=String.valueOf(dateMonth.getText());
                dateday=String.valueOf(dateDay.getText());

                //입력 초기화
                gameSpinner2.setSelection(0);
                dateMonth.setText(null);
                dateDay.setText(null);
                scoreListSpinner.setSelection(0);

                //게임과 날짜에 해당하는 게임 리스트 중 골라서 삭제

            }
        });

        return scoreEditView;
    }
}