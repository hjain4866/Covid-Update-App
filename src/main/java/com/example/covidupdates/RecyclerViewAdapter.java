package com.example.covidupdates;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private Context context;
    private ArrayList<CoronaItem> coronaItemArrayList;

    public RecyclerViewAdapter(Context context, ArrayList<CoronaItem> coronaItemArrayList) {
        this.context = context;
        this.coronaItemArrayList = coronaItemArrayList;
    }

    @NonNull

    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view= LayoutInflater.from(context).inflate(R.layout.news_items,parent,false);

    return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.RecyclerViewHolder holder, int position) {

     CoronaItem coronaItem=coronaItemArrayList.get(position);
     String state=coronaItem.getState();
        String lastupdated=coronaItem.getLastUpdated();
        String death=coronaItem.getDeath();
        String todayDeath=coronaItem.getTodayDeath();
        String activeCases=coronaItem.getActiveCases();
        String todayconfirmed=coronaItem.getTodayConfirmedCases();
        String confirmedCases=coronaItem.getConfirmedCases();
        String recoveredCases=coronaItem.getRecoveredCases();
        String todayRecoveredCases=coronaItem.getTodayRecoveredCases();

        holder.State.setText(state);
        holder.LastUpdated.setText(lastupdated);
        holder.Death.setText(death);
        holder.TodayDeath.setText(todayDeath);
        holder.ActiveCases.setText(activeCases);
        holder.TodayConfirmedCases.setText(todayconfirmed);
        holder.ConfirmedCases.setText(confirmedCases);
        holder.RecoveredCases.setText(recoveredCases);
        holder.TodayRecoveredCases.setText(todayRecoveredCases);

    }

    @Override
    public int getItemCount() {
        return coronaItemArrayList.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder{


        TextView LastUpdated, Death, TodayDeath, ActiveCases,TodayConfirmedCases,RecoveredCases, TodayRecoveredCases,ConfirmedCases,State;

        public RecyclerViewHolder(@NonNull  View itemView) {
            super(itemView);


            LastUpdated=itemView.findViewById(R.id.lastUpdated);
            Death=itemView.findViewById(R.id.death);
            TodayDeath=itemView.findViewById(R.id.todayDeath);
            ActiveCases=itemView.findViewById(R.id.activeCases);
            RecoveredCases=itemView.findViewById(R.id.recoveredCases);
            TodayConfirmedCases=itemView.findViewById(R.id.todayConfirmedcases);
            TodayRecoveredCases=itemView.findViewById(R.id.todayRecoverdCases);
            ConfirmedCases=itemView.findViewById(R.id.confirmedCases);
            State=itemView.findViewById(R.id.stateName);

        }
    }







}
