package com.hiberus;

import com.hiberus.config.ApplicationConfig;
import com.hiberus.config.DispatcherServletConfig;
import com.hiberus.config.RestSecurityConfig;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithSecurityContextTestExecutionListener;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.ServletTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Daniel Pardo Ligorred.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@Rollback
@WebAppConfiguration
@ContextConfiguration(classes = {ApplicationConfig.class, RestSecurityConfig.class, DispatcherServletConfig.class})
@TestExecutionListeners(
        listeners = {
                ServletTestExecutionListener.class,
                DependencyInjectionTestExecutionListener.class,
                DirtiesContextTestExecutionListener.class,
                TransactionalTestExecutionListener.class,
                WithSecurityContextTestExecutionListener.class})
public abstract class AppContextConfigurationAware {

    @Autowired
    protected WebApplicationContext webApplicationContext;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private FilterChainProxy springSecurityFilterChain;

    protected MockMvc mockMvc;

    @Before
    public void setup() {

        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.webApplicationContext)
                .apply(SecurityMockMvcConfigurers.springSecurity(this.springSecurityFilterChain))
                .build();
    }

}