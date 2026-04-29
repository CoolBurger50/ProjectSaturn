import java.util.*;

public class Rooms {
    private static final HashMap<String, Boolean> Rooms = new HashMap<>();

    public Rooms() {
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
}
