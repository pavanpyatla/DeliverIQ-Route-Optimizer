package com.deliveriq.backend.controller;

import com.deliveriq.backend.model.PathResponse;
import com.deliveriq.backend.model.Edge;
import com.deliveriq.backend.service.AStarService;
import com.deliveriq.backend.service.DijkstraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class AlgorithmController {

    @Autowired
    private DijkstraService dijkstraService;

    @Autowired
    private AStarService aStarService;

    @PostMapping("/dijkstra")
    public PathResponse runDijkstra(
            @RequestBody DijkstraRequest request
    ) {

        return dijkstraService.shortestPath(
                request.getEdges(),
                request.getStartNode(),
                request.getDeliveryNodes()
        );
    }

    @PostMapping("/astar")
    public Map<Long, Double> runAStar(
            @RequestBody DijkstraRequest request
    ) {

        return aStarService.shortestPath(
                request.getEdges(),
                request.getStartNode()
        );
    }

    // Request DTO
    public static class DijkstraRequest {

        private List<Edge> edges;

        private Long startNode;

        private List<Long> deliveryNodes;

        public List<Edge> getEdges() {
            return edges;
        }

        public void setEdges(List<Edge> edges) {
            this.edges = edges;
        }

        public Long getStartNode() {
            return startNode;
        }

        public void setStartNode(Long startNode) {
            this.startNode = startNode;
        }

        public List<Long> getDeliveryNodes() {
            return deliveryNodes;
        }

        public void setDeliveryNodes(List<Long> deliveryNodes) {
            this.deliveryNodes = deliveryNodes;
        }
    }
}