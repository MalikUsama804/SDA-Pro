package observer;

import java.util.ArrayList;
import java.util.List;

public class EventBus {

    private static EventBus instance;

    private List<Observer> observers;

    private EventBus() {

        observers = new ArrayList<>();
    }

    public static EventBus getInstance() {

        if (instance == null) {

            instance = new EventBus();
        }

        return instance;
    }

    public void subscribe(Observer observer) {

        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {

        observers.remove(observer);
    }

    public void publish(String event) {

        System.out.println(
                "\nEvent Published: " + event
        );

        for (Observer observer : observers) {

            observer.update(event);
        }
    }
}