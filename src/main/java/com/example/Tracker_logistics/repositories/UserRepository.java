package com.example.Tracker_logistics.repositories;

import com.example.Tracker_logistics.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
