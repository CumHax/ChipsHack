package me.cumhax.chipshack.event;

public class UpdateEvent extends EventStageable {

    public UpdateEvent(Stage stage) {
        super(stage);
    }

    public boolean getType () {
        return false;
    }
}
