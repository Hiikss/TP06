package fr.thomas.module06;

import java.time.LocalDate;
import java.time.Month;

public class Location {

	public static void main(String[] args) {
		Cycle[] cycles = {
				new Velo("Lapierre", "speed 400", LocalDate.of(2022, Month.JANUARY, 6), 27),
				new Velo("Btwin", "riverside 900", LocalDate.of(2023, Month.APRIL, 9), 10),
				new Gyropode("Segway", "Ninebot Elite", LocalDate.of(2023, Month.JUNE, 5), 40, 150),
				new Gyropode("Weebot", "Echo", LocalDate.of(2022, Month.MAY, 2), 35, 160),
				new Gyroroue("Immotion", "v8", LocalDate.of(2023, Month.MARCH, 25), 40),
				new Gyroroue("Segway", "Ninebot One E+", LocalDate.of(2023, Month.MARCH, 25), 30)
		};
		
		for(Cycle c : cycles) {
			System.out.println(c.toString() + " " + c.getTarifLocation() + "€/heure");
		}

	}

}
