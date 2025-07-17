package access;

public class SpeakerMain {
	public static void main(String[] args) {
		Speaker speaker = new Speaker(90);
		speaker.showVolume();
		
		speaker.VolumeUp();
		speaker.showVolume();
		
		speaker.VolumeUp();
		speaker.showVolume();
		
		// speaker.volume = 200;		// 필드에 직접 접근 (volume을 private으로 설정했기 때문에 접근 오류 발생함)
		speaker.showVolume();
	}
}
