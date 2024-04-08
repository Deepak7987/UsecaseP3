

<%@page import="com.rays.dto.ChannelDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		ChannelDTO dto = (ChannelDTO) request.getAttribute("dto");
		String msg = (String) request.getAttribute("msg");
	%>
	<%
		if (dto != null) {
	%>
	<h1 align="center">Update Cartoon</h1>
	<%
		} else {
	%>
	<h1 align="center">Add Cartoon</h1>
	<%
		}
	%>
	<%
		if (msg != null) {
	%>
	<h3 align="center"><%=msg%></h3>
	<%
		}
	%>
	<form action="ChannelCtl" method="post">
		<table align="center">
			<input type="hidden" name="id"
				value="<%=(dto != null) ? dto.getId() : ""%>">
			<tr>
				<th>ChannelName :</th>
				<td><input type="text" name="channelname"
					value="<%=(dto != null) ? dto.getChannelname() : ""%>"></td>
			</tr>
			&nbsp;
			<tr>
				<th>ShowName :</th>
				<td><input type="text" name="showname"
					value="<%=(dto != null) ? dto.getShowname() : ""%>"></td>
			</tr>
			&nbsp;
			<tr>
				<th>WatchList :</th>
				<td><input type="text" name="watchlist"
					value="<%=(dto != null) ? dto.getWatchlist() : ""%>"></td>
			</tr>
			
			&nbsp;
			
			<tr>
				<th>ShowTime :</th>
				<td><input type="<%=(dto != null) ? "text" : "date"%>"
					name="date"
					value="<%=(dto != null) ? dto.getShowtime() : ""%>"></td>
			</tr>
			&nbsp;
			<tr>
				<th></th>
				<td><input type="submit" name="operation"
					value="<%=(dto != null) ? "Update" : "save"%>"> <!-- <input
					type="reset"></td> -->
			</tr>
		</table>
	</form>
</body>
</html>