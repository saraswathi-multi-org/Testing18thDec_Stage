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

import com.testing18thdec_stage.newtestdb.One2oneChild;

/**
 * Service object for domain model class {@link One2oneChild}.
 */
public interface One2oneChildService {

    /**
     * Creates a new One2oneChild. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on One2oneChild if any.
     *
     * @param one2oneChild Details of the One2oneChild to be created; value cannot be null.
     * @return The newly created One2oneChild.
     */
	One2oneChild create(@Valid One2oneChild one2oneChild);


	/**
	 * Returns One2oneChild by given id if exists.
	 *
	 * @param one2onechildId The id of the One2oneChild to get; value cannot be null.
	 * @return One2oneChild associated with the given one2onechildId.
     * @throws EntityNotFoundException If no One2oneChild is found.
	 */
	One2oneChild getById(Short one2onechildId) throws EntityNotFoundException;

    /**
	 * Find and return the One2oneChild by given id if exists, returns null otherwise.
	 *
	 * @param one2onechildId The id of the One2oneChild to get; value cannot be null.
	 * @return One2oneChild associated with the given one2onechildId.
	 */
	One2oneChild findById(Short one2onechildId);


	/**
	 * Updates the details of an existing One2oneChild. It replaces all fields of the existing One2oneChild with the given one2oneChild.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on One2oneChild if any.
     *
	 * @param one2oneChild The details of the One2oneChild to be updated; value cannot be null.
	 * @return The updated One2oneChild.
	 * @throws EntityNotFoundException if no One2oneChild is found with given input.
	 */
	One2oneChild update(@Valid One2oneChild one2oneChild) throws EntityNotFoundException;

    /**
	 * Deletes an existing One2oneChild with the given id.
	 *
	 * @param one2onechildId The id of the One2oneChild to be deleted; value cannot be null.
	 * @return The deleted One2oneChild.
	 * @throws EntityNotFoundException if no One2oneChild found with the given id.
	 */
	One2oneChild delete(Short one2onechildId) throws EntityNotFoundException;

	/**
	 * Find all One2oneChilds matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching One2oneChilds.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<One2oneChild> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all One2oneChilds matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching One2oneChilds.
     *
     * @see Pageable
     * @see Page
	 */
    Page<One2oneChild> findAll(String query, Pageable pageable);

    /**
	 * Exports all One2oneChilds matching the given input query to the given exportType format.
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
	 * Retrieve the count of the One2oneChilds in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the One2oneChild.
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

