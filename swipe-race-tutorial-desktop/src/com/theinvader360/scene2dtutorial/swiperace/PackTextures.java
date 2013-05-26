package com.theinvader360.scene2dtutorial.swiperace;

import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2.Settings;

public class PackTextures {
	public static void main(String[] args) {
                Settings settings = new Settings();
                settings.filterMin = TextureFilter.Linear;
                settings.filterMag = TextureFilter.Linear;
                TexturePacker2.process(settings, "../dev-images", "../swipe-race-tutorial-android/assets", "images");
        }
}
