function showDate()
{
	var now = new Date();
	var days = new Array('Duminică','Luni','Marți','Miercuri','Joi','Vineri','Sîmbătă');
	var months = new Array('01','02','03','04','05','06','07','08','09','10','11','12');
	var date = ((now.getDate()<10) ? "0" : "")+ now.getDate();
	function fourdigits(number)
	{
		return (number < 1000) ? number + 1900 : number;
	}
	
	tnow=new Date();
	thour=now.getHours();
	tmin=now.getMinutes();
	tsec=now.getSeconds();
	
	if (tmin<=9) { tmin="0"+tmin; }
	if (tsec<=9) { tsec="0"+tsec; }
	if (thour<10) { thour="0"+thour; }
	
	today = " ▒ "+days[now.getDay()] + ", " + date + "." + months[now.getMonth()] + "." + (fourdigits(now.getYear())) + " ▪ " + thour + ":" + tmin +":"+ tsec;
	//alert("hsvda");
	document.getElementById("dateDiv").innerHTML = today;
}
setInterval("showDate()", 1000);
