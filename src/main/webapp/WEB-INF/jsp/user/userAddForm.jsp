<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="../common/header.jsp" %>
<script>
    document.title = "회원 정보" ;
</script>
<br/>
    <h1 class="text-center">회원입력</h1>
<br/>
<br/>
<form id="userAddForm" name="userAddForm" method="post" >
	아이디 : <input type="text" id="username" name="username"><br>
	비밀번호 : <input type="password" id="password" name="password" /><br>
	<button type="button" id="btn_userAdd1" onclick="controllerUserAdd()"> form Submit으로 controller로  저장</button>
	<button type="button" id="btn_userAdd" onclick="restcontrollerUserAdd()"> form Submit으로 restcontroller로 저장</button>
	<button type="button" id="btn_ajaxUserAdd" onclick="AjaxRestcontrollerUserAdd()"> ajax로 restcontroller로 저장</button>
	<button type="button" id="btn_fetchUserAdd" onclick="FetchRestcontrollerUserAdd()"> fetch로 restcontroller로 저장</button>
	<button type="button" id="btn_AxiosUserAdd" onclick="AxiosRestcontrollerUserAdd()"> Axios로 restcontroller로 저장</button>
	<button type="button" id="btn_AsyncUserAdd" onclick="AsyncRestcontrollerUserAdd()"> Async로 restcontroller로 저장</button>
	<button  type="reset" id="btn_userAddCancle1">  취소</button>
</form>


<script type="text/javascript">

	function controllerUserAdd() {
		document.userAddForm.action = "<c:url value='/user/controllerUserAddProc'/>";
    	document.userAddForm.submit();
	}

    function restcontrollerUserAdd() {
    	document.userAddForm.action = "<c:url value='/user/restcontrollerUserAddProc'/>";
        document.userAddForm.submit();
    }
    
    
    //////////////////////////////////////////////////////////////////
    // ajax 방식 시작/////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////
    //jQuery ajax로 restcontroller에 JSON으로 DATA로 넘겨서 DTO에 저장하기
    function AjaxRestcontrollerUserAdd() {
    	
    	let data = {
				username: $("#username").val(),
				password: $("#password").val(),				
		};
    	
    	 if(confirm('회원가입 하시겠습니까?')) {
    		 
    			$.ajax({ 
    				type: "POST",
    				url: "/user/ajaxFetchAsyncAxioRestcontrollerUserAddProc",
    				data: JSON.stringify(data), // http body데이터
    				contentType: "application/json; charset=utf-8",// body데이터가 어떤 타입인지(MIME)
    				dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면) => javascript오브젝트로 변경
    				
    			}).done(function(resp){
    				if(resp.status === 200){
    					alert("회원가입에 완료되었습니다.");
    					location.href = "/user/listModel";
    				}else{
    					alert("회원가입에 실패하였습니다.");			
    				}

    			}).fail(function(error){
    				alert(JSON.stringify(error));
    			});
    			
    	 } else {
    		 return false;
    	 }
   	
    }
    //////////////////////////////////////////////////////////////////
    // ajax 방식 끝///////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////
    
    
    //////////////////////////////////////////////////////////////////
    // fetch 방식 시작////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////
  	//Fetch Api(jquery사용)로 restcontroller에 JSON으로 DATA로 넘겨서 DTO에 저장하기
    function FetchRestcontrollerUserAdd() {
    	
    	//jquery 사용안했을때 값가져오기
	    //const form = document.getElementById('userAddForm');
    	//const data = {
    	//	username: form.username.value,
    	//	password: form.password.value,
    	//};
	  
	  
    	let data = {
				username: $("#username").val(),
				password: $("#password").val(),				
		};
    	
    	const uri = '/user/ajaxFetchAsyncAxioRestcontrollerUserAddProc';
    	const method = 'POST';
    	
    	 if(confirm('회원가입 하시겠습니까?')) {
    		 
    		 fetch(uri, {
    				method: method,	
    				headers: {
    					'Content-Type': 'application/json',
    				},
    				body: JSON.stringify(data)

    			}).then(response => {
    				if(response.status === 200){
    					alert("회원가입에 완료되었습니다.");
    					location.href = "/user/listModel";
    				}else{
    					alert("회원가입에 실패하였습니다.");			
    				}
    			}).catch(error => {
    				alert('오류가 발생하였습니다.');
    			});
    			
    	 } else {
    		 return false;
    	 }
   	
    }
    //////////////////////////////////////////////////////////////////
    // fetch 방식 끝//////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////// 
  
    //////////////////////////////////////////////////////////////////
    // Axios 방식 시작////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////  
    //Axios Api(jquery사용)로 restcontroller에 JSON으로 DATA로 넘겨서 DTO에 저장하기
    function AxiosRestcontrollerUserAdd() {
    	
    	//jquery 사용안했을때 값가져오기
	    //const form = document.getElementById('userAddForm');
    	//const data = {
    	//	username: form.username.value,
    	//	password: form.password.value,
    	//};
	  
	  
    	let data = {
				username: $("#username").val(),
				password: $("#password").val(),				
		};
    	
    	const uri = '/user/ajaxFetchAsyncAxioRestcontrollerUserAddProc';
    	const method = 'POST';
    	
    	 if(confirm('회원가입 하시겠습니까?')) {
    		 
    		 axios ({
    			    url: uri,
    				method: method,
    				headers: {
    					'Content-Type': 'application/json',
    				},
    				data: JSON.stringify(data)

    			}).then(response => {
    				if(response.status === 200){
    					alert("회원가입에 완료되었습니다.");
    					location.href = "/user/listModel";
    				}else{
    					alert("회원가입에 실패하였습니다.");			
    				}
    			}).catch(error => {
    				alert('오류가 발생하였습니다.');
    			});
    			
    	 } else {
    		 return false;
    	 }
   	
    } 
    
    //////////////////////////////////////////////////////////////////
    // Axios 방식 끝//////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////

    
    //////////////////////////////////////////////////////////////////
    // Async await 방식 시작//////////////////////////////////////////
    //////////////////////////////////////////////////////////////////
 	async function asyncUserAdd(url, data){
    	    //alert(url);
    	    //console.table(data);
		  	const response = await fetch(url, {
		  			method: 'POST',
	      			headers: {
	        			'Content-type': 'application/json'
	      			},
	      			body: JSON.stringify(data)
		  	});
 		  return response;
 		} 
    
    function AsyncRestcontrollerUserAdd() {
    	

    	let data = {
				username: $("#username").val(),
				password: $("#password").val(),				
		};
    	const url = '/user/ajaxFetchAsyncAxioRestcontrollerUserAddProc';
   	     
    	if(confirm('회원가입 하시겠습니까?')) {
    		
    		asyncUserAdd(url, data) //async 함수 호출
        	 
         	.then(response => response.json())
         	.then(result => {
         		console.table(result)
         		if(result.status === 200){
    				alert("회원가입에 완료되었습니다.");
    				location.href = "/user/listModel";
    			}else{
    				alert("회원가입에 실패하였습니다.");			
    			}
         	})
         	.catch (error => {
         		alert('통신에러 발생');
         	});
    	} else {
    		return false;
    	}
     	 
     	 	
	}

    
    //////////////////////////////////////////////////////////////////
    // Async await 방식 끝//////////////////////////////////////////
    //////////////////////////////////////////////////////////////////

    /* $(document).on('click', '#btn_userAdd', function(e) {
        $("#userAddForm").submit();
    }); */
</script>
<%@include file ="../common/footer.jsp" %>