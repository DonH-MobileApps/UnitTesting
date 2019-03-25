package com.example.restcalls;

import java.io.IOException;

public class Okhttp3Helper {

    public OkhttpClient okhttpClientWithIntercepter() {

        OkhttpClient okhttpClient;
        HttpLongInterceptor httpLoggingInterceptor = new HttpLoggingIntereptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Leve.BASIC);
        okhttpClient = new OkhttpCLient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                build();
        return okhttpClient;

    public static String getSyncroniousOkhttpResonse() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ACTUAL_URL)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }

    public static void getAsyncOkHttpResponse() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ACTUAL_URL)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", "onFailure: ", e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //get json response from the rest call
                String jsonResponse = response.body().string();
                //Create a gson converter for the json string
                Gson gsonConverter = new Gson();
                //post an EventBus post event containing the UserResponse object parsed from the json
                Log.d("TAG_OKHTTP_ASYNC", jsonResponse);
                EventBus.getDefault().post(gsonConverter.fromJson(jsonResponse, UserResponse.class));

            }
        });
    }
}

}
