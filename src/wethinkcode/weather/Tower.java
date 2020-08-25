package wethinkcode.weather;

import wethinkcode.aircrafts.Flyable;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Tower {
//    private ArrayList<Flyable> observers = new ArrayList<Flyable>();
    private List<Flyable> observers = new CopyOnWriteArrayList<Flyable>();

    public void register(Flyable flyable)
    {
        if(!observers.contains(flyable))
            observers.add(flyable);
    }

    public void unregister(Flyable flyable)
    {
        if(observers.contains(flyable))
            observers.remove(flyable);
    }

    protected void conditionsChanged()
    {
        for (Flyable craft: observers) {
            craft.updateConditions();
        }
    }
}
