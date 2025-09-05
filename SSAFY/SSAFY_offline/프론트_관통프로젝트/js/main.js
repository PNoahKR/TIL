
document.addEventListener('DOMContentLoaded', function () {

    // --- Page-specific Logic Runner ---
    const page = document.body.id;

    // --- Auth State Handler (Runs on all pages) ---
    const handleAuthState = () => {
        const navbar = document.querySelector('.navbar');
        if (!navbar) return;

        const loggedInUser = sessionStorage.getItem('loggedInUser');
        const loginLink = navbar.querySelector('a[href="login.html"]');
        const signupLink = navbar.querySelector('a[href="signup.html"]'); // Assuming signup is also a link
        const navRightUl = navbar.querySelector('.navbar-nav.ms-auto');

        // Remove existing dynamic links to prevent duplicates
        let mypageLink = document.getElementById('mypage-link');
        let logoutLink = document.getElementById('logout-link');
        if (mypageLink) mypageLink.remove();
        if (logoutLink) logoutLink.remove();

        if (loggedInUser) {
            // Hide Login and Signup
            if (loginLink) loginLink.style.display = 'none';
            if (signupLink) signupLink.style.display = 'none';

            // Add My Page link
            mypageLink = document.createElement('li');
            mypageLink.className = 'nav-item';
            mypageLink.innerHTML = '<a class="nav-link" href="mypage.html" id="mypage-link">마이페이지</a>';
            navRightUl.appendChild(mypageLink);

            // Add Logout link
            logoutLink = document.createElement('li');
            logoutLink.className = 'nav-item';
            logoutLink.innerHTML = '<a class="nav-link" href="#" id="logout-link">로그아웃</a>';
            logoutLink.querySelector('#logout-link').addEventListener('click', (e) => {
                e.preventDefault();
                sessionStorage.removeItem('loggedInUser');
                alert('로그아웃 되었습니다.');
                window.location.href = 'login.html';
            });
            navRightUl.appendChild(logoutLink);

        } else {
            // Show Login and Signup
            if (loginLink) loginLink.style.display = 'block';
            if (signupLink) signupLink.style.display = 'block';
        }
    };

    // --- Landing Page Logic ---
    if (page === 'page-landing') {
        const featureSections = document.querySelectorAll('.feature-section');
        if (featureSections.length > 0) {
            const observer = new IntersectionObserver((entries) => {
                entries.forEach(entry => {
                    if (entry.isIntersecting) {
                        entry.target.classList.add('visible');
                    }
                });
            }, { threshold: 0.2 });

            featureSections.forEach(section => {
                observer.observe(section);
            });
        }
    }

    // --- Diet Page Logic ---
    if (page === 'page-diet') {
        let foodDB = [];
        let tempFoodList = [];
        let isEditing = false;
        let editingKey = null;

        // Fetch food database from the local JSON file
        fetch('./data/food_db.json')
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok ' + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                foodDB = data;
                console.log('Food DB loaded successfully.');
            })
            .catch(error => {
                console.error('Error loading or parsing food DB:', error);
                alert('음식 데이터베이스를 불러오는 데 실패했습니다.');
            });

        const foodNameInput = document.getElementById('food-name');
        const searchResults = document.getElementById('search-results');
        const addedFoodsList = document.getElementById('added-foods-list');
        const dietForm = document.getElementById('diet-form');
        const dietLogAccordion = document.getElementById('diet-log-accordion');
        const formSubmitButton = dietForm.querySelector('button[type="submit"]');
        const manualAddButton = document.getElementById('manual-add-button');
        const manualAddModal = new bootstrap.Modal(document.getElementById('manualAddModal'));
        const manualAddForm = document.getElementById('manual-add-form');

        // Autocomplete search listener
        foodNameInput.addEventListener('input', () => {
            const query = foodNameInput.value.toLowerCase();
            searchResults.innerHTML = '';
            if (query.length < 2) return;

            const results = foodDB.filter(item => item.DESC_KOR.toLowerCase().includes(query)).slice(0, 5);
            results.forEach(item => {
                const li = document.createElement('li');
                li.className = 'list-group-item list-group-item-action';
                li.textContent = `${item.DESC_KOR} (${item.NUTR_CONT1} kcal)`;
                li.style.cursor = 'pointer';
                li.onclick = () => {
                    addFoodToTempList({
                        name: item.DESC_KOR,
                        calories: parseFloat(item.NUTR_CONT1) || 0,
                        carbs: parseFloat(item.NUTR_CONT2) || 0,
                        protein: parseFloat(item.NUTR_CONT3) || 0,
                        fat: parseFloat(item.NUTR_CONT4) || 0
                    });
                    foodNameInput.value = '';
                    searchResults.innerHTML = '';
                };
                searchResults.appendChild(li);
            });
        });
        
        // Manual add button listener
        manualAddButton.addEventListener('click', () => {
            const food = {
                name: document.getElementById('manual-food-name').value,
                calories: parseFloat(document.getElementById('manual-calories').value) || 0,
                protein: parseFloat(document.getElementById('manual-protein').value) || 0,
                carbs: parseFloat(document.getElementById('manual-carbs').value) || 0,
                fat: parseFloat(document.getElementById('manual-fat').value) || 0,
            };

            if (!food.name || !food.calories) {
                alert('음식 이름과 칼로리를 입력해주세요.');
                return;
            }

            addFoodToTempList(food);
            manualAddForm.reset();
            manualAddModal.hide();
        });

        const addFoodToTempList = (food) => {
            tempFoodList.push(food);
            renderTempFoodList();
        };

        const renderTempFoodList = () => {
            if (tempFoodList.length === 0) {
                addedFoodsList.innerHTML = '<p class="text-muted">검색 또는 직접 입력을 통해 음식을 추가하세요.</p>';
            } else {
                addedFoodsList.innerHTML = tempFoodList.map((food, index) =>
                    `<span class="badge bg-primary me-1 fs-6">${food.name} (${food.calories} kcal) <button type="button" class="btn-close btn-close-white ms-1" data-index="${index}"></button></span>`
                ).join('');
            }
        };

        addedFoodsList.addEventListener('click', (e) => {
            if (e.target.classList.contains('btn-close')) {
                tempFoodList.splice(e.target.dataset.index, 1);
                renderTempFoodList();
            }
        });

        const getDiets = () => JSON.parse(localStorage.getItem('diets') || '{}');
        const saveDiets = (diets) => localStorage.setItem('diets', JSON.stringify(diets));

        const renderDietLogs = () => {
            const diets = getDiets();
            dietLogAccordion.innerHTML = '';
            const dates = Object.keys(diets).sort((a, b) => new Date(b) - new Date(a));
            
            if (dates.length === 0) {
                dietLogAccordion.innerHTML = '<p class="text-center text-muted">아직 기록된 식단이 없습니다.</p>';
                return;
            }

            dates.forEach((date, i) => {
                const meals = diets[date];
                let mealHtml = '';
                for (const mealType in meals) {
                    const totalCals = meals[mealType].reduce((sum, f) => sum + f.calories, 0).toFixed(0);
                    mealHtml += `
                        <div class="mt-3 p-2 border rounded">
                            <div class="d-flex justify-content-between align-items-center">
                                <strong class="fs-5">${mealType} (${totalCals} kcal)</strong>
                                <div>
                                    <button class="btn btn-sm btn-outline-secondary me-1" data-action="edit" data-key="${date}_${mealType}">수정</button>
                                    <button class="btn btn-sm btn-outline-danger" data-action="delete" data-key="${date}_${mealType}">삭제</button>
                                </div>
                            </div>
                            <ul class="list-unstyled mt-2">${meals[mealType].map(f => `<li>- ${f.name} (${f.calories.toFixed(0)} kcal)</li>`).join('')}</ul>
                        </div>`;
                }
                dietLogAccordion.innerHTML += `
                    <div class="accordion-item">
                        <h2 class="accordion-header">
                            <button class="accordion-button ${i > 0 ? 'collapsed' : ''}" type="button" data-bs-toggle="collapse" data-bs-target="#collapse-${i}">${date}</button>
                        </h2>
                        <div id="collapse-${i}" class="accordion-collapse collapse ${i === 0 ? 'show' : ''}" data-bs-parent="#diet-log-accordion">
                            <div class="accordion-body">${mealHtml}</div>
                        </div>
                    </div>`;
            });
        };

        dietLogAccordion.addEventListener('click', (e) => {
            const action = e.target.dataset.action;
            const key = e.target.dataset.key;
            if (!action || !key) return;

            const [date, mealType] = key.split('_');
            let diets = getDiets();

            if (action === 'delete') {
                if (confirm(`'${date}'의 '${mealType}' 식단을 삭제하시겠습니까?`)) {
                    delete diets[date][mealType];
                    if (Object.keys(diets[date]).length === 0) delete diets[date];
                    saveDiets(diets);
                    renderDietLogs();
                }
            }

            if (action === 'edit') {
                const mealToEdit = diets[date][mealType];
                document.getElementById('diet-date').value = date;
                document.getElementById('meal-type').value = mealType;
                tempFoodList = [...mealToEdit];
                isEditing = true;
                editingKey = key;
                formSubmitButton.textContent = '식단 수정하기';
                formSubmitButton.classList.add('btn-success');
                renderTempFoodList();
                window.scrollTo(0, 0);
            }
        });

        dietForm.addEventListener('submit', (e) => {
            e.preventDefault();
            const date = document.getElementById('diet-date').value;
            const mealType = document.getElementById('meal-type').value;
            if (!date || tempFoodList.length === 0) {
                alert('날짜를 선택하고 음식을 추가해주세요.');
                return;
            }

            let diets = getDiets();
            if (isEditing) {
                const [editDate, editMealType] = editingKey.split('_');
                // If the date/mealtype being edited is different from the original, delete the original entry
                if (diets[editDate] && diets[editDate][editMealType]) {
                     delete diets[editDate][editMealType];
                     if (Object.keys(diets[editDate]).length === 0) delete diets[editDate];
                }
            }

            if (!diets[date]) diets[date] = {};
            // In case of editing to a mealtype that already exists on the same day, this will overwrite.
            // For this app's logic, this is acceptable.
            diets[date][mealType] = tempFoodList;
            saveDiets(diets);

            // Reset form state
            tempFoodList = [];
            isEditing = false;
            editingKey = null;
            formSubmitButton.textContent = '이 식단 저장하기';
            formSubmitButton.classList.remove('btn-success');
            dietForm.reset();
            renderTempFoodList();
            renderDietLogs();
        });

        renderDietLogs();
    }

    // --- Challenge Page Logic ---
    if (page === 'page-challenge') {
        const getChallenges = () => JSON.parse(localStorage.getItem('challenges') || '[]');
        const saveChallenges = (challenges) => localStorage.setItem('challenges', JSON.stringify(challenges));
        
        const challengeListContainer = document.querySelector('#page-challenge .list-group');
        const createChallengeModalEl = document.getElementById('createChallengeModal');
        const createChallengeModal = new bootstrap.Modal(createChallengeModalEl);
        const createChallengeButton = createChallengeModalEl.querySelector('.btn-primary');

        const renderChallenges = () => {
            const challenges = getChallenges();
            challengeListContainer.innerHTML = ''; // Clear existing list

            if (challenges.length === 0) {
                challengeListContainer.innerHTML = '<p class="text-center text-muted mt-3">진행 중인 챌린지가 없습니다. 새로운 챌린지를 만들어보세요!</p>';
                return;
            }

            challenges.forEach(challenge => {
                const progress = Math.min(100, (challenge.current / challenge.goal) * 100);
                const challengeItem = document.createElement('div');
                challengeItem.className = 'list-group-item';
                challengeItem.innerHTML = `
                    <div class="d-flex w-100 justify-content-between">
                        <h5 class="mb-1">${challenge.title}</h5>
                        <button type="button" class="btn-close" aria-label="Close" data-id="${challenge.id}"></button>
                    </div>
                    <p class="mb-1">${challenge.desc}</p>
                    <div class="progress mt-2">
                        <div class="progress-bar bg-success" role="progressbar" style="width: ${progress.toFixed(0)}%;" aria-valuenow="${progress.toFixed(0)}" aria-valuemin="0" aria-valuemax="100">${challenge.current.toFixed(0)} / ${challenge.goal} ${challenge.type.split('(')[0]}</div>
                    </div>
                    <small>${challenge.participants}명 참여 중</small>
                `;
                challengeListContainer.appendChild(challengeItem);
            });
        };

        createChallengeButton.addEventListener('click', () => {
            const title = document.getElementById('challenge-title').value;
            const desc = document.getElementById('challenge-desc').value;
            const type = document.getElementById('challenge-type').value;
            const goal = parseFloat(document.getElementById('challenge-goal').value);

            if (!title || !desc || !goal) {
                alert('모든 필드를 올바르게 입력해주세요.');
                return;
            }

            const newChallenge = {
                id: Date.now().toString(),
                title,
                desc,
                type,
                goal,
                current: 0, // Initial progress
                participants: 1 // Creator is the first participant
            };

            const challenges = getChallenges();
            challenges.push(newChallenge);
            saveChallenges(challenges);

            createChallengeModalEl.querySelector('form').reset();
            createChallengeModal.hide();
            renderChallenges();
        });

        challengeListContainer.addEventListener('click', (e) => {
            if (e.target.classList.contains('btn-close')) {
                const challengeId = e.target.dataset.id;
                if (confirm('이 챌린지를 삭제하시겠습니까?')) {
                    let challenges = getChallenges();
                    challenges = challenges.filter(c => c.id !== challengeId);
                    saveChallenges(challenges);
                    renderChallenges();
                }
            }
        });

        renderChallenges();
    }

    // --- Community Page Logic ---
    if (page === 'page-community') {
        const getPosts = () => JSON.parse(localStorage.getItem('posts') || '[]');
        const savePosts = (posts) => localStorage.setItem('posts', JSON.stringify(posts));

        const postList = document.getElementById('post-list');
        const postModalEl = document.getElementById('post-modal');
        const postModal = new bootstrap.Modal(postModalEl);
        const savePostButton = document.getElementById('save-post-button');
        const postForm = document.getElementById('post-form');
        const postModalLabel = document.getElementById('post-modal-label');

        const renderPosts = () => {
            const posts = getPosts().sort((a, b) => b.id - a.id); // Show newest first
            postList.innerHTML = '';
            if (posts.length === 0) {
                postList.innerHTML = '<li class="list-group-item text-center text-muted">아직 게시글이 없습니다. 첫 글을 작성해보세요!</li>';
                return;
            }
            posts.forEach(post => {
                const li = document.createElement('li');
                li.className = 'list-group-item';
                li.innerHTML = `
                    <h5>${post.title}</h5>
                    <p>${post.content.replace(/\n/g, '<br>')}</p>
                    <div class="d-flex justify-content-between text-muted">
                        <small>작성자: ${post.author} | 작성일: ${new Date(post.id).toLocaleDateString()}</small>
                        <div>
                            <a href="#" class="text-primary me-2" data-action="edit" data-id="${post.id}">수정</a>
                            <a href="#" class="text-danger" data-action="delete" data-id="${post.id}">삭제</a>
                        </div>
                    </div>
                `;
                postList.appendChild(li);
            });
        };

        // Open modal for new post
        document.querySelector('button[data-bs-target="#post-modal"]').addEventListener('click', () => {
            postModalLabel.textContent = '새 게시글 작성';
            postForm.reset();
            document.getElementById('post-id').value = '';
        });

        // Save or Update Post
        savePostButton.addEventListener('click', () => {
            const title = document.getElementById('post-title').value;
            const content = document.getElementById('post-content').value;
            const id = document.getElementById('post-id').value;

            if (!title || !content) {
                alert('제목과 내용을 모두 입력해주세요.');
                return;
            }

            let posts = getPosts();
            if (id) { // Editing existing post
                const post = posts.find(p => p.id === id);
                if (post) {
                    post.title = title;
                    post.content = content;
                }
            } else { // Creating new post
                const newPost = {
                    id: Date.now(),
                    title,
                    content,
                    author: '익명' // Replace with actual user later
                };
                posts.push(newPost);
            }
            savePosts(posts);
            postModal.hide();
            renderPosts();
        });

        // Handle Edit and Delete clicks
        postList.addEventListener('click', (e) => {
            e.preventDefault();
            const action = e.target.dataset.action;
            const id = e.target.dataset.id;

            if (!action || !id) return;

            if (action === 'delete') {
                if (confirm('이 게시글을 삭제하시겠습니까?')) {
                    let posts = getPosts();
                    posts = posts.filter(p => p.id != id);
                    savePosts(posts);
                    renderPosts();
                }
            }

            if (action === 'edit') {
                const posts = getPosts();
                const post = posts.find(p => p.id == id);
                if (post) {
                    postModalLabel.textContent = '게시글 수정';
                    document.getElementById('post-id').value = post.id;
                    document.getElementById('post-title').value = post.title;
                    document.getElementById('post-content').value = post.content;
                    postModal.show();
                }
            }
        });

        renderPosts();
    }

    // --- Analysis Page Logic ---
    if (page === 'page-analysis') {
        const getDiets = () => JSON.parse(localStorage.getItem('diets') || '{}');

        const processDietData = () => {
            const diets = getDiets();
            const labels = [];
            const calorieData = [];
            let totalCarbs = 0, totalProtein = 0, totalFat = 0;

            const sortedDates = Object.keys(diets).sort((a, b) => new Date(a) - new Date(b));

            sortedDates.forEach(date => {
                labels.push(date);
                let dailyCalories = 0;
                for (const mealType in diets[date]) {
                    diets[date][mealType].forEach(food => {
                        dailyCalories += food.calories;
                        totalCarbs += food.carbs;
                        totalProtein += food.protein;
                        totalFat += food.fat;
                    });
                }
                calorieData.push(dailyCalories);
            });

            const totalNutrients = totalCarbs + totalProtein + totalFat;
            return {
                labels,
                calorieData,
                nutrientRatio: {
                    carbs: totalNutrients > 0 ? (totalCarbs / totalNutrients) * 100 : 0,
                    protein: totalNutrients > 0 ? (totalProtein / totalNutrients) * 100 : 0,
                    fat: totalNutrients > 0 ? (totalFat / totalNutrients) * 100 : 0,
                },
                avgCalories: calorieData.length > 0 ? calorieData.reduce((a, b) => a + b, 0) / calorieData.length : 0
            };
        };

        const renderCharts = (data) => {
            const nutrientCtx = document.getElementById('nutrientRatioChart').getContext('2d');
            new Chart(nutrientCtx, {
                type: 'doughnut',
                data: {
                    labels: ['탄수화물', '단백질', '지방'],
                    datasets: [{
                        data: [data.nutrientRatio.carbs, data.nutrientRatio.protein, data.nutrientRatio.fat],
                        backgroundColor: ['#FFC107', '#28A745', '#DC3545'],
                    }]
                },
                options: { responsive: true, maintainAspectRatio: false }
            });

            const dailyCtx = document.getElementById('dailyIntakeChart').getContext('2d');
            new Chart(dailyCtx, {
                type: 'line',
                data: {
                    labels: data.labels,
                    datasets: [{
                        label: '일일 섭취 칼로리 (kcal)',
                        data: data.calorieData,
                        borderColor: '#007BFF',
                        fill: false,
                        tension: 0.1
                    }]
                },
                options: { responsive: true, maintainAspectRatio: false }
            });
        };

        const renderAiAnalysis = (data) => {
            const resultDiv = document.getElementById('ai-analysis-result');
            let html = '<ul class="list-group list-group-flush">';

            if (data.avgCalories === 0) {
                html += '<li class="list-group-item">아직 분석할 식단 데이터가 없습니다. 식단을 기록해주세요.</li>';
            } else {
                if (data.avgCalories < 1800) {
                    html += '<li class="list-group-item">평균 섭취 칼로리가 다소 낮은 편입니다. 건강한 에너지 수준을 위해 조금 더 섭취하는 것을 고려해보세요.</li>';
                } else if (data.avgCalories > 2500) {
                    html += '<li class="list-group-item">평균 섭취 칼로리가 높은 편입니다. 식단 조절이나 활동량 증가를 통해 균형을 맞추는 것이 좋습니다.</li>';
                } else {
                    html += '<li class="list-group-item">평균 섭취 칼로리가 적절한 수준입니다. 잘하고 계십니다!</li>';
                }

                if (data.nutrientRatio.protein < 20) {
                    html += '<li class="list-group-item">단백질 섭취 비율이 낮습니다. 근육 건강과 신진대사를 위해 닭가슴살, 계란, 콩 등 단백질이 풍부한 음식을 추가해보세요.</li>';
                } else {
                    html += '<li class="list-group-item">단백질을 충분히 섭취하고 있습니다. 꾸준히 유지해주세요.</li>';
                }
                 if (data.nutrientRatio.fat > 35) {
                    html += '<li class="list-group-item">지방 섭취 비율이 다소 높습니다. 건강한 지방(견과류, 아보카도) 위주로 섭취하고, 튀긴 음식은 줄이는 것이 좋습니다.</li>';
                } else {
                    html += '<li class="list-group-item">지방 섭취 비율은 적절한 수준입니다.</li>';
                }
            }

            html += '</ul>';
            resultDiv.innerHTML = html;
        };

        const handleChat = () => {
            const chatInput = document.getElementById('chat-input');
            const sendButton = document.getElementById('send-button');
            const chatWindow = document.getElementById('chat-window');

            const getAiResponse = (message) => {
                message = message.toLowerCase();
                if (message.includes('운동') || message.includes('추천')) {
                    return '꾸준한 운동은 건강에 매우 중요합니다. 유산소 운동(걷기, 조깅)과 근력 운동(스쿼트, 푸쉬업)을 주 3-4회 병행하는 것을 추천합니다.';
                } else if (message.includes('단백질')) {
                    return '단백질은 우리 몸의 필수 영양소입니다. 식사 시 닭가슴살, 두부, 계란 등을 포함하여 매 끼니 20-30g의 단백질을 섭취하는 것이 좋습니다.';
                } else if (message.includes('칼로리') || message.includes('계산')) {
                    return '일반적으로 성인 남성은 하루 2500kcal, 여성은 2000kcal 정도가 권장되지만, 개인의 활동량과 목표에 따라 조절이 필요합니다.';
                } else if (message.includes('안녕')) {
                    return '안녕하세요! 무엇을 도와드릴까요? 건강 관리에 대해 궁금한 점을 질문해주세요.';
                } else {
                    return '죄송해요, 아직 학습 중이라 답변하기 어려운 질문이에요. 식단, 운동, 영양소와 관련된 질문을 해주시면 더 잘 답변할 수 있어요.';
                }
            };

            const addMessageToChat = (message, sender) => {
                const messageDiv = document.createElement('div');
                messageDiv.className = sender === 'user' ? 'user-message' : 'ai-message';
                messageDiv.innerHTML = `<p class="mb-0">${message}</p>`;
                chatWindow.appendChild(messageDiv);
                chatWindow.scrollTop = chatWindow.scrollHeight;
            };

            const sendMessage = () => {
                const message = chatInput.value.trim();
                if (message === '') return;

                addMessageToChat(message, 'user');
                chatInput.value = '';

                setTimeout(() => {
                    const aiResponse = getAiResponse(message);
                    addMessageToChat(aiResponse, 'ai');
                }, 500);
            };

            sendButton.addEventListener('click', sendMessage);
            chatInput.addEventListener('keydown', (e) => {
                if (e.key === 'Enter') {
                    sendMessage();
                }
            });
        };

        // Initialize page
        const dietData = processDietData();
        renderCharts(dietData);
        renderAiAnalysis(dietData);
        handleChat();
    }

    // --- My Page Logic ---
    if (page === 'page-mypage') {
        const getDiets = () => JSON.parse(localStorage.getItem('diets') || '{}');
        const getChallenges = () => JSON.parse(localStorage.getItem('challenges') || '[]');

        const renderMyPageSummary = () => {
            const diets = getDiets();
            const challenges = getChallenges();

            // Diet Summary
            let totalRecords = 0;
            let totalCalories = 0, totalProtein = 0, totalCarbs = 0, totalFat = 0;
            let uniqueDates = new Set();

            for (const date in diets) {
                uniqueDates.add(date);
                for (const mealType in diets[date]) {
                    diets[date][mealType].forEach(food => {
                        totalCalories += food.calories;
                        totalProtein += food.protein;
                        totalCarbs += food.carbs;
                        totalFat += food.fat;
                    });
                }
            }

            const numDays = uniqueDates.size;
            document.getElementById('total-diet-records').textContent = numDays;
            document.getElementById('avg-daily-calories').textContent = numDays > 0 ? (totalCalories / numDays).toFixed(0) : 0;
            document.getElementById('avg-daily-protein').textContent = numDays > 0 ? (totalProtein / numDays).toFixed(1) : 0;
            document.getElementById('avg-daily-carbs').textContent = numDays > 0 ? (totalCarbs / numDays).toFixed(1) : 0;
            document.getElementById('avg-daily-fat').textContent = numDays > 0 ? (totalFat / numDays).toFixed(1) : 0;

            // Challenge Progress
            const challengeListSummary = document.getElementById('challenge-list-summary');
            challengeListSummary.innerHTML = '';
            document.getElementById('active-challenges').textContent = challenges.length;

            if (challenges.length === 0) {
                challengeListSummary.innerHTML = '<li class="list-group-item text-muted">참여 중인 챌린지가 없습니다.</li>';
            } else {
                challenges.forEach(challenge => {
                    const progress = Math.min(100, (challenge.current / challenge.goal) * 100);
                    const li = document.createElement('li');
                    li.className = 'list-group-item d-flex justify-content-between align-items-center';
                    li.innerHTML = `
                        ${challenge.title}
                        <div class="progress" style="width: 50%;">
                            <div class="progress-bar bg-success" role="progressbar" style="width: ${progress}%;">${progress.toFixed(0)}%</div>
                        </div>
                    `;
                    challengeListSummary.appendChild(li);
                });
            }

            // AI Analysis Comment
            const aiCommentDiv = document.getElementById('mypage-ai-comment');
            let aiComment = '';

            if (numDays === 0 && challenges.length === 0) {
                aiComment = '아직 기록된 식단이나 참여 중인 챌린지가 없습니다. 지금 바로 건강 관리를 시작해보세요!';
            } else {
                // Diet comments
                if (numDays > 0) {
                    const avgCals = totalCalories / numDays;
                    if (avgCals < 1500) aiComment += '식단 기록을 보니 평균 칼로리 섭취가 다소 낮은 편입니다. 충분한 에너지를 위해 식사량을 조금 늘려보는 것을 고려해보세요. ';
                    else if (avgCals > 2500) aiComment += '식단 기록을 보니 평균 칼로리 섭취가 높은 편입니다. 활동량을 늘리거나 식단 조절을 통해 균형을 맞춰보세요. ';
                    else aiComment += '식단 기록이 꾸준하고 평균 칼로리 섭취가 적절합니다. 아주 잘하고 계세요! ';

                    const proteinRatio = (totalProtein / totalCalories) * 400; // Assuming 4kcal/g protein
                    if (proteinRatio < 20) aiComment += '단백질 섭취 비율이 낮은 경향이 있습니다. 근육 건강을 위해 단백질 섭취를 늘려보세요. ';
                    else if (proteinRatio > 30) aiComment += '단백질 섭취 비율이 높은 편입니다. 균형 잡힌 영양 섭취를 위해 탄수화물과 지방도 적절히 섭취하는 것이 좋습니다. ';
                }

                // Challenge comments
                if (challenges.length > 0) {
                    const completedChallenges = challenges.filter(c => c.current >= c.goal).length;
                    if (completedChallenges > 0) aiComment += `총 ${challenges.length}개의 챌린지 중 ${completedChallenges}개를 성공하셨네요! 꾸준함이 정말 대단합니다. `;
                    else aiComment += '참여 중인 챌린지가 있지만 아직 목표 달성 전입니다. 포기하지 말고 꾸준히 노력해보세요! ';
                }
            }
            aiCommentDiv.innerHTML = `<p>${aiComment}</p>`;
        };

        renderMyPageSummary();
    }

    // --- Signup Page Logic ---
    if (page === 'page-signup') {
        const signupForm = document.getElementById('signup-form');
        signupForm.addEventListener('submit', (e) => {
            e.preventDefault();
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;
            const passwordConfirm = document.getElementById('password-confirm').value;

            if (!email || !password) return alert('이메일과 비밀번호를 모두 입력해주세요.');
            if (password !== passwordConfirm) return alert('비밀번호가 일치하지 않습니다.');

            const users = JSON.parse(localStorage.getItem('users') || '[]');
            if (users.find(user => user.email === email)) return alert('이미 존재하는 이메일입니다.');

            users.push({ email, password });
            localStorage.setItem('users', JSON.stringify(users));
            alert('회원가입이 완료되었습니다. 로그인 페이지로 이동합니다.');
            window.location.href = 'login.html';
        });
    }

    // --- Login Page Logic ---
    if (page === 'page-login') {
        const loginButton = document.getElementById('login-button');
        loginButton.addEventListener('click', () => {
            const email = document.getElementById('floatingInput').value;
            const password = document.getElementById('floatingPassword').value;
            const users = JSON.parse(localStorage.getItem('users') || '[]');
            const user = users.find(u => u.email === email);

            if (!user) {
                alert('해당 이메일로 가입된 사용자가 없습니다.');
            } else if (user.password !== password) {
                alert('비밀번호가 올바르지 않습니다.');
            } else {
                alert('로그인에 성공했습니다! 메인 페이지로 이동합니다.');
                sessionStorage.setItem('loggedInUser', JSON.stringify(user));
                window.location.href = 'index.html';
            }
        });
    }
});
