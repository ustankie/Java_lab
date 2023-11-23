package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{

    private int messagesOccurred=0;
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        synchronized(ConsoleMapDisplay.class) {
            System.out.println("Map id: " + worldMap.getId());
            System.out.println(message);
            System.out.println(worldMap);
            messagesOccurred += 1;
            System.out.println("Actualizations occurred in number of: " + messagesOccurred + "\n");
        }

    }

    public int getMessagesOccurred() {
        synchronized (ConsoleMapDisplay.class){
            return messagesOccurred;
        }

    }
}
