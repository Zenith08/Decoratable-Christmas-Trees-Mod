package me.kk47.dct;

import java.util.ArrayList;
import java.util.List;

import me.kk47.dct.api.IItemBobble;
import me.kk47.dct.api.IItemDecoration;
import me.kk47.dct.api.IItemLights;
import me.kk47.dct.api.IItemTopper;

public class ChristmasDecorationRegistry {

	private static List<IItemDecoration> decorations = new ArrayList<IItemDecoration>();
	
	private static List<IItemBobble> bobbles = new ArrayList<IItemBobble>();
	private static List<IItemLights> lights = new ArrayList<IItemLights>();
	private static List<IItemTopper> toppers = new ArrayList<IItemTopper>();
	
	public static void addBobble(IItemBobble ib) {
		decorations.add(ib);
		bobbles.add(ib);
	}
	
	public static void addLights(IItemLights il) {
		decorations.add(il);
		lights.add(il);
	}
	
	public static void addTopper(IItemTopper it) {
		decorations.add(it);
		toppers.add(it);
	}

	public static List<IItemDecoration> getDecorations() {
		return decorations;
	}

	public static List<IItemBobble> getBobbles() {
		return bobbles;
	}

	public static List<IItemLights> getLights() {
		return lights;
	}

	public static List<IItemTopper> getToppers() {
		return toppers;
	}
	
}
