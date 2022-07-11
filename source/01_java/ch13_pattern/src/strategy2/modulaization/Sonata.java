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
		System.out.println("�ҳ�Ÿ ������ door, sheet, handle�� �̷���� �ֽ��ϴ�");

	}

}
