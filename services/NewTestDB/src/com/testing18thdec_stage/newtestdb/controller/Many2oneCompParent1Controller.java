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

import com.testing18thdec_stage.newtestdb.Many2oneCompChild1;
import com.testing18thdec_stage.newtestdb.Many2oneCompParent1;
import com.testing18thdec_stage.newtestdb.Many2oneCompParent1Id;
import com.testing18thdec_stage.newtestdb.service.Many2oneCompParent1Service;


/**
 * Controller object for domain model class Many2oneCompParent1.
 * @see Many2oneCompParent1
 */
@RestController("NewTestDB.Many2oneCompParent1Controller")
@Api(value = "Many2oneCompParent1Controller", description = "Exposes APIs to work with Many2oneCompParent1 resource.")
@RequestMapping("/NewTestDB/Many2oneCompParent1")
public class Many2oneCompParent1Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Many2oneCompParent1Controller.class);

    @Autowired
	@Qualifier("NewTestDB.Many2oneCompParent1Service")
	private Many2oneCompParent1Service many2oneCompParent1Service;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new Many2oneCompParent1 instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Many2oneCompParent1 createMany2oneCompParent1(@RequestBody Many2oneCompParent1 many2oneCompParent1) {
		LOGGER.debug("Create Many2oneCompParent1 with information: {}" , many2oneCompParent1);

		many2oneCompParent1 = many2oneCompParent1Service.create(many2oneCompParent1);
		LOGGER.debug("Created Many2oneCompParent1 with information: {}" , many2oneCompParent1);

	    return many2oneCompParent1;
	}

    @ApiOperation(value = "Returns the Many2oneCompParent1 instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Many2oneCompParent1 getMany2oneCompParent1(@RequestParam("bigintPk") Long bigintPk, @RequestParam("stringPk") String stringPk, @RequestParam("booleanPk") Boolean booleanPk, @RequestParam("charPk") String charPk) {

        Many2oneCompParent1Id many2onecompparent1Id = new Many2oneCompParent1Id();
        many2onecompparent1Id.setBigintPk(bigintPk);
        many2onecompparent1Id.setStringPk(stringPk);
        many2onecompparent1Id.setBooleanPk(booleanPk);
        many2onecompparent1Id.setCharPk(charPk);

        LOGGER.debug("Getting Many2oneCompParent1 with id: {}" , many2onecompparent1Id);
        Many2oneCompParent1 many2oneCompParent1 = many2oneCompParent1Service.getById(many2onecompparent1Id);
        LOGGER.debug("Many2oneCompParent1 details with id: {}" , many2oneCompParent1);

        return many2oneCompParent1;
    }



    @ApiOperation(value = "Updates the Many2oneCompParent1 instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Many2oneCompParent1 editMany2oneCompParent1(@RequestParam("bigintPk") Long bigintPk, @RequestParam("stringPk") String stringPk, @RequestParam("booleanPk") Boolean booleanPk, @RequestParam("charPk") String charPk, @RequestBody Many2oneCompParent1 many2oneCompParent1) {

        many2oneCompParent1.setBigintPk(bigintPk);
        many2oneCompParent1.setStringPk(stringPk);
        many2oneCompParent1.setBooleanPk(booleanPk);
        many2oneCompParent1.setCharPk(charPk);

        LOGGER.debug("Many2oneCompParent1 details with id is updated with: {}" , many2oneCompParent1);

        return many2oneCompParent1Service.update(many2oneCompParent1);
    }

	@ApiOperation(value = "Partially updates the  Many2oneCompParent1 instance associated with the given composite-id.")
	@RequestMapping(value = "/composite-id", method = RequestMethod.PATCH)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Many2oneCompParent1 patchMany2oneCompParent1(@RequestParam("bigintPk") Long bigintPk, @RequestParam("stringPk") String stringPk, @RequestParam("booleanPk") Boolean booleanPk, @RequestParam("charPk") String charPk, @RequestBody @MapTo(Many2oneCompParent1.class) Map<String, Object> many2oneCompParent1Patch) {

        Many2oneCompParent1Id many2onecompparent1Id = new Many2oneCompParent1Id();
        many2onecompparent1Id.setBigintPk(bigintPk);
        many2onecompparent1Id.setStringPk(stringPk);
        many2onecompparent1Id.setBooleanPk(booleanPk);
        many2onecompparent1Id.setCharPk(charPk);
        LOGGER.debug("Partially updating Many2oneCompParent1 with id: {}" , many2onecompparent1Id);

        Many2oneCompParent1 many2oneCompParent1 = many2oneCompParent1Service.partialUpdate(many2onecompparent1Id, many2oneCompParent1Patch);
        LOGGER.debug("Many2oneCompParent1 details after partial update: {}" , many2oneCompParent1);

        return many2oneCompParent1;
    }


    @ApiOperation(value = "Deletes the Many2oneCompParent1 instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteMany2oneCompParent1(@RequestParam("bigintPk") Long bigintPk, @RequestParam("stringPk") String stringPk, @RequestParam("booleanPk") Boolean booleanPk, @RequestParam("charPk") String charPk) {

        Many2oneCompParent1Id many2onecompparent1Id = new Many2oneCompParent1Id();
        many2onecompparent1Id.setBigintPk(bigintPk);
        many2onecompparent1Id.setStringPk(stringPk);
        many2onecompparent1Id.setBooleanPk(booleanPk);
        many2onecompparent1Id.setCharPk(charPk);

        LOGGER.debug("Deleting Many2oneCompParent1 with id: {}" , many2onecompparent1Id);
        Many2oneCompParent1 many2oneCompParent1 = many2oneCompParent1Service.delete(many2onecompparent1Id);

        return many2oneCompParent1 != null;
    }


    /**
     * @deprecated Use {@link #findMany2oneCompParent1s(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Many2oneCompParent1 instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Many2oneCompParent1> searchMany2oneCompParent1sByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Many2oneCompParent1s list by query filter:{}", (Object) queryFilters);
        return many2oneCompParent1Service.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Many2oneCompParent1 instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Many2oneCompParent1> findMany2oneCompParent1s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Many2oneCompParent1s list by filter:", query);
        return many2oneCompParent1Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Many2oneCompParent1 instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Many2oneCompParent1> filterMany2oneCompParent1s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Many2oneCompParent1s list by filter", query);
        return many2oneCompParent1Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param.")
    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportMany2oneCompParent1s(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return many2oneCompParent1Service.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportMany2oneCompParent1sAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = Many2oneCompParent1.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> many2oneCompParent1Service.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of Many2oneCompParent1 instances matching the optional query (q) request param.")
	@RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countMany2oneCompParent1s( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Many2oneCompParent1s");
		return many2oneCompParent1Service.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getMany2oneCompParent1AggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return many2oneCompParent1Service.getAggregatedValues(aggregationInfo, pageable);
    }

    @RequestMapping(value="/composite-id/many2oneCompChild1s", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the many2oneCompChild1s instance associated with the given composite-id.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Many2oneCompChild1> findAssociatedMany2oneCompChild1s(@RequestParam("bigintPk") Long bigintPk, @RequestParam("stringPk") String stringPk, @RequestParam("booleanPk") Boolean booleanPk, @RequestParam("charPk") String charPk, Pageable pageable) {

        LOGGER.debug("Fetching all associated many2oneCompChild1s");
        return many2oneCompParent1Service.findAssociatedMany2oneCompChild1s(bigintPk, stringPk, booleanPk, charPk, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Many2oneCompParent1Service instance
	 */
	protected void setMany2oneCompParent1Service(Many2oneCompParent1Service service) {
		this.many2oneCompParent1Service = service;
	}

}