package com.hiberus.api.service.impl;

import com.hiberus.api.dao.AbstractDAO;
import com.hiberus.api.dao.VehicleDAO;
import com.hiberus.api.model.vehicle.Vehicle;
import com.hiberus.api.service.VehicleService;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daniel Pardo Ligorred.
 */
@Service(value = "vehicleService")
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleDAO vehicleDAO;

    @Override
    //@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Vehicle getById(int id) {
        Vehicle vehicle = this.vehicleDAO.findById(id);
        //vehicle.setStock(100);
        return vehicle;
    }

    @Override
    public Vehicle getByName(String name) {

        return this.getByName(name, null);
    }

    @Override
    public Vehicle getByName(String name, AbstractDAO.CollectionName[] collectionsToInitialize) {

        return this.vehicleDAO.getUniqueLazyEntity(
                this.vehicleDAO.getCriteria().add(Restrictions.eq("name", name)),
                collectionsToInitialize);
    }

    @Override
    public List<Vehicle> getAllUsingHQL() {
        return this.vehicleDAO.findByHQL("from vehicle");
    }

    @Override
    public List<Vehicle> getVehicleByMaxCustomerAgeUsingHQL(int age) {
        return this.vehicleDAO.findByHQL(
                "select distinct v from vehicle v " +
                        "   left join fetch v.sales s " +
                        "   left join s.customer c " +
                        "where " +
                        "   c.age < " + age);
    }

    @Override
    public List<Vehicle> getVehicle(String name, String typeName, String colorName, Float minPrice, Float maxPrice,
                                    Integer minStock, Integer maxStock, boolean initSales) {
        Criteria criteria = this.vehicleDAO.getCriteria();

        if (name != null && name.length() > 0) {
            criteria.add(Restrictions.like("name", "%" + name.toLowerCase() + "%").ignoreCase());
        }

        if (typeName != null && typeName.length() > 0) {
            criteria.createAlias("vehicleType", "vt")
                    .add(Restrictions.like("vt.name", "%" + typeName.toLowerCase() + "%").ignoreCase());
        }

        if (colorName != null && colorName.length() > 0) {
            criteria.createAlias("color", "c")
                    .add(Restrictions.like("c.name", "%" + colorName.toLowerCase() + "%").ignoreCase());
        }

        if (minPrice != null && maxPrice != null) {
            criteria.add(Restrictions.and(
                    Restrictions.gt("price", minPrice),
                    Restrictions.lt("price", maxPrice)
            ));
        }
        else if (minPrice != null) {
            criteria.add(Restrictions.gt("price", minPrice));
        }
        else if (maxPrice != null) {
            criteria.add(Restrictions.lt("price", maxPrice));
        }

        if (minStock != null && maxStock != null) {
            criteria.add(Restrictions.between("stock", minStock, maxStock));
        }
        else if (minStock != null) {
            criteria.add(Restrictions.gt("stock", minStock));
        }
        else if (maxStock != null) {
            criteria.add(Restrictions.lt("stock", maxStock));
        }

        if (initSales) {
            criteria.setFetchMode("sales", FetchMode.JOIN).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        }

        return criteria.addOrder(Order.asc("id")).list();
    }

    @Override
    public List<Vehicle> getVehicleByExample(Vehicle vehicle) {
        return this.vehicleDAO.getCriteria()
                .add(Example.create(vehicle)
                        .ignoreCase()
                        .enableLike()
                        .excludeZeroes())
                .createCriteria("color")
                    .add(Example.create(vehicle.getColor())
                            .ignoreCase()
                            .enableLike()
                            .excludeZeroes())
                .list();
    }

}