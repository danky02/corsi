function modifica(param){
	switch(param){
		
		case "nome":
			var bottoneN = document.querySelector("#nome");
			bottoneN.removeAttribute("readonly");
			bottoneN.value="";
			break;
		
		case "cognome":
			var bottoneN = document.querySelector("#cognome");
			bottoneN.removeAttribute("readonly");
			bottoneN.value="";
			break;
	}
}