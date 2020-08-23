package wethinkcode.aircrafts;

import wethinkcode.program.WriteFile;
import wethinkcode.weather.WeatherTower;

import java.util.HashMap;

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates)
    {
        super(name, coordinates);
        weatherTower = new WeatherTower();
    }

    public void updateConditions()
    {
        String currentWeather = this.weatherTower.getWeather(this.coordinates);
        String message;
        HashMap<String, String> weatherMessages = new HashMap<>();
        weatherMessages.put("SUN", "Machine heating up");
        weatherMessages.put("FOG", "Don't get lost, watch out!");
        weatherMessages.put("SNOW", "The pool of fine cold soft sucks.");
        weatherMessages.put("RAIN", "The chopper blades in a conflict with rain drops, who's gonna win?");

        switch (currentWeather)
        {
            case "SUN" :
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                break;
            case "FOG" :
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
                break;
            case "RAIN" :
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                break;
            case "SNOW" :
                this.coordinates.setHeight(this.coordinates.getHeight() - 12);
                break;
        }

        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);

        if (this.coordinates.getHeight() <= 0){
            message = "Helicopter#" + this.name + "(" + this.id + "): landing.";
            WriteFile.allMessages.add(message);
            this.coordinates.setHeight(0);
            this.unregisterTower();
        }
        else {
            message = "Helicopter#" + this.name + "(" + this.id + "): " + weatherMessages.get(currentWeather);
            WriteFile.allMessages.add(message);
        }
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        String message = "Tower Says: " + "Helicopter#" + this.name + "(" + this.id + ") registered to weather tower";
        WriteFile.allMessages.add(message);
    }

    private void unregisterTower()
    {
        this.weatherTower.unregister(this);
        String message = "Tower Says: " + "Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower";
        WriteFile.allMessages.add(message);
    }
}
