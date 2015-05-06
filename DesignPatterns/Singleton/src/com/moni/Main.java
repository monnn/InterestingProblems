package com.moni;

public class Main {

    public static void main(String[] args) {
	    Singleton lonelyObject = Singleton.getInstance();
        lonelyObject.showMessage();
    }
}
