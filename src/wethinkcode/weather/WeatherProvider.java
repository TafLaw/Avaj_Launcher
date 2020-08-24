package wethinkcode.weather;

import wethinkcode.aircrafts.Coordinates;

import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider()
    {

    }

    public static WeatherProvider getProvider()
    {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates)
    {
        if (coordinates.getHeight() > 100){
            System.out.println(coordinates.getHeight());
            coordinates.setHeight(100);}

        String condition;
        int decider = 0;
        int bound = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude();

        Random randomInt = new Random();
        if(bound < 0)
            bound *= -1;

        decider = randomInt.nextInt(bound);
        if (decider <= Math.round((20*bound)/100))
            condition = "SNOW";
        else if (decider > Math.round((20*bound)/100) && decider <= Math.round((50*bound)/100))
            condition = "RAIN";
        else if (decider > Math.round((50*bound)/100) && decider <= Math.round((80*bound)/100))
            condition = "FOG";
        else
            condition = "SUN";

        return condition;
    }
}
