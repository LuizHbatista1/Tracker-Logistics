package com.example.Tracker_logistics.DTOS;

import com.example.Tracker_logistics.domain.product.StatusType;
import com.example.Tracker_logistics.domain.product.TrackerBase;
import com.example.Tracker_logistics.domain.user.User;
import jakarta.persistence.ManyToOne;

public record ProductDTO( String title,
        TrackerBase origin, StatusType status,
        String arrived,
        Long receiverId) {
}
