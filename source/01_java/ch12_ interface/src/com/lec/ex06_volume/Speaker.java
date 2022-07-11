package com.lec.ex06_volume;
//Speaker s = new Speaker(45)
// �� �ϸ� ���� �ø��� 
// �ٿ��ϸ� ���� ������ 
// Speaker Speaker = new Speaker(45);
// Speaker, volumeUp() �ϸ� ���� 1���ö� 
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
		// Speaker, volumeUp() �ϸ� ���� 1���ö� �Ű����� ���� �Ž���
		if (volumeLevel < SPEAKER_MAX_VOLUME) { // ���̳� ��� �� 50 ��
			volumeLevel++;
			System.out.println(" ���� 1 �÷Ⱦ� ���ó� ! ���� ����" + volumeLevel);
		} else {
			System.out.println("���ó� ! ���� 50 �ִ�ġ�� �ӱ��� ����!");
		}
	}

	// Speaker Speaker = new Speaker(45);
	@Override
	public void volumUp(int level) { // �Ű����� ���� level ��ŭ �÷��� ���� ��� �ִ� ���� 50 �̴ϱ� 50���� ������ ���;ߵ�
		if (volumeLevel + level <= SPEAKER_MAX_VOLUME) { // level ��ŭ ���� �ø�
			volumeLevel += level;
			System.out.println("Speaker ������" + level + "�÷� ����" + volumeLevel);
		} else { // levele ��ŭ ���ø� ���� ex. ���� ���� 45 �ε� levele�� 10 => �ŭ �ø��� ���(50), ���� 50
			int tempLevel = SPEAKER_MAX_VOLUME - volumeLevel;
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("Speaker ������ " + level + "��ŭ ���ø���" + tempLevel + "��ŭ �÷� �ִ�ġ��  " + SPEAKER_MAX_VOLUME);
		}

	}

	@Override
	public void volumDown() {
		if (volumeLevel > SPEAKER_MIN_VOLUME) {
			volumeLevel--;
			System.out.println(" ���� 1 ���Ⱦ� ���ó�! ���� ����" + volumeLevel);
		} else {
			System.out.println("���ó�! ������ ���ڳ� ");
		}

	}

	@Override
	public void volumDown(int level) {
		if (volumeLevel - level >= SPEAKER_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("Speaker ������" + level + "���� ����" + volumeLevel);
		} else {
			int tempLevel = volumeLevel;
			System.out.println("Speaker ������ " + level + "��ŭ ��������" + tempLevel + "��ŭ ���� ������ �ù߷Ҿ�");
		}
	}

}
