package me.cumhax.chipshack.event;

import me.cumhax.chipshack.event.EventPriority;
import me.cumhax.chipshack.event.EventType;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * Indicates a {@link Method} should be invoked when the designated event is fired in an {@link EventManager}.
 *
 * <p>
 * A proper {@link Subscribe} {@link Method} has either ONE (1) or TWO (2) parameters.
 * <br>
 * If the {@link Method} has ONE parameter, it must have a type that extends the {@link EventManager}'s {@link EventManager#BASE_CLASS}.
 * This method will only be invoked with the specified {@link #timing()}.
 * <br>
 * If the {@link Method} has TWO parameters, the first parameter must have a type that extends the {@link EventManager}'s {@link EventManager#BASE_CLASS},
 * and the second parameter have the type {@link EventType}. This method will be invoked for both {@link EventType#PRE}
 * and {@link EventType#POST} events.
 * </p>
 *
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Subscribe {
    /**
     * Indicates the priority of this {@link Subscribe}, by default set to {@link EventPriority#MEDIUM}.
     *
     * @see EventPriority
     *
     * @return the priority of this {@link Subscribe}
     */
    EventPriority priority() default EventPriority.MEDIUM;

    /**
     * Indicates the timing of this {@link Subscribe}, by default set to {@link EventType#PRE}.
     *
     * @see EventType
     *
     * @return the timing of this {@link Subscribe}
     */
    EventType timing() default EventType.PRE;

    /**
     * Indicates if this {@link Subscribe} is persistent or not persistent.
     *
     * <p>
     * Although this is implementation specific, {@code persistent} {@link Subscribe}s are typically registered at the start
     * of program execution or before the desired event will be invoked for the first time, whereas {@code non-persistent}
     * {@link Subscribe}s are typically {@code registered} and {@code deregistered} throughout the runtime of the application.
     * </p>
     *
     * @return if this {@link Subscribe} should be persistent or not persistent
     */
    boolean persistent() default false;
}
