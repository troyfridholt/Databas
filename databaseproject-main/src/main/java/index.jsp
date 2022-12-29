<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@page import="beans.bean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show me the bears</title>
</head>
<body>

	<form action="<%=request.getContextPath()%>/SearchServlet"
		method="post">
		<h4>
			Search database: <input type="text" name="searchString"
				pattern=".{3,}" required
				title="Sök i databasen."> <input
				type="submit" value="Search">
		</h4>
	</form>

	<%
	ArrayList<bean> dataChars = (ArrayList<bean>) request.getAttribute("searchResult");
	String searchString = request.getParameter("searchString");

	if (!(dataChars == null)) {


		out.print("<ul>");

		for (int i = 0; i < dataChars.size(); i++) {
			out.print("<li>");
			out.println(dataChars.get(i).getSCP());
			out.println(dataChars.get(i).getTitle());
			out.println(dataChars.get(i).getRating());
			out.println(dataChars.get(i).getClassification());
			out.println(dataChars.get(i).getType());
			out.println(dataChars.get(i).getRelated_GOI_s());
			out.println(dataChars.get(i).getLocation_Notes());
			out.println(dataChars.get(i).getAuthor());
			out.println(dataChars.get(i).getLeaked_info());
			out.println(dataChars.get(i).getHumanoid_or_Structure());
			out.println(dataChars.get(i).getAnimal_Computer_or_Extradimensional());
			out.println(dataChars.get(i).getAutonomous_or_Cognitohazard());
			out.println(dataChars.get(i).getArtifact_Location_or_Sentient());
			out.println(dataChars.get(i).getSummary());
			out.println(dataChars.get(i).getGender());
			out.println(dataChars.get(i).getNone());
			out.println(dataChars.get(i).getEthnicity_Origins());
			out.print("</li>");
		}
		if (dataChars.size() == 0) {

		}

		out.print("</ul>");

	}
	%>


</body>
</html>