/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.newtestdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class One2oneCompParentId implements Serializable {

    private String stringId;
    private Short byteId;
    private Double floatId;
    private String charId;

    public String getStringId() {
        return this.stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
    }

    public Short getByteId() {
        return this.byteId;
    }

    public void setByteId(Short byteId) {
        this.byteId = byteId;
    }

    public Double getFloatId() {
        return this.floatId;
    }

    public void setFloatId(Double floatId) {
        this.floatId = floatId;
    }

    public String getCharId() {
        return this.charId;
    }

    public void setCharId(String charId) {
        this.charId = charId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof One2oneCompParent)) return false;
        final One2oneCompParent one2oneCompParent = (One2oneCompParent) o;
        return Objects.equals(getStringId(), one2oneCompParent.getStringId()) &&
                Objects.equals(getByteId(), one2oneCompParent.getByteId()) &&
                Objects.equals(getFloatId(), one2oneCompParent.getFloatId()) &&
                Objects.equals(getCharId(), one2oneCompParent.getCharId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStringId(),
                getByteId(),
                getFloatId(),
                getCharId());
    }
}