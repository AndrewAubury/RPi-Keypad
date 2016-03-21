package me.Andrew.Keypad.Config;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;

public class Settings {
public String Code = "ABCD";

//Define Row Pins!
public Pin Row1 = RaspiPin.GPIO_00;
public Pin Row2 = RaspiPin.GPIO_01;
public Pin Row3 = RaspiPin.GPIO_02;
public Pin Row4 = RaspiPin.GPIO_03;

//Define Col Pins!
public Pin Col1 = RaspiPin.GPIO_04;
public Pin Col2 = RaspiPin.GPIO_05;
public Pin Col3 = RaspiPin.GPIO_06;
public Pin Col4 = RaspiPin.GPIO_07;

}
