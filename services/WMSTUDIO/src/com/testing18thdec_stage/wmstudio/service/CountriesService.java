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

import com.testing18thdec_stage.wmstudio.Countries;

/**
 * Service object for domain model class {@link Countries}.
 */
public interface CountriesService {

    /**
     * Creates a new Countries. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Countries if any.
     *
     * @param countries Details of the Countries to be created; value cannot be null.
     * @return The newly created Countries.
     */
    Countries create(@Valid Countries countries);


	/**
     * Returns Countries by given id if exists.
     *
     * @param countriesId The id of the Countries to get; value cannot be null.
     * @return Countries associated with the given countriesId.
	 * @throws EntityNotFoundException If no Countries is found.
     */
    Countries getById(String countriesId);

    /**
     * Find and return the Countries by given id if exists, returns null otherwise.
     *
     * @param countriesId The id of the Countries to get; value cannot be null.
     * @return Countries associated with the given countriesId.
     */
    Countries findById(String countriesId);

	/**
     * Find and return the list of Countries by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param countriesIds The id's of the Countries to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Countries associated with the given countriesIds.
     */
    List<Countries> findByMultipleIds(List<String> countriesIds, boolean orderedReturn);


    /**
     * Updates the details of an existing Countries. It replaces all fields of the existing Countries with the given countries.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Countries if any.
     *
     * @param countries The details of the Countries to be updated; value cannot be null.
     * @return The updated Countries.
     * @throws EntityNotFoundException if no Countries is found with given input.
     */
    Countries update(@Valid Countries countries);


    /**
     * Partially updates the details of an existing Countries. It updates only the
     * fields of the existing Countries which are passed in the countriesPatch.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Countries if any.
     *
     * @param countriesId The id of the Countries to be deleted; value cannot be null.
     * @param countriesPatch The partial data of Countries which is supposed to be updated; value cannot be null.
     * @return The updated Countries.
     * @throws EntityNotFoundException if no Countries is found with given input.
     */
    Countries partialUpdate(String countriesId, Map<String, Object> countriesPatch);

    /**
     * Deletes an existing Countries with the given id.
     *
     * @param countriesId The id of the Countries to be deleted; value cannot be null.
     * @return The deleted Countries.
     * @throws EntityNotFoundException if no Countries found with the given id.
     */
    Countries delete(String countriesId);

    /**
     * Deletes an existing Countries with the given object.
     *
     * @param countries The instance of the Countries to be deleted; value cannot be null.
     */
    void delete(Countries countries);

    /**
     * Find all Countries matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Countries.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Countries> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Countries matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Countries.
     *
     * @see Pageable
     * @see Page
     */
    Page<Countries> findAll(String query, Pageable pageable);

    /**
     * Exports all Countries matching the given input query to the given exportType format.
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
     * Exports all Countries matching the given input query to the given exportType format.
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
     * Retrieve the count of the Countries in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Countries.
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