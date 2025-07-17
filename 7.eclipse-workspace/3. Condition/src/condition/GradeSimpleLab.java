package condition;

	public class GradeSimpleLab {
		public static void main(String[] args) {
			// 학생 시험 점수
			String studentName ="이순신";
			int mathScore = 85;
			int engScore = 92;
			int korScore = 78;
			
			System.out.println("=== 성적 관리 시스템 ===");
			System.out.println("학생 이름 : "+ studentName);
			System.out.println("수학 점수 : "+ mathScore +"점");
			System.out.println("영어 점수 : "+ engScore +"점");
			System.out.println("국어 점수 : "+ korScore +"점");
			System.out.println("\n");
			
			// 점수 유효성 검증 (0 ~ 100점 사이)
			boolean isValidScore = true;  //기본값:true
			
			if (mathScore <0 || mathScore>100) {
				System.out.println(" ❌ 수학 점수가 잘못되었습니다. (0~100점)");
				isValidScore = false;
			}

			
			if (engScore <0 || engScore>100) {
				System.out.println(" ❌ 영어 점수가 잘못되었습니다. (0~100점)");
				isValidScore = false;
			}

			
			if (korScore <0 || korScore>100) {
				System.out.println(" ❌ 국어 점수가 잘못되었습니다. (0~100점)");
				isValidScore = false;
			}
			
			// 점수가 유효하지 않으면 처리 중단
			if(!isValidScore) {
				System.out.println("점수를 다시 확인해주세요.");
				return;
			}
			
			// 모든 점수가 유효한 경우
			System.out.println("모든 점수가 유효합니다. 성적을 계산합니다...\n");

			int totalScore = mathScore + engScore +korScore;
			double average = totalScore / 3.0;		//왼쪽과 오른쪽의 숫자 타입이 같아야하는데, 오른쪽이 정수일 가능성도 있으므로 3이 아니라 3.0으로 나눔
			
			System.out.println("=== 성적 계산 결과 ===");
			System.out.println("총점 : "+ totalScore + "점");
			/*
			 * 		%d : 정수
			 * 		%f : 실수 (float, double 포함) - 기본 소수점 6자리까지 표시 (ex: %.1f : 소수점 첫재짜리까지 표시)
			 * 		%s : 문자열
			 * 		%c : 문자
			 * 		%n : 줄바꿈
			 */
			System.out.println("평균 : " + String.format("%.1f", average) +"점");    //%f:실수형. %.1f : 소숫점 이하 첫째자리까지 출력 
			
			String grade = "";
			if(average >=90) {
				grade ="A";
				System.out.println("등급 : A(우수)");
			} else if (average >=80) {
				grade ="B";
				System.out.println("등급 : B(양호)");
			} else if (average >=70) {
				grade ="C";
				System.out.println("등급 : C(보통)");
			} else if (average >=60) {
				grade ="D";
				System.out.println("등급 : D(미흡)");
			} else {
				grade ="F";
				System.out.println("등급 : F(불합격)");
			};
			
			
			
			
			
			
			// 여기서부터 수업메모에 있는 문제
			
			System.out.println("\n=== 과목별 분석 ===");
			
			int maxScore=mathScore;
			String maxSubject="수학";
			
			if (engScore > maxScore) {
				maxScore = engScore;
				maxSubject = "영어"; 
			} else if (korScore > maxScore) {
				maxScore = korScore;
				maxSubject = "국어";
			}
			
			int minScore = mathScore;
			String minSubject = "수학";
			
			if (engScore < minScore) {
				minScore = engScore;
				minSubject = "영어"; 
			} else if (korScore < minScore) {
				minScore = korScore;
				minSubject = "국어";
			};
			
			System.out.println("🔥 감정 과목: "+ maxSubject + " ("+ maxScore + "점)");
			System.out.println("💪 집중 필요 과목: "+ minSubject + " ("+ minScore + "점)");
			
			
			
			//평균이 60점 이상 -> (기본 출력) 축하합니다! 합격입니다! 
			//	90점 이상 -> (추가 출력1) 성적 우수상 수상 대상입니다!
			//	80점 이상 -> (추가 출력1) 도서 상품권을 드립니다!
			//그외 ->(기본 출력) 아쉽지만 불합격입니다.
							// 재시험 기회가 있으니 포기하지 마세요!
			
			System.out.println("\n=== 최종 결과 ===");

			if (average>=60) {
				System.out.println("🎉 축하합니다! 합격입니다!");
				if(average>=90) {
					System.out.println("⭐ 성적 우수상 수상 대상입니다!");
				} else if(average>=80) {
					System.out.println("📚 도서 상품권을 드립니다!");
				}
			
			} else {
				System.out.println("😞 아쉽지만 불합격입니다.\n 재시험 기회가 있으니 포기하지 마세요!");
			};
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}
