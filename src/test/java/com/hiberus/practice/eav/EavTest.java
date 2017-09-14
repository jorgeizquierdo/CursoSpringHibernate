package com.hiberus.practice.eav;

import com.hiberus.AppContextConfigurationAware;
import com.hiberus.api.model.eav.*;
import com.hiberus.api.service.eav.AttributeService;
import com.hiberus.api.service.eav.ProductService;
import org.hibernate.LazyInitializationException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;

import java.util.List;

/**
 * Created by Jorge Izquierdo Bueno
 */
public class EavTest extends AppContextConfigurationAware {

    @Autowired
    private AttributeService attributeService;
    @Autowired
    private ProductService productService;

    @Test
    public void modelTest() {
        List<EavAttribute> eavAttributeList = this.attributeService.getAllAttributes();
        List<EavAttributeType> eavAttributeTypeList = this.attributeService.getAllAttributeTypes();
        List<EavAttributeGroup> eavAttributeGroupList = this.attributeService.getAllAttributeGroups();
        List<Product> productList = this.productService.getAllProducts();
        List<AttributeProductValue> attributeProductValueList = this.productService.getAllAttributeProductValues();


        Assert.assertTrue(eavAttributeList != null && eavAttributeTypeList != null && eavAttributeGroupList != null
                            && productList != null && attributeProductValueList != null);
    }

    @Test
    public void collectionTest1() {
        EavAttribute eavAttribute = this.attributeService.getAttributeById(1);

        Assert.assertTrue(eavAttribute != null && eavAttribute.getEavAttributeType() != null && eavAttribute.getEavAttributeGroup() != null);
    }

    @Test
    public void collectionTest2() {
        EavAttributeType eavAttributeType = this.attributeService.getAttributeTypeById(1);

        try {
            Assert.assertFalse(eavAttributeType != null && eavAttributeType.getEavAttributeList().size() > 0);
        } catch (Exception e) {
            Assert.assertTrue(e instanceof LazyInitializationException);
        }
    }

    @Test
    public void collectionTest3() {
        EavAttributeType eavAttributeType1 = this.attributeService.getAttributeTypeByIdFetchProfileInitialize1(1);
        EavAttributeType eavAttributeType2 = this.attributeService.getAttributeTypeByIdFetchProfileInitialize2(1);

        Assert.assertTrue(eavAttributeType1.getEavAttributeList().size() != eavAttributeType2.getEavAttributeList().size());
    }

    @Test
    public void collectionTest4() {
        EavAttributeType eavAttributeType1 = this.attributeService.getAttributeTypeByIdCriteriaInitialize1(1);
        EavAttributeType eavAttributeType2 = this.attributeService.getAttributeTypeByIdCriteriaInitialize2(1);

        Assert.assertTrue(eavAttributeType1.getEavAttributeList().size() != eavAttributeType2.getEavAttributeList().size());
    }

    @Test
    public void collectionTest5() {
        EavAttributeType eavAttributeType1 = this.attributeService.getAttributeTypeByIdHibernateInitialize(1);

        Assert.assertTrue(eavAttributeType1.getEavAttributeList().size() > 0);
    }

    @Test
    public void mapTest() {
        Product product = this.productService.getProductById(1);

        try {
            Assert.assertFalse(product.getAttributeValuesMap().size() > 0);
        } catch (Exception e) {
            Assert.assertTrue(e instanceof LazyInitializationException);
        }
    }

    @Test
    public void mapTest2() {
        Product product1 = this.productService.getProductByIdCriteriaInitialize(3);
        Product product2 = this.productService.getProductByIdFetchProfileInitialize(3);
        Product product3 = this.productService.getProductByIdHibernateInitialize(3);

        Assert.assertTrue(product1.getAttributeValuesMap().size() == product2.getAttributeValuesMap().size()
                && product2.getAttributeValuesMap().size() == product3.getAttributeValuesMap().size());
    }

    @Test
    public void filterDefTest() {
        List<Product> productList = this.productService.getAllFilteredByMaxStock(3);

        Assert.assertTrue(productList != null);
    }

    @Test
    public void numberOfProducts() {
        Integer count = this.productService.numberOfProducts();

        Assert.assertTrue(count != null);
    }

    @Test
    public void getByAttr1Value() {
        List<Product> productList = this.productService.getByAttr1Value("Valor 1 1");

        Assert.assertTrue(productList != null);
    }

    @Test
    public void query1CriteriaTest() {
        List<Product> productList = this.productService.query1Criteria();

        Assert.assertTrue(productList != null);
    }

    @Test
    public void query2CriteriaTest() {
        List<Product> productList = this.productService.query2Criteria();

        Assert.assertTrue(productList != null);
    }

    @Test
    public void query1HQLTest() {
        List<Product> productList = this.productService.query1HQL();

        Assert.assertTrue(productList != null);
    }

    @Test
    public void query2HQLTest() {
        List<Product> productList = this.productService.query2HQL();

        Assert.assertTrue(productList != null);
    }

    @Test
    public void insertUpdateAttributeProductValue() {

        try {
            this.productService.insertAttributeProductValue(3, 1, "Nuevo valor");
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void insertAttributeType() {

        try {
            this.attributeService.insertAttributeType("Nuevo tipo de   atributo");
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void inheritanceSingleTableTest() {
        List<EavAttributeGroup> eavAttributeList = this.attributeService.getAllAttributeGroups();

        Assert.assertTrue(eavAttributeList != null);
    }

    @Test
    public void inheritanceSingleTableTestInsert() {
        EavAttributeGroup eavAttributeGroup = new EavAttributeGroup();
        eavAttributeGroup.setCode("codigo x");
        eavAttributeGroup.setName("nombre x");
        this.attributeService.insertAttributeGroup(eavAttributeGroup);
    }

    @Test
    public void inheritanceSingleTableTest2() {
        List<EavAttributeGroupExtended> eavAttributeGroupExtendeds = this.attributeService.getAllFullAttributeGroups();

        Assert.assertTrue(eavAttributeGroupExtendeds != null);
    }

    @Test
    public void inheritanceSingleTableTestInsert2() {
        EavAttributeGroupExtended eavAttributeGroup = new EavAttributeGroupExtended();
        eavAttributeGroup.setCode("codigo x");
        eavAttributeGroup.setName("nombre x");
        eavAttributeGroup.setOtherColum("otra columna x");
        this.attributeService.insertAttributeGroup(eavAttributeGroup);
    }

}
