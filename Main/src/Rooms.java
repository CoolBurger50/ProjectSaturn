import java.util.ArrayList;

public class Rooms {
    private int floor;
    private String wing;
    private int room;
    private static int roomCounter = 1;
    private final int roomID;
    private static final ArrayList<Rooms> allRooms = new ArrayList<>();

    public Rooms(int floor, String wing, int room) {
        this.floor = floor;
        this.wing = wing;
        this.room = room;
        roomID = roomCounter++;
    }

    public int getRoomID() {
        return roomID;
    }

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

    public static ArrayList<Rooms> getAllRooms() {
        return allRooms;
    }

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

    public static String createInserts() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO Rooms (room_floor, room_wing, room_number) VALUES\n");

        int count = 0;
        int total = allRooms.size();

        for (Rooms room : allRooms) {
            sb.append("('")
                    .append(room.floor).append("', '")
                    .append(room.wing).append("', ")
                    .append(room.room).append(")");

            count++;
            if (count < total) {
                sb.append(",\n");
            } else {
                sb.append(";");
            }
        }

        return sb.toString();
    }
}
