package com.hbrooks.trainjourney;

import org.hibernate.annotations.Formula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainJourneyRepository extends JpaRepository<TrainJourney, Integer> {

    List<TrainJourney> findByUserId(Integer id);
}
