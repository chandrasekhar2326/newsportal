package com.gofortrainings.newsportal.core.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

import com.gofortrainings.newsportal.core.Config.SurgeConfig;

@Component(service = SurgeService.class, immediate = true)
@Designate(ocd = SurgeConfig.class)
public class SurgeConfigImpl implements SurgeService {  

    private String organisationName;
    private String address;
    
    @Activate
    public void activate(SurgeConfig config) {
        organisationName = config.getName();
        address = config.getaddress();
    }

    @Override 
    public String getName() {
        return organisationName;
    }

    @Override  
    public String getAddress() {
        return address;
    }
}
