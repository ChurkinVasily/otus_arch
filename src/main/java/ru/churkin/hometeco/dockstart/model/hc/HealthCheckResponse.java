package ru.churkin.hometeco.dockstart.model.hc;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HealthCheckResponse {

    @JsonProperty("status")
    private HealthCheckStatus status;

    public static HealthCheckResponse of(HealthCheckStatus status) {
        HealthCheckResponse res = new HealthCheckResponse();
        res.setStatus(status);
        return res;
    }

    public HealthCheckStatus getStatus() {
        return status;
    }

    public void setStatus(HealthCheckStatus status) {
        this.status = status;
    }
}
