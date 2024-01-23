package Audintel.dao;

import jakarta.persistence.*;
@Entity
public class Airport {

    @Id
    @Column(name = "port_id")
    private int portId;

    @Column(name = "port_name", length = 60)
    private String portName;

    @Column(name = "port_city", length = 40)
    private String portCity;

    public int getPortId() {
        return portId;
    }

    public void setPortId(int portId) {
        this.portId = portId;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getPortCity() {
        return portCity;
    }

    public void setPortCity(String portCity) {
        this.portCity = portCity;
    }
}
