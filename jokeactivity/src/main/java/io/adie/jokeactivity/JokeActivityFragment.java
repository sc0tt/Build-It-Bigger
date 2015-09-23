package io.adie.jokeactivity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class JokeActivityFragment extends Fragment {
    //

    public JokeActivityFragment() {
//
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        String joke = jp.getJoke();
        //Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_joke, container, false);
    }
}
