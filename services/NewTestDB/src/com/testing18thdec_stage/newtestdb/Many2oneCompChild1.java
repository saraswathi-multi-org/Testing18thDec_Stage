/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.newtestdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * Many2oneCompChild1 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`Many2One_Comp_Child1`")
@IdClass(Many2oneCompChild1Id.class)
public class Many2oneCompChild1 implements Serializable {

    private String stringId;
    private Long bigintId;
    private String charId;
    private Boolean booleanId;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] blobCol;
    private Many2oneCompParent1 many2oneCompParent1;

    @Id
    @Column(name = "`STRING ID`", nullable = false, length = 255)
    public String getStringId() {
        return this.stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
    }

    @Id
    @Column(name = "`BIGINT ID`", nullable = false, scale = 0, precision = 19)
    public Long getBigintId() {
        return this.bigintId;
    }

    public void setBigintId(Long bigintId) {
        this.bigintId = bigintId;
    }

    @Column(name = "`CHAR ID`", nullable = true, length = 1)
    public String getCharId() {
        return this.charId;
    }

    public void setCharId(String charId) {
        this.charId = charId;
    }

    @Column(name = "`BOOLEAN ID`", nullable = true)
    public Boolean getBooleanId() {
        return this.booleanId;
    }

    public void setBooleanId(Boolean booleanId) {
        this.booleanId = booleanId;
    }

    @Column(name = "`BLOB COL`", nullable = true)
    public byte[] getBlobCol() {
        return this.blobCol;
    }

    public void setBlobCol(byte[] blobCol) {
        this.blobCol = blobCol;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns(value = {
            @JoinColumn(name = "`STRING ID`", referencedColumnName = "`STRING PK`", insertable = false, updatable = false),
            @JoinColumn(name = "`BIGINT ID`", referencedColumnName = "`BIGINT PK`", insertable = false, updatable = false),
            @JoinColumn(name = "`CHAR ID`", referencedColumnName = "`CHAR PK`", insertable = false, updatable = false),
            @JoinColumn(name = "`BOOLEAN ID`", referencedColumnName = "`BOOLEAN PK`", insertable = false, updatable = false)},
        foreignKey = @ForeignKey(name = "`FK_Many2One_Comp_Child1_bw74x`"))
    public Many2oneCompParent1 getMany2oneCompParent1() {
        return this.many2oneCompParent1;
    }

    public void setMany2oneCompParent1(Many2oneCompParent1 many2oneCompParent1) {
        if(many2oneCompParent1 != null) {
            this.stringId = many2oneCompParent1.getStringPk();
            this.bigintId = many2oneCompParent1.getBigintPk();
            this.charId = many2oneCompParent1.getCharPk();
            this.booleanId = many2oneCompParent1.getBooleanPk();
        }

        this.many2oneCompParent1 = many2oneCompParent1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Many2oneCompChild1)) return false;
        final Many2oneCompChild1 many2oneCompChild1 = (Many2oneCompChild1) o;
        return Objects.equals(getStringId(), many2oneCompChild1.getStringId()) &&
                Objects.equals(getBigintId(), many2oneCompChild1.getBigintId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStringId(),
                getBigintId());
    }
}

