/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratixrest.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;


/**
 *
 * @author wks12
 */
@Entity
@Table(name="cst_icms")
public class IcmsCst {
    
    private Integer id;
    private Integer code;
    private String description;
    private String acronym;
    private boolean mandatoryIcms;
    private boolean mandatoryPis;
    private boolean mandatoryCofins;
    private boolean mandatoryReducao;
    private Integer typeTribute;
    
    public IcmsCst(){
        
    }
    @Id
    @Column(name="id", unique=true, nullable=false)
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="code", nullable = false)
    @NotNull
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Column(name = "description", nullable = false, length = 100)
    @NotNull
    @Length(max=100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="acronym", nullable = false, length = 1)
    @NotNull
    @Length(max=1)
    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }
    
    @Column(name = "mandatory_icms")
    @NotNull
    public boolean getMandatoryIcms() {
        return mandatoryIcms;
    }

    public void setMandatoryIcms(boolean mandatoryIcms) {
        this.mandatoryIcms = mandatoryIcms;
    }
    
    @Column(name = "mandatory_pis")
    @NotNull
    public boolean getMandatoryPis() {
        return mandatoryPis;
    }

    public void setMandatoryPis(boolean mandatoryPis) {
        this.mandatoryPis = mandatoryPis;
    }
    
    @Column(name = "mandatory_cofins")
    @NotNull
    public boolean getMandatoryCofins() {
        return mandatoryCofins ;
    }

    public void setMandatoryCofins(boolean mandatoryCofins) {
        this.mandatoryCofins = mandatoryCofins;
    }
    
    @Column(name = "mandatory_reducao")
    @NotNull
    public boolean getMandatoryReducao() {
        return mandatoryReducao;
    }

    public void setMandatoryReducao(boolean mandatoryReducao) {
        this.mandatoryReducao = mandatoryReducao;
    }
    
//    @Column(name = "type_tribute")
//    @NotNull
//    public Integer gettypeTribute() {
//        return typeTribute;
//    }
//
//    public void setTypeTribute(Integer typeTribute) {
//        this.typeTribute = typeTribute;
//    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        final IcmsCst other = (IcmsCst) obj;
        if (!Objects.equals(this.getId(), other.getId())) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return this.description;
    }

    @Column(name = "type_tribute")
    @NotNull
    public Integer getTypeTribute() {
        return typeTribute;
    }

    /**
     * @param typeTribute the typeTribute to set
     */
    public void setTypeTribute(Integer typeTribute) {
        this.typeTribute = typeTribute;
    }
}
