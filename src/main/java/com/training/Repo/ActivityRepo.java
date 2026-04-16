package com.training.Repo;

import com.training.Entity.Activity;
import com.training.Entity.enums.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepo extends JpaRepository<Activity, Long> {
    List<Activity> findByUserId(Long userId);

    List<Activity> findByActivity(ActivityType activity);

    List<Activity> findByUserIdAndActivity(Long userId, ActivityType activity);



}
