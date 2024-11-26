package ss.hotel;

public class Hotel {
    private String name;
    private Room[] rooms = new Room[2];

    /*@
      @  requires name != null;
      @  ensures this.name == name;
      @*/
    public Hotel(String name) {
        this.name = name;
        rooms[0] = new Room(100);
        rooms[1] = new Room(101);
    }

    public String getName() {
        return name;
    }

    /*@
      @  requires guestName != null;
      @  ensures \result != null ==> (\exists int i; 0 <= i && i < rooms.length; rooms[i].getGuest().getName() == guestName);
      @  ensures \result == null ==> (\forall int i; 0 <= i && i < rooms.length; rooms[i].getGuest().getName() != guestName);
      @*/
    public Room checkIn(String guestName) {
        for (Room room : rooms) {
            if (room.getGuest() == null) {
                Guest guest = new Guest(guestName);
                if (guest.checkin(room)) {
                    return room;
                }
            }
        }
        return null;
    }


    /*@
      @  requires guestName != null;
      @  ensures \result == true ==> (\exists int i; 0 <= i && i < rooms.length; rooms[i].getGuest() == null);
      @  ensures \result == false ==>(\forall int i; 0 <= i && i < rooms.length; rooms[i].getGuest() != guestName);
      @*/
    public boolean checkOut(String guestName) {
        Room room = getRoom(guestName);
        if (room != null) {
            Guest guest = room.getGuest();
            Safe safe = room.getSafe();
            room.setGuest(null);
            guest.checkout();
            safe.deactivate();
            return true;
        }
        return false;
    }
    /*@
      @  ensures \result == null ==>(\forall int i; 0 <= i && i < rooms.length; rooms[i].getGuest() != null);
      @  ensures \result != null ==>(\exists int i; 0 <= i && i < rooms.length; rooms[i].getGuest() == null);
      @*/
    public Room getFreeRoom() {
        for (Room room : rooms) {
            if (room.getGuest() == null) {
                return room;
            }
        }
        return null;
    }

    /*@
      @  requires guestName != null;
      @  ensures \result == null ==> (\forall int i; 0 <= i && i < rooms.length; rooms[i].getGuest().getName() != guestName);
      @  ensures \result != null ==> (\exists int i; 0 <= i && i < rooms.length; rooms[i].getGuest().getName() == guestName);
      @*/
    public Room getRoom(String guestName) {
        for (Room room : rooms) {
            if (room.getGuest() != null && room.getGuest().getName().equals(guestName)) {
                return room;
            }
        }
        return null;
    }
    /*@
      @  ensures \result != null;
      @  ensures (\forall int i; 0 <= i && i < rooms.length;
       \result.contains(rooms[i].getNumber() + " " + (rooms[i].getGuest() != null ?
        rooms[i].getGuest().getName() : "No Guest")));
      @*/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            sb.append("Room ").append(room.getNumber()).append(": ");
            if (room.getGuest() != null) {
                sb.append(room.getGuest().getName());
            } else {
                sb.append("empty");
            }
            sb.append(", Safe: ").append(room.getSafe().isActive() ? "active" : "inactive").append("\n");
        }
        return sb.toString();
    }
}