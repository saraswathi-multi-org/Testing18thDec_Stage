/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.wmstudio.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.List;
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

import com.testing18thdec_stage.wmstudio.Many2oneCompChild;
import com.testing18thdec_stage.wmstudio.Many2oneCompParent;
import com.testing18thdec_stage.wmstudio.Many2oneCompParentId;


/**
 * ServiceImpl object for domain model class Many2oneCompParent.
 *
 * @see Many2oneCompParent
 */
@Service("WMSTUDIO.Many2oneCompParentService")
@Validated
public class Many2oneCompParentServiceImpl implements Many2oneCompParentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(Many2oneCompParentServiceImpl.class);

    @Lazy
    @Autowired
	@Qualifier("WMSTUDIO.Many2oneCompChildService")
	private Many2oneCompChildService many2oneCompChildService;

    @Autowired
    @Qualifier("WMSTUDIO.Many2oneCompParentDao")
    private WMGenericDao<Many2oneCompParent, Many2oneCompParentId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Many2oneCompParent, Many2oneCompParentId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
	public Many2oneCompParent create(Many2oneCompParent many2oneCompParent) {
        LOGGER.debug("Creating a new Many2oneCompParent with information: {}", many2oneCompParent);
        List<Many2oneCompChild> many2oneCompChilds = many2oneCompParent.getMany2oneCompChilds();

        Many2oneCompParent many2oneCompParentCreated = this.wmGenericDao.create(many2oneCompParent);
        if(many2oneCompChilds != null) {
            for(Many2oneCompChild _many2oneCompChild : many2oneCompChilds) {
                _many2oneCompChild.setMany2oneCompParent(many2oneCompParentCreated);
                LOGGER.debug("Creating a new child Many2oneCompChild with information: {}", _many2oneCompChild);
                many2oneCompChildService.create(_many2oneCompChild);
            }
        }
        return many2oneCompParentCreated;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Many2oneCompParent getById(Many2oneCompParentId many2onecompparentId) throws EntityNotFoundException {
        LOGGER.debug("Finding Many2oneCompParent by id: {}", many2onecompparentId);
        Many2oneCompParent many2oneCompParent = this.wmGenericDao.findById(many2onecompparentId);
        if (many2oneCompParent == null){
            LOGGER.debug("No Many2oneCompParent found with id: {}", many2onecompparentId);
            throw new EntityNotFoundException(String.valueOf(many2onecompparentId));
        }
        return many2oneCompParent;
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Many2oneCompParent findById(Many2oneCompParentId many2onecompparentId) {
        LOGGER.debug("Finding Many2oneCompParent by id: {}", many2onecompparentId);
        return this.wmGenericDao.findById(many2onecompparentId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
	@Override
	public Many2oneCompParent update(Many2oneCompParent many2oneCompParent) throws EntityNotFoundException {
        LOGGER.debug("Updating Many2oneCompParent with information: {}", many2oneCompParent);
        this.wmGenericDao.update(many2oneCompParent);

        Many2oneCompParentId many2onecompparentId = new Many2oneCompParentId();
        many2onecompparentId.setByteId(many2oneCompParent.getByteId());
        many2onecompparentId.setStringId(many2oneCompParent.getStringId());
        many2onecompparentId.setCharId(many2oneCompParent.getCharId());
        many2onecompparentId.setFloatId(many2oneCompParent.getFloatId());

        return this.wmGenericDao.findById(many2onecompparentId);
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
	@Override
	public Many2oneCompParent delete(Many2oneCompParentId many2onecompparentId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Many2oneCompParent with id: {}", many2onecompparentId);
        Many2oneCompParent deleted = this.wmGenericDao.findById(many2onecompparentId);
        if (deleted == null) {
            LOGGER.debug("No Many2oneCompParent found with id: {}", many2onecompparentId);
            throw new EntityNotFoundException(String.valueOf(many2onecompparentId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Page<Many2oneCompParent> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Many2oneCompParents");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<Many2oneCompParent> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Many2oneCompParents");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table Many2oneCompParent to {} format", exportType);
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

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<Many2oneCompChild> findAssociatedMany2oneCompChilds(Byte byteId, String stringId, String charId, Double floatId, Pageable pageable) {
        LOGGER.debug("Fetching all associated many2oneCompChilds");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("many2oneCompParent.byteId = '" + byteId + "'");
        queryBuilder.append(" and ");
        queryBuilder.append("many2oneCompParent.stringId = '" + stringId + "'");
        queryBuilder.append(" and ");
        queryBuilder.append("many2oneCompParent.charId = '" + charId + "'");
        queryBuilder.append(" and ");
        queryBuilder.append("many2oneCompParent.floatId = '" + floatId + "'");

        return many2oneCompChildService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Many2oneCompChildService instance
	 */
	protected void setMany2oneCompChildService(Many2oneCompChildService service) {
        this.many2oneCompChildService = service;
    }

}

