import java.util.*;

public class Rooms {
    private int Floor;
    private String Wing;
    private int Room;
    private static int counter = 1;
    private int RoomID;
    private final HashMap<Rooms, Boolean> Rooms = new HashMap<>();

    // Constructor Method
    public Rooms(int Floor, String Wing, int Room) {
        Floor = this.Floor;
        Wing = this.Wing;
        Room = this.Room;
        RoomID = counter++;
    }

    // Getter Methods
    public int getFloor() {return Floor;}

    public String getWing() {return Wing;}

    public int getRoom() {return Room;}

    public static HashMap<Rooms, Boolean> getAllTeachers() {
        return Rooms;
    }

    public G() {
        for (int i = 0; i != 9; i++) {
            for (int j = 0; j != 5; j++) {
                for (int n = 0; n != 21; n++) {
                    String Floor = String.valueOf(i);
                    String Wing = GetWing(j);
                    String Room = String.valueOf(n);
                    Rooms.put(Floor + Wing + Room, true);
                }
            }
        }
    }

    private static String GetWing(int j) {
        if (j ==1 ) {
            return "w";
        } else if (j == 2) {
            return "s";
        } else if (j == 3) {
            return "e";
        } else {
            return "n";
        }
    }

    //WHEN CALLING STRING ROOM MAKE IT IS LOWER CASED

    public boolean getAvailability(String room) {
        return Rooms.get(room);
    }

    public void setTaken(String room) {
        Rooms.replace(room, false);
    }

    public String createInserts(){
        StringBuilder Insert = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 5; j++) {
                for (int n = 0; n < 21; n++) {
                    String floor = String.valueOf(i);
                    String wing = GetWing(j);
                    String room = String.valueOf(n);

                    Insert.append("INSERT INTO Teachers (room_floor, room_wing, room_number) VALUES ('").append(floor).append("', '").append(wing).append("', ").append(room).append(");\n");
                }
            }
        }

        return Insert.toString();
    }
}
