package me.cumhax.chipshack.module.render;

import me.cumhax.chipshack.event.RenderItemEvent;
import me.cumhax.chipshack.event.CommitEvent;
import me.cumhax.chipshack.event.stuff.EventPriority;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.setting.Setting;

public class ViewModel extends Module {

    private final Setting mainX = new Setting("mainX", this, 1.2, 0.0, 6.0);
    private final Setting mainY = new Setting("mainY", this, -0.95, -3.0, 3.0);
    private final Setting mainZ = new Setting("mainZ", this, -1.45, -5.0, 5.0);
    private final Setting offX = new Setting("offX", this, -1.2, -6.0, 0.0);
    private final Setting offY = new Setting("offY", this, -0.95, -3.0, 3.0);
    private final Setting offZ = new Setting("offZ", this, -1.45, -5.0, 5.0);
    private final Setting mainAngel = new Setting("mainAngle", this, 0.0, 0.0, 360.0);
    private final Setting mainRx = new Setting("mainRotationPointX", this, 0.0, -1.0, 1.0);
    private final Setting mainRy = new Setting("mainRotationPointY", this, 0.0, -1.0, 1.0);
    private final Setting mainRz = new Setting("mainRotationPointZ", this, 0.0, -1.0, 1.0);
    private final Setting offAngel = new Setting("offAngle", this, 0.0, 0.0, 360.0);
    private final Setting offRx = new Setting("offRotationPointX", this, 0.0, -1.0, 1.0);
    private final Setting offRy = new Setting("offRotationPointY", this, 0.0, -1.0, 1.0);
    private final Setting offRz = new Setting("offRotationPointZ", this, 0.0, -1.0, 1.0);
    private final Setting mainScaleX = new Setting("mainScaleX", this, 1.0, -5.0, 10.0);
    private final Setting mainScaleY = new Setting("mainScaleY", this, 1.0, -5.0, 10.0);
    private final Setting mainScaleZ = new Setting("mainScaleZ", this, 1.0, -5.0, 10.0);
    private final Setting offScaleX = new Setting("offScaleX", this, 1.0, -5.0, 10.0);
    private final Setting offScaleY = new Setting("offScaleY", this, 1.0, -5.0, 10.0);
    private final Setting offScaleZ = new Setting("offScaleZ", this, 1.0, -5.0, 10.0);

    	public ViewModel() 
	{
		super("ViewModel", "", Category.RENDER);
	}


    @CommitEvent(priority = EventPriority.LOW)
    public void onItemRender(RenderItemEvent event) {
        event.setMainX(mainX.getValue());
        event.setMainY(mainY.getValue());
        event.setMainZ(mainZ.getValue());

        event.setOffX(offX.getValue());
        event.setOffY(offY.getValue());
        event.setOffZ(offZ.getValue());

        event.setMainRAngel(mainAngel.getValue());
        event.setMainRx(mainRx.getValue());
        event.setMainRy(mainRy.getValue());
        event.setMainRz(mainRz.getValue());

        event.setOffRAngel(offAngel.getValue());
        event.setOffRx(offRx.getValue());
        event.setOffRy(offRy.getValue());
        event.setOffRz(offRz.getValue());

        event.setMainHandScaleX(mainScaleX.getValue());
        event.setMainHandScaleY(mainScaleY.getValue());
        event.setMainHandScaleZ(mainScaleZ.getValue());

        event.setOffHandScaleX(offScaleX.getValue());
        event.setOffHandScaleY(offScaleY.getValue());
        event.setOffHandScaleZ(offScaleZ.getValue());
    }
}
