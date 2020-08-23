package wethinkcode.aircrafts;

import wethinkcode.program.WriteFile;
import wethinkcode.weather.*;

import java.util.HashMap;

public class Baloon extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates)
    {
        super(name, coordinates);
        weatherTower = new WeatherTower();
    }

    public void updateConditions()
    {
        String currentWeather = this.weatherTower.getWeather(this.coordinates);
        String message;
        HashMap<String, String> weatherMessages = new HashMap<>();
        weatherMessages.put("SUN", "Can somebody pop some Ice Cream?");
        weatherMessages.put("FOG", "You can't see me...");
        weatherMessages.put("SNOW", "Let's destroy the snowman on the ground.");
        weatherMessages.put("RAIN", "Rainy days, Rainy days, Rainy day.");

        switch (currentWeather)
        {
            case "SUN" :
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 2);
                break;
            case "FOG" :
                this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                break;
            case "RAIN" :
                this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                break;
            case "SNOW" :
                this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                break;
        }

        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);

        if (this.coordinates.getHeight() <= 0){
            message = "Baloon#" + this.name + "(" + this.id + "): landing.";
            WriteFile.allMessages.add(message);
            this.coordinates.setHeight(0);
            this.unregisterTower();
        }
        else {
            message = "Baloon#" + this.name + "(" + this.id + "): " + weatherMessages.get(currentWeather);
            WriteFile.allMessages.add(message);
        }
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        String message = "Tower Says: " + "Baloon#" + this.name + "(" + this.id + ") registered to weather tower";
        WriteFile.allMessages.add(message);
    }

    private void unregisterTower()
    {
        this.weatherTower.unregister(this);
        String message = "Tower Says: " + "Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower";
        WriteFile.allMessages.add(message);
    }
}
