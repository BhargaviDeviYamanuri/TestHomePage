package sample.map.com.homepage;


public class VideosDTO {
    private String videosTitle, videosTime, videosDecs;
    private int videoImage;

    public VideosDTO(String videosTitle, String videosTime, String videosDecs, int videoImage) {
        this.videosTitle = videosTitle;
        this.videosTime = videosTime;
        this.videosDecs = videosDecs;
        this.videoImage = videoImage;
    }

    public String getVideosTitle() {
        return videosTitle;
    }

    public void setVideosTitle(String videosTitle) {
        this.videosTitle = videosTitle;
    }

    public String getVideosTime() {
        return videosTime;
    }

    public void setVideosTime(String videosTime) {
        this.videosTime = videosTime;
    }

    public String getVideosDecs() {
        return videosDecs;
    }

    public void setVideosDecs(String videosDecs) {
        this.videosDecs = videosDecs;
    }

    public int getVideoImage() {
        return videoImage;
    }

    public void setVideoImage(int videoImage) {
        this.videoImage = videoImage;
    }
}

