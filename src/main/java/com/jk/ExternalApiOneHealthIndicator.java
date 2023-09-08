package com.jk;
import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties.Restclient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * External API Health Indicator
 */
@ConditionalOnEnabledHealthIndicator("externalApiOneStatus")
@Component("externalApiOneStatus")
public class ExternalApiOneHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        if (isExternalApiRunning()) {
            return Health.up().withDetail("Ext API1", "AVAILABLE").build();
        } else {
            return Health.outOfService().withDetail("Ext API1", "OUT-OF-SERVICE").build();
        }
    }

    private boolean isExternalApiRunning() {
        return true;
    }
}