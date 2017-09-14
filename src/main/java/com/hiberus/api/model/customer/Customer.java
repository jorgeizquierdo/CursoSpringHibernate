package com.hiberus.api.model.customer;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.hiberus.api.dao.AbstractDAO;
import com.hiberus.api.model.sale.Sale;
import com.hiberus.api.model.vehicle.VehicleType;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import org.jboss.logging.annotations.Param;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

/**
 * Created by Daniel Pardo Ligorred.
 */

// Avoids infinite recursion on JSON serialization.
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@FetchProfile(name = "customer_sales", fetchOverrides = {
        @FetchProfile.FetchOverride(entity = Customer.class, association = "sales", mode = FetchMode.JOIN)
})
@FilterDef(name = "minAgeFilter", parameters = {
        @ParamDef(name = "minAge", type = "int")
})
@Filter(name = "minAgeFilter", condition = ":minAge <= age")
@Entity(name = "customer")
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private int gender;
    @Column(name = "age")
    private int age;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    @Cascade(CascadeType.SAVE_UPDATE)
    private Set<Sale> sales;

    @OneToOne(mappedBy = "customer")
    private CustomerSocialNetworks customerSocialNetworks;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Set<CustomerAddress> customerAddresses;

    @ManyToMany
    @Fetch(FetchMode.SELECT)
    @JoinTable(name = "customer_favorites_vehicle_types",
        joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "vehicle_type_id", referencedColumnName = "id"))
    private Set<VehicleType> favoritesVehicleTypes;

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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }

    public CustomerSocialNetworks getCustomerSocialNetworks() {
        return customerSocialNetworks;
    }

    public void setCustomerSocialNetworks(CustomerSocialNetworks customerSocialNetworks) {
        this.customerSocialNetworks = customerSocialNetworks;
    }

    public Set<CustomerAddress> getCustomerAddresses() {
        return customerAddresses;
    }

    public void setCustomerAddresses(Set<CustomerAddress> customerAddresses) {
        this.customerAddresses = customerAddresses;
    }

    public Set<VehicleType> getFavoritesVehicleTypes() {
        return favoritesVehicleTypes;
    }

    public void setFavoritesVehicleTypes(Set<VehicleType> favoritesVehicleTypes) {
        this.favoritesVehicleTypes = favoritesVehicleTypes;
    }

    public enum Collection implements AbstractDAO.CollectionName{

        SALES("sales"),
        FAVORITE_VEHICLE_TYPES("favoritesVehicleTypes");

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