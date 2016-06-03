	$(document).ready(function(){
	    $(".about").hover(function(){
			$(".about").text("까사 갤러리아란");
	    },
	    function(){
			$(".about").text("ABOUT US");
	    });
	});
	$(document).ready(function(){
	    $(".artists").hover(function(){
			$(".artists").text("작가 보기");
	    },
	    function(){
			$(".artists").text("ARTISTS");
	    });
	});
	$(document).ready(function(){
	    $(".artworks").hover(function(){
			$(".artworks").text("작품 보기");
	    },
	    function(){
			$(".artworks").text("ARTWORKS");
	    });
	});
	$(document).ready(function(){
	    $(".mygalleria").hover(function(){
			$(".mygalleria").text("마이 갤러리아");
	    },
	    function(){
			$(".mygalleria").text("MY GALLERIA");
	    });
	});
	$(document).ready(function(){
	    $(".withus").hover(function(){
			$(".withus").text("함께 하는 분들");
	    },
	    function(){
			$(".withus").text("WITH US");
	    });
	});
	$(document).ready(function(){
	    $(".rules").hover(function(){
			$(".rules").text("규정");
	    },
	    function(){
			$(".rules").text("RULES");
	    });
	});
	
	function login() {
		var reqData = {id:$("#email").val(),pw:$("#password").val()};
		requestService("/api/member/login.do", reqData, function(msg) {
			var rsltCode = msg.result;
			var resData = msg.resData[0];
			if(rsltCode=="error") {
				alert("오류 코드 : "+resData.errorCd+"\n오류 메시지: "+resData.errorMsg);
				
			}else if(rsltCode=="success") {
				alert(resData.usr.name+"님 환영합니다.");
			}
			
		});
	}
	
	function join() {
		var reqData = {id:$("#join_email").val(), name:$("#join_name").val(), pw:$("#join_password").val(), type:1}
		
		if($("#join_password").val()!=$("#join_password_chk").val()) {
			alert("비밀번호와 비밀번호 확인이 옳지 않습니다.");
			return false;
		}
		
		requestService("/api/member/join.do", reqData, function(msg) {
			var rsltCode = msg.result;
			var resData = msg.resData[0];
			if(rsltCode=="error") {
				alert("오류 코드 : "+resData.errorCd+"\n오류 메시지: "+resData.errorMsg);
				
			}else if(rsltCode=="success") {
				alert(resData.rslt.name+"님 환영합니다^^;;");
			}
			
		});
	}