package com.javatpoint.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class Ext_Engagement_Details {

    public Ext_Engagement_Details() {
    }

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long extEngagementId;

    @Column
    @JsonIgnore
    private long assetId;

    @Column
    private String extEngagementValues;

    @Column
    @JsonIgnore
    private Timestamp createdDate;

    @Column
    @JsonIgnore
    private Timestamp modifiedDate;

    public long getExtEngagementId() {
        return extEngagementId;
    }

    public void setExtEngagementId(long extEngagementId) {
        this.extEngagementId = extEngagementId;
    }

    public long getAssetId() {
        return assetId;
    }

    public void setAssetId(long assetId) {
        this.assetId = assetId;
    }

    public String getExtEngagementValues() {
        return extEngagementValues;
    }

    public void setExtEngagementValues(String extEngagementValues) {
        this.extEngagementValues = extEngagementValues;
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
