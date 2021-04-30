package de.szut.zuul;

import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 * <p>
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * A "Room" represents one location in the scenery of the game.  It is
 * connected to other rooms via exits.  The exits are labelled north,
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Room {
    public String description;
    private HashMap<String, Room> exits;
    private HashMap<String, Item> items;


    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     *
     * @param description The room's description.
     */
    public Room(String description) {
        this.description = description;
        this.exits = new HashMap<>();
        this.items = new HashMap<>();
    }

    public void setExit(String direction, Room neighbour) {
        this.exits.put(direction, neighbour);
    }


    public Room getExit(String direction) {
        return this.exits.get(direction);
    }

    public String exitsToString() {
        String exitsStr = "";
        for (String exit : this.exits.keySet()) {
            exitsStr += exit + " ";
        }
        return exitsStr;
    }

    private String itemsToString() {
        String itemsAsStr = "";
        for (Item item : this.items.values()) {
            itemsAsStr += "- " + item.toString() + "\n";
        }
        return itemsAsStr;
    }


    /**
     * @return The description of the room.
     */
    public String getDescription() {
        return description;
    }

    public String getLongDescription() {
        String desc = "You are " + this.description + "\n" + "Exits: " + this.exitsToString() + "\n";
        desc += "Items in this room:\n";
        desc += itemsToString();
        return desc;
    }


    public void putItem(Item newItem) {
        this.items.put(newItem.getName(), newItem);
    }
}
