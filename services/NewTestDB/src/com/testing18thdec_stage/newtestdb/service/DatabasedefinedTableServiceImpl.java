/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.newtestdb.service;

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

import com.testing18thdec_stage.newtestdb.DatabasedefinedTable;
import com.testing18thdec_stage.newtestdb.DatabasedefinedTableId;


/**
 * ServiceImpl object for domain model class DatabasedefinedTable.
 *
 * @see DatabasedefinedTable
 */
@Service("NewTestDB.DatabasedefinedTableService")
@Validated
@EntityService(entityClass = DatabasedefinedTable.class, serviceId = "NewTestDB")
public class DatabasedefinedTableServiceImpl implements DatabasedefinedTableService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabasedefinedTableServiceImpl.class);


    @Autowired
    @Qualifier("NewTestDB.DatabasedefinedTableDao")
    private WMGenericDao<DatabasedefinedTable, DatabasedefinedTableId> wmGenericDao;

    @Autowired
    @Qualifier("wmAppObjectMapper")
    private ObjectMapper objectMapper;


    public void setWMGenericDao(WMGenericDao<DatabasedefinedTable, DatabasedefinedTableId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "NewTestDBTransactionManager")
    @Override
    public DatabasedefinedTable create(DatabasedefinedTable databasedefinedTable) {
        LOGGER.debug("Creating a new DatabasedefinedTable with information: {}", databasedefinedTable);

        DatabasedefinedTable databasedefinedTableCreated = this.wmGenericDao.create(databasedefinedTable);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(databasedefinedTableCreated);
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager")
    @Override
    public DatabasedefinedTable getById(DatabasedefinedTableId databasedefinedtableId) {
        LOGGER.debug("Finding DatabasedefinedTable by id: {}", databasedefinedtableId);
        return this.wmGenericDao.findById(databasedefinedtableId);
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager")
    @Override
    public DatabasedefinedTable findById(DatabasedefinedTableId databasedefinedtableId) {
        LOGGER.debug("Finding DatabasedefinedTable by id: {}", databasedefinedtableId);
        try {
            return this.wmGenericDao.findById(databasedefinedtableId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No DatabasedefinedTable found with id: {}", databasedefinedtableId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager")
    @Override
    public List<DatabasedefinedTable> findByMultipleIds(List<DatabasedefinedTableId> databasedefinedtableIds, boolean orderedReturn) {
        LOGGER.debug("Finding DatabasedefinedTables by ids: {}", databasedefinedtableIds);

        return this.wmGenericDao.findByMultipleIds(databasedefinedtableIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "NewTestDBTransactionManager")
    @Override
    public DatabasedefinedTable update(DatabasedefinedTable databasedefinedTable) {
        LOGGER.debug("Updating DatabasedefinedTable with information: {}", databasedefinedTable);

        this.wmGenericDao.update(databasedefinedTable);
        this.wmGenericDao.refresh(databasedefinedTable);

        return databasedefinedTable;
    }

    @Transactional(value = "NewTestDBTransactionManager")
    @Override
    public DatabasedefinedTable partialUpdate(DatabasedefinedTableId databasedefinedtableId, Map<String, Object>databasedefinedTablePatch) {
        LOGGER.debug("Partially Updating the DatabasedefinedTable with id: {}", databasedefinedtableId);

        DatabasedefinedTable databasedefinedTable = getById(databasedefinedtableId);

        try {
            ObjectReader databasedefinedTableReader = this.objectMapper.reader().forType(DatabasedefinedTable.class).withValueToUpdate(databasedefinedTable);
            databasedefinedTable = databasedefinedTableReader.readValue(this.objectMapper.writeValueAsString(databasedefinedTablePatch));
        } catch (IOException ex) {
            LOGGER.debug("There was a problem in applying the patch: {}", databasedefinedTablePatch, ex);
            throw new InvalidInputException("Could not apply patch",ex);
        }

        databasedefinedTable = update(databasedefinedTable);

        return databasedefinedTable;
    }

    @Transactional(value = "NewTestDBTransactionManager")
    @Override
    public DatabasedefinedTable delete(DatabasedefinedTableId databasedefinedtableId) {
        LOGGER.debug("Deleting DatabasedefinedTable with id: {}", databasedefinedtableId);
        DatabasedefinedTable deleted = this.wmGenericDao.findById(databasedefinedtableId);
        if (deleted == null) {
            LOGGER.debug("No DatabasedefinedTable found with id: {}", databasedefinedtableId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), DatabasedefinedTable.class.getSimpleName(), databasedefinedtableId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "NewTestDBTransactionManager")
    @Override
    public void delete(DatabasedefinedTable databasedefinedTable) {
        LOGGER.debug("Deleting DatabasedefinedTable with {}", databasedefinedTable);
        this.wmGenericDao.delete(databasedefinedTable);
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager")
    @Override
    public Page<DatabasedefinedTable> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all DatabasedefinedTables");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager")
    @Override
    public Page<DatabasedefinedTable> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all DatabasedefinedTables");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service NewTestDB for table DatabasedefinedTable to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "NewTestDBTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service NewTestDB for table DatabasedefinedTable to {} format", options.getExportType());
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