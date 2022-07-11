package strategy2.modulaization;

import strategy2.interfaces.*;

//��ӹ��� ��� : 3���� ��ǰ ����/ // shape ���߻� �������� ���վ�
public class Genesis extends Car {
	public Genesis() {
		setEngine(new EngineHigh());
		setKm(new Km10());
		setFuel(new FuelGasoline());//fuel = new FuelGasoline();
	}
	@Override
	public void shape() {
		System.out.println("���׽ý� ����� door, sheet, handle�� �̷���� �ֽ��ϴ�.");

	}

}
