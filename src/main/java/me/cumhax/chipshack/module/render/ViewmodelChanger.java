package me.cumhax.chipshack.module.render;

import me.cumhax.chipshack.value.Value;
import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;

public class ViewmodelChanger extends Module 
{
	public ViewmodelChanger() {
        super("ViewmodelChanger", "", Category.RENDER);
    }

    public static ViewmodelChanger INSTANCE;

    {
        INSTANCE = this;
    }

    public final Value<Integer> translateX = new Value<>("TranslateX", 0, -100, 100);
    public final Value<Integer> translateY = new Value<>("TranslateY", 0, -100, 100);
    public final Value<Integer> translateZ = new Value<>("TranslateZ", 0, -100, 100);

    public final Value<Integer> rotateX = new Value<>("RotateX", 0, -100, 100);
    public final Value<Integer> rotateY = new Value<>("RotateY", 0, -100, 100);
    public final Value<Integer> rotateZ = new Value<>("RotateZ", 0, -100, 100);

    public final Value<Integer> scaleX = new Value<>("ScaleX", 100, 0, 100);
    public final Value<Integer> scaleY = new Value<>("ScaleY", 100, 0, 100);
    public final Value<Integer> scaleZ = new Value<>("ScaleZ", 100, 0, 100);

}
