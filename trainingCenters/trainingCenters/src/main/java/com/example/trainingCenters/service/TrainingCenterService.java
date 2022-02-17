package com.example.trainingCenters.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trainingCenters.dao.TrainingCenterDao;
import com.example.trainingCenters.entity.TrainingCenter;

@Service
public class TrainingCenterService {

	@Autowired
	private TrainingCenterDao trainingcenterdao;
	
	// Get All 
	public List<TrainingCenter> getAllTrainingCenter() {
		// TODO Auto-generated method stub
		List<TrainingCenter> trainingcenter = (List<TrainingCenter>)trainingcenterdao.findAll();
		return trainingcenter;
	}
	
	//Add New Training Center
		public TrainingCenter addTrainingCenter(TrainingCenter a)
		{
			return trainingcenterdao.saveAndFlush(a);
		}

		
}
