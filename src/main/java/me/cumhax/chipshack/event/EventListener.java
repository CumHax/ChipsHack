package me.cumhax.chipshack.event;

import me.cumhax.chipshack.event.Event;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface EventListener {

    Class<? extends Event>[] events();
    int priority() default 3;

}
