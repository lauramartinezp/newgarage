package com.everis.alicante.courses.beca.java_.garage;

import java.util.Scanner;

import com.everis.alicante.courses.beca.java_.garage.domain.Bicycle;
import com.everis.alicante.courses.beca.java_.garage.domain.Car;
import com.everis.alicante.courses.beca.java_.garage.domain.MotorBike;
import com.everis.alicante.courses.beca.java_.garage.manager.BicycleManager;
import com.everis.alicante.courses.beca.java_.garage.manager.CarManager;
import com.everis.alicante.courses.beca.java_.garage.manager.MotorBikeManager;
import com.everis.alicante.courses.becajava.garage.ui.GarageMenu;

public class GarageRunner {
	
	static Scanner in = new Scanner(System.in);
	
	public static void main(String [] args) {
		String option;
		
		CarManager carManager = new CarManager();
		MotorBikeManager motorBikeManager = new MotorBikeManager();
		BicycleManager bicycleManager = new BicycleManager();
		loadData(carManager, motorBikeManager, bicycleManager);
		
		
		
		do {
			option=GarageMenu.getInstance().play();
			switch(option) {
			case "1.1":
				System.out.println(carManager.list());
				break;
			case "1.2":
				carManager.save(carBuilder());
				break;
			case "1.3":
				carManager.delete(selectCar(carManager));
				break;
				
			case "2.1":
				System.out.println(motorBikeManager.list());
				break;
			case "2.2":
				motorBikeManager.save(motorBikeBuilder());
				break;
				
				
			case "3.1":
				System.out.println(bicycleManager.list());
				break;
			case "3.2":
				bicycleManager.save(bicycleBuilder());
				break;
		}
		} while (!option.equals("0"));
		
	}

	private static Car carBuilder() {
		System.out.println("Insert your plate: ");
		String plate = in.nextLine();
		System.out.println("Insert your color: ");
		String color = in.nextLine();
		System.out.println("Insert your model: ");
		String model = in.nextLine();
		
		return new Car(plate, color, model);
	}
	
	private static Car selectCar() {
		
		
		return new Car(plate, color, model);
	}
	
	private static MotorBike motorBikeBuilder() {
		System.out.println("Insert your plate: ");
		String plate = in.nextLine();
		System.out.println("Insert your color: ");
		String color = in.nextLine();
		System.out.println("Insert your model: ");
		String model = in.nextLine();
		
		return new MotorBike(plate, color, model);
	}
	
	private static Bicycle bicycleBuilder() {
		System.out.println("Insert your color: ");
		String color = in.nextLine();
		System.out.println("Insert your model: ");
		String model = in.nextLine();
		
		return new Bicycle (color, model);
	}
	
	private void loadData (CarManager carManager) {
		for(int i=0;i<10; i++) {
			carManager.save(new Car("matricula"+i, "color"+i, "modelo"+i));
		}
	}
	
}
