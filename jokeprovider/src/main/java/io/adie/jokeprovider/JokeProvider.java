package io.adie.jokeprovider;

import java.util.Random;

public class JokeProvider {
    private Random random = new Random();
    private String[] jokes = {
            "How do you make a tissue dance? You put a little boogie in it.",
            "What does a nosey pepper do? Gets jalapeno business!",
            "Why can’t you hear a pterodactyl in the bathroom? Because it has a silent pee."
    };

    public String getJoke(){
        int index = random.nextInt(jokes.length);
        return jokes[index];
    }
}
