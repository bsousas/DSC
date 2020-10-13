package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Cadeira;
import com.example.service.CadeiraService;

@RestController

@RequestMapping("v1/api/cadeiras")

public class CadeirasController {
	
	@Autowired
	CadeiraService cadeiraService;
	
	
	@GetMapping("/ranking")
	public ResponseEntity<?> getRankCadeiras(){
		return new ResponseEntity<>(cadeiraService.getOrdered(), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> getCadeiras(){
		return new ResponseEntity<>(cadeiraService.getCadeiras(), HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<?> postCadeiras(@RequestBody Cadeira cadeiras){
		cadeiras.setId(cadeiraService.getCadeiras().size());
		cadeiraService.createCadeira(cadeiras);
		return new ResponseEntity(cadeiras, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCadeira(@PathVariable int id){
		Cadeira x = cadeiraService.getCadeiraPorId(id);
		cadeiraService.deleteCadeira(id);
		return new ResponseEntity<>(x, HttpStatus.OK);
	}
	

}
