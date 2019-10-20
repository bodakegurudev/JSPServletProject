<%@ page import="java.io.*,java.util.*,com.rupesh.ParameterModel"%>

<html>
<head>
<title>DropDown in JSP</title>

<% 
	List<ParameterModel> lendUnitList = new ArrayList();
	lendUnitList.add(new ParameterModel("233", "233"));
	lendUnitList.add(new ParameterModel("222", "222"));
	lendUnitList.add(new ParameterModel("333", "333"));
	lendUnitList.add(new ParameterModel("444", "444"));
	
	List<ParameterModel> legalEntityList = new ArrayList();
	legalEntityList.add(new ParameterModel("Branch", "Branch"));
	legalEntityList.add(new ParameterModel("Subsidary", "Subsidary"));
%>

<script> 
	//Global variable holding all the options of Legal Unit
	var globalLegalEntityOptionsHtml;
	
	function populateLegalEntity(selLendingUnitDD) {
		var selLegalUnitDD = document.getElementById("selLegalUnit");
		if(globalLegalEntityOptionsHtml == null){
			//Initialize only on first call to populateLegalEntity function
			globalLegalEntityOptionsHtml = document.getElementById("selLegalUnit").innerHTML;
		}
		
		if(selLendingUnitDD.options[selLendingUnitDD.selectedIndex].value == "233"){
			//Remove subsidary option if lending unit is 233
			for (var i=0; i<selLegalUnitDD.length; i++) {
			    if (selLegalUnitDD.options[i].value == 'Subsidary'){
			    	selLegalUnitDD.remove(i);
				}
			}
		} else {
			//Reset all options back if value for lending unit is not 233
			selLegalUnitDD.innerHTML= globalLegalEntityOptionsHtml;
		}
	}
	
	</script>
</head>
<body>

	<%!int i = 0; ParameterModel pModel = null;%>

	<h3>Lending Unit</h3>
	<select name="selLendingUnit" id="selLendingUnit" onChange="populateLegalEntity(this)">
		<option selected></option>
		<%
			if (lendUnitList != null && lendUnitList.size() > 0) {
				for (int i = 0; i < lendUnitList.size(); i++) {
					pModel = lendUnitList.get(i);
					%>
					<option value="<%=pModel.getCode1()%>">
						<%=pModel.getDesc1()%>
					</option>
					<%
				}
			}
		%>
	</select>

	<h3>Legal Entity</h3>
	<select name="selLegalUnit" id="selLegalUnit">
		<option selected></option>
		<%
			if (legalEntityList != null && legalEntityList.size() > 0) {
				for (int i = 0; i < legalEntityList.size(); i++) {
					pModel = legalEntityList.get(i);
					%>
					<option value="<%=pModel.getCode1()%>">
						<%=pModel.getDesc1()%>
					</option>
					<%
				}
			}
		%>
	</select>
</body>
</html>