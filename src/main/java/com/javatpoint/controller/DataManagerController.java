package com.javatpoint.controller;

import com.javatpoint.model.Data_Entity_Details;
import com.javatpoint.model.Data_Store_Details;
import com.javatpoint.model.Dm_Config;
import com.javatpoint.model.Ext_Engagement_Details;
import com.javatpoint.service.DataManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DataManagerController {

  @Autowired DataManagerService dataManagerService;

  @Autowired EntityManager entityManager;

  @PostMapping("/v3/resources/worker/saveDMConfigDetails")
  private ResponseEntity saveDataManagerConfigDetails(@RequestBody Dm_Config dmConfig) {
    System.out.println("Inside the saveDataManagerConfigDetails method");
    List<Data_Store_Details> storeDetailsList = new ArrayList<>();
    List<Data_Entity_Details> entityDetailsList = new ArrayList<>();
    List<Ext_Engagement_Details> extEngagementDetailsList = new ArrayList<>();
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    if (dmConfig.getDataStoreDetails().size() != 0) {
      for (Data_Store_Details store_details : dmConfig.getDataStoreDetails()) {
        long asset_id = dmConfig.getAssetId();
        store_details.setAssetId(asset_id);
        store_details.setCreatedDate(timestamp);
        store_details.setModifiedDate(timestamp);
        storeDetailsList.add(store_details);
        dmConfig.setDataStoreDetails(storeDetailsList);
      }
    }

    if (dmConfig.getData_entity_details().size() != 0) {
      for (Data_Entity_Details entity_details : dmConfig.getData_entity_details()) {
        long asset_id = dmConfig.getAssetId();
        entity_details.setAssetId(asset_id);
        entity_details.setCreatedDate(timestamp);
        entity_details.setModifiedDate(timestamp);
        entityDetailsList.add(entity_details);
        dmConfig.setData_entity_details(entityDetailsList);
      }
    }

    if (dmConfig.getExt_engagement_details().size() != 0) {
      for (Ext_Engagement_Details ext_engagement_details : dmConfig.getExt_engagement_details()) {
        long asset_id = dmConfig.getAssetId();
        ext_engagement_details.setAssetId(asset_id);
        ext_engagement_details.setCreatedDate(timestamp);
        ext_engagement_details.setModifiedDate(timestamp);
        extEngagementDetailsList.add(ext_engagement_details);
        dmConfig.setExt_engagement_details(extEngagementDetailsList);
      }
    }
    dataManagerService.saveOrUpdate(dmConfig);
    return new ResponseEntity<>("Success", HttpStatus.OK);
  }

  @GetMapping("/v3/resources/worker/getAssetDetails")
  private List<Dm_Config> getAllAssets() {
    return dataManagerService.getAllAssets();
  }

  private List<Dm_Config> usingCriteriaBuilder() {

    // Create the criteria builder and the criteria.
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery query = builder.createQuery();
    Root<Dm_Config> root = query.from(Dm_Config.class);
    root.fetch("dataStoreDetails");
    // Join<Dm_Config, Data_Store_Details> storeDetailsJoin = root.join("dataStoreDetails");
    // storeDetailsJoin.on(builder.equal(root.get("assetId"), storeDetailsJoin.get("Dm_Config")));
    // query.multiselect(storeDetailsJoin);
    query.select(root);
    List<Dm_Config> resultList = entityManager.createQuery(query).getResultList();
    return resultList;
  }

  @GetMapping("/v3/resources/worker/getAssetById/{assetId}")
  private Dm_Config getAsset(@PathVariable("assetId") int assetId) {
    return dataManagerService.getAssetById(assetId);
  }
}
