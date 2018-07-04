package com.desafiolatam.prueba4.networks.quotes;

import android.os.AsyncTask;

import com.desafiolatam.prueba4.models.Quote;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class GetQuote extends AsyncTask<String, Void, List<Quote>> {

    @Override
    protected List<Quote> doInBackground(String... strings) {
        Quotes quotes = new QuoteInterceptor().get();
        Call<List<Quote>> quote = quotes.get(strings[0], strings[1]);

        try{
            Response<List<Quote>> response = quote.execute();
            if (response.code() == 200 && response.isSuccessful()){
                return response.body();
            }else {
                return null;
            }
        }catch(IOException e){
            return null;
        }
    }
}
