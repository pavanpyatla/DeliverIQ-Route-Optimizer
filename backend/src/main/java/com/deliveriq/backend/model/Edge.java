package com.deliveriq.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "edges")
public class Edge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long fromNode;

    private Long toNode;

    private double weight;

    public Edge() {
    }

    public Edge(Long fromNode, Long toNode, double weight) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public Long getFromNode() {
        return fromNode;
    }

    public void setFromNode(Long fromNode) {
        this.fromNode = fromNode;
    }

    public Long getToNode() {
        return toNode;
    }

    public void setToNode(Long toNode) {
        this.toNode = toNode;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}