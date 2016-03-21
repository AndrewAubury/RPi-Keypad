package me.Andrew.Keypad;

import me.Andrew.Keypad.Config.Settings;
import me.Andrew.Keypad.GPIO.GPIOMethords;

public class Main {
	private static Main instance = null;
	
	public Settings set = new Settings();
	public static Methords Meths = new Methords();
	public static GPIOMethords GPIOMeths;
	public Storage store = new Storage();
	
	public static void main(String[] args) {
			Meths.buttonIn.start();
			GPIOMeths = new GPIOMethords();
	}
	public static Main getInstance() {
	      if(instance == null) {
	         instance = new Main();
	      }
	      return instance;
	   }
	
}
