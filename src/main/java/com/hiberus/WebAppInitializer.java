package com.hiberus;

import com.hiberus.config.ApplicationConfig;
import com.hiberus.config.DispatcherServletConfig;
import com.hiberus.config.RestSecurityConfig;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Java web context initialization for Servlet 3.0.
 *
 * Created by Daniel Pardo Ligorred.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Initializing servlet context. Only once on startup.
     *
     * @param servletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        // Don't forget call onStartup parent method to contexts initialization.
        super.onStartup(servletContext);
    }

    /**
     * Root context Java configuration classes...
     *
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {

        return new Class<?>[]{ApplicationConfig.class, RestSecurityConfig.class};
    }

    /**
     * Servlets child context Java configuration classes...
     *
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class<?>[]{DispatcherServletConfig.class};
    }

    /**
     * Servlet-URI matching for...
     *
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * ServletContainer filters.
     *
     * @return
     */
    @Override
    protected Filter[] getServletFilters() {

        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        return new Filter[]{characterEncodingFilter};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {

        // Initializing context params...
        registration.setInitParameter("spring.profiles.active", "default");
    }

}