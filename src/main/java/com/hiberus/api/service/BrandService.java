package com.hiberus.api.service;

import java.util.List;

/**
 * Created by Daniel on 16/06/2016.
 */
public interface BrandService {

    List<?> getBrandsByCountry(String country);

}