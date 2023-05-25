/**
 * 채팅 관련한 기능 구현
 */

 document.addEventListener('DOMContentLoaded',()=>{

	// 웹 소켓 객체 만들기
	let ws; // 웹소켓
	ws = new WebSocket("ws://localhost:8082/accmg/chat");
	
	
	
	
	// 메시지가 표시될 곳 설정
	let messages = document.querySelector('#chatcontent');
	
	ws.onmessage = (e) => {
		
		let message = e.data;
		console.log("received messages : " + message);
		
	};
	
	const btnsend = document.querySelector('#btnsend');
	btnsend.addEventListener('click',() => {
		
		let text = document.querySelector("#inputtext").value;
		ws.send(text);
		writeResponse(text);
		text="";
		
	})
	

	const btnopen = document.querySelector("#btnopen");
	btnopen.addEventListener('click',()=>{
		
		if(ws!==undefined && ws.readyState!==WebSocket.CLOSED)
		{
			writeResponse("WebSocket is already opened");
			return;
		}
		
		
		
		
		ws.onopen=(e) => {
			console.log('연결');
			if(e.data===undefined) {
				return;
			} else {
				writeResponse(e.data);
			};
			
			
			
		};
		ws.onmessage=(e)=>{
			writeResponse(e.data);
		};
		ws.onclose = (e) => {
			writeResponse("Connection closed");
		}
		
	});

	const btnclose = document.querySelector('#btnclose');
	btnclose.addEventListener('click',()=>{
		
		ws.close();
		console.log('소켓 해제');
	});

	function writeResponse(text){
		messages.innerHTML += "<br/>"+text;
	}
		 
 })