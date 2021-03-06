package com.AISubtitles.Server.dao;

import java.util.List;

import com.AISubtitles.Server.domain.VideoCollections;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoCollectionsDao extends JpaRepository<VideoCollections, Integer> {
    VideoCollections findByUserIdAndVideoId(int userId, int videoId);
    List<VideoCollections> findAllByUserId(int userId);
}