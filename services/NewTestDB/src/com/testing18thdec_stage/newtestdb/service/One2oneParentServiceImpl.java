/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.newtestdb.service;

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

import com.testing18thdec_stage.newtestdb.One2oneChild;
import com.testing18thdec_stage.newtestdb.One2oneParent;


/**
 * ServiceImpl object for domain model class One2oneParent.
 *
 * @see One2oneParent
 */
@Service("NewTestDB.One2oneParentService")
@Validated
@EntityService(entityClass = One2oneParent.class, serviceId = "NewTestDB")
public class One2oneParentServiceImpl implements One2oneParentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(One2oneParentServiceImpl.class);


    @Autowired
    @Qualifier("NewTestDB.One2oneParentDao")
    private WMGenericDao<One2oneParent, Short> wmGenericDao;

    @Autowired
    @Qualifier("wmAppObjectMapper")
    private ObjectMapper objectMapper;


    public void setWMGenericDao(WMGenericDao<One2oneParent, Short> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "NewTestDBTransactionManager")
    @Override
    public One2oneParent create(One2oneParent one2oneParent) {
        LOGGER.debug("Creating a new One2oneParent with information: {}", one2oneParent);

        One2oneParent one2oneParentCreated = this.wmGenericDao.create(one2oneParent);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(one2oneParentCreated);
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager")
    @Override
    public One2oneParent getById(Short one2oneparentId) {
        LOGGER.debug("Finding One2oneParent by id: {}", one2oneparentId);
        return this.wmGenericDao.findById(one2oneparentId);
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager")
    @Override
    public One2oneParent findById(Short one2oneparentId) {
        LOGGER.debug("Finding One2oneParent by id: {}", one2oneparentId);
        try {
            return this.wmGenericDao.findById(one2oneparentId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No One2oneParent found with id: {}", one2oneparentId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager")
    @Override
    public List<One2oneParent> findByMultipleIds(List<Short> one2oneparentIds, boolean orderedReturn) {
        LOGGER.debug("Finding One2oneParents by ids: {}", one2oneparentIds);

        return this.wmGenericDao.findByMultipleIds(one2oneparentIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "NewTestDBTransactionManager")
    @Override
    public One2oneParent update(One2oneParent one2oneParent) {
        LOGGER.debug("Updating One2oneParent with information: {}", one2oneParent);

        One2oneChild one2oneChild = one2oneParent.getOne2oneChild();
        if(one2oneChild != null && Hibernate.isInitialized(one2oneChild)) {
            one2oneChild.setOne2oneParent(one2oneParent);
        }

        this.wmGenericDao.update(one2oneParent);
        this.wmGenericDao.refresh(one2oneParent);

        return one2oneParent;
    }

    @Transactional(value = "NewTestDBTransactionManager")
    @Override
    public One2oneParent partialUpdate(Short one2oneparentId, Map<String, Object>one2oneParentPatch) {
        LOGGER.debug("Partially Updating the One2oneParent with id: {}", one2oneparentId);

        One2oneParent one2oneParent = getById(one2oneparentId);

        try {
            ObjectReader one2oneParentReader = this.objectMapper.reader().forType(One2oneParent.class).withValueToUpdate(one2oneParent);
            one2oneParent = one2oneParentReader.readValue(this.objectMapper.writeValueAsString(one2oneParentPatch));
        } catch (IOException ex) {
            LOGGER.debug("There was a problem in applying the patch: {}", one2oneParentPatch, ex);
            throw new InvalidInputException("Could not apply patch",ex);
        }

        one2oneParent = update(one2oneParent);

        return one2oneParent;
    }

    @Transactional(value = "NewTestDBTransactionManager")
    @Override
    public One2oneParent delete(Short one2oneparentId) {
        LOGGER.debug("Deleting One2oneParent with id: {}", one2oneparentId);
        One2oneParent deleted = this.wmGenericDao.findById(one2oneparentId);
        if (deleted == null) {
            LOGGER.debug("No One2oneParent found with id: {}", one2oneparentId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), One2oneParent.class.getSimpleName(), one2oneparentId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "NewTestDBTransactionManager")
    @Override
    public void delete(One2oneParent one2oneParent) {
        LOGGER.debug("Deleting One2oneParent with {}", one2oneParent);
        this.wmGenericDao.delete(one2oneParent);
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager")
    @Override
    public Page<One2oneParent> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all One2oneParents");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager")
    @Override
    public Page<One2oneParent> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all One2oneParents");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service NewTestDB for table One2oneParent to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service NewTestDB for table One2oneParent to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}