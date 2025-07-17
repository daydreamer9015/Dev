// getElementById("heading")는 id가 'heading'인 요소를 가져오는 것
var heading = document.getElementById("heading");
// = 기호는 오른쪽에 있는 것을 왼쪽으로 assign 하는 것. = 기준 왼쪽은 L value, 오른쪽은 R value
// onclick = function () : 클릭했을 때 실행할 함수 정의
    heading.onclick = function () {
    // style.color : 글자의 색상을 바꾸는 속성
    // if 조건문 : 현재 색이 'red'이면 파란색으로 바꾸기
        if(heading.style.color === "red") {
            heading.style.color = "blue";
        }
    // 그 외에는 빨간색으로 바꾸기
        else {
            heading.style.color = "red";
        }
    };