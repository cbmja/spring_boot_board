	
	
	/*삭제 알림창 SSSSSSSSSSSSSSSSSSSSS
	확인 눌렀을 때 보낼 주소 속성 줘야함 아래처럼
	th:data-uri="@{|/answer/delete/${answer.id}|}"*/
	const delete_elements = document.getElementsByClassName("delete");
	Array.from(delete_elements).forEach(function (element) {
		element.addEventListener('click', function () {
			if (confirm("정말로 삭제하시겠습니까?")) {
				location.href = this.dataset.uri;
			};
		});
	});
	/*삭제 알림창 EEEEEEEEEEEEEEEEEEEEEEE*/
	/*추천 알림창 SSSSSSSSSSSSSSSSSSSSSSS*/
	const recommend_elements = document.getElementsByClassName("recommend");
	Array.from(recommend_elements).forEach(function (element) {
		element.addEventListener('click', function () {
			if (confirm("정말로 추천하시겠습니까?")) {
				location.href = this.dataset.uri;
			};
		});
	});
	/*추천 알림창 EEEEEEEEEEEEEEEEEEEEEEE*/
	/*질문 목록 검색, 페이징 SSSSSSSSSSSSSSSSSSSSSSS*/
		const page_elements = document.getElementsByClassName("page-link");
	Array.from(page_elements).forEach(function (element) {
		element.addEventListener('click', function () {
			document.getElementById('page').value = this.dataset.page;
			document.getElementById('searchForm').submit();
		});
	});
	const btn_search = document.getElementById("btn_search");
	btn_search.addEventListener('click', function () {
		document.getElementById('kw').value = document.getElementById('search_kw').value;
		document.getElementById('page').value = 0;  // 검색버튼을 클릭할 경우 0페이지부터 조회한다.
		document.getElementById('searchForm').submit();
	});
	/*질문 목록 검색, 페이징 EEEEEEEEEEEEEEEEEEEEEEE*/
	
	