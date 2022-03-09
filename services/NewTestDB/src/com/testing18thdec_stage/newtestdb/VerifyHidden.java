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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

 
import java.time.LocalDateTime;

/**
 * VerifyHidden generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`VERIFY_HIDDEN`", uniqueConstraints = {
        @UniqueConstraint(name = "`UK_VERIFY_HIDDEN_INTCOL2DBDEF`", columnNames = {"`INTCOL2DBDEF`"})})
public class VerifyHidden implements Serializable {

    private Integer pkcol;
    private Integer intcol2dbdef;
    private Integer intcoladdDbdef;
     
    private LocalDateTime expires;

    @Id
    @Column(name = "`PKCOL`", nullable = false, scale = 0, precision = 10)
    public Integer getPkcol() {
        return this.pkcol;
    }

    public void setPkcol(Integer pkcol) {
        this.pkcol = pkcol;
    }

    @Column(name = "`INTCOL2DBDEF`", nullable = true, scale = 0, precision = 10)
    public Integer getIntcol2dbdef() {
        return this.intcol2dbdef;
    }

    public void setIntcol2dbdef(Integer intcol2dbdef) {
        this.intcol2dbdef = intcol2dbdef;
    }

    @Column(name = "`INTCOLADD_DBDEF`", nullable = true, scale = 0, precision = 10)
    public Integer getIntcoladdDbdef() {
        return this.intcoladdDbdef;
    }

    public void setIntcoladdDbdef(Integer intcoladdDbdef) {
        this.intcoladdDbdef = intcoladdDbdef;
    }

    @Column(name = "`expires`", nullable = true)
    public LocalDateTime getExpires() {
        return this.expires;
    }

    public void setExpires(LocalDateTime expires) {
        this.expires = expires;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VerifyHidden)) return false;
        final VerifyHidden verifyHidden = (VerifyHidden) o;
        return Objects.equals(getPkcol(), verifyHidden.getPkcol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPkcol());
    }
}

