package home.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by ПК on 03.12.2015.
 */
@Entity
@Component
public class PointGPS {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "PointGPS", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "PointGPS_ID")
    private Long id;
    private Long emplId;
    private Double latitude;
    private Double longitude;
    private LocalDateTime localDateTime;

    public PointGPS() {
    }

    public PointGPS(Long emplId, Double latitude, Double longitude, LocalDateTime localDateTime) {
        this.emplId = emplId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.localDateTime = localDateTime;
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

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "PointGPS{" +
                "id=" + id +
                ", emplId=" + emplId +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
