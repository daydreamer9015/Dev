package oop.lab;

public class MusicPlayer {
	int volume = 0;
	boolean isOn = false;
	

	void off() {
		isOn = false;
		System.out.println("음악 플레이어를 종료합니다.");
	}

	void checkStatus() {
		System.out.println("음악 플레이어 상태 확인");
		if(isOn = true) {
			System.out.println("음악 플레이어 ON, 볼륨: " + volume);
		} else {
			System.out.println("음악 플레이어 OFF");
		}
	}

	void volDown() {
		volume--;
		System.out.println("음악 플레이어 볼륨: " + volume);
	}

	void volUp() {
		volume++;
		System.out.println("음악 플레이어 볼륨: " + volume);
	}

	void on() {
		isOn = true;
		System.out.println("음악 플레이어를 시작합니다.");
	}
}
