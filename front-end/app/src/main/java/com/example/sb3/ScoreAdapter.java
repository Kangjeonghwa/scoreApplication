package com.example.sb3;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ViewHolder> {
    Context context;

    ArrayList<ScoreItem> items=new ArrayList<ScoreItem>();
    //ArrayList<ScoreItem> filteredItems=new ArrayList<ScoreItem>();

    public ScoreAdapter(Context context){
        this.context=context;
    }


    @NonNull
    @Override
    public ScoreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.score_item,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreAdapter.ViewHolder holder, int position) {
        ScoreItem item=items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(ScoreItem item){items.add(item);}

    public void addItems(ArrayList<ScoreItem> items){
        this.items=items;
    }

    public ScoreItem getItem(int position){
        return items.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView date;
        TextView game;
        TextView player1,player2;
        TextView player1Score, player2Score;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            date=(TextView) itemView.findViewById(R.id.Date);
            game=(TextView) itemView.findViewById(R.id.game);
            player1=(TextView) itemView.findViewById(R.id.player1);
            player2=(TextView) itemView.findViewById(R.id.player2);
            player1Score=(TextView) itemView.findViewById(R.id.player1_score);
            player2Score=(TextView) itemView.findViewById(R.id.player2_score);
        }

        public void setItem(ScoreItem item){
            date.setText(item.getDate());
            game.setText(item.getGame());
            player1.setText(item.getPlayer1());
            player2.setText(item.getPlayer2());

            //spannableString을 사용하여 조건부 글자 색상 변경
            String playerscore1=item.getPlayer1Score();
            String playerscore2=item.getPlayer2Score();

            SpannableString spanstr1=new SpannableString(playerscore1);
            SpannableString spanstr2=new SpannableString(playerscore2);

            //이긴쪽 점수 색 표시
            int ps1=Integer.parseInt(item.getPlayer1Score());
            int ps2=Integer.parseInt(item.getPlayer2Score());

            if(ps1>ps2){
                spanstr1.setSpan(new ForegroundColorSpan(Color.parseColor("#ff5851")),0,spanstr1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                spanstr2.setSpan(new ForegroundColorSpan(Color.parseColor("#747474")),0,spanstr2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }else if(ps1<ps2){
                spanstr1.setSpan(new ForegroundColorSpan(Color.parseColor("#747474")),0,spanstr1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                spanstr2.setSpan(new ForegroundColorSpan(Color.parseColor("#3498db")),0,spanstr2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }else{
                spanstr1.setSpan(new ForegroundColorSpan(Color.parseColor("#747474")),0,spanstr1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                spanstr2.setSpan(new ForegroundColorSpan(Color.parseColor("#747474")),0,spanstr2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }

            player1Score.setText(spanstr1);
            player2Score.setText(spanstr2);
        }
    }

   /* 왜 안될까....
   public Filter getFilterGame(){
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String gameStr=charSequence.toString().toLowerCase(Locale.ROOT);
                if(gameStr.isEmpty()){
                    filteredItems=items;
                }else {
                    ArrayList<ScoreItem> filteringItems=new ArrayList<ScoreItem>();
                    for(ScoreItem item:items){
                        if(item.getGame().toLowerCase(Locale.ROOT).contains(gameStr)){
                            filteringItems.add(item);
                        }
                    }
                    filteredItems=filteringItems;
                }
                FilterResults filterResults= new FilterResults();
                filterResults.values=filteredItems;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredItems=(ArrayList<ScoreItem>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public Filter getFilterPlayer(){
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String playerStr=charSequence.toString();
                if(playerStr.isEmpty()){
                    filteredItems=items;
                }else {
                    ArrayList<ScoreItem> filteringItems=new ArrayList<ScoreItem>();
                    for(ScoreItem item:items){
                        if(item.getPlayer1().toLowerCase().contains(playerStr.toLowerCase())){
                            filteringItems.add(item);
                        }else if(item.getPlayer2().toLowerCase().contains(playerStr.toLowerCase())){
                            filteringItems.add(item);
                        }
                    }
                    filteredItems=filteringItems;
                }
                FilterResults filterResults= new FilterResults();
                filterResults.values=filteredItems;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredItems=(ArrayList<ScoreItem>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }*/

}
