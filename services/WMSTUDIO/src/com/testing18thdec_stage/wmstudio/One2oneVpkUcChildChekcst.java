/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing18thdec_stage.wmstudio;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * One2oneVpkUcChildChekcst generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`ONE2ONE_VPK_UC_CHILD_CHEKCST`")
@IdClass(One2oneVpkUcChildChekcstId.class)
public class One2oneVpkUcChildChekcst implements Serializable {

    private String characterCol;
    private Double floatCol;
    private BigInteger smallintCol;
    private String stringCol;
    private BigInteger integerCol;

    @Id
    @Column(name = "`CHARACTER_COL`", nullable = true, length = 1)
    public String getCharacterCol() {
        return this.characterCol;
    }

    public void setCharacterCol(String characterCol) {
        this.characterCol = characterCol;
    }

    @Id
    @Column(name = "`FLOAT_COL`", nullable = true, scale = 4, precision = 8)
    public Double getFloatCol() {
        return this.floatCol;
    }

    public void setFloatCol(Double floatCol) {
        this.floatCol = floatCol;
    }

    @Id
    @Column(name = "`SMALLINT_COL`", nullable = true, scale = 0, precision = 38)
    public BigInteger getSmallintCol() {
        return this.smallintCol;
    }

    public void setSmallintCol(BigInteger smallintCol) {
        this.smallintCol = smallintCol;
    }

    @Id
    @Column(name = "`STRING_COL`", nullable = true, length = 20)
    public String getStringCol() {
        return this.stringCol;
    }

    public void setStringCol(String stringCol) {
        this.stringCol = stringCol;
    }

    @Id
    @Column(name = "`INTEGER_COL`", nullable = true, scale = 0, precision = 38)
    public BigInteger getIntegerCol() {
        return this.integerCol;
    }

    public void setIntegerCol(BigInteger integerCol) {
        this.integerCol = integerCol;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof One2oneVpkUcChildChekcst)) return false;
        final One2oneVpkUcChildChekcst one2oneVpkUcChildChekcst = (One2oneVpkUcChildChekcst) o;
        return Objects.equals(getCharacterCol(), one2oneVpkUcChildChekcst.getCharacterCol()) &&
                Objects.equals(getFloatCol(), one2oneVpkUcChildChekcst.getFloatCol()) &&
                Objects.equals(getSmallintCol(), one2oneVpkUcChildChekcst.getSmallintCol()) &&
                Objects.equals(getStringCol(), one2oneVpkUcChildChekcst.getStringCol()) &&
                Objects.equals(getIntegerCol(), one2oneVpkUcChildChekcst.getIntegerCol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCharacterCol(),
                getFloatCol(),
                getSmallintCol(),
                getStringCol(),
                getIntegerCol());
    }
}

