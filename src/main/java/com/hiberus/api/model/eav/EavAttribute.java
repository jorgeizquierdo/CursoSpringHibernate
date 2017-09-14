package com.hiberus.api.model.eav;

import javax.persistence.*;

/**
 * Created by Jorge Izquierdo Bueno
 */
@Entity(name = "eavAttribute")
@Table(name = "eav_attribute")
public class EavAttribute {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @ManyToOne
    @JoinColumn(name = "attribute_type_id")
    private EavAttributeType eavAttributeType;

    @ManyToOne
    @JoinColumn(name = "group_attribute_id")
    private EavAttributeGroup eavAttributeGroup;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public EavAttributeType getEavAttributeType() {
        return eavAttributeType;
    }

    public void setEavAttributeType(EavAttributeType eavAttributeType) {
        this.eavAttributeType = eavAttributeType;
    }

    public EavAttributeGroup getEavAttributeGroup() {
        return eavAttributeGroup;
    }

    public void setEavAttributeGroup(EavAttributeGroup eavAttributeGroup) {
        this.eavAttributeGroup = eavAttributeGroup;
    }
}
