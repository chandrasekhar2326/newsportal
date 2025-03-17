package com.gofortrainings.newsportal.core.Config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "SurgeConfiguration" , description = "About Configuration")
public @interface SurgeConfig {

    @AttributeDefinition(
        name = "Oragansiation Name",
        description = "Enter the Organisation name"
    )

    public  String getName() default "Surge Software Soltuions";

    @AttributeDefinition(
        name = "Address Of Organsiation",
        description = "Enter the address Oragansiation"
    )

    public String getaddress() default "Bangalore";

}
