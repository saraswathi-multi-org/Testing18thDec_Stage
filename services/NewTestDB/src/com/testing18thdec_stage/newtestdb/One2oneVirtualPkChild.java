/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.newtestdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * One2oneVirtualPkChild generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`One2One_VirtualPK_Child`")
@IdClass(One2oneVirtualPkChildId.class)
public class One2oneVirtualPkChild implements Serializable {

    private String charPkId;
    private String stringCol1;
    private String stringCol2;
    private String charCol;

    @Id
    @Column(name = "`Char PK ID`", nullable = true, length = 1)
    public String getCharPkId() {
        return this.charPkId;
    }

    public void setCharPkId(String charPkId) {
        this.charPkId = charPkId;
    }

    @Id
    @Column(name = "`StringCol1`", nullable = false, length = 25)
    public String getStringCol1() {
        return this.stringCol1;
    }

    public void setStringCol1(String stringCol1) {
        this.stringCol1 = stringCol1;
    }

    @Id
    @Column(name = "`StringCol2`", nullable = false, length = 25)
    public String getStringCol2() {
        return this.stringCol2;
    }

    public void setStringCol2(String stringCol2) {
        this.stringCol2 = stringCol2;
    }

    @Id
    @Column(name = "`CharCol`", nullable = false, length = 1)
    public String getCharCol() {
        return this.charCol;
    }

    public void setCharCol(String charCol) {
        this.charCol = charCol;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof One2oneVirtualPkChild)) return false;
        final One2oneVirtualPkChild one2oneVirtualPkChild = (One2oneVirtualPkChild) o;
        return Objects.equals(getCharPkId(), one2oneVirtualPkChild.getCharPkId()) &&
                Objects.equals(getStringCol1(), one2oneVirtualPkChild.getStringCol1()) &&
                Objects.equals(getStringCol2(), one2oneVirtualPkChild.getStringCol2()) &&
                Objects.equals(getCharCol(), one2oneVirtualPkChild.getCharCol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCharPkId(),
                getStringCol1(),
                getStringCol2(),
                getCharCol());
    }
}