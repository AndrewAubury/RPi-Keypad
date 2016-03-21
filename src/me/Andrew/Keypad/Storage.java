package me.Andrew.Keypad;

import java.util.HashMap;

import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;

public class Storage {
	public String CodeEntered = "";
	public HashMap<String,GpioPinDigitalInput> ColPins = null;
	public HashMap<String,GpioPinDigitalOutput> RowPins = null;
	public boolean CodeMode = false;
}
