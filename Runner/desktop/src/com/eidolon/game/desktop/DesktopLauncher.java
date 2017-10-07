package com.eidolon.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.eidolon.game.Runner;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.width = Runner.WIDTH;
		config.height = Runner.HEIGHT;
        config.title = Runner.TITLE;

		new LwjglApplication(new Runner(), config);
	}
}
