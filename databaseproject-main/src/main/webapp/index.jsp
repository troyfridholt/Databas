<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="beans.bean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css"
	rel="stylesheet">
<title>SQL connection</title>
</head>
<body>
	<div class="flex justify-center text-center px-auto mx-auto">
		<form action="<%=request.getContextPath()%>/SearchServlet"
			method="post">

			<p class="text-7xl font-bold pt-16 pb-5">
				<span class="text-blue-500">P</span> <span class="text-red-500">o</span>
				<span class="text-yellow-500">n</span> <span class="text-blue-500">t</span>
				<span class="text-green-600">u</span> <span class="text-red-500">s</span>
			</p>

			<input type="text"
				class="border border-2 border-gray-400 py-2 px-32 my-5 rounded-3xl outline-none left-1"
				name="searchString" pattern=".{3,}" required title="3 tecken minst!"><br>
			<input type="submit"
				class="border border-2 border-gray-400 px-16 rounded-xl outline-none"
				value="SEARCH">
		</form>
	</div>
	<div class="justify-left pt-10 mx-10">
		<p>
			<%
			ArrayList<bean> dataAnswer = (ArrayList<bean>) request.getAttribute("searchResult");
			String searchString = request.getParameter("searchString");
			out.print("<p>Search results: </p>");

			if (!(dataAnswer == null)) {
				out.print("<ul>");

				for (int i = 0; i < dataAnswer.size(); i++) {
					out.print("<li>");
					out.println(dataAnswer.get(i).getSCP());
					out.println(dataAnswer.get(i).getTitle());
					out.println(dataAnswer.get(i).getRating());
					out.println(dataAnswer.get(i).getClassification());
					out.println(dataAnswer.get(i).getType());
					out.println(dataAnswer.get(i).getRelated_GOI_s());
					out.println(dataAnswer.get(i).getLocation_Notes());
					out.println(dataAnswer.get(i).getAuthor());
					out.println(dataAnswer.get(i).getLeaked_info());
					out.println(dataAnswer.get(i).getHumanoid_or_Structure());
					out.println(dataAnswer.get(i).getAnimal_Computer_or_Extradimensional());
					out.println(dataAnswer.get(i).getAutonomous_or_Cognitohazard());
					out.println(dataAnswer.get(i).getArtifact_Location_or_Sentient());
					out.println(dataAnswer.get(i).getSummary());
					out.println(dataAnswer.get(i).getGender());
					out.println(dataAnswer.get(i).getNone());
					out.println(dataAnswer.get(i).getEthnicity_Origins());
					out.print("</li>");
				}
				if (dataAnswer.size() == 0) {
					out.print("No results");
				}
				out.print("</ul>");
			}
			%>
		</p>
	</div>

</body>
</html>