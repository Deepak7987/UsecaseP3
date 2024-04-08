package com.rays.test;

import java.text.SimpleDateFormat;

import com.rays.dto.ChannelDTO;
import com.rays.model.ChannelModel;

public class ChannelTest {
	
	public static void main(String[] args) throws Exception {
		
		testAdd();
	}

	
		private static void testAdd() throws Exception {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			ChannelDTO dto = new ChannelDTO();
			
			dto.setId(1);
			dto.setChannelname("pogo");
			dto.setShowname("chota bhim");
			dto.setWatchlist("five");
			dto.setShowtime(sdf.parse("2024-03-12"));
			
			ChannelModel model = new ChannelModel();
			model.add(dto);

			
		}
	}


