package com.example.designsupportlibrary.weather.rest;

import com.example.designsupportlibrary.weather.model.WeatherData;

import retrofit.Call;
import retrofit.Retrofit;
import retrofit.GsonConverterFactory;

public class WeatherClient {
    private static final String Url = "http://api.openweathermap.org/";
    private static final String AppId = "Your App Id Goes Here"; // Add your app id here

    private WeatherService mService;
    private Retrofit mRetrofit;

    public WeatherClient() {

        mRetrofit = new Retrofit.Builder()
        .baseUrl(Url)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

        mService = mRetrofit.create(WeatherService.class);
    }

    public Call<WeatherData> getWeather(String city) {
        return mService.getWeather(city, AppId);
    }
}
