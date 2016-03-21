package me.Andrew.Keypad;

import me.Andrew.Keypad.Config.Settings;
import me.Andrew.Keypad.Listener.ButtonInput;

public class Methords {
	Main MA = Main.getInstance();
	Settings settings = new Settings();
    ButtonInput buttonIn = new ButtonInput();
	
	public String getCode() {
		if (settings.Code.matches(".*[*#qwertyuiopsfghjklzxvnmQWERTYUIOPSFGHJKLZXVNM!£$%^&*()-_+#=*}].*")) {
			settings.Code = "1234";
			return ("1234");
		} else {
			if (settings.Code == "") {
				settings.Code = "1234";
				return ("1234");
			} else {
				return settings.Code;
			}
		}
	}
public void testButtonListener(){
	buttonIn.start();
}
public void testButtonListener1(){
	buttonIn.stop();
}
public boolean ComareCodes(){
	if(MA.store.CodeEntered.equalsIgnoreCase(getCode())){
		return true;
	}else{
		return false;
	}
}
	public String getButton(int Row, int Col) {
		// 1 2 3 A
		// 4 5 6 B
		// 7 8 9 C
		// * 0 # D

		if (Row == 1) {
			if (Col == 1) {
				return ("1");
			} else if (Col == 2) {
				return ("2");
			} else if (Col == 3) {
				return ("3");
			} else if (Col == 4) {
				return ("A");
			} else {
				return ("Error: Invalid Location");
			}
		} else if (Row == 2) {
			if (Col == 1) {
				return ("4");
			} else if (Col == 2) {
				return ("5");
			} else if (Col == 3) {
				return ("6");
			} else if (Col == 4) {
				return ("B");
			} else {
				return ("Error: Invalid Location");
			}
		} else if (Row == 3) {
			if (Col == 1) {
				return ("7");
			} else if (Col == 2) {
				return ("8");
			} else if (Col == 3) {
				return ("9");
			} else if (Col == 4) {
				return ("C");
			} else {
				return ("Error: Invalid Location");
			}
		} else if (Row == 4) {
			if (Col == 1) {
				return ("*");
			} else if (Col == 2) {
				return ("0");
			} else if (Col == 3) {
				return ("#");
			} else if (Col == 4) {
				return ("D");
			} else {
				return ("Error: Invalid Location");
			}
		} else {
			return ("Error: Invalid Location");
		}

	}
}