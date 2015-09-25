package com.udacity.gradle.builditbigger;


import android.test.AndroidTestCase;

public class JokeAsyncTaskTest extends AndroidTestCase implements JokeAsyncTask.JokeResponse {

    public void testVerifyJokeNotEmpty() {
        new JokeAsyncTask(this).execute();
    }

    public void jokeRetrieved(String joke) {
        assertTrue(!joke.isEmpty());
    }
}
