let deptwise=(str)=>{
	var xhttp;
  xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
    document.getElementById("deptemp").innerHTML = this.responseText;
    }
  };
  xhttp.open("GET", "deptsearchemp?str="+str, true);
  xhttp.send();
}