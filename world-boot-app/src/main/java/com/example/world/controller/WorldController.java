package com.example.world.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.world.dao.WorldDao;
import com.example.world.entity.Country;

@RestController
@RequestScope
@CrossOrigin
@RequestMapping("countries")
public class WorldController {
	@Autowired private WorldDao worldDao;
	// http://localhost:7001/world/api/v1/countries/TUR
	@GetMapping("{code}")
	public Country findCountryByCode(@PathVariable String code) {
		return worldDao.findCountryByCode(code);
	}
}
