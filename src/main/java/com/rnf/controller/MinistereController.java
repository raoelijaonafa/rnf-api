package com.rnf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rnf.service.referentiel.MinistereService;
 
@RestController

public class MinistereController {
 

@Autowired
private MinistereService minService;
	
@GetMapping("${v1API}/ministere/all")
@PreAuthorize("hasRole('ROLE_SUPERADMIN')or hasRole('ROLE_ADMIN')")
public Object listAllSecteur() {
	return this.minService.findAllMinistere();

 
}
	
}
