package me.Andrew.Keypad.GPIO;

import java.util.HashMap;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.*;

import me.Andrew.Keypad.Main;
import me.Andrew.Keypad.Config.Settings;

public class GPIOMethords {
	public Main MA = Main.getInstance();
	public Settings settings = new Settings();
	final GpioController gpio = GpioFactory.getInstance();

	public HashMap<String, GpioPinDigitalInput> ColPins = new HashMap<String, GpioPinDigitalInput>();
	public HashMap<String, GpioPinDigitalOutput> RowPins = new HashMap<String, GpioPinDigitalOutput>();

	public void setupPins() {
		if (ColPins.isEmpty()) {
			ColPins.put("1", gpio.provisionDigitalInputPin(settings.Col1));
			ColPins.put("2", gpio.provisionDigitalInputPin(settings.Col2));
			ColPins.put("3", gpio.provisionDigitalInputPin(settings.Col3));
			ColPins.put("4", gpio.provisionDigitalInputPin(settings.Col4));
		}
		if (RowPins.isEmpty()) {
			RowPins.put("1", gpio.provisionDigitalOutputPin(settings.Row1));
			RowPins.put("2", gpio.provisionDigitalOutputPin(settings.Row2));
			RowPins.put("3", gpio.provisionDigitalOutputPin(settings.Row3));
			RowPins.put("4", gpio.provisionDigitalOutputPin(settings.Row4));
		}
		MA.store.ColPins = ColPins;
		MA.store.RowPins = RowPins;
	}

}
