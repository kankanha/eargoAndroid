package com.example.pooja.eargoandroid.Interface;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pooja.eargoandroid.Models.DailyData;
import com.example.pooja.eargoandroid.R;
import com.example.pooja.eargoandroid.Util.Utils;

import java.util.List;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    Context context;
    List<DailyData> list;
    clickListener listener;

    public CustomAdapter(Context ctxt, List<DailyData> dailyDataList, clickListener clickListener) {
        context = ctxt;
        list = dailyDataList;
        Utils.PopulateMap();
        listener = clickListener;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        public TextView date;
        public TextView summary;
        public TextView lowTemp;
        public TextView highTemp;
        ImageView icon;
        CardView cardView;

        public CustomViewHolder(View view) {
            super(view);

            cardView = view.findViewById(R.id.card_view);
            date = (TextView) view.findViewById(R.id.date);
            summary = (TextView) view.findViewById(R.id.summary);
            lowTemp = (TextView) view.findViewById(R.id.tempLow);
            highTemp = (TextView) view.findViewById(R.id.tempHigh);
            icon = view.findViewById(R.id.image);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DailyData item = getItem(getAdapterPosition());
                    listener.onItemClick(item);
                }
            });
        }
    }

    @NonNull
    @Override
    public CustomAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_layout, viewGroup, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {

        customViewHolder.date.setText(Utils.GetDate(list.get(i).getTime())); // use utils to convert time to date a
        customViewHolder.summary.setText(list.get(i).getSummary());
        customViewHolder.lowTemp.setText(list.get(i).getTemperatureLow().toString());
        customViewHolder.highTemp.setText(list.get(i).getTemperatureHigh().toString());
        Utils.SetImage(list.get(i).getIcon(), customViewHolder.icon);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public DailyData getItem(int pos) {
        if (list != null) {
            return list.get(pos);
        } else {
            return null;
        }
    }


    public void PopulatelistItem(List<DailyData> dailyDataList) {
        list = dailyDataList;
        notifyDataSetChanged();
    }
}
