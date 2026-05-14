package com.deliveriq.backend.service;

import com.deliveriq.backend.model.Edge;
import com.deliveriq.backend.model.PathResponse;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DijkstraService {

    public PathResponse shortestPath(
            List<Edge> edges,
            Long startNode,
            List<Long> deliveryNodes
    ) {

        Map<Long, List<Edge>> graph = new HashMap<>();

        for (Edge edge : edges) {

            graph.putIfAbsent(edge.getFromNode(), new ArrayList<>());

            graph.get(edge.getFromNode()).add(edge);
        }

        Map<Long, Double> distances = new HashMap<>();

        Map<Long, Long> previous = new HashMap<>();

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

                double newDistance =
                        currentDistance + edge.getWeight();

                if (
                        !distances.containsKey(neighbor)
                                || newDistance < distances.get(neighbor)
                ) {

                    distances.put(neighbor, newDistance);

                    previous.put(neighbor, currentNode);

                    pq.add(new long[]{
                            neighbor,
                            (long) newDistance
                    });
                }
            }
        }

        List<Long> fullPath = new ArrayList<>();

        for (Long deliveryNode : deliveryNodes) {

            List<Long> currentPath = new ArrayList<>();

            Long current = deliveryNode;

            while (current != null) {

                currentPath.add(current);

                current = previous.get(current);
            }

            Collections.reverse(currentPath);

            for (Long node : currentPath) {

                if (!fullPath.contains(node)) {
                    fullPath.add(node);
                }
            }
        }

        return new PathResponse(fullPath);
    }
}