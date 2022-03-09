/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.newtestdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Many2oneCompChild generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`Many2One_Comp_Child`")
public class Many2oneCompChild implements Serializable {

    private Short shortId;
    private Double floatCol;
    private String charCol;
    private String stringCol;
    private BigDecimal doubleCol;
    private Timestamp timestampCol;
    private Many2oneCompParent many2oneCompParent;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`SHORT ID`", nullable = false, scale = 0, precision = 5)
    public Short getShortId() {
        return this.shortId;
    }

    public void setShortId(Short shortId) {
        this.shortId = shortId;
    }

    @Column(name = "`FLOAT COL`", nullable = true, scale = 4, precision = 8)
    public Double getFloatCol() {
        return this.floatCol;
    }

    public void setFloatCol(Double floatCol) {
        this.floatCol = floatCol;
    }

    @Column(name = "`CHAR COL`", nullable = true, length = 1)
    public String getCharCol() {
        return this.charCol;
    }

    public void setCharCol(String charCol) {
        this.charCol = charCol;
    }

    @Column(name = "`STRING COL`", nullable = true, length = 50)
    public String getStringCol() {
        return this.stringCol;
    }

    public void setStringCol(String stringCol) {
        this.stringCol = stringCol;
    }

    @Column(name = "`DOUBLE COL`", nullable = true, scale = 8, precision = 18)
    public BigDecimal getDoubleCol() {
        return this.doubleCol;
    }

    public void setDoubleCol(BigDecimal doubleCol) {
        this.doubleCol = doubleCol;
    }

    @Column(name = "`TIMESTAMP COL`", nullable = true)
    public Timestamp getTimestampCol() {
        return this.timestampCol;
    }

    public void setTimestampCol(Timestamp timestampCol) {
        this.timestampCol = timestampCol;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns(value = {
            @JoinColumn(name = "`FLOAT COL`", referencedColumnName = "`FLOAT ID`", insertable = false, updatable = false),
            @JoinColumn(name = "`CHAR COL`", referencedColumnName = "`CHAR ID`", insertable = false, updatable = false),
            @JoinColumn(name = "`STRING COL`", referencedColumnName = "`STRING ID`", insertable = false, updatable = false),
            @JoinColumn(name = "`DOUBLE COL`", referencedColumnName = "`DOUBLE COL`", insertable = false, updatable = false)},
        foreignKey = @ForeignKey(name = "`FK_Many2One_Comp_Child_TkQvrH`"))
    @Fetch(FetchMode.JOIN)
    public Many2oneCompParent getMany2oneCompParent() {
        return this.many2oneCompParent;
    }

    public void setMany2oneCompParent(Many2oneCompParent many2oneCompParent) {
        if(many2oneCompParent != null) {
            this.floatCol = many2oneCompParent.getFloatId();
            this.charCol = many2oneCompParent.getCharId();
            this.stringCol = many2oneCompParent.getStringId();
            this.doubleCol = many2oneCompParent.getDoubleCol();
        }

        this.many2oneCompParent = many2oneCompParent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Many2oneCompChild)) return false;
        final Many2oneCompChild many2oneCompChild = (Many2oneCompChild) o;
        return Objects.equals(getShortId(), many2oneCompChild.getShortId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShortId());
    }
}