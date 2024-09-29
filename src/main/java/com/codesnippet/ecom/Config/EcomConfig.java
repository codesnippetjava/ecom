package com.codesnippet.ecom.Config;

import com.codesnippet.ecomassistant.Service.DeprecatedUtilityService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "com.codesnippet.ecomassistant",
        excludeFilters = @ComponentScan.Filter
                (type = FilterType.ASSIGNABLE_TYPE,
                        classes = {DeprecatedUtilityService.class})
)
public class EcomConfig {
}
