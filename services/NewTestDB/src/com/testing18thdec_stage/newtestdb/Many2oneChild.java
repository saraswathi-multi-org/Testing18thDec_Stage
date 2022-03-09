/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.newtestdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

 
import java.time.LocalDateTime;

/**
 * Many2oneChild generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`Many2One_Child`")
public class Many2oneChild implements Serializable {

    private Integer byteid;
    private Date datecol;
    private String stringcol;
     
    private LocalDateTime datetimecol;
    private Many2oneParent many2oneParent;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`BYTEID`", nullable = false, scale = 0, precision = 10)
    public Integer getByteid() {
        return this.byteid;
    }

    public void setByteid(Integer byteid) {
        this.byteid = byteid;
    }

    @Column(name = "`DATECOL`", nullable = true)
    public Date getDatecol() {
        return this.datecol;
    }

    public void setDatecol(Date datecol) {
        this.datecol = datecol;
    }

    @Column(name = "`STRINGCOL`", nullable = true, length = 20)
    public String getStringcol() {
        return this.stringcol;
    }

    public void setStringcol(String stringcol) {
        this.stringcol = stringcol;
    }

    @Column(name = "`DATETIMECOL`", nullable = true)
    public LocalDateTime getDatetimecol() {
        return this.datetimecol;
    }

    public void setDatetimecol(LocalDateTime datetimecol) {
        this.datetimecol = datetimecol;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`STRINGCOL`", referencedColumnName = "`STRING ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_Many2One_Child_TO_Many0DNi`"))
    public Many2oneParent getMany2oneParent() {
        return this.many2oneParent;
    }

    public void setMany2oneParent(Many2oneParent many2oneParent) {
        if(many2oneParent != null) {
            this.stringcol = many2oneParent.getStringId();
        }

        this.many2oneParent = many2oneParent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Many2oneChild)) return false;
        final Many2oneChild many2oneChild = (Many2oneChild) o;
        return Objects.equals(getByteid(), many2oneChild.getByteid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getByteid());
    }
}

