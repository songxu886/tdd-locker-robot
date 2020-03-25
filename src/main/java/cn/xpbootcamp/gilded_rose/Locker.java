package cn.xpbootcamp.gilded_rose;

import com.google.common.annotations.VisibleForTesting;

public class Locker {

    private boolean[] blocks = new boolean[19];

    public Ticket storeIn() {
        int index = findFirstAvailableIndex(blocks);
        if (index == -1) {
            throw new IllegalStateException("locker is full");
        }
        blocks[index] = true;
        final Ticket ticket = new Ticket();
        ticket.id = "ticketId";
        ticket.lockerNumber = index;
        return ticket;
    }

    @VisibleForTesting
    void storeInIndex(int index) {
        blocks[index] = true;
    }

    private int findFirstAvailableIndex(boolean[] blocks) {
        for (int i = 0; i < blocks.length; i++) {
            if (!blocks[i]) return i;
        }
        return -1;
    }
}
