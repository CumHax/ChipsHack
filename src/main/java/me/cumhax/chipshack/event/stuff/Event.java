package me.cumhax.chipshack.event.stuff;


public class Event {
    private boolean isCancelled;

    public Event(){
        isCancelled = false;
    }

    /**
     * @return if the event is cancelled
     */
    public boolean isCancelled() {
        return isCancelled;
    }

    /**
     * @param cancelled boolean to set if the event is cancelled
     */
    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }
}
