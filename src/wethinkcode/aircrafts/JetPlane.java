package wethinkcode.aircrafts;

import wethinkcode.program.WriteFile;
import wethinkcode.weather.WeatherTower;

import java.util.*;

public class JetPlane extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates)
    {
        super(name, coordinates);
        weatherTower = new WeatherTower();
    }

    public void updateConditions()
    {
        String currentWeather = this.weatherTower.getWeather(this.coordinates);
        //TODO: Add a dictionary containing messages
        String message;
        HashMap<String, String> weatherMessages = new HashMap<>();
        weatherMessages.put("SUN", "It's good time to get the heights higher!");
        weatherMessages.put("FOG", "Don't get too comfortable...");
        weatherMessages.put("SNOW", "The engine might freeze, down we go!");
        weatherMessages.put("RAIN", "This is normal but we must stay on guard.");

        switch (currentWeather)
        {
            case "SUN" :
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                break;
            case "FOG" :
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                break;
            case "RAIN" :
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
                break;
            case "SNOW" :
                this.coordinates.setHeight(this.coordinates.getHeight() - 7);
                break;
        }

        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);

        if (this.coordinates.getHeight() <= 0){
            message = "JetPlane#" + this.name + "(" + this.id + "): landing.";
            WriteFile.allMessages.add(message);
            this.coordinates.setHeight(0);
            this.unregisterTower();
        }
        else {
            message = "JetPlane#" + this.name + "(" + this.id + "): " + weatherMessages.get(currentWeather);
            WriteFile.allMessages.add(message);
        }

    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        String message = "Tower Says: " + "JetPlane#" + this.name + "(" + this.id + ") registered to weather tower";
        //TODO: Write the message to file
        WriteFile.allMessages.add(message);
    }

    private void unregisterTower()
    {
        this.weatherTower.unregister(this);
        String message = "Tower Says: " + "JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower";
        //TODO: Write the message to file
        WriteFile.allMessages.add(message);
    }
}
