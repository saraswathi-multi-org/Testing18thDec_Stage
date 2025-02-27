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

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.manager.ExportedFileManager;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.MapTo;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.testing18thdec_stage.newtestdb.One2oneParent;
import com.testing18thdec_stage.newtestdb.service.One2oneParentService;


/**
 * Controller object for domain model class One2oneParent.
 * @see One2oneParent
 */
@RestController("NewTestDB.One2oneParentController")
@Api(value = "One2oneParentController", description = "Exposes APIs to work with One2oneParent resource.")
@RequestMapping("/NewTestDB/One2oneParent")
public class One2oneParentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(One2oneParentController.class);

    @Autowired
	@Qualifier("NewTestDB.One2oneParentService")
	private One2oneParentService one2oneParentService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new One2oneParent instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2oneParent createOne2oneParent(@RequestBody One2oneParent one2oneParent) {
		LOGGER.debug("Create One2oneParent with information: {}" , one2oneParent);

		one2oneParent = one2oneParentService.create(one2oneParent);
		LOGGER.debug("Created One2oneParent with information: {}" , one2oneParent);

	    return one2oneParent;
	}

    @ApiOperation(value = "Returns the One2oneParent instance associated with the given id.")
    @RequestMapping(value = "/{shortPkId:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2oneParent getOne2oneParent(@PathVariable("shortPkId") Short shortPkId) {
        LOGGER.debug("Getting One2oneParent with id: {}" , shortPkId);

        One2oneParent foundOne2oneParent = one2oneParentService.getById(shortPkId);
        LOGGER.debug("One2oneParent details with id: {}" , foundOne2oneParent);

        return foundOne2oneParent;
    }

    @ApiOperation(value = "Updates the One2oneParent instance associated with the given id.")
    @RequestMapping(value = "/{shortPkId:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2oneParent editOne2oneParent(@PathVariable("shortPkId") Short shortPkId, @RequestBody One2oneParent one2oneParent) {
        LOGGER.debug("Editing One2oneParent with id: {}" , one2oneParent.getShortPkId());

        one2oneParent.setShortPkId(shortPkId);
        one2oneParent = one2oneParentService.update(one2oneParent);
        LOGGER.debug("One2oneParent details with id: {}" , one2oneParent);

        return one2oneParent;
    }
    
    @ApiOperation(value = "Partially updates the One2oneParent instance associated with the given id.")
    @RequestMapping(value = "/{shortPkId:.+}", method = RequestMethod.PATCH)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2oneParent patchOne2oneParent(@PathVariable("shortPkId") Short shortPkId, @RequestBody @MapTo(One2oneParent.class) Map<String, Object> one2oneParentPatch) {
        LOGGER.debug("Partially updating One2oneParent with id: {}" , shortPkId);

        One2oneParent one2oneParent = one2oneParentService.partialUpdate(shortPkId, one2oneParentPatch);
        LOGGER.debug("One2oneParent details after partial update: {}" , one2oneParent);

        return one2oneParent;
    }

    @ApiOperation(value = "Deletes the One2oneParent instance associated with the given id.")
    @RequestMapping(value = "/{shortPkId:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteOne2oneParent(@PathVariable("shortPkId") Short shortPkId) {
        LOGGER.debug("Deleting One2oneParent with id: {}" , shortPkId);

        One2oneParent deletedOne2oneParent = one2oneParentService.delete(shortPkId);

        return deletedOne2oneParent != null;
    }

    /**
     * @deprecated Use {@link #findOne2oneParents(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of One2oneParent instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<One2oneParent> searchOne2oneParentsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering One2oneParents list by query filter:{}", (Object) queryFilters);
        return one2oneParentService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of One2oneParent instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<One2oneParent> findOne2oneParents(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering One2oneParents list by filter:", query);
        return one2oneParentService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of One2oneParent instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<One2oneParent> filterOne2oneParents(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering One2oneParents list by filter", query);
        return one2oneParentService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportOne2oneParents(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return one2oneParentService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportOne2oneParentsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = One2oneParent.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> one2oneParentService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of One2oneParent instances matching the optional query (q) request param.")
	@RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countOne2oneParents( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting One2oneParents");
		return one2oneParentService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getOne2oneParentAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return one2oneParentService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service One2oneParentService instance
	 */
	protected void setOne2oneParentService(One2oneParentService service) {
		this.one2oneParentService = service;
	}

}