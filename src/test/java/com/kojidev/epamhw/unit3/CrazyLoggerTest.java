package com.kojidev.epamhw.unit3;


import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class CrazyLoggerTest {

    @Test
    public void test() throws IOException {

        CrazyLogger logger = new CrazyLogger();

        logger.log("Somebody once told me the world is gonna roll me");
        logger.log("I ain't the sharpest tool in the shed");
        logger.log("She was looking kind of dumb with her finger and her thumb");
        logger.log("In the shape of an \"L\" on her forehead");

        logger.log("Well the years start coming and they don't stop coming");
        logger.log("Fed to the rules and I hit the ground running");
        logger.log("Didn't make sense not to live for fun");
        logger.log("Your brain gets smart but your head gets dumb");
        logger.log("So much to do, so much to see");
        logger.log("So what's wrong with taking the back streets?");
        logger.log("You'll never know if you don't go");
        logger.log("You'll never shine if you don't glow");

        logger.log("Hey now, you're an all-star, get your game on, go play");
        logger.log("Hey now, you're a rock star, get the show on, get paid");
        logger.log("And all that glitters is gold");
        logger.log("Only shooting stars break the mold");

        logger.log("It's a cool place and they say it gets colder");
        logger.log("You're bundled up now, wait till you get older");
        logger.log("But the meteor men beg to differ");
        logger.log("Judging by the hole in the satellite picture");
        logger.log("The ice we skate is getting pretty thin");
        logger.log("The water's getting warm so you might as well swim");
        logger.log("My world's on fire, how about yours?");
        logger.log("That's the way I like it and I never get bored");

        logger.log("Hey now, you're an all-star, get your game on, go play");
        logger.log("Hey now, you're a rock star, get the show on, get paid");
        logger.log("All that glitters is gold");
        logger.log("Only shooting stars break the mold");

        logger.log("Hey now, you're an all-star, get your game on, go play");
        logger.log("Hey now, you're a rock star, get the show, on get paid");
        logger.log("And all that glitters is gold");
        logger.log("Only shooting stars");

        logger.log("Somebody once asked could I spare some change for gas?");
        logger.log("I need to get myself away from this place");
        logger.log("I said yep what a concept");
        logger.log("I could use a little fuel myself");
        logger.log("And we could all use a little change");

        logger.log("Well, the years start coming and they don't stop coming");
        logger.log("Fed to the rules and I hit the ground running");
        logger.log("Didn't make sense not to live for fun");
        logger.log("Your brain gets smart but your head gets dumb");
        logger.log("So much to do, so much to see");
        logger.log("So what's wrong with taking the back streets?");
        logger.log("You'll never know if you don't go (go!)");
        logger.log("You'll never shine if you don't glow");

        logger.log("Hey now, you're an all-star, get your game on, go play");
        logger.log("Hey now, you're a rock star, get the show on, get paid");
        logger.log("And all that glitters is gold");
        logger.log("Only shooting stars break the mold");

        logger.log("And all that glitters is gold");
        logger.log("Only shooting stars break the mold");


        BufferedReader result = logger.find("You");

        String line;

        while ((line = result.readLine()) != null) {
            assertThat(line.toLowerCase(), containsString("you"));
        }

    }

}
