$(function(){
	var stype,sex,mtc,dept,levle,doc,invoiceNumber;
	$.getJSON("http://localhost:8088/select/reg",function(dt){
			stype=dt.stype;
			sex=dt.sex;
			mtc=dt.mtc;
			dept=dt.dept;
			levle=dt.levle;
			caseNumber=dt.caseNumber;
			invoiceNumber=dt.invoiceNumber;
			//填充省份
		});
})