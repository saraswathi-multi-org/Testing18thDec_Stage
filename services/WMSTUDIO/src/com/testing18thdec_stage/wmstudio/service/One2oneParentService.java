/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.wmstudio.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testing18thdec_stage.wmstudio.One2oneParent;

/**
 * Service object for domain model class {@link One2oneParent}.
 */
public interface One2oneParentService {

    /**
     * Creates a new One2oneParent. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on One2oneParent if any.
     *
     * @param one2oneParent Details of the One2oneParent to be created; value cannot be null.
     * @return The newly created One2oneParent.
     */
    One2oneParent create(@Valid One2oneParent one2oneParent);


	/**
     * Returns One2oneParent by given id if exists.
     *
     * @param one2oneparentId The id of the One2oneParent to get; value cannot be null.
     * @return One2oneParent associated with the given one2oneparentId.
	 * @throws EntityNotFoundException If no One2oneParent is found.
     */
    One2oneParent getById(Byte one2oneparentId);

    /**
     * Find and return the One2oneParent by given id if exists, returns null otherwise.
     *
     * @param one2oneparentId The id of the One2oneParent to get; value cannot be null.
     * @return One2oneParent associated with the given one2oneparentId.
     */
    One2oneParent findById(Byte one2oneparentId);

	/**
     * Find and return the list of One2oneParents by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param one2oneparentIds The id's of the One2oneParent to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return One2oneParents associated with the given one2oneparentIds.
     */
    List<One2oneParent> findByMultipleIds(List<Byte> one2oneparentIds, boolean orderedReturn);


    /**
     * Updates the details of an existing One2oneParent. It replaces all fields of the existing One2oneParent with the given one2oneParent.
     *
     * This method overrides the input field values using Server side or database managed properties defined on One2oneParent if any.
     *
     * @param one2oneParent The details of the One2oneParent to be updated; value cannot be null.
     * @return The updated One2oneParent.
     * @throws EntityNotFoundException if no One2oneParent is found with given input.
     */
    One2oneParent update(@Valid One2oneParent one2oneParent);


    /**
     * Partially updates the details of an existing One2oneParent. It updates only the
     * fields of the existing One2oneParent which are passed in the one2oneParentPatch.
     *
     * This method overrides the input field values using Server side or database managed properties defined on One2oneParent if any.
     *
     * @param one2oneparentId The id of the One2oneParent to be deleted; value cannot be null.
     * @param one2oneParentPatch The partial data of One2oneParent which is supposed to be updated; value cannot be null.
     * @return The updated One2oneParent.
     * @throws EntityNotFoundException if no One2oneParent is found with given input.
     */
    One2oneParent partialUpdate(Byte one2oneparentId, Map<String, Object> one2oneParentPatch);

    /**
     * Deletes an existing One2oneParent with the given id.
     *
     * @param one2oneparentId The id of the One2oneParent to be deleted; value cannot be null.
     * @return The deleted One2oneParent.
     * @throws EntityNotFoundException if no One2oneParent found with the given id.
     */
    One2oneParent delete(Byte one2oneparentId);

    /**
     * Deletes an existing One2oneParent with the given object.
     *
     * @param one2oneParent The instance of the One2oneParent to be deleted; value cannot be null.
     */
    void delete(One2oneParent one2oneParent);

    /**
     * Find all One2oneParents matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching One2oneParents.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<One2oneParent> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all One2oneParents matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching One2oneParents.
     *
     * @see Pageable
     * @see Page
     */
    Page<One2oneParent> findAll(String query, Pageable pageable);

    /**
     * Exports all One2oneParents matching the given input query to the given exportType format.
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
     * Exports all One2oneParents matching the given input query to the given exportType format.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     * @see Pageable
     * @see OutputStream
     */
    void export(DataExportOptions options, Pageable pageable, OutputStream outputStream);

    /**
     * Retrieve the count of the One2oneParents in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the One2oneParent.
     */
    long count(String query);

    /**
     * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return Paginated data with included fields.
     *
     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
    Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}