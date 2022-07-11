package strategy2.modulaization;

import strategy2.interfaces.EngineHigh;
import strategy2.interfaces.EngineMid;
import strategy2.interfaces.FuelGasoline;
import strategy2.interfaces.Km15;

public class Sonata extends Car {
	public Sonata() {
		setEngine(new EngineMid());
		setKm(new Km15());
		setFuel(new FuelGasoline());
	}
	@Override
	public void shape() {
		System.out.println("소나타 외형은 door, sheet, handle로 이루어져 있습니다");

	}

}
