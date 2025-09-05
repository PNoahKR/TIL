const DB_KEY = 'yumyum_data';
const LOGGED_IN_USER_KEY = 'yumyum_loggedInUser';

// 현재 로그인한 사용자 정보 가져오기
function getLoggedInUser() {
    return JSON.parse(sessionStorage.getItem(LOGGED_IN_USER_KEY));
}

// 전체 데이터베이스 가져오기
function getDatabase() {
    return JSON.parse(localStorage.getItem(DB_KEY)) || {};
}

// 전체 데이터베이스 저장하기
function saveDatabase(db) {
    localStorage.setItem(DB_KEY, JSON.stringify(db));
}

// 현재 사용자의 데이터 가져오기 (없으면 초기화)
function getUserData() {
    const db = getDatabase();
    const user = getLoggedInUser();
    if (!user) return null;

    if (!db[user.email]) {
        db[user.email] = {
            meals: [],
            challenges: [],
            posts: [],
            goals: { dailyCalories: 2000, protein: 100, carbs: 250, fat: 65 }
        };
        saveDatabase(db);
    }
    return db[user.email];
}

// 현재 사용자의 데이터 저장하기
function saveUserData(userData) {
    const db = getDatabase();
    const user = getLoggedInUser();
    if (!user) return;

    db[user.email] = userData;
    saveDatabase(db);
}

// 특정 데이터 유형 가져오기 (예: 'meals', 'challenges')
function getData(type) {
    const userData = getUserData();
    return userData ? userData[type] : [];
}

// 특정 데이터 유형에 아이템 추가하기
function addItem(type, item) {
    const userData = getUserData();
    if (!userData) return;

    // 간단한 ID 생성
    item.id = Date.now();
    userData[type].push(item);

    // 식단 기록 시, 영양소 챌린지 진행률 업데이트
    if (type === 'meals') {
        updateNutrientChallengeProgress(item.date, userData);
    }

    saveUserData(userData);
}

// 특정 날짜의 영양소 섭취량을 기반으로 챌린지 진행률을 업데이트하는 함수
function updateNutrientChallengeProgress(date, userData) {
    const { meals, challenges } = userData;

    // 1. 해당 날짜에 활성화된 영양소 관련 챌린지를 찾습니다.
    const activeNutrientChallenges = challenges.filter(c => {
        const challengeType = c.type.toLowerCase();
        return c.status === 'active' && 
               date >= c.startDate && 
               date <= c.endDate && 
               ['protein', 'calories', 'carbs', 'fat'].includes(challengeType);
    });

    if (activeNutrientChallenges.length === 0) return;

    // 2. 해당 날짜의 총 영양소 섭취량을 계산합니다.
    const dailyTotals = { protein: 0, carbs: 0, fat: 0, calories: 0 };
    const mealsForDate = meals.filter(m => m.date === date);

    mealsForDate.forEach(meal => {
        meal.foods.forEach(food => {
            dailyTotals.protein += food.protein || 0;
            dailyTotals.carbs += food.carbs || 0;
            dailyTotals.fat += food.fat || 0;
            dailyTotals.calories += food.calories || 0;
        });
    });

    // 3. 각 챌린지의 현재 진행률을 업데이트합니다.
    activeNutrientChallenges.forEach(challenge => {
        const challengeType = challenge.type.toLowerCase();
        if (dailyTotals.hasOwnProperty(challengeType)) {
            challenge.current = Math.round(dailyTotals[challengeType]);
        }
    });
}

// 특정 데이터 유형에서 아이템 삭제하기
function deleteItem(type, itemId) {
    const userData = getUserData();
    if (!userData) return;

    userData[type] = userData[type].filter(item => item.id !== itemId);
    saveUserData(userData);
}

// 특정 아이템 업데이트하기
function updateItem(type, itemId, updatedItem) {
    const userData = getUserData();
    if (!userData) return;

    const itemIndex = userData[type].findIndex(item => item.id === itemId);
    if (itemIndex > -1) {
        userData[type][itemIndex] = updatedItem;
        saveUserData(userData);
    }
}

// 사용자 프로필 정보 업데이트
function updateUserProfile(updatedUser) {
    const users = JSON.parse(localStorage.getItem('yumyum_users')) || [];
    const userIndex = users.findIndex(u => u.email === updatedUser.email);

    if (userIndex > -1) {
        // 새 비밀번호가 입력되지 않았으면 기존 비밀번호 유지
        if (!updatedUser.password) {
            updatedUser.password = users[userIndex].password;
        }
        users[userIndex] = updatedUser;
        localStorage.setItem('yumyum_users', JSON.stringify(users));

        // 현재 세션 정보도 업데이트
        sessionStorage.setItem(LOGGED_IN_USER_KEY, JSON.stringify(updatedUser));
        return true;
    }
    return false;
}
