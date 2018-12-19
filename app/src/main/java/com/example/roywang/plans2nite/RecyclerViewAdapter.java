package com.example.roywang.plans2nite;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Event> events;
    private Context mContext;

    RecyclerViewAdapter(ArrayList<Event> events, Context mContext) {
        this.events = events;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        viewHolder.textViewName.setText(events.get(i).name);
        viewHolder.textViewDate.setText(events.get(i).date);
        viewHolder.textViewLocation.setText(events.get(i).location);
        viewHolder.textViewPlantype.setText(events.get(i).plantype);
        viewHolder.textViewDetails.setText(events.get(i).details);

        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, events.get(i).name, Toast.LENGTH_SHORT).show();
                Toast.makeText(mContext, events.get(i).date, Toast.LENGTH_SHORT).show();
                Toast.makeText(mContext, events.get(i).location, Toast.LENGTH_SHORT).show();
                Toast.makeText(mContext, events.get(i).plantype, Toast.LENGTH_SHORT).show();
                Toast.makeText(mContext, events.get(i).details, Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewDate;
        TextView textViewLocation;
        TextView textViewPlantype;
        TextView textViewDetails;
        Button buttonRegisterListView;

        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textViewName);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewLocation = itemView.findViewById(R.id.textViewLocation);
            textViewPlantype = itemView.findViewById(R.id.textViewPlantype);
            textViewDetails = itemView.findViewById(R.id.textViewDetails);
            parentLayout = itemView.findViewById(R.id.parent_Layout);
            buttonRegisterListView = itemView.findViewById(R.id.buttonRegisterListView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "click"+getAdapterPosition(),Toast.LENGTH_SHORT).show();                }
            });

            buttonRegisterListView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"You have successfully registered for the event",Toast.LENGTH_SHORT ).show() ;
                }
            });

        }
    }


}
