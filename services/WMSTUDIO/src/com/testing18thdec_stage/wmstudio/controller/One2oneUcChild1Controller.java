/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.wmstudio.controller;

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

import com.testing18thdec_stage.wmstudio.One2oneUcChild1;
import com.testing18thdec_stage.wmstudio.service.One2oneUcChild1Service;


/**
 * Controller object for domain model class One2oneUcChild1.
 * @see One2oneUcChild1
 */
@RestController("WMSTUDIO.One2oneUcChild1Controller")
@Api(value = "One2oneUcChild1Controller", description = "Exposes APIs to work with One2oneUcChild1 resource.")
@RequestMapping("/WMSTUDIO/One2oneUcChild1")
public class One2oneUcChild1Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(One2oneUcChild1Controller.class);

    @Autowired
	@Qualifier("WMSTUDIO.One2oneUcChild1Service")
	private One2oneUcChild1Service one2oneUcChild1Service;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new One2oneUcChild1 instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2oneUcChild1 createOne2oneUcChild1(@RequestBody One2oneUcChild1 one2oneUcChild1) {
		LOGGER.debug("Create One2oneUcChild1 with information: {}" , one2oneUcChild1);

		one2oneUcChild1 = one2oneUcChild1Service.create(one2oneUcChild1);
		LOGGER.debug("Created One2oneUcChild1 with information: {}" , one2oneUcChild1);

	    return one2oneUcChild1;
	}

    @ApiOperation(value = "Returns the One2oneUcChild1 instance associated with the given id.")
    @RequestMapping(value = "/{shortId:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2oneUcChild1 getOne2oneUcChild1(@PathVariable("shortId") Short shortId) {
        LOGGER.debug("Getting One2oneUcChild1 with id: {}" , shortId);

        One2oneUcChild1 foundOne2oneUcChild1 = one2oneUcChild1Service.getById(shortId);
        LOGGER.debug("One2oneUcChild1 details with id: {}" , foundOne2oneUcChild1);

        return foundOne2oneUcChild1;
    }

    @ApiOperation(value = "Updates the One2oneUcChild1 instance associated with the given id.")
    @RequestMapping(value = "/{shortId:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2oneUcChild1 editOne2oneUcChild1(@PathVariable("shortId") Short shortId, @RequestBody One2oneUcChild1 one2oneUcChild1) {
        LOGGER.debug("Editing One2oneUcChild1 with id: {}" , one2oneUcChild1.getShortId());

        one2oneUcChild1.setShortId(shortId);
        one2oneUcChild1 = one2oneUcChild1Service.update(one2oneUcChild1);
        LOGGER.debug("One2oneUcChild1 details with id: {}" , one2oneUcChild1);

        return one2oneUcChild1;
    }
    
    @ApiOperation(value = "Partially updates the One2oneUcChild1 instance associated with the given id.")
    @RequestMapping(value = "/{shortId:.+}", method = RequestMethod.PATCH)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2oneUcChild1 patchOne2oneUcChild1(@PathVariable("shortId") Short shortId, @RequestBody @MapTo(One2oneUcChild1.class) Map<String, Object> one2oneUcChild1Patch) {
        LOGGER.debug("Partially updating One2oneUcChild1 with id: {}" , shortId);

        One2oneUcChild1 one2oneUcChild1 = one2oneUcChild1Service.partialUpdate(shortId, one2oneUcChild1Patch);
        LOGGER.debug("One2oneUcChild1 details after partial update: {}" , one2oneUcChild1);

        return one2oneUcChild1;
    }

    @ApiOperation(value = "Deletes the One2oneUcChild1 instance associated with the given id.")
    @RequestMapping(value = "/{shortId:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteOne2oneUcChild1(@PathVariable("shortId") Short shortId) {
        LOGGER.debug("Deleting One2oneUcChild1 with id: {}" , shortId);

        One2oneUcChild1 deletedOne2oneUcChild1 = one2oneUcChild1Service.delete(shortId);

        return deletedOne2oneUcChild1 != null;
    }

    @RequestMapping(value = "/emailCol/{emailCol}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching One2oneUcChild1 with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2oneUcChild1 getByEmailCol(@PathVariable("emailCol") String emailCol) {
        LOGGER.debug("Getting One2oneUcChild1 with uniques key EmailCol");
        return one2oneUcChild1Service.getByEmailCol(emailCol);
    }

    /**
     * @deprecated Use {@link #findOne2oneUcChild1s(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of One2oneUcChild1 instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<One2oneUcChild1> searchOne2oneUcChild1sByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering One2oneUcChild1s list by query filter:{}", (Object) queryFilters);
        return one2oneUcChild1Service.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of One2oneUcChild1 instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<One2oneUcChild1> findOne2oneUcChild1s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering One2oneUcChild1s list by filter:", query);
        return one2oneUcChild1Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of One2oneUcChild1 instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<One2oneUcChild1> filterOne2oneUcChild1s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering One2oneUcChild1s list by filter", query);
        return one2oneUcChild1Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportOne2oneUcChild1s(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return one2oneUcChild1Service.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportOne2oneUcChild1sAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = One2oneUcChild1.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> one2oneUcChild1Service.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of One2oneUcChild1 instances matching the optional query (q) request param.")
	@RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countOne2oneUcChild1s( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting One2oneUcChild1s");
		return one2oneUcChild1Service.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getOne2oneUcChild1AggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return one2oneUcChild1Service.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service One2oneUcChild1Service instance
	 */
	protected void setOne2oneUcChild1Service(One2oneUcChild1Service service) {
		this.one2oneUcChild1Service = service;
	}

}