/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.wmstudio;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * One2oneUcChild generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`One2One_UC_Child`", uniqueConstraints = {
            @UniqueConstraint(name = "`UK_One2One_UC_Child_Byte_Col`", columnNames = {"`Byte Col`"})})
public class One2oneUcChild implements Serializable {

    private String emailId;
    private Byte byteCol;
    private String booleanCol;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] blobCol;
    private One2oneChild one2oneChild;
    private One2oneUcChild1 one2oneUcChild1;

    @Id
    @Column(name = "`Email ID`", nullable = false, length = 20)
    public String getEmailId() {
        return this.emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Column(name = "`Byte Col`", nullable = true, scale = 0, precision = 2)
    public Byte getByteCol() {
        return this.byteCol;
    }

    public void setByteCol(Byte byteCol) {
        this.byteCol = byteCol;
    }

    @Column(name = "`Boolean Col`", nullable = true, length = 1)
    public String getBooleanCol() {
        return this.booleanCol;
    }

    public void setBooleanCol(String booleanCol) {
        this.booleanCol = booleanCol;
    }

    @Column(name = "`Blob Col`", nullable = true)
    public byte[] getBlobCol() {
        return this.blobCol;
    }

    public void setBlobCol(byte[] blobCol) {
        this.blobCol = blobCol;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`Byte Col`", referencedColumnName = "`Byte PK`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_One2One_UC_Child_TO_OIIGzz`"))
    @Fetch(FetchMode.JOIN)
    public One2oneChild getOne2oneChild() {
        return this.one2oneChild;
    }

    public void setOne2oneChild(One2oneChild one2oneChild) {
        if(one2oneChild != null) {
            this.byteCol = one2oneChild.getBytePk();
        }

        this.one2oneChild = one2oneChild;
    }
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "one2oneUcChild")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.REMOVE})
    public One2oneUcChild1 getOne2oneUcChild1() {
        return this.one2oneUcChild1;
    }

    public void setOne2oneUcChild1(One2oneUcChild1 one2oneUcChild1) {
        this.one2oneUcChild1 = one2oneUcChild1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof One2oneUcChild)) return false;
        final One2oneUcChild one2oneUcChild = (One2oneUcChild) o;
        return Objects.equals(getEmailId(), one2oneUcChild.getEmailId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmailId());
    }
}