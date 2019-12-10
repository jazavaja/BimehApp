package com.javad.mrbimeh.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.javad.mrbimeh.MyTextView.NumTextView;
import com.javad.mrbimeh.R;
import com.javad.mrbimeh.inter.item;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    private item item;
    private List<String> matnn;
    private List<String> onvvan;

    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        NumTextView matn;
        NumTextView onvan;
        NumTextView time;

        ViewHolder(View v) {
            super(v);
            this.time = (NumTextView) v.findViewById(R.id.time);
            this.onvan = (NumTextView) v.findViewById(R.id.txt_title);
            this.matn = (NumTextView) v.findViewById(R.id.short_message);
        }
    }

    public MessageAdapter(List<String> onvan, List<String> matn, item item) {
        this.onvvan = onvan;
        this.matnn = matn;
        this.item = item;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_message, parent, false));
    }

    public void onBindViewHolder(final ViewHolder holder, int position) {
        String mtn = (String) this.matnn.get(position);
        holder.onvan.setText((String) this.onvvan.get(position));
        holder.matn.setText(mtn);
        holder.itemView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MessageAdapter.this.item.setOnItemClick(holder.getAdapterPosition());
            }
        });
    }

    public int getItemCount() {
        return this.onvvan.size();
    }

    public void add(int position, String item) {
        this.onvvan.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        this.onvvan.remove(position);
        notifyItemRemoved(position);
    }
}
