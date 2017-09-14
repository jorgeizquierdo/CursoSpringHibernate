package com.hiberus.api.model.eav;

import org.hibernate.annotations.Filter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Jorge Izquierdo Bueno
 */
@Entity(name = "attributeProductValue")
@Table(name = "attribute_product_value")
public class AttributeProductValue implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "attribute_id", referencedColumnName = "id")
    private EavAttribute eavAttribute;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "value")
    private String value;

    public EavAttribute getEavAttribute() {
        return eavAttribute;
    }

    public void setEavAttribute(EavAttribute eavAttribute) {
        this.eavAttribute = eavAttribute;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
