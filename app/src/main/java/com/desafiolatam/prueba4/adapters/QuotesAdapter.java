package com.desafiolatam.prueba4.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.desafiolatam.prueba4.R;
import com.desafiolatam.prueba4.models.Quote;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.ViewHolder>{
    private List<Quote> quotes = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_quote, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Quote quote = quotes.get(position);
        holder.quoteTv.setText(quote.getQuote());
        holder.authorTv.setText(quote.getAuthor());
        holder.categoryTv.setText(quote.getCategory());
    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    public void update(List<Quote> quotes) {
        this.quotes.clear();
        this.quotes.addAll(quotes);
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView quoteTv, authorTv, categoryTv;


        public ViewHolder(View itemView) {
            super(itemView);

            quoteTv = itemView.findViewById(R.id.quoteTv);
            authorTv = itemView.findViewById(R.id.authorTv);
            categoryTv = itemView.findViewById(R.id.categoryTv);
        }
    }
}
