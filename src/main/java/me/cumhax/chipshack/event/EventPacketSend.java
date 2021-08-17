package me.cumhax.chipshack.event;

import net.minecraft.network.Packet;
import me.cumhax.chipshack.event.EventCancellable;

public class EventPacketSend extends EventCancellable {
	private Packet packet;

	public EventPacketSend(EventStage stage, Packet packet) {
		super(stage);

		this.packet = packet;
	}

	public void setPacket(Packet packet) {
		this.packet = packet;
	}

	public Packet getPacket() {
		return this.packet;
	}
}