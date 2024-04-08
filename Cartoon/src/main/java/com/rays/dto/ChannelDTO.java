package com.rays.dto;

import java.util.Date;

public class ChannelDTO {
	
	private long id;
	private String channelname;
	private String showname;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getChannelname() {
		return channelname;
	}
	public void setChannelname(String channelname) {
		this.channelname = channelname;
	}
	public String getShowname() {
		return showname;
	}
	public void setShowname(String showname) {
		this.showname = showname;
	}
	public String getWatchlist() {
		return watchlist;
	}
	public void setWatchlist(String watchlist) {
		this.watchlist = watchlist;
	}
	public Date getShowtime() {
		return showtime;
	}
	public void setShowtime(Date showtime) {
		this.showtime = showtime;
	}
	private String watchlist;
	private Date showtime;
	

}
