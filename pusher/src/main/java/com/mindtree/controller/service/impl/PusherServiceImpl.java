package com.mindtree.controller.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mindtree.controller.service.PusherService;
import com.pusher.rest.Pusher;

@Service
public class PusherServiceImpl implements PusherService{

	private  static String APP_ID; 
	private  static String APP_KEY; 
	private  static String APP_SECRET; 
	private  static String APP_CLUSTER;
	
	@Override
	public String hitPusher()
	{
		Map<String,Object> map = new HashMap<String,Object>();
		if(APP_ID==null||APP_KEY==null||APP_SECRET==null||APP_CLUSTER==null)
		{
			return "Configuration is not set";
		}
		
		Pusher pusher = new Pusher(APP_ID, APP_KEY, APP_SECRET);
		pusher.setCluster(APP_CLUSTER);
		map.put("APP_SECRET",APP_SECRET);
		map.put("APP_KEY", APP_KEY);
		pusher.trigger("my-channel", "my-event", Collections.singletonMap("message", map));
		return "pusher got hit";
	}

	@Override
	public Map pusherConfiguration(Map<String, Object> map) {
		APP_CLUSTER = (String)map.get("APP_CLUSTER");
		APP_KEY = (String)map.get("APP_KEY");
		APP_SECRET = (String)map.get("APP_SECRET");
		APP_ID = (String)map.get("APP_ID");
		return map;
	}


}
