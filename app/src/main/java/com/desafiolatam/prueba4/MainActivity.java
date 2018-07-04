package com.desafiolatam.prueba4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.desafiolatam.prueba4.adapters.QuotesAdapter;
import com.desafiolatam.prueba4.models.Quote;
import com.desafiolatam.prueba4.networks.quotes.GetQuote;

import java.util.List;

public class MainActivity extends AppCompatActivity {
QuotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.quotesRv);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new QuotesAdapter();
        recyclerView.setAdapter(adapter);

        new MainQuotes().execute("movies", "10");
    }

    private class MainQuotes extends GetQuote {
        @Override
        protected void onPostExecute(List<Quote> quotes) {
            adapter.update(quotes);
        }
    }
}
