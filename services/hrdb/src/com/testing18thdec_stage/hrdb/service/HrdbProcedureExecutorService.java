/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.hrdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import com.testing18thdec_stage.hrdb.models.procedure.*;

public interface HrdbProcedureExecutorService {

    ProcedureCreateEmptyBlockResponse executeProcedure_CreateEmptyBlock(Integer baddr, Integer bcount);

}