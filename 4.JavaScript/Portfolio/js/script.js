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

// // 프로젝트/수업 데이터
// const totalProjects = 1; // 완료한 프로젝트 수
// const studyingStartDate = new Date("2025-05-27"); // 수업 시작일
// const today = new Date(); // 현재 날짜

// // 수업한 일수 계산
// const diffTime = today - studyingStartDate;
// const studyingDays = Math.floor(diffTime / (1000 * 60 * 60 * 24)) + 1; // 시작일 포함

// // DOM에 표시
// document.addEventListener("DOMContentLoaded", function () {
//   document.getElementById("projectCount").textContent = totalProjects;
//   document.getElementById("studyingDays").textContent = studyingDays;
// });

// ====== 전역 변수 및 초기화 ======
document.addEventListener("DOMContentLoaded", function() {
    initializeNavigation();
    initializeStats();
    initializeSkillsInteraction();
    initializeSmoothScroll();
    initializeFormValidation();
    initializeScrollAnimations();
});

// ====== 1. 네비게이션 기능 ======
function initializeNavigation() {
    // 햄버거 메뉴 토글
    const hamburger = document.querySelector(".hamburger");
    const navMenu = document.querySelector(".nav-menu");
    
    if (hamburger && navMenu) {
        hamburger.addEventListener("click", () => {
            navMenu.classList.toggle("active");
            hamburger.classList.toggle("active");
        });
    }
    
    // 스크롤 시 네비게이션 배경 변화
    const navbar = document.querySelector(".navbar");
    window.addEventListener("scroll", () => {
        if (window.scrollY > 50) {
            navbar.style.background = "rgba(255, 255, 255, 0.95)";
            navbar.style.backdropFilter = "blur(10px)";
        } else {
            navbar.style.background = "#fff";
            navbar.style.backdropFilter = "none";
        }
    });
}

// ====== 2. 통계 데이터 계산 및 표시 ======
function initializeStats() {
    // 프로젝트 관련 데이터
    const totalProjects = 3; // 완성된 프로젝트 수
    const githubCommits = 127; // GitHub 커밋 수
    const followers = 45; // 팔로워 수
    
    // 수업 시작일부터 연속 학습일 계산
    const studyingStartDate = new Date("2025-05-27");
    const today = new Date();
    const diffTime = today - studyingStartDate;
    const studyingDays = Math.floor(diffTime / (1000 * 60 * 60 * 24)) + 1;
    
    // DOM 요소 업데이트
    updateStatElement("projectCount", totalProjects);
    updateStatElement("studyingDays", studyingDays);
    updateStatElement("githubCommits", githubCommits);
    updateStatElement("followers", followers);
    
    // 숫자 카운트 애니메이션
    animateNumbers();
}

function updateStatElement(id, value) {
    const element = document.getElementById(id);
    if (element) {
        element.textContent = value;
    }
}

function animateNumbers() {
    const stats = document.querySelectorAll('.stat-number');
    
    stats.forEach(stat => {
        const target = parseInt(stat.textContent);
        let current = 0;
        const increment = target / 30; // 30프레임으로 나누어 애니메이션
        
        const timer = setInterval(() => {
            current += increment;
            if (current >= target) {
                stat.textContent = target;
                clearInterval(timer);
            } else {
                stat.textContent = Math.floor(current);
            }
        }, 50);
    });
}

// ====== 3. 스킬 태그 인터랙션 ======
function initializeSkillsInteraction() {
    const skillItems = document.querySelectorAll('.skills-group li');
    let selectedSkills = new Set();
    
    skillItems.forEach(skill => {
        skill.addEventListener('click', () => {
            const skillName = skill.textContent.trim();
            
            if (selectedSkills.has(skillName)) {
                // 스킬 선택 해제
                skill.classList.remove('selected');
                selectedSkills.delete(skillName);
                skill.style.background = '#f9f9fb';
                skill.style.color = '#2c3e50';
            } else {
                // 스킬 선택
                skill.classList.add('selected');
                selectedSkills.add(skillName);
                skill.style.background = '#667eea';
                skill.style.color = '#fff';
                skill.style.transform = 'scale(1.05)';
                
                // 선택 알림
                showNotification(`"${skillName}" 스킬이 선택되었습니다!`);
            }
            
            // 선택된 스킬 목록 콘솔 출력
            console.log('선택된 스킬:', Array.from(selectedSkills));
        });
        
        // 호버 효과 개선
        skill.addEventListener('mouseenter', () => {
            if (!skill.classList.contains('selected')) {
                skill.style.transform = 'translateY(-2px)';
                skill.style.boxShadow = '0 4px 12px rgba(0,0,0,0.1)';
            }
        });
        
        skill.addEventListener('mouseleave', () => {
            if (!skill.classList.contains('selected')) {
                skill.style.transform = 'translateY(0)';
                skill.style.boxShadow = '0 1px 4px rgba(0,0,0,0.03)';
            }
        });
    });
}

// ====== 4. 알림 시스템 ======
function showNotification(message) {
    // 기존 알림 제거
    const existingNotification = document.querySelector('.notification');
    if (existingNotification) {
        existingNotification.remove();
    }
    
    // 새 알림 생성
    const notification = document.createElement('div');
    notification.className = 'notification';
    notification.textContent = message;
    notification.style.cssText = `
        position: fixed;
        top: 100px;
        right: 20px;
        background: #667eea;
        color: white;
        padding: 1rem 1.5rem;
        border-radius: 8px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.15);
        z-index: 9999;
        animation: slideIn 0.3s ease-out;
        font-weight: 500;
    `;
    
    // CSS 애니메이션 추가
    const style = document.createElement('style');
    style.textContent = `
        @keyframes slideIn {
            from { transform: translateX(100%); opacity: 0; }
            to { transform: translateX(0); opacity: 1; }
        }
        @keyframes slideOut {
            from { transform: translateX(0); opacity: 1; }
            to { transform: translateX(100%); opacity: 0; }
        }
    `;
    document.head.appendChild(style);
    
    document.body.appendChild(notification);
    
    // 3초 후 자동 제거
    setTimeout(() => {
        notification.style.animation = 'slideOut 0.3s ease-out';
        setTimeout(() => notification.remove(), 300);
    }, 3000);
}

// ====== 5. 부드러운 스크롤 애니메이션 ======
function initializeSmoothScroll() {
    const navLinks = document.querySelectorAll('nav a[href^="#"]');
    
    navLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault();
            
            const targetId = link.getAttribute('href').substring(1);
            const targetSection = document.getElementById(targetId);
            
            if (targetSection) {
                const offsetTop = targetSection.offsetTop - 70; // 네비게이션 높이 고려
                
                window.scrollTo({
                    top: offsetTop,
                    behavior: 'smooth'
                });
            }
        });
    });
}

// ====== 6. 폼 유효성 검사 및 처리 ======
function initializeFormValidation() {
    const contactForm = document.querySelector('.contact-form-card form');
    
    if (contactForm) {
        contactForm.addEventListener('submit', (e) => {
            e.preventDefault();
            
            const formData = new FormData(contactForm);
            const name = formData.get('name');
            const email = formData.get('email');
            const message = formData.get('message');
            
            // 유효성 검사
            if (!validateForm(name, email, message)) {
                return;
            }
            
            // 폼 제출 시뮬레이션
            submitForm(name, email, message);
        });
    }
}

function validateForm(name, email, message) {
    const errors = [];
    
    // 이름 검사
    if (!name || name.trim().length < 2) {
        errors.push('이름은 2글자 이상 입력해주세요.');
    }
    
    // 이메일 검사
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!email || !emailRegex.test(email)) {
        errors.push('올바른 이메일 주소를 입력해주세요.');
    }
    
    // 메시지 검사
    if (!message || message.trim().length < 10) {
        errors.push('메시지는 10글자 이상 입력해주세요.');
    }
    
    // 에러가 있으면 알림 표시
    if (errors.length > 0) {
        showNotification(errors.join(' '));
        return false;
    }
    
    return true;
}

function submitForm(name, email, message) {
    // 로딩 상태 표시
    const submitBtn = document.querySelector('.contact-form-card .btn-primary');
    const originalText = submitBtn.textContent;
    submitBtn.textContent = '전송 중...';
    submitBtn.disabled = true;
    
    // 전송 시뮬레이션 (실제로는 서버로 데이터 전송)
    setTimeout(() => {
        showNotification('메시지가 성공적으로 전송되었습니다!');
        
        // 폼 초기화
        document.querySelector('.contact-form-card form').reset();
        
        // 버튼 원상복구
        submitBtn.textContent = originalText;
        submitBtn.disabled = false;
        
        // 콘솔에 전송 데이터 출력
        console.log('전송된 데이터:', { name, email, message });
    }, 2000);
}

// ====== 7. 스크롤 애니메이션 ======
function initializeScrollAnimations() {
    const animatedElements = document.querySelectorAll('.skills-group, .project-card, .contact-info-card, .contact-form-card');
    
    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.style.opacity = '1';
                entry.target.style.transform = 'translateY(0)';
            }
        });
    }, {
        threshold: 0.1,
        rootMargin: '0px 0px -50px 0px'
    });
    
    animatedElements.forEach(element => {
        // 초기 상태 설정
        element.style.opacity = '0';
        element.style.transform = 'translateY(30px)';
        element.style.transition = 'opacity 0.6s ease-out, transform 0.6s ease-out';
        
        observer.observe(element);
    });
}

// ====== 8. 유틸리티 함수 ======
function throttle(func, wait) {
    let timeout;
    return function executedFunction(...args) {
        const later = () => {
            clearTimeout(timeout);
            func(...args);
        };
        clearTimeout(timeout);
        timeout = setTimeout(later, wait);
    };
}

function debounce(func, wait) {
    let timeout;
    return function executedFunction(...args) {
        const later = () => {
            clearTimeout(timeout);
            func(...args);
        };
        clearTimeout(timeout);
        timeout = setTimeout(later, wait);
    };
}

// ====== 9. 추가 인터랙션 기능 ======
function initializeAdditionalFeatures() {
    // 프로젝트 카드 호버 효과 강화
    const projectCards = document.querySelectorAll('.project-card');
    projectCards.forEach(card => {
        card.addEventListener('mouseenter', () => {
            card.style.transform = 'translateY(-8px) scale(1.02)';
        });
        
        card.addEventListener('mouseleave', () => {
            card.style.transform = 'translateY(0) scale(1)';
        });
    });
    
    // 소셜 버튼 클릭 트래킹
    const socialBtns = document.querySelectorAll('.social-btn');
    socialBtns.forEach(btn => {
        btn.addEventListener('click', (e) => {
            const platform = btn.getAttribute('href') || btn.dataset.platform;
            console.log(`소셜 링크 클릭: ${platform}`);
        });
    });
}

// ====== 10. 키보드 접근성 개선 ======
function initializeAccessibility() {
    // 키보드 네비게이션 지원
    document.addEventListener('keydown', (e) => {
        if (e.key === 'Tab') {
            document.body.classList.add('keyboard-navigation');
        }
    });
    
    document.addEventListener('mousedown', () => {
        document.body.classList.remove('keyboard-navigation');
    });
    
    // 포커스 트랩 (모달이 있다면)
    const focusableElements = 'button, [href], input, select, textarea, [tabindex]:not([tabindex="-1"])';
    
    // ESC 키로 선택 해제
    document.addEventListener('keydown', (e) => {
        if (e.key === 'Escape') {
            // 선택된 스킬들 모두 해제
            const selectedSkills = document.querySelectorAll('.skills-group li.selected');
            selectedSkills.forEach(skill => {
                skill.click(); // 클릭 이벤트 트리거하여 해제
            });
        }
    });
}

// 모든 기능 초기화
document.addEventListener("DOMContentLoaded", function() {
    initializeNavigation();
    initializeStats();
    initializeSkillsInteraction();
    initializeSmoothScroll();
    initializeFormValidation();
    initializeScrollAnimations();
    initializeAdditionalFeatures();
    initializeAccessibility();
    
    console.log('포트폴리오 웹사이트가 성공적으로 로드되었습니다!');
});
