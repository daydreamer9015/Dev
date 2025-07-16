package oop.lab;

public class MusicPlayerMain4 {
	public static void main(String[] args) {
		MusicPlayer player = new MusicPlayer();
		
		// 음악 플레이어 켜기
		player.on();

		// 볼륨 증가
		player.volUp();		
		
		// 볼륨 증가
		player.volUp();		
				
		// 볼륨 감소
		player.volDown();		
		
		// 음악 플레이어 상태
		player.checkStatus();
		
		// 음악 플레이어 끄기
		player.off();		
	}
}
