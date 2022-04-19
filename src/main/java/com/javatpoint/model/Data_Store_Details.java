package com.javatpoint.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class Data_Store_Details {

    public Data_Store_Details() {
    }

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dataStoreId;

    @Column
    @JsonIgnore
    private long assetId;

    @Column
    private String dataStoreValues;

    @Column
    @JsonIgnore
    private Timestamp createdDate;

    @Column
    @JsonIgnore
    private Timestamp modifiedDate;

    public long getDataStoreId() {
        return dataStoreId;
    }

    public void setDataStoreId(long dataStoreId) {
        this.dataStoreId = dataStoreId;
    }

    public long getAssetId() {
        return assetId;
    }

    public void setAssetId(long assetId) {
        this.assetId = assetId;
    }

    public String getDataStoreValues() {
        return dataStoreValues;
    }

    public void setDataStoreValues(String dataStoreValues) {
        this.dataStoreValues = dataStoreValues;
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
