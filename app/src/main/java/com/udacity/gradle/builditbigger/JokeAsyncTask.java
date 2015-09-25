package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import io.adie.jokeapi.myApi.MyApi;


public class JokeAsyncTask extends AsyncTask<String, Void, String> {
    private static final String TAG = JokeAsyncTask.class.getSimpleName();
    //private static JokeApi jokeApiService = null;
    private static MyApi jokeApiService = null;
    private Context context;
    private JokeResponse resp = null;

    public JokeAsyncTask(JokeResponse jr) {
        resp = jr;
    }

    @Override
    protected String doInBackground(String... params) {
        if(jokeApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://jokeapi-1079.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            jokeApiService = builder.build();

        }

        try {
            return jokeApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Log.d(TAG, result);
        resp.jokeRetrieved(result);
    }

    public interface JokeResponse {
        void jokeRetrieved(String joke);
    }

}
