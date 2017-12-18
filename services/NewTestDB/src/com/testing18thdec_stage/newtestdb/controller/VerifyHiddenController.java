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

import com.testing18thdec_stage.newtestdb.VerifyHidden;
import com.testing18thdec_stage.newtestdb.service.VerifyHiddenService;


/**
 * Controller object for domain model class VerifyHidden.
 * @see VerifyHidden
 */
@RestController("NewTestDB.VerifyHiddenController")
@Api(value = "VerifyHiddenController", description = "Exposes APIs to work with VerifyHidden resource.")
@RequestMapping("/NewTestDB/VerifyHidden")
public class VerifyHiddenController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VerifyHiddenController.class);

    @Autowired
	@Qualifier("NewTestDB.VerifyHiddenService")
	private VerifyHiddenService verifyHiddenService;

	@ApiOperation(value = "Creates a new VerifyHidden instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public VerifyHidden createVerifyHidden(@RequestBody VerifyHidden verifyHidden) {
		LOGGER.debug("Create VerifyHidden with information: {}" , verifyHidden);

		verifyHidden = verifyHiddenService.create(verifyHidden);
		LOGGER.debug("Created VerifyHidden with information: {}" , verifyHidden);

	    return verifyHidden;
	}

    @ApiOperation(value = "Returns the VerifyHidden instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public VerifyHidden getVerifyHidden(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting VerifyHidden with id: {}" , id);

        VerifyHidden foundVerifyHidden = verifyHiddenService.getById(id);
        LOGGER.debug("VerifyHidden details with id: {}" , foundVerifyHidden);

        return foundVerifyHidden;
    }

    @ApiOperation(value = "Updates the VerifyHidden instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public VerifyHidden editVerifyHidden(@PathVariable("id") Integer id, @RequestBody VerifyHidden verifyHidden) throws EntityNotFoundException {
        LOGGER.debug("Editing VerifyHidden with id: {}" , verifyHidden.getPkcol());

        verifyHidden.setPkcol(id);
        verifyHidden = verifyHiddenService.update(verifyHidden);
        LOGGER.debug("VerifyHidden details with id: {}" , verifyHidden);

        return verifyHidden;
    }

    @ApiOperation(value = "Deletes the VerifyHidden instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteVerifyHidden(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting VerifyHidden with id: {}" , id);

        VerifyHidden deletedVerifyHidden = verifyHiddenService.delete(id);

        return deletedVerifyHidden != null;
    }

    @RequestMapping(value = "/intcol2dbdef/{intcol2dbdef}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching VerifyHidden with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public VerifyHidden getByIntcol2dbdef(@PathVariable("intcol2dbdef") Integer intcol2dbdef) {
        LOGGER.debug("Getting VerifyHidden with uniques key Intcol2dbdef");
        return verifyHiddenService.getByIntcol2dbdef(intcol2dbdef);
    }

    /**
     * @deprecated Use {@link #findVerifyHiddens(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of VerifyHidden instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<VerifyHidden> searchVerifyHiddensByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering VerifyHiddens list");
        return verifyHiddenService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of VerifyHidden instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<VerifyHidden> findVerifyHiddens(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering VerifyHiddens list");
        return verifyHiddenService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of VerifyHidden instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<VerifyHidden> filterVerifyHiddens(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering VerifyHiddens list");
        return verifyHiddenService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportVerifyHiddens(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return verifyHiddenService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of VerifyHidden instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countVerifyHiddens( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting VerifyHiddens");
		return verifyHiddenService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getVerifyHiddenAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return verifyHiddenService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service VerifyHiddenService instance
	 */
	protected void setVerifyHiddenService(VerifyHiddenService service) {
		this.verifyHiddenService = service;
	}

}

