package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
//import io.adie.jokeapi.jokeApi.JokeApi;


public class JokeAsyncTask extends AsyncTask<String, Void, String> {
    private static final String TAG = JokeAsyncTask.class.getSimpleName();
    //private static JokeApi jokeApiService = null;
    //private static MyApi jokeApiService = null;
    private Context context;
    private JokeResponse resp = null;

    @Override
    protected String doInBackground(String... params) {
/*        if(jokeApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
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
        }*/
        return "";
    }

    @Override
    protected void onPostExecute(String result) {
        resp.jokeRetrieved(result);
    }

    public interface JokeResponse {
        void jokeRetrieved(String joke);
    }

}
