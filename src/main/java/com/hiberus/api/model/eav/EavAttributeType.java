package com.hiberus.api.model.eav;

import com.hiberus.api.dao.AbstractDAO;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Jorge Izquierdo Bueno
 */
@Entity(name = "eavAttributeType")
@Table(name = "eav_attribute_type")
@FetchProfile(name = "attribute_type_attribute", fetchOverrides = {
        @FetchProfile.FetchOverride(entity = EavAttributeType.class, association = "eavAttributeList", mode = FetchMode.JOIN)
})
public class EavAttributeType {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "eavAttributeType")
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

    public enum Collection implements AbstractDAO.CollectionName{

        EAV_ATTRIBUTE_LIST("eavAttributeList");

        private String collectionName;

        Collection(String collectionName) {
            this.collectionName = collectionName;
        }

        @Override
        public String getCollectionName() {

            return this.collectionName;
        }

    }
}
