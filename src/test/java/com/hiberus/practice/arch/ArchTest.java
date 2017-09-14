package com.hiberus.practice.arch;

import com.hiberus.api.service.BrandService;
import com.hiberus.api.service.DealershipService;
import com.hiberus.config.ApplicationConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Daniel on 16/06/2016.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class ArchTest {

    @Autowired
    private DealershipService dealershipService;
    @Autowired
    private BrandService brandService;

    @Test
    public void getDealershipNumberOfVehicles(){

        Assert.assertTrue(this.dealershipService.getDealershipNumberOfVehicles(1) > 0);
    }

    @Test
    public void getBrandsByCountry(){

        List<?> brands = this.brandService.getBrandsByCountry("España");

        Assert.assertTrue(brands != null && brands.size() > 0);
    }

}