<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="lazy" uri="http://lazyloading.com/tags/ll"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>

<script src="js/jQuery1.11.0.min.js"></script>
<!-- LOAD ANGULAR JS BEFORE ELSE BOOTSTRAP WILL FAIL -->
<script src="js/angular.js"></script>
 <link href="css/foundation.min.css" rel="stylesheet" /> 

<style type="text/css">
.colorRed{
background: red;

}
html{
	padding:0px;
	margin: 0px;
}
td{
	padding: 0px;
	margin: 0px;
}
header{
	margin: 0;
	background-color: #107385;
	width: 100%;
	height: 4em;
}

</style> 
<script type="text/javascript">
	$(function(){
	$('#submit').click(function(){
		angular.element('#MyTable').scope().submitLazyForm("checked", "true");		
	});

	});
	
</script>
</head>
<body>
<header>
	<h3 style="margin:0; color: #fff; padding: 0.5em">Lazy Loading Demo</h3>
</header>
	
	
	<div class="small-6 large-6 columns">
		
		<form action="filterPersonByName.htm">
			
			<fieldset>
				<legend>Filter Person by Name</legend>
				
				<div class="large-12 columns">
					
					<div class="row">
					
						<div class="large-9 columns">
							<label>Person Name Containing : 
								<input type="text" name="personName" placeholder="Person Name" value="${personName }" />
							</label>						
						</div>
						
						<div class="large-3 columns">
							<label>
								<input type="submit" name="action" placeholder="Filter Data" />
							</label>						
						</div>
						
					</div>
					
				</div>
				
			</fieldset>
			
		</form>
		
	</div>
	
	<div class="small-12 large-12 columns">
			<form:form commandName="personList" method="post" action="submit.htm">
				<lazy:dataTable id='MyTable' modelClass="com.lazyload.model.LazyPerson" recordsPerPage="5" paginateDisplayRange="6" 
							perPageSelection="5,10,15,100" height="350px" stickyHeader="false" loadingImg="images/hex-loader2.gif"
							idTr="row_{{lazyObj.$index}}" requestAttr="${filter }" cssStyle="white-space: nowrap;" >
				
				<lazy:dataColumn attributeName="" headerText="#" id="1" cssStyleTh="width: 20px" cssStyleTd="padding: 0">
		 			<input type='checkbox' ng-value="lazyObj.checked" ng-model='lazyObj.checked' />
		 			<!-- lazyObj is the implicit object which represents the object in current iteration -->
		 		</lazy:dataColumn>
						
					<!-- $index is the variable provided by Angular JS representing the record number in ng-repeat.
						It is in this order the list will be binded with the backing bean when records will be submitted
					 -->
				<lazy:dataColumn attributeName="userId" headerText="User Id" cssStyleTd="padding: 0" evalExpression="ng-class='{colorRed: lazyObj.userId ==\"1\"}'" > <!--  evalExpression="ng-class='{colorRed: lazyObj.code ==\"IBR00001\"}'" -->
					<input type='hidden' name="persons[{{$index}}].userId" ng-value="lazyObj.userId" ng-model='lazyObj.userId' />
				</lazy:dataColumn>
				
		 		<lazy:dataColumn attributeName="personName" headerText="Person Name" cssStyleTd="padding: 0">
		 			<input type='hidden' name="persons[{{$index}}].personName" ng-value="lazyObj.personName" ng-model='lazyObj.personName' />
		 		</lazy:dataColumn> 
		 				 		
		 		<lazy:dataColumn attributeName="address" headerText="Address" cssStyleTd="padding: 0">		
		 			<input type='hidden' name="persons[{{$index}}].address" ng-value="lazyObj.address" ng-model='lazyObj.address' /> 			
		 		</lazy:dataColumn>
		 		
		 		<lazy:dataColumn attributeName="hobbies" headerText="Hobbies" cssStyleTd="padding: 0">
		 			<select name="persons[{{$index}}].selectedHobby">
		 				<option ng-repeat='value in lazyObj.hobbies' value='{{value}}' >{{value}}</option>
		 			</select>
		 		</lazy:dataColumn>		 		
		 		<lazy:dataColumn attributeName="email" headerText="Email" cssStyleTd="padding: 0">		 			
		 		</lazy:dataColumn>
		 		
		 		<lazy:dataColumn attributeName="registeredOn" headerText="Resistered On" cssStyleTd="padding: 0">		 			
		 		</lazy:dataColumn>
		 		
		 		<lazy:dataColumn attributeName="" headerText="Remarks" cssStyleTd="padding: 0">
		 			<input type='text' name="persons[{{$index}}].remarks" ng-value="lazyObj.remarks" ng-model='lazyObj.remarks' /> 
		 		</lazy:dataColumn>
			</lazy:dataTable>
			
			<div class="small-12 large 12 center">
				<input type="submit" name="submit" value="Submit Records" id="submit"></input>
			</div>
		</form:form>
	</div>

</body>
</html>