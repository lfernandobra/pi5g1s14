//script.js
function loadContent(contentUrl) {
	  var req = new XMLHttpRequest();
	  req.open("GET", contentUrl, false);
	  if(req.overrideMimeType)
		  req.overrideMimeType('text/xml; charset=iso-8859-1'); 	
	  req.send(null);
	  var page = req.responseText;

	  document.getElementById("conteudo").innerHTML = page;
	
}