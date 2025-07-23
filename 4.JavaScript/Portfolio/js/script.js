// let now = new Date(); // 특정한 파라미터를 주지 않으면 오늘 날짜로 객체 지정
// let firstDay = new Date("2025-05-27"); // 시작 날짜를 객체로 지정

// // 1970년 1월 1일 0시 0분 0초부터 지금까지의 밀리 초 경과 시간 (정수)
// let toNow = now.getTime(); // 오늘까지 지난 시간 (밀리초)(1970.01.01~)
// let tofirst = firstDay.getTime(); // 2025년 05월 27일까지 지난 시간(1970.01.01~2025.05.27)
// let passTime = toNow - tofirst; // 5월 27일부터 오늘까지 지난 시간 (밀리초)

// // 밀리 초를 일 수로 계산하고 반올림 , round : 소수 첫째자리에서 반올림해서 정수
// passTime= Math.round(passTime/(1000*60*60*24)) //1초 * 60(1분에) * 60(1시간에) *24(하루에)
// document.querySelector("#result").innerText = passTime;

// document.addEventListener("DOMContentLoaded", () => {
// const hamburger = document.querySelector(".hamburger");
// const navMenu = document.querySelector(".nav-menu");

//     hamburger.addEventListener("click", () => {
//         navMenu.classList.toggle("active");
//         hamburger.classList.toggle("active");
//     });
// });

// 프로젝트/수업 데이터
const totalProjects = 1; // 완료한 프로젝트 수
const studyingStartDate = new Date("2025-05-27"); // 수업 시작일
const today = new Date(); // 현재 날짜

// 수업한 일수 계산
const diffTime = today - studyingStartDate;
const studyingDays = Math.floor(diffTime / (1000 * 60 * 60 * 24)) + 1; // 시작일 포함

// DOM에 표시
document.addEventListener("DOMContentLoaded", function () {
  document.getElementById("projectCount").textContent = totalProjects;
  document.getElementById("studyingDays").textContent = studyingDays;
});