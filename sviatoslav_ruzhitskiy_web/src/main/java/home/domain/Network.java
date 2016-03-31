package home.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Created by RAZER on 2/6/2016.
 */

@Component
@Entity
public class Network {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "Network_Seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long networkId;
    private String name;
    private Long[] owners;
    private Long[] employees;
    private Long[] friendlyNetworks;
    private String contacts;
    private Long[] offices;

    public Network() {}

    public Network(String name, Long[] owners) {
        this.name = name;
        this.owners = owners;
    }

    public Network(String name, Long[] owners, Long[] employees, Long[] friendlyNetworks, String contacts, Long[] offices) {
        this.name = name;
        this.owners = owners;
        this.employees = employees;
        this.friendlyNetworks = friendlyNetworks;
        this.contacts = contacts;
        this.offices = offices;
    }

    public Long getNetworkId() {
        return networkId;
    }

    public void setNetworkId(Long networkId) {
        this.networkId = networkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long[] getOwners() {
        return owners;
    }

    public void setOwners(Long[] owners) {
        this.owners = owners;
    }

    public Long[] getEmployees() {
        return employees;
    }

    public void setEmployees(Long[] employees) {
        this.employees = employees;
    }

    public Long[] getFriendlyNetworks() {
        return friendlyNetworks;
    }

    public void setFriendlyNetworks(Long[] friendlyNetworks) {
        this.friendlyNetworks = friendlyNetworks;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public Long[] getOffices() {
        return offices;
    }

    public void setOffices(Long[] offices) {
        this.offices = offices;
    }

    @Override
    public String toString() {
        return "Network{" +
                "networkId=" + networkId +
                ", name='" + name + '\'' +
                ", owners=" + Arrays.toString(owners) +
                ", employees=" + Arrays.toString(employees) +
                ", friendlyNetworks=" + Arrays.toString(friendlyNetworks) +
                ", contacts='" + contacts + '\'' +
                ", offices=" + Arrays.toString(offices) +
                '}';
    }
}
