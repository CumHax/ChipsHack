package me.cumhax.chipshack.event;

import me.cumhax.chipshack.event.EventType;

/**
 * Represents a common base object for {@link EventManager}s.
 *
 * <p>
 * This object allows for events to be {@link #cancelled}. The implications of a {@link #cancelled} event is
 * implementation specific, but this typically indicates the execution of the designated event should not occur.
 * <br>
 * Depending on the implementation of the specific {@link Event}, an {@link Event} with timing set to
 * {@link EventType#POST} may or may not be fired if the {@link EventType#PRE} {@link Event} is {@link #cancelled}.
 * <br>
 * Typically, only {@link Subscribe}s with timing set to {@link EventType#PRE} can be {@link #cancelled},
 * and attempting to cancel an {@link Subscribe} with timing set to {@link EventType#POST}
 * will likely be ignored, or in many cases, illegal.
 * </p>
 */
public class Event {
    /**
     * Indicates if this {@link Event} has been designated as cancelled (TRUE) or approved (FALSE).
     *
     * @see #setCancelled(boolean)
     * @see #isCancelled()
     */
    private boolean cancelled;

    /**
     * Returns if this {@link Event} has been designated as {@link #cancelled}.
     *
     * @return if this {@link Event} is {@link #cancelled}
     */
    public final boolean isCancelled() {
        return this.cancelled;
    }

    /**
     * Designates this {@link Event} as {@link #cancelled} or NOT {@link #cancelled}.
     *
     * <p>
     * If {@code cancelled} is set to TRUE, this designates this {@link Event} as {@link #cancelled}.
     * <br>
     * If {@code cancelled} is set to FALSE, this designates this {@link Event} as NOT {@link #cancelled} (approved).
     * </p>
     *
     * @param cancelled indicates the cancellation status of this event
     */
    public final void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    /**
     * Designates this event as {@link #cancelled}.
     *
     * @see #setCancelled(boolean) with {@code FALSE} {@code cancelled} argument
     */
    public final void cancel() {
        this.setCancelled(true);
    }

    /**
     * Designates this event as NOT {@link #cancelled} (approved).
     *
     * @see #setCancelled(boolean) with {@code TRUE} {@code cancelled} argument
     */
    public final void restore() {
        this.setCancelled(false);
    }
}
