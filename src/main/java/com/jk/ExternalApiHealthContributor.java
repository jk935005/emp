package com.jk;
import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.actuate.autoconfigure.info.ConditionalOnEnabledInfoContributor;
import org.springframework.boot.actuate.health.CompositeHealthContributor;
import org.springframework.boot.actuate.health.HealthContributor;
import org.springframework.boot.actuate.health.NamedContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Health Aggregator for External APIs
 */
@ConditionalOnEnabledHealthIndicator("externalApiHealthStatus")
@Component("externalApiHealthStatus")
public class ExternalApiHealthContributor implements CompositeHealthContributor {
    private Map<String, HealthContributor> extHealthContributors = new HashMap<>();

    public ExternalApiHealthContributor(ExternalApiOneHealthIndicator externalApiOneHealthIndicator,
                                        ExternalApiTwoHealthIndicator externalApiTwoHealthIndicator) {
        extHealthContributors.putIfAbsent("extApi1", externalApiOneHealthIndicator);
        extHealthContributors.putIfAbsent("extApi2", externalApiTwoHealthIndicator);
    }

    @Override
    public HealthContributor getContributor(String name) {
        return extHealthContributors.get(name);
    }

    @Override
    public Iterator<NamedContributor<HealthContributor>> iterator() {
        return extHealthContributors.entrySet().stream().map(item ->
                NamedContributor.of(item.getKey(), item.getValue())).iterator();
    }
}