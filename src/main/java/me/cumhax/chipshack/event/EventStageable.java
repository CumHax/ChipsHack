package me.cumhax.chipshack.event;

import net.minecraftforge.fml.common.eventhandler.Event;

public class EventStageable extends Event {

    private final Stage stage;

    public EventStageable(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

}
