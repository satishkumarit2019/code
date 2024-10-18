package designpattern;

// Main class to test the adapter pattern
public class AdapterPatternDemo {
    public static void main(String[] args) {
        // Create a round plug
        RoundPlug roundPlug = new RoundPlug();


        // Use an adapter to fit the round plug into the square socket
        SquareSocket socket = new SquareSocket(new PlugAdapter(roundPlug));

        // Charge the device using the square socket
        socket.charge();
    }
}

// The target interface: Socket with a square hole
interface SquarePlug {
    void insertIntoSquareSocket();
}

// Concrete implementation of a square socket
class SquareSocket {
    private SquarePlug plug;

    // Constructor takes a square plug object
    public SquareSocket(SquarePlug plug) {
        this.plug = plug;
    }

    public void charge() {
        System.out.println("Charging using square socket.");
        plug.insertIntoSquareSocket();
    }
}

// Existing class: Round plug (incompatible with square socket)
class RoundPlug {
    public void insertIntoRoundSocket() {
        System.out.println("Inserted into round socket.");
    }
}

// Adapter class: Converts RoundPlug to behave like a SquarePlug
class PlugAdapter implements SquarePlug {
    private RoundPlug roundPlug;

    // Adapter constructor takes a RoundPlug object
    public PlugAdapter(RoundPlug roundPlug) {
        this.roundPlug = roundPlug;
    }

    // Adapts the round plug to fit into the square socket
    @Override
    public void insertIntoSquareSocket() {
        System.out.println("Adapting round plug to square socket.");
        roundPlug.insertIntoRoundSocket();
    }
}
