package com.example.sb3;

import android.os.Bundle;

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


public class GameManagementFragment extends Fragment {
    //게임 스피너
    private Spinner gameSpinner;
    private ArrayAdapter<String> gameSpinnerAdapter;
    private String selectedGame;

    //게임 스피너 임시 데이터
    private static String[] items=new String[]{"SOCCER","TENNIS", "TABLE TENNIS", "BASEBALL", "BASKETBALL", "HOCKEY","VOLLEYBALL"};

    //버튼, 에디트텍스트
    private Button addNewGameBtn, editGameBtn;
    private EditText newGame, editGame;
    private String newgame, editgame;

    public GameManagementFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static GameManagementFragment newInstance(String param1, String param2) {

        return new GameManagementFragment();
    }

    /*@Override
    public void onCreate(Bundle savedInstanceState) {

    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup gameManagementView = (ViewGroup) inflater.inflate(R.layout.fragment_game_management, container, false);
        // Inflate the layout for this fragment

        //게임 스피너
        gameSpinner=(Spinner) gameManagementView.findViewById(R.id.gamemanagement_game_dropdown);
        gameSpinnerAdapter =new ArrayAdapter<String>(
                getActivity(), R.layout.spinner_text_selected, items    //프래그먼트에서는 getActivity()로 컨텍스트 가져오는거 잊지말기
        );
        gameSpinnerAdapter.setDropDownViewResource(R.layout.spinner_text);
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

        //새 게임 입력
        newGame = (EditText) gameManagementView.findViewById(R.id.gamemanagement_newgame_text);
        addNewGameBtn = (Button) gameManagementView.findViewById(R.id.gamemanagement_add_btn);
        addNewGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newgame=String.valueOf(newGame.getText());

                //입력 초기화
                newGame.setText(null);

                //newgame 추가
            }
        });

        //게임 수정
        editGame = (EditText) gameManagementView.findViewById(R.id.gamemanagement_editgame_text);
        editGameBtn = (Button) gameManagementView.findViewById(R.id.gamemanagement_editgame_btn);
        editGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editgame=String.valueOf(editGame.getText());

                //입력 초기화
                gameSpinner.setSelection(0);
                editGame.setText(null);

                //selectedGame를 editgame로 고치기
            }
        });




        return gameManagementView;
    }
}