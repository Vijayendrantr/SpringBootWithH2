package com.javatpoint.service;

import com.javatpoint.model.Dm_Config;
import com.javatpoint.repository.DataManagerRepository;
import com.javatpoint.repository.DataStoreDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataManagerService {

  public static final String FIND_ASSETS =
      "SELECT dm.assetId, dm.dmChecked, dm.dmInternalChecked, dm.dmExternalChecked, dm.e2ePreprodEnabled, dm.prodEnabled" +
              "dm.createdDate, dm.modifiedDate, dsd.dataStoreId, dsd.dataStoreValues FROM DM_Config dm ,Data_Store_Details dsd";

  @Autowired DataManagerRepository dataManagerRepository;

  @Autowired DataStoreDetailsRepository dataStoreDetailsRepository;

  public void saveOrUpdate(Dm_Config dmConfig) {
    dataManagerRepository.save(dmConfig);
  }

  @Query(value = FIND_ASSETS, nativeQuery = true)
  public List<Dm_Config> getAllAssets() {
    List<Dm_Config> dmConfig = new ArrayList<>();
    dataManagerRepository.findAll().forEach(config -> dmConfig.add(config));
    return dmConfig;
  }

  public Dm_Config getAssetById(int assetId) {
    return dataManagerRepository.findById((long) assetId).get();
  }
}
