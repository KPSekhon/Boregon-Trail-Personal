package model;

import model.exceptions.UnknownItemException;
import org.json.JSONArray;
import org.json.JSONObject;
import persistance.Writable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Represents a log of alarm system events.
 * We use the Singleton Design Pattern to ensure that there is only
 * one EventLog in the system and that the system has global access
 * to the single instance of the EventLog.
 */

//taken from Alarm System Project
public class EventLog implements Iterable<Event> {
    /**
     * the only EventLog in the system (Singleton Design Pattern)
     */
    private static EventLog theLog;
    private Collection<Event> events;

    /**
     * Prevent external construction.
     * (Singleton Design Pattern).
     */
    private EventLog() {
        events = new ArrayList<Event>();
    }

    /**
     * Gets instance of EventLog - creates it
     * if it doesn't already exist.
     * (Singleton Design Pattern)
     *
     * @return instance of EventLog
     */
    public static EventLog getInstance() {
        if (theLog == null) {
            theLog = new EventLog();
        }

        return theLog;
    }

    /**
     * Adds an event to the event log.
     *
     * @param e the event to be added
     */
    public void logEvent(Event e) {
        events.add(e);
    }

    /**
     * Clears the event log and logs the event.
     */
    public void clear() {
        events.clear();
        logEvent(new Event("Event log cleared."));
    }

    // EFFECTS: returns items in inventory as a JSON array
    // Source: JSonSerializationDemo
    public JSONArray logEventsToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Event e : events) {
            jsonArray.put(e.toJson());
        }
        return jsonArray;
    }


    // MODIFIES: this
    // EFFECTS: re-instantiates item from JsonObject
    public void fromJson(JSONObject json) {
        JSONArray eventsList = json.getJSONArray("eventLog");
        for (int i = 0; i < eventsList.length(); i++) {
            Event event = new Event(eventsList.getJSONObject(i).getString("description"));
            logEvent(event);
        }
    }

    @Override
    public Iterator<Event> iterator() {
        return events.iterator();
    }
}