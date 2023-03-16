function modifica(param){
	switch(param){
		
		case "nome":
			var bottoneN = document.querySelector("#name");
			bottoneN.removeAttribute("readonly");
			bottoneN.value="";
			break;
		
		case "cognome":
			var bottoneN = document.querySelector("#surname");
			bottoneN.removeAttribute("readonly");
			bottoneN.value="";
			break;
	}
}