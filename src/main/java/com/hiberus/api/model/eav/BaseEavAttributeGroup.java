package com.hiberus.api.model.eav;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Jorge Izquierdo Bueno
 */
@MappedSuperclass
public class BaseEavAttributeGroup {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "eavAttributeGroup")
    private List<EavAttribute> eavAttributeList;

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

    public List<EavAttribute> getEavAttributeList() {
        return eavAttributeList;
    }

    public void setEavAttributeList(List<EavAttribute> eavAttributeList) {
        this.eavAttributeList = eavAttributeList;
    }
}
