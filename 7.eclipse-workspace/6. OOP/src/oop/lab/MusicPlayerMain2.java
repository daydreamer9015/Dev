package oop.lab;

public class MusicPlayerMain2 {
	public static void main(String[] args) {
		MusicPlayerData player = new MusicPlayerData();
		
		// 음악 플레이어 켜기
		System.out.println("음악 플레이어를 시작합니다.");
		player.isOn = true;
		
		// 볼륨 증가
		player.volume++;
		System.out.println("음악 플레이어 볼륨: " + player.volume);
		
		// 볼륨 증가
		player.volume++;
		System.out.println("음악 플레이어 볼륨: " + player.volume);
				
		// 볼륨 감소
		player.volume--;
		System.out.println("음악 플레이어 볼륨: " + player.volume);
		
		// 음악 플레이어 상태
		System.out.println("음악 플레이어 상태 확인");
		if(player.isOn = true) {
			System.out.println("음악 플레이어 ON, 볼륨: " + player.volume);
		} else {
			System.out.println("음악 플레이어 OFF");
		}
		
		// 음악 플레이어 끄기
		System.out.println("음악 플레이어를 종료합니다.");
		player.isOn = false;
	}
}
