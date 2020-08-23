package wethinkcode.weather;

import wethinkcode.aircrafts.Flyable;
import wethinkcode.program.ReadFile;
import wethinkcode.validations.ValidateFile;
import wethinkcode.weather.WeatherTower;

public class Simulator {
    public void simulate()
    {
        WeatherTower weatherTower = new WeatherTower();
        for (Flyable craft:  ReadFile.flyables) {
            craft.registerTower(weatherTower);
        }

        for (int sims = 1; sims <= ValidateFile.simulationsNo; ValidateFile.simulationsNo--){
            weatherTower.changeWeather();
        }
    }
}
