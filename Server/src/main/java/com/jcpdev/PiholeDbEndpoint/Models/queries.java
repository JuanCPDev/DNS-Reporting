package com.jcpdev.PiholeDbEndpoint.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class queries {

    @Column
    @Id
    private Integer id;
    @Column
    private String client;
    @Column
    private int status;
    @Column
    private String domain;


    public String getClient() {
        return client;
    }

    public Integer getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }

    public String getDomain() {
        return domain;
    }


}
