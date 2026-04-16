package com.training.Repo;

import com.training.Entity.Activity;
import com.training.Entity.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationRepo extends JpaRepository<Recommendation, Long> {
    List<Recommendation> findByUserId(Long userId);

    List<Recommendation> findByActivityId(Long activityId);

    List<Recommendation> findByUserIdAndActivityId(Long userId, Long activityId);
}
