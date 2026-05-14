package com.deliveriq.backend.service;

import com.deliveriq.backend.model.Edge;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AStarService {

    public Map<Long, Double> shortestPath(
            List<Edge> edges,
            Long startNode
    ) {

        Map<Long, List<Edge>> graph = new HashMap<>();

        for (Edge edge : edges) {

            graph.putIfAbsent(edge.getFromNode(), new ArrayList<>());

            graph.get(edge.getFromNode()).add(edge);
        }

        Map<Long, Double> distances = new HashMap<>();

        PriorityQueue<long[]> pq =
                new PriorityQueue<>(Comparator.comparingDouble(a -> a[1]));

        distances.put(startNode, 0.0);

        pq.add(new long[]{startNode, 0});

        while (!pq.isEmpty()) {

            long[] current = pq.poll();

            Long currentNode = current[0];

            double currentDistance = current[1];

            if (!graph.containsKey(currentNode)) {
                continue;
            }

            for (Edge edge : graph.get(currentNode)) {

                Long neighbor = edge.getToNode();

                double heuristic = 1.0;

                double newDistance =
                        currentDistance
                                + edge.getWeight()
                                + heuristic;

                if (
                        !distances.containsKey(neighbor)
                                || newDistance < distances.get(neighbor)
                ) {

                    distances.put(neighbor, newDistance);

                    pq.add(new long[]{
                            neighbor,
                            (long) newDistance
                    });
                }
            }
        }

        return distances;
    }
}