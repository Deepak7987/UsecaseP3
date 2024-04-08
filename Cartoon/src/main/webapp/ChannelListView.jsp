
<%@page import="com.rays.dto.ChannelDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Channel List</title>
</head>
<body>
	<jsp:useBean id="dto" class="com.rays.dto.ChannelDTO"
		scope="request"></jsp:useBean>
	<form action="ChannelListCtl" method="post">
		<h1 align="center">Channel List</h1>
		<%
			List list = (List) request.getAttribute("list");
			Iterator it = list.iterator();
			int index = 1;
			String msg = (String) request.getAttribute("msg");
			if (msg != null) {
		%>
		<h3 align="center" style="color: red"><%=msg%></h3>
		<%
			}
		%>
		&nbsp;&nbsp;&nbsp;
		<table align="center">

			<tr>
				<td>Channel Name :
				</th>
				<td><input type="text" name="channelname"> <input
					type="submit" name="operation" value="search"></td>
			</tr>

		
				</select></td>
				<!-- <td><input type="submit" name="operation" value="Search"></td> -->
			</tr>

		</table>
		&nbsp;
		<table align="center" width="100%" cellpadding=7px border="2">
			<tr align="center" bgcolor="gray">
				<th>Select</th>
				<th>S.NO</th>
				<th>ChannelName</th>
				<th>ShowName</th>
				<th>WatchList</th>
				<th>ShowTime</th>
				<th>Edit</th>

			</tr>
			<%
				while (it.hasNext()) {
					dto = (ChannelDTO) it.next();
			%>
			<tr align="center">
				<td><input type="checkbox" name="ids" value="<%=dto.getId()%>"></td>
				<td><%=index++%></td>
				<td><%=dto.getChannelname()%></td>
				<td><%=dto.getShowname()%></td>
				<td><%=dto.getWatchlist()%></td>
				<td><%=dto.getShowtime()%></td>
				<td><a href="ChannelCtl?id=<%=dto.getId()%>">[edit]</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<table align="center">
			<tr>
				<th></th>
				<td><input type="submit" name="operation" value="delete"></td>
				<th></th>
				<!-- <td><input type="submit" name="operation" value="new"></td>
				<td><input type="reset"></td> -->
			</tr>
		</table>

	</form>
</body>
</html>