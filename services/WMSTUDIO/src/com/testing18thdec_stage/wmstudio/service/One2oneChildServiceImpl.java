/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.wmstudio.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testing18thdec_stage.wmstudio.One2oneChild;
import com.testing18thdec_stage.wmstudio.One2oneUcChild;


/**
 * ServiceImpl object for domain model class One2oneChild.
 *
 * @see One2oneChild
 */
@Service("WMSTUDIO.One2oneChildService")
@Validated
public class One2oneChildServiceImpl implements One2oneChildService {

    private static final Logger LOGGER = LoggerFactory.getLogger(One2oneChildServiceImpl.class);

    @Lazy
    @Autowired
	@Qualifier("WMSTUDIO.One2oneUcChildService")
	private One2oneUcChildService one2oneUcChildService;

    @Autowired
    @Qualifier("WMSTUDIO.One2oneChildDao")
    private WMGenericDao<One2oneChild, Byte> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<One2oneChild, Byte> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
	public One2oneChild create(One2oneChild one2oneChild) {
        LOGGER.debug("Creating a new One2oneChild with information: {}", one2oneChild);
        One2oneUcChild one2oneUcChild = one2oneChild.getOne2oneUcChild();

        One2oneChild one2oneChildCreated = this.wmGenericDao.create(one2oneChild);
        if(one2oneUcChild != null) {
            LOGGER.debug("Creating a new child One2oneUcChild with information: {}", one2oneUcChild);
            one2oneUcChild.setOne2oneChild(one2oneChildCreated);
            one2oneUcChildService.create(one2oneUcChild);
        }
        return one2oneChildCreated;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public One2oneChild getById(Byte one2onechildId) throws EntityNotFoundException {
        LOGGER.debug("Finding One2oneChild by id: {}", one2onechildId);
        One2oneChild one2oneChild = this.wmGenericDao.findById(one2onechildId);
        if (one2oneChild == null){
            LOGGER.debug("No One2oneChild found with id: {}", one2onechildId);
            throw new EntityNotFoundException(String.valueOf(one2onechildId));
        }
        return one2oneChild;
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public One2oneChild findById(Byte one2onechildId) {
        LOGGER.debug("Finding One2oneChild by id: {}", one2onechildId);
        return this.wmGenericDao.findById(one2onechildId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
	@Override
	public One2oneChild update(One2oneChild one2oneChild) throws EntityNotFoundException {
        LOGGER.debug("Updating One2oneChild with information: {}", one2oneChild);
        this.wmGenericDao.update(one2oneChild);

        Byte one2onechildId = one2oneChild.getBytePk();

        return this.wmGenericDao.findById(one2onechildId);
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
	@Override
	public One2oneChild delete(Byte one2onechildId) throws EntityNotFoundException {
        LOGGER.debug("Deleting One2oneChild with id: {}", one2onechildId);
        One2oneChild deleted = this.wmGenericDao.findById(one2onechildId);
        if (deleted == null) {
            LOGGER.debug("No One2oneChild found with id: {}", one2onechildId);
            throw new EntityNotFoundException(String.valueOf(one2onechildId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Page<One2oneChild> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all One2oneChilds");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<One2oneChild> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all One2oneChilds");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table One2oneChild to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
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


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service One2oneUcChildService instance
	 */
	protected void setOne2oneUcChildService(One2oneUcChildService service) {
        this.one2oneUcChildService = service;
    }

}

