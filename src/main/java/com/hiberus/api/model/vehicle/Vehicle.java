package com.hiberus.api.model.vehicle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hiberus.api.dao.AbstractDAO;
import com.hiberus.api.model.dealership.Dealership;
import com.hiberus.api.model.sale.Sale;
import com.hiberus.api.model.translation.DescriptionTranslations;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Formula;
import org.hibernate.bytecode.internal.javassist.FieldHandled;
import org.hibernate.bytecode.internal.javassist.FieldHandler;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Daniel Pardo Ligorred.
 */
@Entity(name = "vehicle")
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private float price;
    @Column(name = "stock")
    private int stock;

    @Formula("stock * stock")
    private int calculo;

    public int getCalculo() {
        return calculo;
    }

    public void setCalculo(int calculo) {
        this.calculo = calculo;
    }

    //@ManyToOne
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_type_id", referencedColumnName = "id")
    private VehicleType vehicleType;

    //@ManyToOne
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id", referencedColumnName = "id")
    private Color color;

    //@ManyToOne
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dealership_id", referencedColumnName = "id")
    private Dealership dealership;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicle")
    private List<Sale> sales;

    //@OneToMany(fetch = FetchType.EAGER)
    @OneToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumns({
            @JoinColumn(name = "vehicle_id")
    })
    @OrderBy("description DESC")
    private List<DescriptionTranslations> descriptionTranslations;

    //@OneToMany(fetch = FetchType.EAGER)
    @OneToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "vehicle_id")
    @MapKey
    private Map<Integer, DescriptionTranslations> descriptionTraductionsMap;

    //@ElementCollection(fetch = FetchType.EAGER)
    @ElementCollection(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @CollectionTable(name = "description_translations", joinColumns = @JoinColumn(name = "vehicle_id"))
    @Column(name = "description")
    private Set<String> descriptionTraductionsElement;

    //@ElementCollection(fetch = FetchType.EAGER)
    @ElementCollection(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @CollectionTable(name = "description_translations", joinColumns = @JoinColumn(name = "vehicle_id"))
    @MapKeyColumn(name = "id")
    @Column(name = "description")
    private Map<Integer, String> descriptionTraductionsElementMap;

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

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Dealership getDealership() {
        return dealership;
    }

    public void setDealership(Dealership dealership) {
        this.dealership = dealership;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public List<DescriptionTranslations> getDescriptionTranslations() {
        return descriptionTranslations;
    }

    public void setDescriptionTranslations(List<DescriptionTranslations> descriptionTranslations) {
        this.descriptionTranslations = descriptionTranslations;
    }

    public Map<Integer, DescriptionTranslations> getDescriptionTraductionsMap() {
        return descriptionTraductionsMap;
    }

    public void setDescriptionTraductionsMap(Map<Integer, DescriptionTranslations> descriptionTraductionsMap) {
        this.descriptionTraductionsMap = descriptionTraductionsMap;
    }

    public Set<String> getDescriptionTraductionsElement() {
        return descriptionTraductionsElement;
    }

    public void setDescriptionTraductionsElement(Set<String> descriptionTraductionsElement) {
        this.descriptionTraductionsElement = descriptionTraductionsElement;
    }

    public Map<Integer, String> getDescriptionTraductionsElementMap() {
        return descriptionTraductionsElementMap;
    }

    public void setDescriptionTraductionsElementMap(Map<Integer, String> descriptionTraductionsElementMap) {
        this.descriptionTraductionsElementMap = descriptionTraductionsElementMap;
    }

    public enum Collection implements AbstractDAO.CollectionName{

        SALES("sales");

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