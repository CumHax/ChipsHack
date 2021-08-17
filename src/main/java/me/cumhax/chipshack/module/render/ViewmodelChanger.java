package me.cumhax.chipshack.module.render;

import me.cumhax.chipshack.setting.Setting;
import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;

public class ViewmodelChanger extends Module {
	
		public ViewmodelChanger() {
		super("ViewmodelChanger", "", Category.RENDER);
	}
	
    public static ViewmodelChanger INSTANCE;

    {
        INSTANCE = this;
    }

    private final Setting translateX = new Setting("TransLateX", this, 0, -100, 100);
    private final Setting translateY = new Setting("TransLateY", this, 0, -100, 100);
    private final Setting translateZ = new Setting("TransLateZ", this, 0, -100, 100);

    private final Setting rotateX = new Setting("RotateX", this, 0, -100, 100);
    private final Setting rotateY = new Setting("RotateY", this, 0, -100, 100);
	private final Setting rotateZ = new Setting("RotateZ", this, 0, -100, 100);

    private final Setting scaleX = new Setting("ScaleX", this, 0, -100, 100);
    private final Setting scaleY = new Setting("ScaleY", this, 0, -100, 100);
    private final Setting scaleZ = new Setting("ScaleZ", this, 0, -100, 100);
   }
