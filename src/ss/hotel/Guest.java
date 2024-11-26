package ss.hotel;

/**
 * A class representing a guest in a hotel.
 * A guest is able to check in and check out as well.
 */
public class Guest {
    private final String name;
    private Room room;

    /**
     * Creates a new guest with the given name.
     * @param name the name of the guest.
     */
    public Guest(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the guest.
     * @return the name of the guest.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the room the guest is currently checked into.
     * @return the room the guest is currently checked into.
     */
    /*@pure@*/
    public Room getRoom() {
        return room;
    }

    /**
     * Checks the guest into the current room if there is no
     * guest occupying the room currently.
     * @param room the room to check into.
     * @return true if check-in was successful, false if not.
     */
    /*@
     requires room != null;
     ensures \result == (this.room == null && room.getGuest() == null);
     ensures \result ==> (this.room == room && room.getGuest() == this);
     ensures !\result ==> (this.room == \old(this.room) && room.getGuest() == \old(room.getGuest()));
     */
    public boolean checkin(Room room) {
        if (this.room == null && room.getGuest() == null) {
            this.room = room;
            room.setGuest(this);
            return true;
        }
        return false;
    }

    /**
     * Checks out the guest from the current room
     * if there is a guest occupying that room.
     * @return true if the guest has been checked out, false if not.
     */
    /*@
     requires this.room != null;  // The guest must be checked into a room.
     ensures \result == (this.room == null);  // After checkout, the room should be null.
     ensures \result ==> (this.room == null && \old(this.room).getGuest() == null);  // The room is now free.
     ensures !\result ==> (this.room == \old(this.room));  // The room is still occupied.
     */
    public boolean checkout() {
        if (this.room != null) {
            Room currentRoom = this.room;
            this.room = null;
            currentRoom.setGuest(null);
            return true;
        }
        return false;
    }

    /**
     * Returns a string representation of the guest.
     * @return a string representation of the guest.
     */
    @Override
    public String toString(){
        return "Guest " + name;
    }
}