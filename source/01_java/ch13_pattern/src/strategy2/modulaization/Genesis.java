package strategy2.modulaization;

import strategy2.interfaces.*;

//상속받은 멤버 : 3가지 부품 변수/ // shape ㅊ추상 나머지는 다잇어
public class Genesis extends Car {
	public Genesis() {
		setEngine(new EngineHigh());
		setKm(new Km10());
		setFuel(new FuelGasoline());//fuel = new FuelGasoline();
	}
	@Override
	public void shape() {
		System.out.println("제네시스 모양은 door, sheet, handle로 이루어져 있습니다.");

	}

}
