document.addEventListener('DOMContentLoaded', function() {
    const loggedInUser = JSON.parse(sessionStorage.getItem('yumyum_loggedInUser'));

    // 로그인 상태가 아니면 로그인 페이지로 리디렉션
    if (!loggedInUser) {
        alert('로그인이 필요합니다.');
        window.location.href = 'login.html';
        return; // 리디렉션 후 아래 코드 실행 방지
    }

    // 로그아웃 버튼 이벤트 리스너 추가
    const logoutButtons = document.querySelectorAll('a[href="login.html"]'); // 네비바의 로그아웃 버튼
    logoutButtons.forEach(button => {
        if(button.textContent.includes('로그아웃')){
            button.addEventListener('click', function(e) {
                e.preventDefault();
                sessionStorage.removeItem('yumyum_loggedInUser');
                alert('로그아웃 되었습니다.');
                window.location.href = 'index.html';
            });
        }
    });
});
