package com.AISubtitles.Server.dao;

import java.util.List;

import com.AISubtitles.Server.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface VideoDao extends JpaRepository<Video, Integer> {
    
    @Transactional
    @Modifying
    @Query(value = "update  video_info set video_p = :video_p , video_path = :video_path where video_id = :video_id",nativeQuery = true)
    public Integer compressVideo(@Param("video_id")Integer video_id,@Param("video_path") String video_path,@Param("video_p") Integer video_p);
 
     @Transactional
     @Modifying
     @Query(value = "update video_info set  video_path = :video_path , audio_type = :audio_type where  video_id = :video_id",nativeQuery = true)
     public Integer voiceChanger(@Param("video_id") Integer video_id,@Param("video_path") String video_path,@Param("audio_type") Integer audio_type);
     
     /*
     * Gavin
     * 添加对应音频的字幕路径
     * Param audioPath    音频路径
     * Param subtitlePath 语音识别生成字幕路径
     */
    @Query(value = "update video_info  set video_zhsubtitle = :subtitlePath where video_audio = :audioPath" ,nativeQuery = true)
    public Integer audio2zhSubtitle(@Param("audioPath")String audioPath, @Param("subtitlePath")String subtitlePath);
    
    /*
     * 翻译成目标语言的字幕路径
     * Param subtitlePath    视频语言字幕路径
     * Param transSubtitlePath 语音识别生成字幕路径
     */
    @Query(value = "update video_info  set video_ensubtitle = :transSubtitlePath where video_zhsubtitle = :subtitlePath" ,nativeQuery = true)
    public Integer translateSubtitle(@Param("subtitlePath")String subtitlePath, @Param("transSubtitlePath")String transSubtitlePath);




    /*
     * Gavin
     * 视频语言字幕与目标语言字幕合并字幕路径
     * Param zhSubtitlePath    视频语言字幕路径
     * Param mergedSubtitlePath 合并字幕路径
     */
    @Query(value = "update video_info  set video_enzhsubtitle = :mergedSubtitlePath where video_zhsubtitle = :zhSubtitlePath" ,nativeQuery = true)
    public Integer mergeSubtitle(@Param("zhSubtitlePath")String zhSubtitlePath, @Param("mergedSubtitlePath")String mergedSubtitlePath);

    /*
     * Gavin
     * 将字幕转为JSON格式
     * Param srt_filename    srt字幕路径
     * Param out_filename    JSON格式字幕路径
     */
    @Query(value = "update video_info  set video_enzhsubtitlejson = :out_filename where video_enzhsubtitle = :srt_filename" ,nativeQuery = true)
    public Integer srt2json(@Param("srt_filename")String srt_filename, @Param("out_filename")String out_filename);


    @Transactional
    @Modifying
    @Query(value = "update video_info set video_cover = :video_cover where video_id = :video_id", nativeQuery = true)
    Integer modifyCover(@Param("video_id") Integer video_id, @Param("video_cover") String video_cover);


    @Transactional
    @Modifying
    @Query(value = "update video_info set video_path = :video_path where video_id = :video_id", nativeQuery = true)
    Integer modifyPath(@Param("video_id") Integer video_id, @Param("video_path") String video_path);

    @Transactional
    @Modifying
    @Query(value = "update video_info set video_name = :video_name where video_id = :video_id", nativeQuery = true)
    Integer modifyName(@Param("video_id") Integer video_id, @Param("video_name") String video_name);

    @Transactional
    @Modifying
    @Query(value = "update video_info set process_progress = :process_progress where video_id = :video_id", nativeQuery = true)
    Integer modifyProgress(@Param("video_id") Integer video_id, @Param("process_progress") Double process_progress);

    List<Video> findAllByUserId(int userId);

    Video findByIdentifier(String identifier);

    List<Video> findByVideoNameLike(String videoName);

}
