package me.cumhax.chipshack.event;

import me.cumhax.chipshack.event.more.EventStage;

public class Render3DEvent extends EventStage {
   private final float partialTicks;

   public Render3DEvent(float partialTicks) {
      this.partialTicks = partialTicks;
   }

   public float getPartialTicks() {
      return this.partialTicks;
   }
}
