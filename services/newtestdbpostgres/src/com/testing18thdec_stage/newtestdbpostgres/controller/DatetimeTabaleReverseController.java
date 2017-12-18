/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.newtestdbpostgres.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.testing18thdec_stage.newtestdbpostgres.DatetimeTabaleReverse;
import com.testing18thdec_stage.newtestdbpostgres.service.DatetimeTabaleReverseService;


/**
 * Controller object for domain model class DatetimeTabaleReverse.
 * @see DatetimeTabaleReverse
 */
@RestController("newtestdbpostgres.DatetimeTabaleReverseController")
@Api(value = "DatetimeTabaleReverseController", description = "Exposes APIs to work with DatetimeTabaleReverse resource.")
@RequestMapping("/newtestdbpostgres/DatetimeTabaleReverse")
public class DatetimeTabaleReverseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatetimeTabaleReverseController.class);

    @Autowired
	@Qualifier("newtestdbpostgres.DatetimeTabaleReverseService")
	private DatetimeTabaleReverseService datetimeTabaleReverseService;

	@ApiOperation(value = "Creates a new DatetimeTabaleReverse instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DatetimeTabaleReverse createDatetimeTabaleReverse(@RequestBody DatetimeTabaleReverse datetimeTabaleReverse) {
		LOGGER.debug("Create DatetimeTabaleReverse with information: {}" , datetimeTabaleReverse);

		datetimeTabaleReverse = datetimeTabaleReverseService.create(datetimeTabaleReverse);
		LOGGER.debug("Created DatetimeTabaleReverse with information: {}" , datetimeTabaleReverse);

	    return datetimeTabaleReverse;
	}

    @ApiOperation(value = "Returns the DatetimeTabaleReverse instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DatetimeTabaleReverse getDatetimeTabaleReverse(@PathVariable("id") String id) throws EntityNotFoundException {
        LOGGER.debug("Getting DatetimeTabaleReverse with id: {}" , id);

        DatetimeTabaleReverse foundDatetimeTabaleReverse = datetimeTabaleReverseService.getById(id);
        LOGGER.debug("DatetimeTabaleReverse details with id: {}" , foundDatetimeTabaleReverse);

        return foundDatetimeTabaleReverse;
    }

    @ApiOperation(value = "Updates the DatetimeTabaleReverse instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DatetimeTabaleReverse editDatetimeTabaleReverse(@PathVariable("id") String id, @RequestBody DatetimeTabaleReverse datetimeTabaleReverse) throws EntityNotFoundException {
        LOGGER.debug("Editing DatetimeTabaleReverse with id: {}" , datetimeTabaleReverse.getId());

        datetimeTabaleReverse.setId(id);
        datetimeTabaleReverse = datetimeTabaleReverseService.update(datetimeTabaleReverse);
        LOGGER.debug("DatetimeTabaleReverse details with id: {}" , datetimeTabaleReverse);

        return datetimeTabaleReverse;
    }

    @ApiOperation(value = "Deletes the DatetimeTabaleReverse instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteDatetimeTabaleReverse(@PathVariable("id") String id) throws EntityNotFoundException {
        LOGGER.debug("Deleting DatetimeTabaleReverse with id: {}" , id);

        DatetimeTabaleReverse deletedDatetimeTabaleReverse = datetimeTabaleReverseService.delete(id);

        return deletedDatetimeTabaleReverse != null;
    }

    /**
     * @deprecated Use {@link #findDatetimeTabaleReverses(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of DatetimeTabaleReverse instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DatetimeTabaleReverse> searchDatetimeTabaleReversesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering DatetimeTabaleReverses list");
        return datetimeTabaleReverseService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of DatetimeTabaleReverse instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DatetimeTabaleReverse> findDatetimeTabaleReverses(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering DatetimeTabaleReverses list");
        return datetimeTabaleReverseService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of DatetimeTabaleReverse instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DatetimeTabaleReverse> filterDatetimeTabaleReverses(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering DatetimeTabaleReverses list");
        return datetimeTabaleReverseService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportDatetimeTabaleReverses(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return datetimeTabaleReverseService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of DatetimeTabaleReverse instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countDatetimeTabaleReverses( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting DatetimeTabaleReverses");
		return datetimeTabaleReverseService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getDatetimeTabaleReverseAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return datetimeTabaleReverseService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service DatetimeTabaleReverseService instance
	 */
	protected void setDatetimeTabaleReverseService(DatetimeTabaleReverseService service) {
		this.datetimeTabaleReverseService = service;
	}

}

