package com.gofortrainings.newsportal.core.Config;

import com.gofortrainings.newsportal.core.Config.ChildPagesConfig;
import com.gofortrainings.newsportal.core.services.ChildPagesService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.service.component.annotations.*;
import org.osgi.service.metatype.annotations.Designate;

import java.util.*;

@Component(service = ChildPagesService.class, immediate = true, configurationPolicy = ConfigurationPolicy.REQUIRE)
@Designate(ocd = ChildPagesConfig.class)
public class ChildpagesConfigImpl implements ChildPagesService {

    private String pagePath;

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @Activate
    @Modified
    protected void activate(ChildPagesConfig config) {
        this.pagePath = config.pagePath();
    }

    @Override
    public String getPagePath() {
        return pagePath;
    }

    @Override
    public List<String> getChildPages() {
        List<String> childPages = new ArrayList<>();
        Map<String, Object> authInfo = Collections.singletonMap(ResourceResolverFactory.SUBSERVICE, "chandra");

        try (ResourceResolver resourceResolver = resourceResolverFactory.getServiceResourceResolver(authInfo)) {
            Resource parentResource = resourceResolver.getResource(pagePath);
            if (parentResource != null) {
                Iterator<Resource> children = parentResource.listChildren();
                while (children.hasNext()) {
                    Resource child = children.next();
                    ValueMap properties = child.getValueMap();
                    String title = properties.get("jcr:title", String.class);
                    childPages.add(title != null ? title : child.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return childPages;
    }
}
