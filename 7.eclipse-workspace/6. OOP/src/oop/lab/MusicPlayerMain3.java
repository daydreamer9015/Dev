package oop.lab;

public class MusicPlayerMain3 {
	public static void main(String[] args) {
		MusicPlayerData player = new MusicPlayerData();
		
		// 음악 플레이어 켜기
		on(player);

		// 볼륨 증가
		volUp(player);		
		volUp(player);		
				
		// 볼륨 감소
		volDown(player);		
		
		// 음악 플레이어 상태
		checkStatus(player);
		
		// 음악 플레이어 끄기
		off(player);		
	}

	static void off(MusicPlayerData player) {
		player.isOn = false;		
		System.out.println("음악 플레이어를 종료합니다.");
	}

	static void checkStatus(MusicPlayerData player) {
		System.out.println("음악 플레이어 상태 확인");
		if(player.isOn = true) {
			System.out.println("음악 플레이어 ON, 볼륨: " + player.volume);
		} else {
			System.out.println("음악 플레이어 OFF");
		}
	}

	static void volDown(MusicPlayerData player) {
		player.volume--;
		System.out.println("음악 플레이어 볼륨: " + player.volume);
	}

	static void volUp(MusicPlayerData player) {
		player.volume++;
		System.out.println("음악 플레이어 볼륨: " + player.volume);
	}

	static void on(MusicPlayerData player) {
		player.isOn = true;
		System.out.println("음악 플레이어를 시작합니다.");
	}
}
