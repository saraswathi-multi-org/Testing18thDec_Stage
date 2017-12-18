/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.wmstudio;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Many2oneCompChildId implements Serializable {

    private BigDecimal doubleId;
    private Byte byteId;
    private String charId;

    public BigDecimal getDoubleId() {
        return this.doubleId;
    }

    public void setDoubleId(BigDecimal doubleId) {
        this.doubleId = doubleId;
    }

    public Byte getByteId() {
        return this.byteId;
    }

    public void setByteId(Byte byteId) {
        this.byteId = byteId;
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
        if (!(o instanceof Many2oneCompChild)) return false;
        final Many2oneCompChild many2oneCompChild = (Many2oneCompChild) o;
        return Objects.equals(getDoubleId(), many2oneCompChild.getDoubleId()) &&
                Objects.equals(getByteId(), many2oneCompChild.getByteId()) &&
                Objects.equals(getCharId(), many2oneCompChild.getCharId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDoubleId(),
                getByteId(),
                getCharId());
    }
}
