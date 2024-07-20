let searchemp=(str)=>
{
	 var xhttp;
  xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
    document.getElementById("searchdata").innerHTML = this.responseText;
    }
  };
  xhttp.open("GET", "searchemp?str="+str, true);
  xhttp.send();
}