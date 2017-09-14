package com.hiberus.api.model.eav;

import javax.persistence.*;

/**
 * Created by jorge on 28/06/2016.
 */
@Entity(name = "eavAttributeGroupExtended")
@Table(name = "eav_attribute_group")
public class EavAttributeGroupExtended extends BaseEavAttributeGroup {

    @Column(name = "other_column")
    private String otherColum;

    public String getOtherColum() {
        return otherColum;
    }

    public void setOtherColum(String otherColum) {
        this.otherColum = otherColum;
    }
}
