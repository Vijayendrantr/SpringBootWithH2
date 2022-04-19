package com.javatpoint.controller;

import com.javatpoint.model.Data_Entity_Details;
import com.javatpoint.model.Data_Store_Details;
import com.javatpoint.model.Dm_Config;
import com.javatpoint.model.Ext_Engagement_Details;
import com.javatpoint.repository.DataManagerRepository;
import com.javatpoint.service.DataManagerService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.persistence.Basic;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


@ExtendWith(MockitoExtension.class)
//@WebMvcTest(DataManagerController.class)
public class DataManagerControllerTest {

    @Mock
    private DataManagerService dataManagerService;

    @Mock
    private DataManagerRepository dataManagerRepository;

    @InjectMocks
    private DataManagerController dataManagerController;


    private MockMvc mockMvc;

    List<Data_Store_Details> storeDetailsList = new ArrayList<Data_Store_Details>();
    List<Data_Entity_Details> entityDetailsList = new ArrayList<>();
    List<Ext_Engagement_Details> extEngagementDetailsList = new ArrayList<>();
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    @Before
    public void setup() {

    }


    @Test
    public void testGetByAssetId() throws Exception {

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

        Mockito.when(dataManagerService.getAssetById(111)).thenReturn(dmConfig);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/v3/resources/worker/getAssetById/111")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(200, status);
        System.out.println(result.getResponse());
    }
}
