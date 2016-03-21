package me.Andrew.Keypad;

import me.Andrew.Keypad.Config.Settings;
import me.Andrew.Keypad.GPIO.GPIOMethords;

public class Main {
	private static Main instance = null;

	public static Settings set;
	public static Methords Meths;
	public static GPIOMethords GPIOMeths;
	public static Storage store;

	public static void main(String[] args) {
		set = new Settings();
		store = new Storage();
		Meths = new Methords();
		GPIOMeths = new GPIOMethords();
		Meths.buttonIn.start();

	}

	public static Main getInstance() {
		if (instance == null) {
			instance = new Main();
		}
		return instance;
	}

}
