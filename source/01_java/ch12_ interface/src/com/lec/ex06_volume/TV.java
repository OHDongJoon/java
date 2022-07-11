package com.lec.ex06_volume;

// �� �ϸ� ���� �ø��� 
// �ٿ��ϸ� ���� ������ 
// Tv tv = new TV(45);
// tv, volumeUp() �ϸ� ���� 1���ö� 
public class TV implements IVolume {
	private final int TV_MAX_VOLUME = 50;
	private final int TV_MIN_VOLUME = 0;

	public TV() {
	}

	public TV(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}

	private int volumeLevel;

	@Override
	public void volumUp() {// Tv tv = new TV(3);
		// tv, volumeUp() �ϸ� ���� 1���ö� �Ű����� ���� �Ž���
		if (volumeLevel < TV_MAX_VOLUME) { // ���̳� ��� �� 50 ��
			volumeLevel++;
			System.out.println(" ���� 1 �÷Ⱦ� ���ó� ! ���� ����" + volumeLevel);
		} else {
			System.out.println(" ! ���� 50 �ִ�ġ�� �ӱ��� ����!");
		}
	}

	// Tv tv = new TV(45);
	@Override
	public void volumUp(int level) { // �Ű����� ���� level ��ŭ �÷��� ���� ��� �ִ� ���� 50 �̴ϱ� 50���� ������ ���;ߵ�
		if (volumeLevel + level <= TV_MAX_VOLUME) { // level ��ŭ ���� �ø�
			volumeLevel += level;
			System.out.println("TV ������" + level + "�÷� ����" + volumeLevel);
		} else { // levele ��ŭ ���ø� ���� ex. ���� ���� 45 �ε� levele�� 10 => �ŭ �ø��� ���(50), ���� 50
			int tempLevel = TV_MAX_VOLUME - volumeLevel;//temp�� �ƽ� 50 - �������� �� ���־� 10
			volumeLevel = TV_MAX_VOLUME; // 50 
			System.out.println("TV ������ " + level + "��ŭ ���ø���" + tempLevel + "��ŭ �÷� �ִ�ġ��  " + TV_MAX_VOLUME);
		}

	}

	@Override
	public void volumDown() {
		if (volumeLevel > TV_MIN_VOLUME) {
			volumeLevel--;
			System.out.println(" ���� 1 ���Ⱦ� ! ���� ����" + volumeLevel);
		} else {
			System.out.println(" ������ ���ڳ� ");
		}

	}

	@Override
	public void volumDown(int level) {
		if (volumeLevel - level >= TV_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("TV ������" + level + "���� ����" + volumeLevel);
		} else {
			int tempLevel = volumeLevel;
			System.out.println("TV ������ " + level + "��ŭ ��������" + tempLevel + "��ŭ ���� ������ ");
		}
	}

}
