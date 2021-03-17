package com.spring.aop.springAop.data;

import org.springframework.stereotype.Service;

import com.spring.aop.springAop.aspect.TrackTime;

@Service
public class Dao1 {
	
	@TrackTime
	public String retrieveSomething() {
		return "Dao1";
	}

}
