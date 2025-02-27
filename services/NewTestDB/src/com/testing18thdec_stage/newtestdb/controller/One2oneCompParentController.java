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

import com.testing18thdec_stage.newtestdb.One2oneCompParent;
import com.testing18thdec_stage.newtestdb.One2oneCompParentId;
import com.testing18thdec_stage.newtestdb.service.One2oneCompParentService;


/**
 * Controller object for domain model class One2oneCompParent.
 * @see One2oneCompParent
 */
@RestController("NewTestDB.One2oneCompParentController")
@Api(value = "One2oneCompParentController", description = "Exposes APIs to work with One2oneCompParent resource.")
@RequestMapping("/NewTestDB/One2oneCompParent")
public class One2oneCompParentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(One2oneCompParentController.class);

    @Autowired
	@Qualifier("NewTestDB.One2oneCompParentService")
	private One2oneCompParentService one2oneCompParentService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new One2oneCompParent instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2oneCompParent createOne2oneCompParent(@RequestBody One2oneCompParent one2oneCompParent) {
		LOGGER.debug("Create One2oneCompParent with information: {}" , one2oneCompParent);

		one2oneCompParent = one2oneCompParentService.create(one2oneCompParent);
		LOGGER.debug("Created One2oneCompParent with information: {}" , one2oneCompParent);

	    return one2oneCompParent;
	}

    @ApiOperation(value = "Returns the One2oneCompParent instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2oneCompParent getOne2oneCompParent(@RequestParam("stringId") String stringId, @RequestParam("byteId") Short byteId, @RequestParam("floatId") Double floatId, @RequestParam("charId") String charId) {

        One2oneCompParentId one2onecompparentId = new One2oneCompParentId();
        one2onecompparentId.setStringId(stringId);
        one2onecompparentId.setByteId(byteId);
        one2onecompparentId.setFloatId(floatId);
        one2onecompparentId.setCharId(charId);

        LOGGER.debug("Getting One2oneCompParent with id: {}" , one2onecompparentId);
        One2oneCompParent one2oneCompParent = one2oneCompParentService.getById(one2onecompparentId);
        LOGGER.debug("One2oneCompParent details with id: {}" , one2oneCompParent);

        return one2oneCompParent;
    }



    @ApiOperation(value = "Updates the One2oneCompParent instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2oneCompParent editOne2oneCompParent(@RequestParam("stringId") String stringId, @RequestParam("byteId") Short byteId, @RequestParam("floatId") Double floatId, @RequestParam("charId") String charId, @RequestBody One2oneCompParent one2oneCompParent) {

        one2oneCompParent.setStringId(stringId);
        one2oneCompParent.setByteId(byteId);
        one2oneCompParent.setFloatId(floatId);
        one2oneCompParent.setCharId(charId);

        LOGGER.debug("One2oneCompParent details with id is updated with: {}" , one2oneCompParent);

        return one2oneCompParentService.update(one2oneCompParent);
    }

	@ApiOperation(value = "Partially updates the  One2oneCompParent instance associated with the given composite-id.")
	@RequestMapping(value = "/composite-id", method = RequestMethod.PATCH)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public One2oneCompParent patchOne2oneCompParent(@RequestParam("stringId") String stringId, @RequestParam("byteId") Short byteId, @RequestParam("floatId") Double floatId, @RequestParam("charId") String charId, @RequestBody @MapTo(One2oneCompParent.class) Map<String, Object> one2oneCompParentPatch) {

        One2oneCompParentId one2onecompparentId = new One2oneCompParentId();
        one2onecompparentId.setStringId(stringId);
        one2onecompparentId.setByteId(byteId);
        one2onecompparentId.setFloatId(floatId);
        one2onecompparentId.setCharId(charId);
        LOGGER.debug("Partially updating One2oneCompParent with id: {}" , one2onecompparentId);

        One2oneCompParent one2oneCompParent = one2oneCompParentService.partialUpdate(one2onecompparentId, one2oneCompParentPatch);
        LOGGER.debug("One2oneCompParent details after partial update: {}" , one2oneCompParent);

        return one2oneCompParent;
    }


    @ApiOperation(value = "Deletes the One2oneCompParent instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteOne2oneCompParent(@RequestParam("stringId") String stringId, @RequestParam("byteId") Short byteId, @RequestParam("floatId") Double floatId, @RequestParam("charId") String charId) {

        One2oneCompParentId one2onecompparentId = new One2oneCompParentId();
        one2onecompparentId.setStringId(stringId);
        one2onecompparentId.setByteId(byteId);
        one2onecompparentId.setFloatId(floatId);
        one2onecompparentId.setCharId(charId);

        LOGGER.debug("Deleting One2oneCompParent with id: {}" , one2onecompparentId);
        One2oneCompParent one2oneCompParent = one2oneCompParentService.delete(one2onecompparentId);

        return one2oneCompParent != null;
    }


    /**
     * @deprecated Use {@link #findOne2oneCompParents(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of One2oneCompParent instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<One2oneCompParent> searchOne2oneCompParentsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering One2oneCompParents list by query filter:{}", (Object) queryFilters);
        return one2oneCompParentService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of One2oneCompParent instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<One2oneCompParent> findOne2oneCompParents(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering One2oneCompParents list by filter:", query);
        return one2oneCompParentService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of One2oneCompParent instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<One2oneCompParent> filterOne2oneCompParents(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering One2oneCompParents list by filter", query);
        return one2oneCompParentService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportOne2oneCompParents(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return one2oneCompParentService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportOne2oneCompParentsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = One2oneCompParent.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> one2oneCompParentService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of One2oneCompParent instances matching the optional query (q) request param.")
	@RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countOne2oneCompParents( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting One2oneCompParents");
		return one2oneCompParentService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getOne2oneCompParentAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return one2oneCompParentService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service One2oneCompParentService instance
	 */
	protected void setOne2oneCompParentService(One2oneCompParentService service) {
		this.one2oneCompParentService = service;
	}

}