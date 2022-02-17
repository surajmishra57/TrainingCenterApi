package com.example.trainingCenters.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trainingCenters.entity.TrainingCenter;


public interface TrainingCenterDao extends JpaRepository<TrainingCenter, Integer> {
	

}
