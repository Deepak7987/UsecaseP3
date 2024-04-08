package com.rays.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.dto.ChannelDTO;
import com.rays.model.ChannelModel;

@WebServlet("/ChannelCtl")
public class ChannelCtl extends HttpServlet {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		ChannelDTO dto = new ChannelDTO();
		ChannelModel model = new ChannelModel();
		if (id != null) {
			dto = model.findByPk(Long.parseLong(id));
			req.setAttribute("dto", dto);
		}
		RequestDispatcher rd = req.getRequestDispatcher("ChannelView.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ChannelDTO dto = new ChannelDTO();
		String id = req.getParameter("id");
		String op = req.getParameter("operation");
		ChannelModel model = new ChannelModel();
		
		dto.setChannelname(req.getParameter("channelname"));
		dto.setShowname(req.getParameter("showname"));
		dto.setWatchlist(req.getParameter("watchlist"));
		
		try {
			dto.setShowtime(sdf.parse(req.getParameter("date")));
		} catch (java.text.ParseException e) {
			
			e.printStackTrace();
		}
		
		
		if (op.equalsIgnoreCase("update")) {
			dto.setId(Integer.parseInt(id));
			model.update(dto);
			req.setAttribute("dto", dto);
			req.setAttribute("msg", "channel record updated successfully");
		}
		if (op.equalsIgnoreCase("save")) {
			req.setAttribute("dto", dto);
			model.add(dto);
			req.setAttribute("msg", "Channel record added successfully");

		}if (op.equalsIgnoreCase("reset")) {
//			req.setAttribute("dto", dto);
			RequestDispatcher rd = req.getRequestDispatcher("ChannelView.jsp");
			rd.forward(req, resp);

		}
		RequestDispatcher rd = req.getRequestDispatcher("ChannelView.jsp");
		rd.forward(req, resp);

	}

}
