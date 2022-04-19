package com.javatpoint.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class Data_Entity_Details {

    public Data_Entity_Details() {
    }

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dataEntityId;

    @Column
    @JsonIgnore
    private long assetId;

    @Column
    private String dataEntityValues;

    @Column
    @JsonIgnore
    private Timestamp createdDate;

    @Column
    @JsonIgnore
    private Timestamp modifiedDate;

    public long getDataEntityId() {
        return dataEntityId;
    }

    public void setDataEntityId(long dataEntityId) {
        this.dataEntityId = dataEntityId;
    }

    public long getAssetId() {
        return assetId;
    }

    public void setAssetId(long assetId) {
        this.assetId = assetId;
    }

    public String getDataEntityValues() {
        return dataEntityValues;
    }

    public void setDataEntityValues(String dataEntityValues) {
        this.dataEntityValues = dataEntityValues;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
