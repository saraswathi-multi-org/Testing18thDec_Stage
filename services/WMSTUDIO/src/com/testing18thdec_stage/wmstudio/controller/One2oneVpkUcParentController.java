/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.wmstudio.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.time.LocalDateTime;
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

import com.testing18thdec_stage.wmstudio.One2oneVpkUcParent;
import com.testing18thdec_stage.wmstudio.One2oneVpkUcParentId;
import com.testing18thdec_stage.wmstudio.service.One2oneVpkUcParentService;


/**
 * Controller object for domain model class One2oneVpkUcParent.
 * @see One2oneVpkUcParent
 */
@RestController("WMSTUDIO.One2oneVpkUcParentController")
@Api(value = "One2oneVpkUcParentController", description = "Exposes APIs to work with One2oneVpkUcParent resource.")
@RequestMapping("/WMSTUDIO/One2oneVpkUcParent")
public class One2oneVpkUcParentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(One2oneVpkUcParentController.class);

    @Autowired
	@Qualifier("WMSTUDIO.One2oneVpkUcParentService")
	private One2oneVpkUcParentService one2oneVpkUcParentService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new One2oneVpkUcParent instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2oneVpkUcParent createOne2oneVpkUcParent(@RequestBody One2oneVpkUcParent one2oneVpkUcParent) {
		LOGGER.debug("Create One2oneVpkUcParent with information: {}" , one2oneVpkUcParent);

		one2oneVpkUcParent = one2oneVpkUcParentService.create(one2oneVpkUcParent);
		LOGGER.debug("Created One2oneVpkUcParent with information: {}" , one2oneVpkUcParent);

	    return one2oneVpkUcParent;
	}

    @ApiOperation(value = "Returns the One2oneVpkUcParent instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2oneVpkUcParent getOne2oneVpkUcParent(@RequestParam("stringCol") String stringCol, @RequestParam("dateCol") LocalDateTime dateCol, @RequestParam("charCol") String charCol, @RequestParam("clobCol") String clobCol) {

        One2oneVpkUcParentId one2onevpkucparentId = new One2oneVpkUcParentId();
        one2onevpkucparentId.setStringCol(stringCol);
        one2onevpkucparentId.setDateCol(dateCol);
        one2onevpkucparentId.setCharCol(charCol);
        one2onevpkucparentId.setClobCol(clobCol);

        LOGGER.debug("Getting One2oneVpkUcParent with id: {}" , one2onevpkucparentId);
        One2oneVpkUcParent one2oneVpkUcParent = one2oneVpkUcParentService.getById(one2onevpkucparentId);
        LOGGER.debug("One2oneVpkUcParent details with id: {}" , one2oneVpkUcParent);

        return one2oneVpkUcParent;
    }



    @ApiOperation(value = "Updates the One2oneVpkUcParent instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2oneVpkUcParent editOne2oneVpkUcParent(@RequestParam("stringCol") String stringCol, @RequestParam("dateCol") LocalDateTime dateCol, @RequestParam("charCol") String charCol, @RequestParam("clobCol") String clobCol, @RequestBody One2oneVpkUcParent one2oneVpkUcParent) {

        one2oneVpkUcParent.setStringCol(stringCol);
        one2oneVpkUcParent.setDateCol(dateCol);
        one2oneVpkUcParent.setCharCol(charCol);
        one2oneVpkUcParent.setClobCol(clobCol);

        LOGGER.debug("One2oneVpkUcParent details with id is updated with: {}" , one2oneVpkUcParent);

        return one2oneVpkUcParentService.update(one2oneVpkUcParent);
    }

	@ApiOperation(value = "Partially updates the  One2oneVpkUcParent instance associated with the given composite-id.")
	@RequestMapping(value = "/composite-id", method = RequestMethod.PATCH)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2oneVpkUcParent patchOne2oneVpkUcParent(@RequestParam("stringCol") String stringCol, @RequestParam("dateCol") LocalDateTime dateCol, @RequestParam("charCol") String charCol, @RequestParam("clobCol") String clobCol, @RequestBody @MapTo(One2oneVpkUcParent.class) Map<String, Object> one2oneVpkUcParentPatch) {

        One2oneVpkUcParentId one2onevpkucparentId = new One2oneVpkUcParentId();
        one2onevpkucparentId.setStringCol(stringCol);
        one2onevpkucparentId.setDateCol(dateCol);
        one2onevpkucparentId.setCharCol(charCol);
        one2onevpkucparentId.setClobCol(clobCol);
        LOGGER.debug("Partially updating One2oneVpkUcParent with id: {}" , one2onevpkucparentId);

        One2oneVpkUcParent one2oneVpkUcParent = one2oneVpkUcParentService.partialUpdate(one2onevpkucparentId, one2oneVpkUcParentPatch);
        LOGGER.debug("One2oneVpkUcParent details after partial update: {}" , one2oneVpkUcParent);

        return one2oneVpkUcParent;
    }


    @ApiOperation(value = "Deletes the One2oneVpkUcParent instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteOne2oneVpkUcParent(@RequestParam("stringCol") String stringCol, @RequestParam("dateCol") LocalDateTime dateCol, @RequestParam("charCol") String charCol, @RequestParam("clobCol") String clobCol) {

        One2oneVpkUcParentId one2onevpkucparentId = new One2oneVpkUcParentId();
        one2onevpkucparentId.setStringCol(stringCol);
        one2onevpkucparentId.setDateCol(dateCol);
        one2onevpkucparentId.setCharCol(charCol);
        one2onevpkucparentId.setClobCol(clobCol);

        LOGGER.debug("Deleting One2oneVpkUcParent with id: {}" , one2onevpkucparentId);
        One2oneVpkUcParent one2oneVpkUcParent = one2oneVpkUcParentService.delete(one2onevpkucparentId);

        return one2oneVpkUcParent != null;
    }


    @RequestMapping(value = "/stringCol/{stringCol}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching One2oneVpkUcParent with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2oneVpkUcParent getByStringCol(@PathVariable("stringCol") String stringCol) {
        LOGGER.debug("Getting One2oneVpkUcParent with uniques key StringCol");
        return one2oneVpkUcParentService.getByStringCol(stringCol);
    }

    /**
     * @deprecated Use {@link #findOne2oneVpkUcParents(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of One2oneVpkUcParent instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<One2oneVpkUcParent> searchOne2oneVpkUcParentsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering One2oneVpkUcParents list by query filter:{}", (Object) queryFilters);
        return one2oneVpkUcParentService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of One2oneVpkUcParent instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<One2oneVpkUcParent> findOne2oneVpkUcParents(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering One2oneVpkUcParents list by filter:", query);
        return one2oneVpkUcParentService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of One2oneVpkUcParent instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<One2oneVpkUcParent> filterOne2oneVpkUcParents(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering One2oneVpkUcParents list by filter", query);
        return one2oneVpkUcParentService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportOne2oneVpkUcParents(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return one2oneVpkUcParentService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportOne2oneVpkUcParentsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = One2oneVpkUcParent.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> one2oneVpkUcParentService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of One2oneVpkUcParent instances matching the optional query (q) request param.")
	@RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countOne2oneVpkUcParents( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting One2oneVpkUcParents");
		return one2oneVpkUcParentService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getOne2oneVpkUcParentAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return one2oneVpkUcParentService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service One2oneVpkUcParentService instance
	 */
	protected void setOne2oneVpkUcParentService(One2oneVpkUcParentService service) {
		this.one2oneVpkUcParentService = service;
	}

}