package com.gofortrainings.newsportal.core.models;

import com.gofortrainings.newsportal.core.services.SurgeService;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

@Model(adaptables = org.apache.sling.api.resource.Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SurgeModel {

    @OSGiService
    private SurgeService surgeService;

    public String getOrganisationName() {
        return surgeService != null ? surgeService.getName() : "SurgeSoftware";
    }

    public String getOrganisationAddress() {
        return surgeService != null ? surgeService.getAddress() : "Bangalore";
    }
}

