/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.newtestdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testing18thdec_stage.newtestdb.Many2oneChild;
import com.testing18thdec_stage.newtestdb.Many2oneParent;

/**
 * Service object for domain model class {@link Many2oneParent}.
 */
public interface Many2oneParentService {

    /**
     * Creates a new Many2oneParent. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Many2oneParent if any.
     *
     * @param many2oneParent Details of the Many2oneParent to be created; value cannot be null.
     * @return The newly created Many2oneParent.
     */
	Many2oneParent create(@Valid Many2oneParent many2oneParent);


	/**
	 * Returns Many2oneParent by given id if exists.
	 *
	 * @param many2oneparentId The id of the Many2oneParent to get; value cannot be null.
	 * @return Many2oneParent associated with the given many2oneparentId.
     * @throws EntityNotFoundException If no Many2oneParent is found.
	 */
	Many2oneParent getById(String many2oneparentId) throws EntityNotFoundException;

    /**
	 * Find and return the Many2oneParent by given id if exists, returns null otherwise.
	 *
	 * @param many2oneparentId The id of the Many2oneParent to get; value cannot be null.
	 * @return Many2oneParent associated with the given many2oneparentId.
	 */
	Many2oneParent findById(String many2oneparentId);


	/**
	 * Updates the details of an existing Many2oneParent. It replaces all fields of the existing Many2oneParent with the given many2oneParent.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Many2oneParent if any.
     *
	 * @param many2oneParent The details of the Many2oneParent to be updated; value cannot be null.
	 * @return The updated Many2oneParent.
	 * @throws EntityNotFoundException if no Many2oneParent is found with given input.
	 */
	Many2oneParent update(@Valid Many2oneParent many2oneParent) throws EntityNotFoundException;

    /**
	 * Deletes an existing Many2oneParent with the given id.
	 *
	 * @param many2oneparentId The id of the Many2oneParent to be deleted; value cannot be null.
	 * @return The deleted Many2oneParent.
	 * @throws EntityNotFoundException if no Many2oneParent found with the given id.
	 */
	Many2oneParent delete(String many2oneparentId) throws EntityNotFoundException;

	/**
	 * Find all Many2oneParents matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Many2oneParents.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Many2oneParent> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Many2oneParents matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Many2oneParents.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Many2oneParent> findAll(String query, Pageable pageable);

    /**
	 * Exports all Many2oneParents matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Many2oneParents in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Many2oneParent.
	 */
	long count(String query);

	/**
	 * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
	 * @return Paginated data with included fields.

     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
	Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);

    /*
     * Returns the associated many2oneChilds for given Many2oneParent id.
     *
     * @param stringId value of stringId; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Many2oneChild instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Many2oneChild> findAssociatedMany2oneChilds(String stringId, Pageable pageable);

}

