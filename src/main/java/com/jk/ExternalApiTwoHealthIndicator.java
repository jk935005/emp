package com.jk;

import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * External API Health Indicator
 */
@ConditionalOnEnabledHealthIndicator("externalApiTwoStatus")
@Component("externalApiTwoStatus")
public class ExternalApiTwoHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        if (isExternalApiRunning()) {
            return Health.up().withDetail("Ext API2", "AVAILABLE").build();
        } else {
            return Health.outOfService().withDetail("Ext API2", "OUT-OF-SERVICE").build();
        }
    }

    private boolean isExternalApiRunning() {
        return true;
    }
}