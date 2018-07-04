package com.desafiolatam.prueba4.networks.quotes;

import com.desafiolatam.prueba4.models.Quote;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface Quotes {
    @GET(" ")
    Call<List<Quote>> get(@Query("cat") String category, @Query("count") String count);
}
