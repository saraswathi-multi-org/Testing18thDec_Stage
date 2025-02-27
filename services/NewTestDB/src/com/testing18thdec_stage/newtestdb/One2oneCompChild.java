/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.newtestdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * One2oneCompChild generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`One2One_Comp_Child`")
@IdClass(One2oneCompParentId.class)
public class One2oneCompChild implements Serializable {

    private Short byteId;
    private Double floatId;
    private String charId;
    private String stringId;
    private Boolean booleanCol;
    private BigDecimal bigdecCol;
    private One2oneCompParent one2oneCompParent;

    @Id
    @Column(name = "`BYTE COL`", nullable = false, scale = 0, precision = 3)
    public Short getByteId() {
        return this.byteId;
    }

    public void setByteId(Short byteId) {
        this.byteId = byteId;
    }

    @Id
    @Column(name = "`FLOAT COL`", nullable = false, scale = 4, precision = 8)
    public Double getFloatId() {
        return this.floatId;
    }

    public void setFloatId(Double floatId) {
        this.floatId = floatId;
    }

    @Id
    @Column(name = "`CHAR COL`", nullable = false, length = 1)
    public String getCharId() {
        return this.charId;
    }

    public void setCharId(String charId) {
        this.charId = charId;
    }

    @Id
    @Column(name = "`STRING COL`", nullable = false, length = 20)
    public String getStringId() {
        return this.stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
    }

    @Column(name = "`BOOLEAN COL`", nullable = true)
    public Boolean getBooleanCol() {
        return this.booleanCol;
    }

    public void setBooleanCol(Boolean booleanCol) {
        this.booleanCol = booleanCol;
    }

    @Column(name = "`BIGDEC COL`", nullable = true, scale = 15, precision = 35)
    public BigDecimal getBigdecCol() {
        return this.bigdecCol;
    }

    public void setBigdecCol(BigDecimal bigdecCol) {
        this.bigdecCol = bigdecCol;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumns(value = {
            @JoinColumn(name = "`BYTE COL`", referencedColumnName = "`BYTE ID`", insertable = false, updatable = false),
            @JoinColumn(name = "`CHAR COL`", referencedColumnName = "`CHAR ID`", insertable = false, updatable = false),
            @JoinColumn(name = "`STRING COL`", referencedColumnName = "`STRING ID`", insertable = false, updatable = false),
            @JoinColumn(name = "`FLOAT COL`", referencedColumnName = "`FLOAT ID`", insertable = false, updatable = false)},
        foreignKey = @ForeignKey(name = "`FK_One2One_Comp_Child_TOYxbW7`"))
    @Fetch(FetchMode.JOIN)
    public One2oneCompParent getOne2oneCompParent() {
        return this.one2oneCompParent;
    }

    public void setOne2oneCompParent(One2oneCompParent one2oneCompParent) {
        if(one2oneCompParent != null) {
            this.byteId = one2oneCompParent.getByteId();
            this.charId = one2oneCompParent.getCharId();
            this.stringId = one2oneCompParent.getStringId();
            this.floatId = one2oneCompParent.getFloatId();
        }

        this.one2oneCompParent = one2oneCompParent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof One2oneCompChild)) return false;
        final One2oneCompChild one2oneCompChild = (One2oneCompChild) o;
        return Objects.equals(getByteId(), one2oneCompChild.getByteId()) &&
                Objects.equals(getFloatId(), one2oneCompChild.getFloatId()) &&
                Objects.equals(getCharId(), one2oneCompChild.getCharId()) &&
                Objects.equals(getStringId(), one2oneCompChild.getStringId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getByteId(),
                getFloatId(),
                getCharId(),
                getStringId());
    }
}