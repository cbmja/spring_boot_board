	
	
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