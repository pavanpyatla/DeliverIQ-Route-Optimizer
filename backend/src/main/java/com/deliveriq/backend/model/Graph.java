package com.deliveriq.backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "graphs")
public class Graph {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Node> nodes;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Edge> edges;

    public Graph() {
    }

    public Graph(String name, List<Node> nodes, List<Edge> edges) {
        this.name = name;
        this.nodes = nodes;
        this.edges = edges;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }
}