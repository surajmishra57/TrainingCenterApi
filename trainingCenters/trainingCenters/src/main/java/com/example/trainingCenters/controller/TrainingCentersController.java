package com.example.trainingCenters.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.trainingCenters.entity.TrainingCenter;
import com.example.trainingCenters.service.TrainingCenterService;

@RestController
public class TrainingCentersController {
	
	@Autowired
	private TrainingCenterService trainingcenterservice;
	
	
	@GetMapping("/trainingcenter")
	ResponseEntity<List<TrainingCenter>> getAllTrainingCenters()
	{
		List<TrainingCenter> b = trainingcenterservice.getAllTrainingCenter();
		if(b.size()<=0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(b);
		return ResponseEntity.of(Optional.of(b));
		
	}
	
	
	
	@PostMapping("/trainingcenter")
	ResponseEntity<TrainingCenter> addNewTrainingCenter(@Valid @RequestBody TrainingCenter trainingcenter)
	{
	   TrainingCenter tr=null;
	   tr = trainingcenterservice.addTrainingCenter(trainingcenter);
	   if(tr==null)
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		return  ResponseEntity.status(HttpStatus.CREATED).body(tr); 
	}
	

}
