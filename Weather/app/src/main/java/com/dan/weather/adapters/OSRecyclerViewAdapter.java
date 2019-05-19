package com.dan.weather.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.dan.weather.R;
import java.util.ArrayList;
import java.util.List;

public class OSRecyclerViewAdapter extends RecyclerView.Adapter<OSRecyclerViewAdapter.OSViewHolder> {
    private final LayoutInflater inflater;
    private OsClickListener osClickListener;
    private List<String> osList;

    public OSRecyclerViewAdapter(List<String> items, Context context) {
        this.osList = new ArrayList<>(2);
        this.osList = items;
        this.inflater = LayoutInflater.from(context);
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public OSViewHolder onCreateViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
        return new OSViewHolder(inflater.inflate(R.layout.os_itetm, parentViewGroup, false));
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull OSViewHolder osViewHolder, int position) {
        final String item = osList.get(position);

        osViewHolder.txtOs.setText(item);
        osViewHolder.locationItemRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (osClickListener != null) {
                    osClickListener.onClick(item);
                }
            }
        });
    }

    // Return the size of your dataSet (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return osList.size();
    }

    public void setOsList(List<String> osItems){
        this.osList = osItems;
        notifyDataSetChanged();
    }

    public interface OsClickListener {
        void onClick(String os);
    }

    public void setOSClickListener(OsClickListener osClickListener) {
        this.osClickListener = osClickListener;
    }

    // Provide a reference to the views for each data item
    class OSViewHolder extends RecyclerView.ViewHolder {
        private final View locationItemRoot;
        private final TextView txtOs;

        OSViewHolder(final View itemView) {
            super(itemView);
            this.locationItemRoot = itemView.findViewById(R.id.os_item_root);
            this.txtOs = itemView.findViewById(R.id.textView32);
        }
    }
}