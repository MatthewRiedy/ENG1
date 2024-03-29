package com.eng1.eng1game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.eng1.eng1game.eng1Game;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(1024,720);
		config.setResizable(false);
		config.setForegroundFPS(60);
		config.setTitle("Eng1Game");
		new Lwjgl3Application(new eng1Game(), config);
	}
}
