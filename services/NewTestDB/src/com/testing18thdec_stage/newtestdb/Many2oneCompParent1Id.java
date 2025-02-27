/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.newtestdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class Many2oneCompParent1Id implements Serializable {

    private Long bigintPk;
    private String stringPk;
    private Boolean booleanPk;
    private String charPk;

    public Long getBigintPk() {
        return this.bigintPk;
    }

    public void setBigintPk(Long bigintPk) {
        this.bigintPk = bigintPk;
    }

    public String getStringPk() {
        return this.stringPk;
    }

    public void setStringPk(String stringPk) {
        this.stringPk = stringPk;
    }

    public Boolean getBooleanPk() {
        return this.booleanPk;
    }

    public void setBooleanPk(Boolean booleanPk) {
        this.booleanPk = booleanPk;
    }

    public String getCharPk() {
        return this.charPk;
    }

    public void setCharPk(String charPk) {
        this.charPk = charPk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Many2oneCompParent1)) return false;
        final Many2oneCompParent1 many2oneCompParent1 = (Many2oneCompParent1) o;
        return Objects.equals(getBigintPk(), many2oneCompParent1.getBigintPk()) &&
                Objects.equals(getStringPk(), many2oneCompParent1.getStringPk()) &&
                Objects.equals(getBooleanPk(), many2oneCompParent1.getBooleanPk()) &&
                Objects.equals(getCharPk(), many2oneCompParent1.getCharPk());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBigintPk(),
                getStringPk(),
                getBooleanPk(),
                getCharPk());
    }
}