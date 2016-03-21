package me.Andrew.Keypad.Listener;

import java.util.HashMap;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;

import me.Andrew.Keypad.Main;

public class ButtonInput {
	public boolean isRunning = false;
	public GpioController gpio = GpioFactory.getInstance();
	Main MA = Main.getInstance();

	public HashMap<String, GpioPinDigitalInput> ColPins = null;
	public HashMap<String, GpioPinDigitalOutput> RowPins = null;

	public void start() {
		isRunning = true;
		ButtonListener();
	}

	public void stop() {
		isRunning = false;
	}

	private int ScanRow(int row) {
		int Col = 0;
		RowPins.get(String.valueOf(row)).high();
		if (ColPins.get("1").isHigh()) {
			Col = 1;
		} else if (ColPins.get("2").isHigh()) {
			Col = 2;
		} else if (ColPins.get("3").isHigh()) {
			Col = 3;
		} else if (ColPins.get("4").isHigh()) {
			Col = 4;
		}
		return Col;
	}
	private void ButtonListener() {
		Main.GPIOMeths.setupPins();
		RowPins = Main.store.RowPins;
		ColPins = Main.store.ColPins;

		int Row = 1;
		int Response = 0;

		while (isRunning == true) {
			if (!(0 < Row && Row < 5)) {
				Row = 1;
			}
			Response = ScanRow(Row);
			if (Response != 0) {
				stop();
				buttonPressEvent(Row, Response);

			}
			Row++;

		}
	}

	public void buttonPressEvent(int Row, int Col) {
		String ButtonPressed = Main.Meths.getButton(Row, Col);
		if (ButtonPressed.equalsIgnoreCase("*")) {
			System.out.println("Code Logging Started");
			Main.store.CodeMode = true;
		} else if (ButtonPressed.equalsIgnoreCase("#")) {
			System.out.println("Code Logging Ended");
			if (Main.Meths.ComareCodes()) {
				System.out.println("Code Correct");
			} else {
				System.out.println("Code Incorrect");
			}
			Main.store.CodeMode = false;
		} else {
			if (Main.store.CodeMode == false) {
				System.out.println("Code Logging Not Running");
			} else {
				Main.store.CodeEntered = Main.store.CodeEntered + ButtonPressed;
				System.out.println("Code Entered: " + Main.store.CodeEntered);
			}
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		} finally {
			start();
		}

	}
}
