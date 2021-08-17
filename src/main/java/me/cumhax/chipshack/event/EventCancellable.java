package me.cumhax.chipshack.event;

import me.cumhax.chipshack.event.more.EventStageable;

public class EventCancellable extends EventStageable {
	private boolean canceled;

	public EventCancellable() {}

	public EventCancellable(EventStage stage) {
		super(stage);
	}

	public EventCancellable(EventStage stage, boolean canceled) {
		super(stage);

		this.canceled = canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}

	public void cancel() {
		this.canceled = true;
	}

	public boolean isCancelled() {
		return this.canceled;
	}
}