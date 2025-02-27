/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.newtestdb.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.sql.Date;
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

import com.testing18thdec_stage.newtestdb.One2oneVirtualChild;
import com.testing18thdec_stage.newtestdb.One2oneVirtualChildId;
import com.testing18thdec_stage.newtestdb.service.One2oneVirtualChildService;


/**
 * Controller object for domain model class One2oneVirtualChild.
 * @see One2oneVirtualChild
 */
@RestController("NewTestDB.One2oneVirtualChildController")
@Api(value = "One2oneVirtualChildController", description = "Exposes APIs to work with One2oneVirtualChild resource.")
@RequestMapping("/NewTestDB/One2oneVirtualChild")
public class One2oneVirtualChildController {

    private static final Logger LOGGER = LoggerFactory.getLogger(One2oneVirtualChildController.class);

    @Autowired
	@Qualifier("NewTestDB.One2oneVirtualChildService")
	private One2oneVirtualChildService one2oneVirtualChildService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new One2oneVirtualChild instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2oneVirtualChild createOne2oneVirtualChild(@RequestBody One2oneVirtualChild one2oneVirtualChild) {
		LOGGER.debug("Create One2oneVirtualChild with information: {}" , one2oneVirtualChild);

		one2oneVirtualChild = one2oneVirtualChildService.create(one2oneVirtualChild);
		LOGGER.debug("Created One2oneVirtualChild with information: {}" , one2oneVirtualChild);

	    return one2oneVirtualChild;
	}

    @ApiOperation(value = "Returns the One2oneVirtualChild instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2oneVirtualChild getOne2oneVirtualChild(@RequestParam("charId") String charId, @RequestParam("stringCol") String stringCol, @RequestParam("booleanCol") Boolean booleanCol, @RequestParam("dateCol") Date dateCol) {

        One2oneVirtualChildId one2onevirtualchildId = new One2oneVirtualChildId();
        one2onevirtualchildId.setCharId(charId);
        one2onevirtualchildId.setStringCol(stringCol);
        one2onevirtualchildId.setBooleanCol(booleanCol);
        one2onevirtualchildId.setDateCol(dateCol);

        LOGGER.debug("Getting One2oneVirtualChild with id: {}" , one2onevirtualchildId);
        One2oneVirtualChild one2oneVirtualChild = one2oneVirtualChildService.getById(one2onevirtualchildId);
        LOGGER.debug("One2oneVirtualChild details with id: {}" , one2oneVirtualChild);

        return one2oneVirtualChild;
    }



    @ApiOperation(value = "Updates the One2oneVirtualChild instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2oneVirtualChild editOne2oneVirtualChild(@RequestParam("charId") String charId, @RequestParam("stringCol") String stringCol, @RequestParam("booleanCol") Boolean booleanCol, @RequestParam("dateCol") Date dateCol, @RequestBody One2oneVirtualChild one2oneVirtualChild) {

        one2oneVirtualChild.setCharId(charId);
        one2oneVirtualChild.setStringCol(stringCol);
        one2oneVirtualChild.setBooleanCol(booleanCol);
        one2oneVirtualChild.setDateCol(dateCol);

        LOGGER.debug("One2oneVirtualChild details with id is updated with: {}" , one2oneVirtualChild);

        return one2oneVirtualChildService.update(one2oneVirtualChild);
    }

	@ApiOperation(value = "Partially updates the  One2oneVirtualChild instance associated with the given composite-id.")
	@RequestMapping(value = "/composite-id", method = RequestMethod.PATCH)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2oneVirtualChild patchOne2oneVirtualChild(@RequestParam("charId") String charId, @RequestParam("stringCol") String stringCol, @RequestParam("booleanCol") Boolean booleanCol, @RequestParam("dateCol") Date dateCol, @RequestBody @MapTo(One2oneVirtualChild.class) Map<String, Object> one2oneVirtualChildPatch) {

        One2oneVirtualChildId one2onevirtualchildId = new One2oneVirtualChildId();
        one2onevirtualchildId.setCharId(charId);
        one2onevirtualchildId.setStringCol(stringCol);
        one2onevirtualchildId.setBooleanCol(booleanCol);
        one2onevirtualchildId.setDateCol(dateCol);
        LOGGER.debug("Partially updating One2oneVirtualChild with id: {}" , one2onevirtualchildId);

        One2oneVirtualChild one2oneVirtualChild = one2oneVirtualChildService.partialUpdate(one2onevirtualchildId, one2oneVirtualChildPatch);
        LOGGER.debug("One2oneVirtualChild details after partial update: {}" , one2oneVirtualChild);

        return one2oneVirtualChild;
    }


    @ApiOperation(value = "Deletes the One2oneVirtualChild instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteOne2oneVirtualChild(@RequestParam("charId") String charId, @RequestParam("stringCol") String stringCol, @RequestParam("booleanCol") Boolean booleanCol, @RequestParam("dateCol") Date dateCol) {

        One2oneVirtualChildId one2onevirtualchildId = new One2oneVirtualChildId();
        one2onevirtualchildId.setCharId(charId);
        one2onevirtualchildId.setStringCol(stringCol);
        one2onevirtualchildId.setBooleanCol(booleanCol);
        one2onevirtualchildId.setDateCol(dateCol);

        LOGGER.debug("Deleting One2oneVirtualChild with id: {}" , one2onevirtualchildId);
        One2oneVirtualChild one2oneVirtualChild = one2oneVirtualChildService.delete(one2onevirtualchildId);

        return one2oneVirtualChild != null;
    }


    /**
     * @deprecated Use {@link #findOne2oneVirtualChilds(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of One2oneVirtualChild instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<One2oneVirtualChild> searchOne2oneVirtualChildsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering One2oneVirtualChilds list by query filter:{}", (Object) queryFilters);
        return one2oneVirtualChildService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of One2oneVirtualChild instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<One2oneVirtualChild> findOne2oneVirtualChilds(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering One2oneVirtualChilds list by filter:", query);
        return one2oneVirtualChildService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of One2oneVirtualChild instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<One2oneVirtualChild> filterOne2oneVirtualChilds(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering One2oneVirtualChilds list by filter", query);
        return one2oneVirtualChildService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportOne2oneVirtualChilds(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return one2oneVirtualChildService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportOne2oneVirtualChildsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = One2oneVirtualChild.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> one2oneVirtualChildService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of One2oneVirtualChild instances matching the optional query (q) request param.")
	@RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countOne2oneVirtualChilds( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting One2oneVirtualChilds");
		return one2oneVirtualChildService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getOne2oneVirtualChildAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return one2oneVirtualChildService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service One2oneVirtualChildService instance
	 */
	protected void setOne2oneVirtualChildService(One2oneVirtualChildService service) {
		this.one2oneVirtualChildService = service;
	}

}