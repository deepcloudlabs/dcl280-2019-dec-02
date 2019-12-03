package com.example.service;

import java.util.Collection;

import javax.jws.WebService;

@WebService
public interface LotteryService {
	Collection<Integer> 
	         draw(int min,int max,int size,boolean sorted);
}
