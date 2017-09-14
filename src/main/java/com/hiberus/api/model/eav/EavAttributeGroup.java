package com.hiberus.api.model.eav;

import org.hibernate.annotations.Where;
import org.hibernate.annotations.WhereJoinTable;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Jorge Izquierdo Bueno
 */
@Entity(name = "eavAttributeGroup")
@Table(name = "eav_attribute_group")
public class EavAttributeGroup extends BaseEavAttributeGroup {
}
