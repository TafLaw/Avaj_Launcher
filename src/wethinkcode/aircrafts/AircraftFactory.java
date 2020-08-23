package wethinkcode.aircrafts;

public abstract class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {

        Flyable airCraft = null;
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        switch (type)
        {

            case "Baloon" :

                airCraft = new Baloon(name, coordinates);
                break;
            case "JetPlane" :
                airCraft = new JetPlane(name, coordinates);
                break;
            case "Helicopter" :
                airCraft = new Helicopter(name, coordinates);
                break;
        }
        return airCraft;
    }
}
