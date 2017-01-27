package de.info_ag.printer.ui.tui;

import java.util.Scanner;

import de.info_ag.printer.motor.MotorManager;

public class Tui {
	private Scanner scanner;
	private MotorManager motorManager;

	private String help = "Ende -> beendet das Programm.\n" + "Drucke -> Drucke ein beliebiges Ding.\n"
			+ "Kalibriere -> Kalibriere den Drucker.\n";

	private String printShapes = "";

	public Tui(MotorManager motorManager) {
		scanner = new Scanner(System.in);
		System.out.println("Hi, willkommen zu diesem supercoolen Drucker.");

		this.motorManager = motorManager;
	}

	public void start() {
		System.out.println("Sag mal, was ich machen soll.");
		String input = scan();
		if (input.equalsIgnoreCase("Hilfe")) {
			System.out.print(help);
		} else if (input.equalsIgnoreCase("Drucke")) {
			print();
		} else if (input.equalsIgnoreCase("Ende")) {
			System.exit(0);
		} else if (input.equalsIgnoreCase("Kalibriere")) {
			motorManager.calibrate();
		} else {
			System.out.println("Brauchst du Hilfe?");
			System.out.println("Gib 'Hilfe' ein, um zu erfahren, was du tun kannst.");
		}
	}

	// TODO Zweck dieser Methode?
	private String scan() {
		String input;
		input = scanner.nextLine();

		return input;
	}

	private void print() {
		System.out.println("Was soll ich drucken?");
		String printShape = scan();
		if (printShape.equals("Hi")) {
			motorManager.print(null);
		} else {
			System.out.println("Sry, aber " + printShape + " kenne ich nicht!");
			System.out.println("Ich kann schon diese tolle Sachen drucken:" + printShapes);
		}
	}
}
