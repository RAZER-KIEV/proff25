package home.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by RAZER on 2/18/2016.
 */

@Entity
@Component
public class MyEvent  implements Comparable<MyEvent>{
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "MyEvent_Seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "MyEvent_ID")
    Long eventId;
    Long networkId;
    Long resevers[];
    String message;
    Date publishDate;

    public MyEvent(String message) {
        this.message = message;
    }

    public MyEvent() {
    }

    public MyEvent(Long[] resevers, String message, Date date, Long networkId) {
        this.resevers = resevers;
        this.message = message;
        this.publishDate = date;
        this.networkId = networkId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long[] getResevers() {
        return resevers;
    }

    public void setResevers(Long[] resevers) {
        this.resevers = resevers;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Long getNetworkId() {
        return networkId;
    }

    public void setNetworkId(Long networkId) {
        this.networkId = networkId;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", networkId=" + networkId +
                ", resevers=" + Arrays.toString(resevers) +
                ", message='" + message + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }

    @Override
    public int compareTo(MyEvent o) {
        return o.getPublishDate().compareTo(getPublishDate());
    }
}
