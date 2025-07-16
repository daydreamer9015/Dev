package clazz;

public class MovieReviewMain {
	public static void main(String[] args) {
		MovieReview kpop = new MovieReview();		
		kpop.title = "케이팝 데몬 헌터스";
		kpop.review = "신나는 분위기";
		
		MovieReview yadang = new MovieReview();		
		yadang.title = "야당";
		yadang.review = "연기 뛰어나고 재미있음";
		
		System.out.println("영화 제목: "+kpop.title+", 리뷰: "+kpop.review);
		System.out.println("영화 제목: "+yadang.title+", 리뷰: "+yadang.review);
		
		
		
		MovieReview[] content = new MovieReview[2];
		content[0] = kpop;
		content[1] = yadang;
		
		for(int i = 0; i < content.length; i++) {
		System.out.println("영화 제목: "+ content[i].title + ", 리뷰: "+ content[i].review);
		}
	}
}
