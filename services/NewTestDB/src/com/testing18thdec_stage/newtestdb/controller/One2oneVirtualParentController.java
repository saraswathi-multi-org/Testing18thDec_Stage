/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.newtestdb.controller;

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

import com.testing18thdec_stage.newtestdb.One2oneVirtualParent;
import com.testing18thdec_stage.newtestdb.service.One2oneVirtualParentService;


/**
 * Controller object for domain model class One2oneVirtualParent.
 * @see One2oneVirtualParent
 */
@RestController("NewTestDB.One2oneVirtualParentController")
@Api(value = "One2oneVirtualParentController", description = "Exposes APIs to work with One2oneVirtualParent resource.")
@RequestMapping("/NewTestDB/One2oneVirtualParent")
public class One2oneVirtualParentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(One2oneVirtualParentController.class);

    @Autowired
	@Qualifier("NewTestDB.One2oneVirtualParentService")
	private One2oneVirtualParentService one2oneVirtualParentService;

	@ApiOperation(value = "Creates a new One2oneVirtualParent instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2oneVirtualParent createOne2oneVirtualParent(@RequestBody One2oneVirtualParent one2oneVirtualParent) {
		LOGGER.debug("Create One2oneVirtualParent with information: {}" , one2oneVirtualParent);

		one2oneVirtualParent = one2oneVirtualParentService.create(one2oneVirtualParent);
		LOGGER.debug("Created One2oneVirtualParent with information: {}" , one2oneVirtualParent);

	    return one2oneVirtualParent;
	}

    @ApiOperation(value = "Returns the One2oneVirtualParent instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2oneVirtualParent getOne2oneVirtualParent(@PathVariable("id") String id) throws EntityNotFoundException {
        LOGGER.debug("Getting One2oneVirtualParent with id: {}" , id);

        One2oneVirtualParent foundOne2oneVirtualParent = one2oneVirtualParentService.getById(id);
        LOGGER.debug("One2oneVirtualParent details with id: {}" , foundOne2oneVirtualParent);

        return foundOne2oneVirtualParent;
    }

    @ApiOperation(value = "Updates the One2oneVirtualParent instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2oneVirtualParent editOne2oneVirtualParent(@PathVariable("id") String id, @RequestBody One2oneVirtualParent one2oneVirtualParent) throws EntityNotFoundException {
        LOGGER.debug("Editing One2oneVirtualParent with id: {}" , one2oneVirtualParent.getCharPkId());

        one2oneVirtualParent.setCharPkId(id);
        one2oneVirtualParent = one2oneVirtualParentService.update(one2oneVirtualParent);
        LOGGER.debug("One2oneVirtualParent details with id: {}" , one2oneVirtualParent);

        return one2oneVirtualParent;
    }

    @ApiOperation(value = "Deletes the One2oneVirtualParent instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteOne2oneVirtualParent(@PathVariable("id") String id) throws EntityNotFoundException {
        LOGGER.debug("Deleting One2oneVirtualParent with id: {}" , id);

        One2oneVirtualParent deletedOne2oneVirtualParent = one2oneVirtualParentService.delete(id);

        return deletedOne2oneVirtualParent != null;
    }

    /**
     * @deprecated Use {@link #findOne2oneVirtualParents(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of One2oneVirtualParent instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<One2oneVirtualParent> searchOne2oneVirtualParentsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering One2oneVirtualParents list");
        return one2oneVirtualParentService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of One2oneVirtualParent instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<One2oneVirtualParent> findOne2oneVirtualParents(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering One2oneVirtualParents list");
        return one2oneVirtualParentService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of One2oneVirtualParent instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<One2oneVirtualParent> filterOne2oneVirtualParents(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering One2oneVirtualParents list");
        return one2oneVirtualParentService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportOne2oneVirtualParents(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return one2oneVirtualParentService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of One2oneVirtualParent instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countOne2oneVirtualParents( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting One2oneVirtualParents");
		return one2oneVirtualParentService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getOne2oneVirtualParentAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return one2oneVirtualParentService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service One2oneVirtualParentService instance
	 */
	protected void setOne2oneVirtualParentService(One2oneVirtualParentService service) {
		this.one2oneVirtualParentService = service;
	}

}

