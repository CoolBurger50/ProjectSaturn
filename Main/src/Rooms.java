import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Rooms {
    private int floor;
    private String wing;
    private int room;
    private static int counter = 1;
    private final int roomID;
    private static final ArrayList<Rooms> allRooms = new ArrayList<>();

    // Constructor Method
    public Rooms(int Floor, String Wing, int Room) {
        roomID = counter++;
    }

    // Getter Methods
    public int getFloor() {
        return floor;
    }

    public String getWing() {
        return wing;
    }

    public int getRoom() {
        return room;
    }

    public int getRoomID() {
        return roomID;
    }

    public static ArrayList<Rooms> getAllRooms() {
        return allRooms;
    }

    // Hashmap Generation
    public static void generateRooms() {
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 3; j++) {
                for (int n = 1; n <= 20; n++) {
                    Rooms currentRoom = new Rooms(i,getWing(j),n);
                    allRooms.add(currentRoom);
                }
            }
        }
    }

    // Convert Int -> Wing
    private static String getWing(int j) {
        if (j == 0) {
            return "n";
        } else if (j == 1) {
            return "e";
        } else if (j == 2) {
            return "s";
        } else {
            return "w";
        }
    }

    // Object -> ID translation
    public Rooms fromRoomID(int roomID) {
        for (Rooms room : allRooms) {
            if (room.getRoomID() == roomID) {
                return room;
            }
        }
        return null;
    }

    // Check HashMap value for said roomID
    public boolean checkAvailability (int roomID) {return allRooms.get(fromRoomID(roomID));}

    // Set the value for said Room ID to false
    public void setTaken (int roomID) {allRooms.replace(fromRoomID(roomID), false);}

    // Reset all values in HashMap
    public void resetValues() {
        for (Rooms room : allRooms.keySet()) {
            allRooms.replace(room, true);
        }
    }

    // Creates Inserts Statements
    public static String createInserts() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO Rooms (room_floor, room_wing, room_number) VALUES\n");

        int count = 0;
        int total = allRooms.size();

        for (Rooms room : allRooms.keySet()) {
            sb.append("('")
                    .append(room.getFloor()).append("', '")
                    .append(room.getWing()).append("', ")
                    .append(room.getRoom()).append(")");

            count++;
            if (count < total) {
                sb.append(",\n");
            } else {
                sb.append(";");
            }
        }

        return sb.toString();
    }

    // Used for testing
    @Override
    public String toString() {
        return "\n\n" + floor+wing+room + "\nRoomID:" + roomID + "\nAvailability";
    }
}
