/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.wmstudio.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
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

import com.testing18thdec_stage.wmstudio.Many2oneCompChild;
import com.testing18thdec_stage.wmstudio.Many2oneCompChild2;
import com.testing18thdec_stage.wmstudio.Many2oneCompChildId;


/**
 * ServiceImpl object for domain model class Many2oneCompChild.
 *
 * @see Many2oneCompChild
 */
@Service("WMSTUDIO.Many2oneCompChildService")
@Validated
@EntityService(entityClass = Many2oneCompChild.class, serviceId = "WMSTUDIO")
public class Many2oneCompChildServiceImpl implements Many2oneCompChildService {

    private static final Logger LOGGER = LoggerFactory.getLogger(Many2oneCompChildServiceImpl.class);


    @Autowired
    @Qualifier("WMSTUDIO.Many2oneCompChildDao")
    private WMGenericDao<Many2oneCompChild, Many2oneCompChildId> wmGenericDao;

    @Autowired
    @Qualifier("wmAppObjectMapper")
    private ObjectMapper objectMapper;


    public void setWMGenericDao(WMGenericDao<Many2oneCompChild, Many2oneCompChildId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
    public Many2oneCompChild create(Many2oneCompChild many2oneCompChild) {
        LOGGER.debug("Creating a new Many2oneCompChild with information: {}", many2oneCompChild);

        Many2oneCompChild2 many2oneCompChild2 = many2oneCompChild.getMany2oneCompChild2();
        if(many2oneCompChild2 != null && Hibernate.isInitialized(many2oneCompChild2)) {
            many2oneCompChild2.setMany2oneCompChild(many2oneCompChild);
        }

        Many2oneCompChild many2oneCompChildCreated = this.wmGenericDao.create(many2oneCompChild);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(many2oneCompChildCreated);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Many2oneCompChild getById(Many2oneCompChildId many2onecompchildId) {
        LOGGER.debug("Finding Many2oneCompChild by id: {}", many2onecompchildId);
        return this.wmGenericDao.findById(many2onecompchildId);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Many2oneCompChild findById(Many2oneCompChildId many2onecompchildId) {
        LOGGER.debug("Finding Many2oneCompChild by id: {}", many2onecompchildId);
        try {
            return this.wmGenericDao.findById(many2onecompchildId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Many2oneCompChild found with id: {}", many2onecompchildId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public List<Many2oneCompChild> findByMultipleIds(List<Many2oneCompChildId> many2onecompchildIds, boolean orderedReturn) {
        LOGGER.debug("Finding Many2oneCompChilds by ids: {}", many2onecompchildIds);

        return this.wmGenericDao.findByMultipleIds(many2onecompchildIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
    @Override
    public Many2oneCompChild update(Many2oneCompChild many2oneCompChild) {
        LOGGER.debug("Updating Many2oneCompChild with information: {}", many2oneCompChild);

        Many2oneCompChild2 many2oneCompChild2 = many2oneCompChild.getMany2oneCompChild2();
        if(many2oneCompChild2 != null && Hibernate.isInitialized(many2oneCompChild2)) {
            many2oneCompChild2.setMany2oneCompChild(many2oneCompChild);
        }

        this.wmGenericDao.update(many2oneCompChild);
        this.wmGenericDao.refresh(many2oneCompChild);

        return many2oneCompChild;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
    public Many2oneCompChild partialUpdate(Many2oneCompChildId many2onecompchildId, Map<String, Object>many2oneCompChildPatch) {
        LOGGER.debug("Partially Updating the Many2oneCompChild with id: {}", many2onecompchildId);

        Many2oneCompChild many2oneCompChild = getById(many2onecompchildId);

        try {
            ObjectReader many2oneCompChildReader = this.objectMapper.reader().forType(Many2oneCompChild.class).withValueToUpdate(many2oneCompChild);
            many2oneCompChild = many2oneCompChildReader.readValue(this.objectMapper.writeValueAsString(many2oneCompChildPatch));
        } catch (IOException ex) {
            LOGGER.debug("There was a problem in applying the patch: {}", many2oneCompChildPatch, ex);
            throw new InvalidInputException("Could not apply patch",ex);
        }

        many2oneCompChild = update(many2oneCompChild);

        return many2oneCompChild;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
    public Many2oneCompChild delete(Many2oneCompChildId many2onecompchildId) {
        LOGGER.debug("Deleting Many2oneCompChild with id: {}", many2onecompchildId);
        Many2oneCompChild deleted = this.wmGenericDao.findById(many2onecompchildId);
        if (deleted == null) {
            LOGGER.debug("No Many2oneCompChild found with id: {}", many2onecompchildId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), Many2oneCompChild.class.getSimpleName(), many2onecompchildId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
    public void delete(Many2oneCompChild many2oneCompChild) {
        LOGGER.debug("Deleting Many2oneCompChild with {}", many2oneCompChild);
        this.wmGenericDao.delete(many2oneCompChild);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<Many2oneCompChild> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Many2oneCompChilds");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<Many2oneCompChild> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Many2oneCompChilds");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table Many2oneCompChild to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table Many2oneCompChild to {} format", options.getExportType());
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