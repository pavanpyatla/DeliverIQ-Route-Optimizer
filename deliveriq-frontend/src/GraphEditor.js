import { useCallback, useState } from "react";
import axios from "axios";

import ReactFlow, {
  addEdge,
  Background,
  Controls,
  MiniMap,
  useEdgesState,
  useNodesState,
} from "reactflow";

import "reactflow/dist/style.css";

const initialNodes = [];

const initialEdges = [];

function GraphEditor() {
  const [nodeId, setNodeId] = useState(1);
  const [shortestPath, setShortestPath] = useState([]);

  const [deliveryNodes, setDeliveryNodes] = useState("");
  const [nodes, setNodes, onNodesChange] =
    useNodesState(initialNodes);

  const [edges, setEdges, onEdgesChange] =
    useEdgesState(initialEdges);

  const onConnect = useCallback(
    (params) => {

    const weight = prompt("Enter edge weight:");

    setEdges((eds) =>
      addEdge(
        {
          ...params,
          animated: true,
          label: weight,
        },
        eds
      )
        );
  },
        [setEdges]
);

  const addNode = () => {

    const newNode = {
      id: String(nodeId),

      position: {
        x: Math.random() * 400,
        y: Math.random() * 400,
      },

      data: {
        label: `Node ${nodeId}`,
      },
    };

    setNodes((nds) => [...nds, newNode]);

    setNodeId(nodeId + 1);
  };


  const runDijkstra = async () => {

  const formattedEdges = edges.map((edge) => ({
    fromNode: Number(edge.source),
    toNode: Number(edge.target),
    weight: Number(edge.label),
  }));

  const deliveryArray = deliveryNodes
    .split(",")
    .map((node) => Number(node.trim()));

  const requestBody = {
    startNode: 1,
    deliveryNodes: deliveryArray,
    edges: formattedEdges,
  };  

  try {

    const response = await axios.post(
      "http://localhost:8081/api/dijkstra",
      requestBody
    );

    console.log(response.data);

    setShortestPath(response.data.path);    
    alert("Dijkstra executed successfully!");

  } catch (error) {

    console.error(error);

    alert("Backend connection failed");
  }
};

  const highlightedEdges = edges.map((edge) => {

    let isShortestPath = false;

    for (let i = 0; i < shortestPath.length - 1; i++) {

      if (
        edge.source === String(shortestPath[i]) &&
        edge.target === String(shortestPath[i + 1])
      ) {

        isShortestPath = true;
        break;
      }
    }

    return {
      ...edge,

      style: {
        stroke: isShortestPath ? "red" : "#999",
        strokeWidth: isShortestPath ? 4 : 2,
      },
    };
  });

  return (
    <div style={{ width: "100%", height: "100vh" }}>

      <button
        onClick={addNode}
        style={{
          position: "absolute",
          zIndex: 10,
          top: 10,
          left: 10,
          padding: "10px 20px",
          background: "#2563eb",
          color: "white",
          border: "none",
          borderRadius: "10px",
          cursor: "pointer",
        }}
      >
        Add Node
      </button>

      <button
        onClick={runDijkstra}
        style={{
          position: "absolute",
          zIndex: 10,
          top: 60,
          left: 10,
          padding: "10px 20px",
          background: "#dc2626",
          color: "white",
          border: "none",
          borderRadius: "10px",
          cursor: "pointer",
        }}
      >
            Run Dijkstra
      </button>

      <input
        type="text"
        placeholder="Delivery Nodes (2,3,4)"
        value={deliveryNodes}
        onChange={(e) => setDeliveryNodes(e.target.value)}
        style={{
          position: "absolute",
          zIndex: 10,
          top: 160,
          left: 10,
          padding: "10px",
          borderRadius: "10px",
          border: "1px solid gray",
          width: "220px",
        }}
      />

      <ReactFlow
        nodes={nodes}
        edges={highlightedEdges}
        onNodesChange={onNodesChange}
        onEdgesChange={onEdgesChange}
        onConnect={onConnect}
        fitView
      >

        <MiniMap />

        <Controls />

        <Background />

      </ReactFlow>

    </div>
  );
}

export default GraphEditor;