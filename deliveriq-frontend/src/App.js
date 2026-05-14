// import { useState } from "react";
// import axios from "axios";

// import {
//   MapContainer,
//   TileLayer,
//   Marker,
//   Popup,
//   Polyline,
//   useMapEvents
// } from "react-leaflet";

// import "leaflet/dist/leaflet.css";

// function LocationMarker({ addMarker }) {

//   useMapEvents({
//     click(e) {
//       addMarker(e.latlng);
//     },
//   });

//   return null;
// }

// function App() {

//   const [markers, setMarkers] = useState([]);
//   const [shortestPath, setShortestPath] = useState([]);

//   const addMarker = (latlng) => {
//     setMarkers([...markers, latlng]);
//   };

//   const runDijkstra = async () => {

//     if (markers.length < 2) {
//       alert("Add at least 2 nodes");
//       return;
//     }

//     const edges = [];

//     for (let i = 0; i < markers.length - 1; i++) {

//       edges.push({
//         fromNode: i + 1,
//         toNode: i + 2,
//         weight: 1
//       });
//     }

//     const requestBody = {
//       startNode: 1,
//       edges: edges
//     };

//     try {

//       const response = await axios.post(
//         "http://localhost:8081/api/dijkstra",
//         requestBody
//       );

//       console.log(response.data);
//       const pathIds = response.data.path;

//       const optimizedMarkers = pathIds.map(
//         (id) => markers[id - 1]
//       );

//       setShortestPath(optimizedMarkers);  
//       alert("Dijkstra executed successfully!");

//     } catch (error) {

//       console.error(error);

//       alert("Backend connection failed");
//     }
//   };

//   return (
//   <div className="h-screen bg-gray-900 text-white flex">

//     {/* Sidebar */}
//     <div className="w-80 bg-gray-800 p-6 shadow-2xl">

//       <h1 className="text-3xl font-bold mb-6 text-blue-400">
//         DeliverIQ 🚀
//       </h1>

//       <div className="space-y-4">

//         <button
//           onClick={runDijkstra}
//           className="w-full bg-blue-500 hover:bg-blue-600 transition p-3 rounded-xl font-semibold"
//         >
//           Run Dijkstra
//         </button>

//         <div className="bg-gray-700 p-4 rounded-xl">
//           <h2 className="text-xl font-semibold mb-2">
//             Graph Stats
//           </h2>

//           <p>Nodes: {markers.length}</p>
//           <p>Edges: {markers.length - 1}</p>
//         </div>

//       </div>
//     </div>

//     {/* Map Section */}
//     <div className="flex-1 p-4">

//       <div className="rounded-2xl overflow-hidden shadow-2xl border border-gray-700">

//         <MapContainer
//           center={[17.3850, 78.4867]}
//           zoom={13}
//           style={{ height: "90vh", width: "100%" }}
//         >

//           <TileLayer
//             attribution='&copy; OpenStreetMap contributors'
//             url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
//           />

//           <LocationMarker addMarker={addMarker} />

//           {markers.map((position, index) => (
//             <Marker key={index} position={position}>
//               <Popup>
//                 Node {index + 1}
//               </Popup>
//             </Marker>
//           ))}

//           <Polyline positions={markers} />

//           <Polyline
//             positions={shortestPath}
//             pathOptions={{
//               color: "red",
//               weight: 6
//             }}
//           />

//         </MapContainer>

//       </div>

//     </div>

//   </div>
// );
// }

// export default App;


import GraphEditor from "./GraphEditor";

function App() {
  return <GraphEditor />;
}

export default App;