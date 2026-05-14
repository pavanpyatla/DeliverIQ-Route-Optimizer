package com.deliveriq.backend.model;

import java.util.List;

public class PathResponse {

    private List<Long> path;

    public PathResponse(List<Long> path) {
        this.path = path;
    }

    public List<Long> getPath() {
        return path;
    }

    public void setPath(List<Long> path) {
        this.path = path;
    }
}