package me.cumhax.chipshack.gui.clickgui2;

import java.awt.Color;
import java.util.ArrayList;

import me.cumhax.chipshack.Client;
import me.cumhax.chipshack.module.Category;
import me.cumhax.chipshack.module.Module;
import me.cumhax.chipshack.gui.clickgui2.RenderUtil;
import me.cumhax.chipshack.gui.clickgui2.font.FontUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;

public class Window
{
	ScaledResolution scaledRes = new ScaledResolution(Minecraft.getMinecraft());
	private final ArrayList<ModuleButton> buttons = new ArrayList<>();
	private final Category category;
	private final int W;
	private final int H;
	private final ArrayList<ModuleButton> buttonsBeforeClosing = new ArrayList<>();
	private int X;
	private int Y;
	private int dragX;
	private int dragY;
	private boolean open = true;
	private boolean dragging;
	private int showingButtonCount;
	private boolean opening;
	private boolean closing;

	public Window(Category category, int x, int y, int w, int h)
	{
		this.category = category;
		X = x;
		Y = y;
		W = w;
		H = h;

		int yOffset = Y + H;

		for (Module module : Client.moduleManager.getModules(category))
		{
			ModuleButton button = new ModuleButton(module, X, yOffset, W, H);
			buttons.add(button);
			yOffset += H;
		}
		showingButtonCount = buttons.size();
	}

	public void render(int mX, int mY)
	{
		RenderUtil.drawGradientSideways(0, 0, 0 + 970, 0 + 2, new Color(64,41,213,255).getRGB(), new Color(124,9,77, 255).getRGB());
		
		if (dragging)
		{
			X = dragX + mX;
			Y = dragY + mY;
		}
		
		Gui.drawRect(X, Y + 1, X + W, Y + H, new Color(24,14,60, 255).getRGB());
		Gui.drawRect(X, Y + 1, X + 1, Y + H, new Color(64,41,213, 255).getRGB());
		Gui.drawRect(X + 104, Y + 1, X + W, Y + H, new Color(124,9,77, 255).getRGB());
		RenderUtil.drawGradientSideways(X, Y + 1, X + W, Y + 2, new Color(64,41,213,255).getRGB(), new Color(124,9,77, 255).getRGB());
		RenderUtil.drawGradientSideways(X, Y + 14, X + W, Y + 15, new Color(64,41,213,255).getRGB(), new Color(124,9,77, 255).getRGB());
		FontUtil.drawStringWithShadow(category.getName(), X + ( W / 2 ) - (FontUtil.getStringWidth(category.getName()) / 2), Y + 5, new Color(255, 255, 255, 255).getRGB());

		if (open || opening || closing)
		{
			int modY = Y + H;

			int moduleRenderCount = 0;
			for (ModuleButton moduleButton : buttons)
			{
				moduleRenderCount++;

				if (moduleRenderCount < showingButtonCount + 1)
				{
					moduleButton.setX(X);
					moduleButton.setY(modY);

					moduleButton.render(mX, mY);

					if (!moduleButton.isOpen() && opening && buttonsBeforeClosing.contains(moduleButton))
					{
						moduleButton.processRightClick();
					}

					modY += H;

					if (moduleButton.isOpen() || moduleButton.isOpening() || moduleButton.isClosing())
					{

						int settingRenderCount = 0;
						for (SettingButton settingButton : moduleButton.getButtons())
						{
							settingRenderCount++;

							if (settingRenderCount < moduleButton.getShowingModuleCount() + 1)
							{
								settingButton.setX(X);
								settingButton.setY(modY);

								settingButton.render(mX, mY);

								modY += H;
							}
						}
					}
				}
			}
		}

		if (opening)
		{
			showingButtonCount++;
			if (showingButtonCount == buttons.size())
			{
				opening = false;
				open = true;
				buttonsBeforeClosing.clear();
			}
		}

		if (closing)
		{
			showingButtonCount--;
			if (showingButtonCount == 0 || showingButtonCount == 1)
			{
				closing = false;
				open = false;
			}
		}

	}

	public void mouseDown(int mX, int mY, int mB)
	{
		if (isHover(X, Y, W, H, mX, mY))
		{
			if (mB == 0)
			{
				dragging = true;
				dragX = X - mX;
				dragY = Y - mY;
			}
			else if (mB == 1)
			{
				if (open && !opening && !closing)
				{
					
				}
			}
		}

		if (open)
		{
			for (ModuleButton button : buttons)
			{
				button.mouseDown(mX, mY, mB);
			}
		}
	}

	public void mouseUp(int mX, int mY)
	{
		dragging = false;

		if (open)
		{
			for (ModuleButton button : buttons)
			{
				button.mouseUp(mX, mY);
			}
		}
	}

	public void keyPress(int key)
	{
		if (open)
		{
			for (ModuleButton button : buttons)
			{
				button.keyPress(key);
			}
		}
	}

	public void close()
	{
		for (ModuleButton button : buttons)
		{
			button.close();
		}
	}

	private boolean isHover(int X, int Y, int W, int H, int mX, int mY)
	{
		return mX >= X && mX <= X + W && mY >= Y && mY <= Y + H;
	}

	public int getY()
	{
		return Y;
	}

	public void setY(int y)
	{
		Y = y;
	}
}
