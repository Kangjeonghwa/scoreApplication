package com.example.sb3;

import static java.lang.Integer.parseInt;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.ViewHolder> {
    Context context;

    ArrayList<RankingItem> items=new ArrayList<RankingItem>();

    public RankingAdapter(Context context) {
        this.context=context;
    }

    public RankingAdapter(ArrayList<RankingItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RankingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.ranking_item,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RankingAdapter.ViewHolder holder, int position) {
        RankingItem item=items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(RankingItem item){
        items.add(item);
    }

    public void addItems(ArrayList<RankingItem> items){
        this.items=items;
    }

    public RankingItem getItem(int position){
        return items.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView rank;
        TextView score;
        TextView player;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rank=(TextView) itemView.findViewById(R.id.rank);
            score=(TextView) itemView.findViewById(R.id.total_score);
            player=(TextView) itemView.findViewById(R.id.player);
        }

        public void setItem(RankingItem item){
            rank.setText(item.getRank());
            score.setText(item.getScore());
            player.setText(item.getPlayer());

            //spannableString을 사용하여 조건부 글자 색상 변경
            SpannableString spanRank=new SpannableString(item.getRank());
            SpannableString spanScore=new SpannableString(item.getScore());
            SpannableString spanPlayer=new SpannableString(item.getPlayer());

            //1,2,3등 조건부 글자 색상 변경
            int n=parseInt(item.getRank());

            if(n==1){
                /*rank.setTextColor(Color.parseColor("#FFE814"));
                score.setTextColor(Color.parseColor("#FFE814"));
                player.setTextColor(Color.parseColor("#FFE814"));*/
                spanRank.setSpan(new ForegroundColorSpan(Color.parseColor("#FFE814")),0,spanRank.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                spanScore.setSpan(new ForegroundColorSpan(Color.parseColor("#FFE814")),0,spanScore.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                spanPlayer.setSpan(new ForegroundColorSpan(Color.parseColor("#FFE814")),0,spanPlayer.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }else if(n==2||n==3){
                /*rank.setTextColor(Color.parseColor("#4ACEEB"));
                score.setTextColor(Color.parseColor("#4ACEEB"));
                player.setTextColor(Color.parseColor("#4ACEEB"));*/
                spanRank.setSpan(new ForegroundColorSpan(Color.parseColor("#4ACEEB")),0,spanRank.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                spanScore.setSpan(new ForegroundColorSpan(Color.parseColor("#4ACEEB")),0,spanScore.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                spanPlayer.setSpan(new ForegroundColorSpan(Color.parseColor("#4ACEEB")),0,spanPlayer.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }else{
                /*rank.setTextColor(Color.parseColor("#4ACEEB"));
                score.setTextColor(Color.parseColor("#4ACEEB"));
                player.setTextColor(Color.parseColor("#4ACEEB"));*/
                spanRank.setSpan(new ForegroundColorSpan(Color.parseColor("#F5F5F5")),0,spanRank.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                spanScore.setSpan(new ForegroundColorSpan(Color.parseColor("#F5F5F5")),0,spanScore.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                spanPlayer.setSpan(new ForegroundColorSpan(Color.parseColor("#F5F5F5")),0,spanPlayer.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }

            rank.setText(spanRank);
            score.setText(spanScore);
            player.setText(spanPlayer);
        }
    }
}
