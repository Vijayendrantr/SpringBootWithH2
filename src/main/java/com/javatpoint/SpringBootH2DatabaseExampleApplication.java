package com.javatpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.javatpoint.model.*;
import com.javatpoint.repository.DataManagerRepository;
import com.javatpoint.repository.DataStoreDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootH2DatabaseExampleApplication implements  CommandLineRunner {
  public static void main(String[] args) {
    SpringApplication.run(SpringBootH2DatabaseExampleApplication.class, args);
  }

  @Autowired DataManagerRepository dataManagerRepository;
  @Autowired DataStoreDetailsRepository dataStoreDetailsRepository;

  @Override
  public void run(String[] args) throws Exception {

    List<Data_Store_Details> storeDetailsList = new ArrayList<Data_Store_Details>();
    List<Data_Entity_Details> entityDetailsList = new ArrayList<>();
    List<Ext_Engagement_Details> extEngagementDetailsList = new ArrayList<>();
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    Dm_Config dmConfig = new Dm_Config();
    dmConfig.setAssetId(111);
    dmConfig.setDmChecked(true);
    dmConfig.setDmInternalChecked(true);
    dmConfig.setDmExternalChecked(false);
    dmConfig.setE2ePreprodEnabled(true);
    dmConfig.setProdEnabled(false);
    dmConfig.setCreatedDate(timestamp);
    dmConfig.setModifiedDate(timestamp);

    Data_Store_Details dataStoreDetails1 = new Data_Store_Details();
    dataStoreDetails1.setAssetId(111);
    dataStoreDetails1.setDataStoreId(111);
    dataStoreDetails1.setDataStoreValues("test");
    dataStoreDetails1.setCreatedDate(timestamp);
    dataStoreDetails1.setModifiedDate(timestamp);

    Data_Store_Details dataStoreDetails2 = new Data_Store_Details();
    dataStoreDetails2.setAssetId(111);
    dataStoreDetails2.setDataStoreId(222);
    dataStoreDetails2.setDataStoreValues("demo");
    dataStoreDetails2.setCreatedDate(timestamp);
    dataStoreDetails2.setModifiedDate(timestamp);

    storeDetailsList.add(dataStoreDetails1);
    storeDetailsList.add(dataStoreDetails2);
    dmConfig.setDataStoreDetails(storeDetailsList);

    Data_Entity_Details data_entity_details = new Data_Entity_Details();
    data_entity_details.setAssetId(111);
    data_entity_details.setDataEntityId(111);
    data_entity_details.setDataEntityValues("entity_test");
    data_entity_details.setCreatedDate(timestamp);
    data_entity_details.setModifiedDate(timestamp);

    entityDetailsList.add(data_entity_details);
    dmConfig.setData_entity_details(entityDetailsList);

    Ext_Engagement_Details ext_engagement_details = new Ext_Engagement_Details();
    ext_engagement_details.setAssetId(111);
    ext_engagement_details.setExtEngagementId(111);
    ext_engagement_details.setExtEngagementValues("engagement_test");
    ext_engagement_details.setCreatedDate(timestamp);
    ext_engagement_details.setModifiedDate(timestamp);

    extEngagementDetailsList.add(ext_engagement_details);
    dmConfig.setExt_engagement_details(extEngagementDetailsList);

    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    String json = ow.writeValueAsString(dmConfig);
    System.out.println("JSON String : " + json);
    System.out.println("Data Manager Config Details : " + dmConfig.toString());

     this.dataManagerRepository.save(dmConfig);
  }
}
