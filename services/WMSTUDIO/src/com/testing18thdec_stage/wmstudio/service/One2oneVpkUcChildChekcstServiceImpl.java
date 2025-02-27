/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.wmstudio.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.wavemaker.commons.InvalidInputException;
import com.wavemaker.commons.MessageResource;
import com.wavemaker.runtime.data.annotations.EntityService;
import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testing18thdec_stage.wmstudio.One2oneVpkUcChildChekcst;
import com.testing18thdec_stage.wmstudio.One2oneVpkUcChildChekcstId;


/**
 * ServiceImpl object for domain model class One2oneVpkUcChildChekcst.
 *
 * @see One2oneVpkUcChildChekcst
 */
@Service("WMSTUDIO.One2oneVpkUcChildChekcstService")
@Validated
@EntityService(entityClass = One2oneVpkUcChildChekcst.class, serviceId = "WMSTUDIO")
public class One2oneVpkUcChildChekcstServiceImpl implements One2oneVpkUcChildChekcstService {

    private static final Logger LOGGER = LoggerFactory.getLogger(One2oneVpkUcChildChekcstServiceImpl.class);


    @Autowired
    @Qualifier("WMSTUDIO.One2oneVpkUcChildChekcstDao")
    private WMGenericDao<One2oneVpkUcChildChekcst, One2oneVpkUcChildChekcstId> wmGenericDao;

    @Autowired
    @Qualifier("wmAppObjectMapper")
    private ObjectMapper objectMapper;


    public void setWMGenericDao(WMGenericDao<One2oneVpkUcChildChekcst, One2oneVpkUcChildChekcstId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
    public One2oneVpkUcChildChekcst create(One2oneVpkUcChildChekcst one2oneVpkUcChildChekcst) {
        LOGGER.debug("Creating a new One2oneVpkUcChildChekcst with information: {}", one2oneVpkUcChildChekcst);

        One2oneVpkUcChildChekcst one2oneVpkUcChildChekcstCreated = this.wmGenericDao.create(one2oneVpkUcChildChekcst);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(one2oneVpkUcChildChekcstCreated);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public One2oneVpkUcChildChekcst getById(One2oneVpkUcChildChekcstId one2onevpkucchildchekcstId) {
        LOGGER.debug("Finding One2oneVpkUcChildChekcst by id: {}", one2onevpkucchildchekcstId);
        return this.wmGenericDao.findById(one2onevpkucchildchekcstId);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public One2oneVpkUcChildChekcst findById(One2oneVpkUcChildChekcstId one2onevpkucchildchekcstId) {
        LOGGER.debug("Finding One2oneVpkUcChildChekcst by id: {}", one2onevpkucchildchekcstId);
        try {
            return this.wmGenericDao.findById(one2onevpkucchildchekcstId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No One2oneVpkUcChildChekcst found with id: {}", one2onevpkucchildchekcstId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public List<One2oneVpkUcChildChekcst> findByMultipleIds(List<One2oneVpkUcChildChekcstId> one2onevpkucchildchekcstIds, boolean orderedReturn) {
        LOGGER.debug("Finding One2oneVpkUcChildChekcsts by ids: {}", one2onevpkucchildchekcstIds);

        return this.wmGenericDao.findByMultipleIds(one2onevpkucchildchekcstIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
    @Override
    public One2oneVpkUcChildChekcst update(One2oneVpkUcChildChekcst one2oneVpkUcChildChekcst) {
        LOGGER.debug("Updating One2oneVpkUcChildChekcst with information: {}", one2oneVpkUcChildChekcst);

        this.wmGenericDao.update(one2oneVpkUcChildChekcst);
        this.wmGenericDao.refresh(one2oneVpkUcChildChekcst);

        return one2oneVpkUcChildChekcst;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
    public One2oneVpkUcChildChekcst partialUpdate(One2oneVpkUcChildChekcstId one2onevpkucchildchekcstId, Map<String, Object>one2oneVpkUcChildChekcstPatch) {
        LOGGER.debug("Partially Updating the One2oneVpkUcChildChekcst with id: {}", one2onevpkucchildchekcstId);

        One2oneVpkUcChildChekcst one2oneVpkUcChildChekcst = getById(one2onevpkucchildchekcstId);

        try {
            ObjectReader one2oneVpkUcChildChekcstReader = this.objectMapper.reader().forType(One2oneVpkUcChildChekcst.class).withValueToUpdate(one2oneVpkUcChildChekcst);
            one2oneVpkUcChildChekcst = one2oneVpkUcChildChekcstReader.readValue(this.objectMapper.writeValueAsString(one2oneVpkUcChildChekcstPatch));
        } catch (IOException ex) {
            LOGGER.debug("There was a problem in applying the patch: {}", one2oneVpkUcChildChekcstPatch, ex);
            throw new InvalidInputException("Could not apply patch",ex);
        }

        one2oneVpkUcChildChekcst = update(one2oneVpkUcChildChekcst);

        return one2oneVpkUcChildChekcst;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
    public One2oneVpkUcChildChekcst delete(One2oneVpkUcChildChekcstId one2onevpkucchildchekcstId) {
        LOGGER.debug("Deleting One2oneVpkUcChildChekcst with id: {}", one2onevpkucchildchekcstId);
        One2oneVpkUcChildChekcst deleted = this.wmGenericDao.findById(one2onevpkucchildchekcstId);
        if (deleted == null) {
            LOGGER.debug("No One2oneVpkUcChildChekcst found with id: {}", one2onevpkucchildchekcstId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), One2oneVpkUcChildChekcst.class.getSimpleName(), one2onevpkucchildchekcstId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
    public void delete(One2oneVpkUcChildChekcst one2oneVpkUcChildChekcst) {
        LOGGER.debug("Deleting One2oneVpkUcChildChekcst with {}", one2oneVpkUcChildChekcst);
        this.wmGenericDao.delete(one2oneVpkUcChildChekcst);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<One2oneVpkUcChildChekcst> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all One2oneVpkUcChildChekcsts");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<One2oneVpkUcChildChekcst> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all One2oneVpkUcChildChekcsts");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table One2oneVpkUcChildChekcst to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table One2oneVpkUcChildChekcst to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}