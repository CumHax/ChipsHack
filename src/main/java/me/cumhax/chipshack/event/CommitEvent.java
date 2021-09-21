package me.cumhax.chipshack.event;

import me.cumhax.chipshack.event.stuff.EventPriority;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CommitEvent {
    public EventPriority priority() default EventPriority.NONE;
}
