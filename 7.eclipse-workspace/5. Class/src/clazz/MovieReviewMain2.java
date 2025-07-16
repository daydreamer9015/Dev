package clazz;
/*
 * 배열을 도입하고 영화 리뷰를 배열에서 관리하시오.
 * 리뷰 출력할 때 배열과 for문 사용 - 향상된 for
 */
public class MovieReviewMain2 {
	public static void main(String[] args) {
		MovieReview kpop = new MovieReview();		
		kpop.title = "케이팝 데몬 헌터스";
		kpop.review = "신나는 분위기";
		
		MovieReview yadang = new MovieReview();		
		yadang.title = "야당";
		yadang.review = "연기 뛰어나고 재미있음";
		
		MovieReview[] content = new MovieReview[2];
		content[0] = kpop;
		content[1] = yadang;
		
		for(MovieReview review : content) {
		System.out.println("영화 제목: "+ review.title + ", 리뷰: "+ review.review);
		}
	}
}
