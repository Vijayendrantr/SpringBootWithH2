package com.javatpoint.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Dm_Config {

  public Dm_Config() {}

  @Id @Column private long assetId;

  @Column private boolean dmChecked;

  @Column private boolean dmInternalChecked;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "fk_assetId", referencedColumnName = "assetId")
  List<Data_Store_Details> dataStoreDetails = new ArrayList<Data_Store_Details>();

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "fk_assetId", referencedColumnName = "assetId")
  List<Data_Entity_Details> data_entity_details = new ArrayList<Data_Entity_Details>();

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "fk_assetId", referencedColumnName = "assetId")
  List<Ext_Engagement_Details> ext_engagement_details = new ArrayList<Ext_Engagement_Details>();

  @Column private boolean dmExternalChecked;

  @Column private boolean e2ePreprodEnabled;

  @Column private boolean prodEnabled;

  @Column private Timestamp createdDate;

  @Column private Timestamp modifiedDate;

  public long getAssetId() {
    return assetId;
  }

  public void setAssetId(long assetId) {
    this.assetId = assetId;
  }

  public boolean isDmChecked() {
    return dmChecked;
  }

  public void setDmChecked(boolean dmChecked) {
    this.dmChecked = dmChecked;
  }

  public boolean isDmInternalChecked() {
    return dmInternalChecked;
  }

  public void setDmInternalChecked(boolean dmInternalChecked) {
    this.dmInternalChecked = dmInternalChecked;
  }

  public List<Data_Store_Details> getDataStoreDetails() {
    return dataStoreDetails;
  }

  public void setDataStoreDetails(List<Data_Store_Details> dataStoreDetails) {
    this.dataStoreDetails = dataStoreDetails;
  }

  public List<Data_Entity_Details> getData_entity_details() {
    return data_entity_details;
  }

  public void setData_entity_details(List<Data_Entity_Details> data_entity_details) {
    this.data_entity_details = data_entity_details;
  }

  public List<Ext_Engagement_Details> getExt_engagement_details() {
    return ext_engagement_details;
  }

  public void setExt_engagement_details(List<Ext_Engagement_Details> ext_engagement_details) {
    this.ext_engagement_details = ext_engagement_details;
  }

  public boolean isDmExternalChecked() {
    return dmExternalChecked;
  }

  public void setDmExternalChecked(boolean dmExternalChecked) {
    this.dmExternalChecked = dmExternalChecked;
  }

  public boolean isE2ePreprodEnabled() {
    return e2ePreprodEnabled;
  }

  public void setE2ePreprodEnabled(boolean e2ePreprodEnabled) {
    this.e2ePreprodEnabled = e2ePreprodEnabled;
  }

  public boolean isProdEnabled() {
    return prodEnabled;
  }

  public void setProdEnabled(boolean prodEnabled) {
    this.prodEnabled = prodEnabled;
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

  @Override
  public String toString() {
    return "Dm_Config{"
        + "assetId="
        + assetId
        + ", dmChecked="
        + dmChecked
        + ", dmInternalChecked="
        + dmInternalChecked
        + ", dataStoreDetails="
        + dataStoreDetails
        + ", data_entity_details="
        + data_entity_details
        + ", ext_engagement_details="
        + ext_engagement_details
        + ", dmExternalChecked="
        + dmExternalChecked
        + ", e2ePreprodEnabled="
        + e2ePreprodEnabled
        + ", prodEnabled="
        + prodEnabled
        + ", createdDate="
        + createdDate
        + ", modifiedDate="
        + modifiedDate
        + '}';
  }
}
