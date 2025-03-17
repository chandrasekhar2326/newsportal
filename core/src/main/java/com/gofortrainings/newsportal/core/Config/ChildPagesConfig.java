package com.gofortrainings.newsportal.core.Config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(
        name = "Child Pages Configuration",
        description = "Configuration to fetch child pages under a specified page path"
)
public @interface ChildPagesConfig {

    @AttributeDefinition(
            name = "Page Path",
            description = "Enter the page path from which child pages should be fetched"
    )
    String pagePath() default "/content/newsportal/us/en";
}
