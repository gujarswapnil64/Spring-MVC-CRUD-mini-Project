  let nameValidate=(str)=>{
      let pattern=/^[a-zA-Z]+$/g
      let result=str.match(pattern);
      if(result!=null)
      {
   document.getElementById("s").innerHTML="";
      }
      else{
document.getElementById("s").innerHTML="invalid name";

      }
   }