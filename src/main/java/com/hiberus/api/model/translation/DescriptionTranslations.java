package com.hiberus.api.model.translation;

import javax.persistence.*;

/**
 * Created by jorge on 12/06/2016.
 */
@Entity(name = "descriptionTranslations")
@Table(name = "description_translations")
public class DescriptionTranslations {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "language_id")
    private int languageId;
    @Column(name = "vehicle_id")
    private int vehicleId;
    @Column(name = "description")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}