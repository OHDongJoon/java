package com.lec.ex06_volume;
//Speaker s = new Speaker(45)
// 업 하면 볼륨 올리고 
// 다운하면 볼륨 내리고 
// Speaker Speaker = new Speaker(45);
// Speaker, volumeUp() 하면 볼륨 1씩올라감 
public class Speaker implements IVolume {
	private final int SPEAKER_MAX_VOLUME = 100;
	private final int SPEAKER_MIN_VOLUME = 0;

	public Speaker() {
	}

	public Speaker(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}

	private int volumeLevel;

	@Override
	public void volumUp() {// Speaker Speaker = new Speaker(3);
		// Speaker, volumeUp() 하면 볼륨 1씩올라감 매개변수 없는 거실행
		if (volumeLevel < SPEAKER_MAX_VOLUME) { // 파이널 상수 로 50 들어감
			volumeLevel++;
			System.out.println(" 볼륨 1 올렸어 병시나 ! 현재 볼륨" + volumeLevel);
		} else {
			System.out.println("병시나 ! 지금 50 최대치야 귓구녕 터져!");
		}
	}

	// Speaker Speaker = new Speaker(45);
	@Override
	public void volumUp(int level) { // 매개변수 들어온 level 만큼 올려줘 현재 상수 최대 볼륨 50 이니까 50보다 작은거 들어와야됨
		if (volumeLevel + level <= SPEAKER_MAX_VOLUME) { // level 만큼 볼륨 올림
			volumeLevel += level;
			System.out.println("Speaker 볼륨을" + level + "올려 현재" + volumeLevel);
		} else { // levele 만큼 못올릴 경유 ex. 현재 볼륨 45 인데 levele이 10 => 몇만큼 올릴지 계산(50), 볼륨 50
			int tempLevel = SPEAKER_MAX_VOLUME - volumeLevel;
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("Speaker 볼륨을 " + level + "만큼 못올리고" + tempLevel + "만큼 올려 최대치야  " + SPEAKER_MAX_VOLUME);
		}

	}

	@Override
	public void volumDown() {
		if (volumeLevel > SPEAKER_MIN_VOLUME) {
			volumeLevel--;
			System.out.println(" 볼륨 1 내렸어 병시나! 현재 볼륨" + volumeLevel);
		} else {
			System.out.println("병시나! 내릴꺼 없자나 ");
		}

	}

	@Override
	public void volumDown(int level) {
		if (volumeLevel - level >= SPEAKER_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("Speaker 볼륨을" + level + "내려 현재" + volumeLevel);
		} else {
			int tempLevel = volumeLevel;
			System.out.println("Speaker 볼륨을 " + level + "만큼 못내리고" + tempLevel + "만큼 내려 못내려 시발롬아");
		}
	}

}
