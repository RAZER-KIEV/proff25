package home.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ПК on 03.12.2015.
 */
@Entity
@Component
public class PointGPS {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "PointGPS_Seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "PointGPS_ID")
    private Long id;
    private Long emplId;
    private String title;
    private Double latitude;
    private Double longitude;
    private Date dateTime;

    public PointGPS() {
    }

    public PointGPS(Double longitude, Double latitude, Long emplId) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.emplId = emplId;
        dateTime = new Date();
        title ="new Point";

    }

    public PointGPS(Long emplId, String title, Double latitude, Double longitude) {
        this.emplId = emplId;
        this.title = title;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dateTime =new Date();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmplId() {
        return emplId;
    }

    public void setEmplId(Long emplId) {
        this.emplId = emplId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Date getDate() {
        return dateTime;
    }

    public void setDate(Date date) {
        this.dateTime = date;
    }

    @Override
    public String toString() {
        return "PointGPS{" +
                "id=" + id +
                ", emplId=" + emplId +
                ", title='" + title + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", publishDate=" + dateTime +
                '}';
    }
}
