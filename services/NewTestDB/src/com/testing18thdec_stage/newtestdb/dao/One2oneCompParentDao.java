/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.newtestdb.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;
import com.wavemaker.runtime.data.dao.query.types.wmql.WMQLTypeHelper;

import com.testing18thdec_stage.newtestdb.One2oneCompParent;
import com.testing18thdec_stage.newtestdb.One2oneCompParentId;

/**
 * Specifies methods used to obtain and modify One2oneCompParent related information
 * which is stored in the database.
 */
@Repository("NewTestDB.One2oneCompParentDao")
public class One2oneCompParentDao extends WMGenericDaoImpl<One2oneCompParent, One2oneCompParentId> {

    @Autowired
    @Qualifier("NewTestDBTemplate")
    private HibernateTemplate template;

    @Autowired
    @Qualifier("NewTestDBWMQLTypeHelper")
    private WMQLTypeHelper wmqlTypeHelper;


    @Override
    public HibernateTemplate getTemplate() {
        return this.template;
    }

    @Override
    public WMQLTypeHelper getWMQLTypeHelper() {
        return this.wmqlTypeHelper;
    }

}