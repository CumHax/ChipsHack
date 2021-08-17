package me.cumhax.chipshack.event.more;

public class EventStageable {
	private EventStage stage;

	public EventStageable() {}

	public EventStageable(EventStage stage) {
		this.stage = stage;
	}

	public void setStage(EventStage stage) {
		this.stage = stage;
	}

	public EventStage getStage() {
		return this.stage;
	}

	public enum EventStage {
		PRE, POST;
	}
}