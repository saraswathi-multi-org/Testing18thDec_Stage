/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.newtestdb.service;

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

import com.testing18thdec_stage.newtestdb.Many2oneCompChild1;
import com.testing18thdec_stage.newtestdb.Many2oneCompParent1;
import com.testing18thdec_stage.newtestdb.Many2oneCompParent1Id;

/**
 * Service object for domain model class {@link Many2oneCompParent1}.
 */
public interface Many2oneCompParent1Service {

    /**
     * Creates a new Many2oneCompParent1. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Many2oneCompParent1 if any.
     *
     * @param many2oneCompParent1 Details of the Many2oneCompParent1 to be created; value cannot be null.
     * @return The newly created Many2oneCompParent1.
     */
    Many2oneCompParent1 create(@Valid Many2oneCompParent1 many2oneCompParent1);


	/**
     * Returns Many2oneCompParent1 by given id if exists.
     *
     * @param many2onecompparent1Id The id of the Many2oneCompParent1 to get; value cannot be null.
     * @return Many2oneCompParent1 associated with the given many2onecompparent1Id.
	 * @throws EntityNotFoundException If no Many2oneCompParent1 is found.
     */
    Many2oneCompParent1 getById(Many2oneCompParent1Id many2onecompparent1Id);

    /**
     * Find and return the Many2oneCompParent1 by given id if exists, returns null otherwise.
     *
     * @param many2onecompparent1Id The id of the Many2oneCompParent1 to get; value cannot be null.
     * @return Many2oneCompParent1 associated with the given many2onecompparent1Id.
     */
    Many2oneCompParent1 findById(Many2oneCompParent1Id many2onecompparent1Id);

	/**
     * Find and return the list of Many2oneCompParent1s by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param many2onecompparent1Ids The id's of the Many2oneCompParent1 to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Many2oneCompParent1s associated with the given many2onecompparent1Ids.
     */
    List<Many2oneCompParent1> findByMultipleIds(List<Many2oneCompParent1Id> many2onecompparent1Ids, boolean orderedReturn);


    /**
     * Updates the details of an existing Many2oneCompParent1. It replaces all fields of the existing Many2oneCompParent1 with the given many2oneCompParent1.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Many2oneCompParent1 if any.
     *
     * @param many2oneCompParent1 The details of the Many2oneCompParent1 to be updated; value cannot be null.
     * @return The updated Many2oneCompParent1.
     * @throws EntityNotFoundException if no Many2oneCompParent1 is found with given input.
     */
    Many2oneCompParent1 update(@Valid Many2oneCompParent1 many2oneCompParent1);


    /**
     * Partially updates the details of an existing Many2oneCompParent1. It updates only the
     * fields of the existing Many2oneCompParent1 which are passed in the many2oneCompParent1Patch.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Many2oneCompParent1 if any.
     *
     * @param many2onecompparent1Id The id of the Many2oneCompParent1 to be deleted; value cannot be null.
     * @param many2oneCompParent1Patch The partial data of Many2oneCompParent1 which is supposed to be updated; value cannot be null.
     * @return The updated Many2oneCompParent1.
     * @throws EntityNotFoundException if no Many2oneCompParent1 is found with given input.
     */
    Many2oneCompParent1 partialUpdate(Many2oneCompParent1Id many2onecompparent1Id, Map<String, Object> many2oneCompParent1Patch);

    /**
     * Deletes an existing Many2oneCompParent1 with the given id.
     *
     * @param many2onecompparent1Id The id of the Many2oneCompParent1 to be deleted; value cannot be null.
     * @return The deleted Many2oneCompParent1.
     * @throws EntityNotFoundException if no Many2oneCompParent1 found with the given id.
     */
    Many2oneCompParent1 delete(Many2oneCompParent1Id many2onecompparent1Id);

    /**
     * Deletes an existing Many2oneCompParent1 with the given object.
     *
     * @param many2oneCompParent1 The instance of the Many2oneCompParent1 to be deleted; value cannot be null.
     */
    void delete(Many2oneCompParent1 many2oneCompParent1);

    /**
     * Find all Many2oneCompParent1s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Many2oneCompParent1s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Many2oneCompParent1> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Many2oneCompParent1s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Many2oneCompParent1s.
     *
     * @see Pageable
     * @see Page
     */
    Page<Many2oneCompParent1> findAll(String query, Pageable pageable);

    /**
     * Exports all Many2oneCompParent1s matching the given input query to the given exportType format.
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
     * Exports all Many2oneCompParent1s matching the given input query to the given exportType format.
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
     * Retrieve the count of the Many2oneCompParent1s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Many2oneCompParent1.
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

    /*
     * Returns the associated many2oneCompChild1s for given Many2oneCompParent1 id.
     *
     * @param bigintPk value of bigintPk; value cannot be null
     * @param stringPk value of stringPk; value cannot be null
     * @param booleanPk value of booleanPk; value cannot be null
     * @param charPk value of charPk; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Many2oneCompChild1 instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Many2oneCompChild1> findAssociatedMany2oneCompChild1s(Long bigintPk, String stringPk, Boolean booleanPk, String charPk, Pageable pageable);

}