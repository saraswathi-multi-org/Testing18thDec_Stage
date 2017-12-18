/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.wmstudio.service;

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

import com.testing18thdec_stage.wmstudio.One2oneVpkUcChildChekcst;
import com.testing18thdec_stage.wmstudio.One2oneVpkUcChildChekcstId;

/**
 * Service object for domain model class {@link One2oneVpkUcChildChekcst}.
 */
public interface One2oneVpkUcChildChekcstService {

    /**
     * Creates a new One2oneVpkUcChildChekcst. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on One2oneVpkUcChildChekcst if any.
     *
     * @param one2oneVpkUcChildChekcst Details of the One2oneVpkUcChildChekcst to be created; value cannot be null.
     * @return The newly created One2oneVpkUcChildChekcst.
     */
	One2oneVpkUcChildChekcst create(@Valid One2oneVpkUcChildChekcst one2oneVpkUcChildChekcst);


	/**
	 * Returns One2oneVpkUcChildChekcst by given id if exists.
	 *
	 * @param one2onevpkucchildchekcstId The id of the One2oneVpkUcChildChekcst to get; value cannot be null.
	 * @return One2oneVpkUcChildChekcst associated with the given one2onevpkucchildchekcstId.
     * @throws EntityNotFoundException If no One2oneVpkUcChildChekcst is found.
	 */
	One2oneVpkUcChildChekcst getById(One2oneVpkUcChildChekcstId one2onevpkucchildchekcstId) throws EntityNotFoundException;

    /**
	 * Find and return the One2oneVpkUcChildChekcst by given id if exists, returns null otherwise.
	 *
	 * @param one2onevpkucchildchekcstId The id of the One2oneVpkUcChildChekcst to get; value cannot be null.
	 * @return One2oneVpkUcChildChekcst associated with the given one2onevpkucchildchekcstId.
	 */
	One2oneVpkUcChildChekcst findById(One2oneVpkUcChildChekcstId one2onevpkucchildchekcstId);


	/**
	 * Updates the details of an existing One2oneVpkUcChildChekcst. It replaces all fields of the existing One2oneVpkUcChildChekcst with the given one2oneVpkUcChildChekcst.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on One2oneVpkUcChildChekcst if any.
     *
	 * @param one2oneVpkUcChildChekcst The details of the One2oneVpkUcChildChekcst to be updated; value cannot be null.
	 * @return The updated One2oneVpkUcChildChekcst.
	 * @throws EntityNotFoundException if no One2oneVpkUcChildChekcst is found with given input.
	 */
	One2oneVpkUcChildChekcst update(@Valid One2oneVpkUcChildChekcst one2oneVpkUcChildChekcst) throws EntityNotFoundException;

    /**
	 * Deletes an existing One2oneVpkUcChildChekcst with the given id.
	 *
	 * @param one2onevpkucchildchekcstId The id of the One2oneVpkUcChildChekcst to be deleted; value cannot be null.
	 * @return The deleted One2oneVpkUcChildChekcst.
	 * @throws EntityNotFoundException if no One2oneVpkUcChildChekcst found with the given id.
	 */
	One2oneVpkUcChildChekcst delete(One2oneVpkUcChildChekcstId one2onevpkucchildchekcstId) throws EntityNotFoundException;

	/**
	 * Find all One2oneVpkUcChildChekcsts matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching One2oneVpkUcChildChekcsts.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<One2oneVpkUcChildChekcst> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all One2oneVpkUcChildChekcsts matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching One2oneVpkUcChildChekcsts.
     *
     * @see Pageable
     * @see Page
	 */
    Page<One2oneVpkUcChildChekcst> findAll(String query, Pageable pageable);

    /**
	 * Exports all One2oneVpkUcChildChekcsts matching the given input query to the given exportType format.
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
	 * Retrieve the count of the One2oneVpkUcChildChekcsts in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the One2oneVpkUcChildChekcst.
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


}

