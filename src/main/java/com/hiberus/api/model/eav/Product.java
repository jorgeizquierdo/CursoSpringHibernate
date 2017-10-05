package com.hiberus.api.model.eav;

import com.hiberus.api.dao.AbstractDAO;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.Map;

/**
 * Created by Jorge Izquierdo Bueno
 */
@Entity(name = "product")
@Table(name = "product")
@FetchProfiles({
        @FetchProfile(name = "attribute_product_value", fetchOverrides = {
                @FetchProfile.FetchOverride(entity = Product.class, association = "attributeValuesMap", mode = FetchMode.JOIN)
        })
})
@FilterDef(name = "maxStock", parameters = {
        @ParamDef(name = "maxStock", type = "int")
})
@Filter(name = "maxStock", condition = "stock <= :maxStock")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private float price;

    @Column(name = "stock")
    private int stock;

    @OneToMany(mappedBy = "product")
    @Where(clause = "active = 1")
    private List<AttributeProductValue> attributeProductValueList;

    @ElementCollection
    @CollectionTable(name = "attribute_product_value", joinColumns = @JoinColumn(name = "product_id"))
    @MapKeyColumn(name = "attribute_id")
    @Column(name = "value")
    @Where(clause = "active = 1")
    private Map<Integer, String> attributeValuesMap;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<AttributeProductValue> getAttributeProductValueList() {
        return attributeProductValueList;
    }

    public void setAttributeProductValueList(List<AttributeProductValue> attributeProductValueList) {
        this.attributeProductValueList = attributeProductValueList;
    }

    public Map<Integer, String> getAttributeValuesMap() {
        return attributeValuesMap;
    }

    public void setAttributeValuesMap(Map<Integer, String> attributeValuesMap) {
        this.attributeValuesMap = attributeValuesMap;
    }

    public enum Collection implements AbstractDAO.CollectionName{

        ATTRIBUTE_PRODUCT_VALUE_LIST("attributeProductValueList"),
        ATTRIBUTE_VALUES_MAP("attributeValuesMap");

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
