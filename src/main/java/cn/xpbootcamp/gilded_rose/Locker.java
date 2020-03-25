package cn.xpbootcamp.gilded_rose;

import com.google.common.annotations.VisibleForTesting;

public class Locker {

    private String[] ticketIds = new String[19];

    public Ticket storeIn() {
        int index = findFirstAvailableIndex(ticketIds);
        if (index == -1) {
            throw new IllegalStateException("locker is full");
        }
        ticketIds[index] = "ticketId";
        final Ticket ticket = new Ticket();
        ticket.id = "ticketId";
        ticket.blockNumber = index;
        return ticket;
    }

    @VisibleForTesting
    void storeInIndex(int index) {
        ticketIds[index] = "ticketId";
    }

    private int findFirstAvailableIndex(String[] ticketIds) {
        for (int i = 0; i < ticketIds.length; i++) {
            if (ticketIds[i] == null) return i;
        }
        return -1;
    }

    public int takeOut(String ticketId) {
        for(int i = 0; i < 19; i++){
            if(ticketId.equals(ticketIds[i])){
                return i;
            }
        }
        return -1;
    }
}
