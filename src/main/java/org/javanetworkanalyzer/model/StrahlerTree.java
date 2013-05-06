/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javanetworkanalyzer.model;

import org.javanetworkanalyzer.data.VStrahler;
import java.util.HashMap;
import java.util.Map;
import org.jgrapht.EdgeFactory;
import org.jgrapht.graph.DirectedPseudograph;

/**
 * A graph for use in the Strahler algorithm.
 *
 * @param <E> Edge class.
 *
 * @author Adam Gouge
 */
public class StrahlerTree<E> extends DirectedPseudograph<VStrahler, E> {

    /**
     * The root vertex.
     */
    private VStrahler rootVertex = null;
    /**
     * Map of ids to vertices.
     */
    private final Map<Integer, VStrahler> nodeMap;

    /**
     * @see AbstractBaseGraph
     */
    public StrahlerTree(Class<? extends E> edgeClass) {
        super(edgeClass);
        this.nodeMap = new HashMap<Integer, VStrahler>();
    }

    /**
     * @see AbstractBaseGraph
     */
    public StrahlerTree(EdgeFactory<VStrahler, E> ef) {
        super(ef);
        this.nodeMap = new HashMap<Integer, VStrahler>();
    }

    /**
     * Add a vertex with the given id.
     *
     * @param id Id
     *
     * @return True if the vertex was added.
     */
    private boolean addVertex(int id) {
        if (!nodeMap.containsKey(id)) {
            VStrahler node = new VStrahler(id);
            nodeMap.put(id, node);
            return addVertex(node);
        } else {
            throw new IllegalStateException(
                    "This vertex has already been added!");
        }
    }

    /**
     * Get the vertex with the given id.
     *
     * @param id Id.
     *
     * @return The vertex with the given id.
     */
    public VStrahler getVertex(int id) {
        return nodeMap.get(id);
    }

    /**
     * Set the root vertex as the vertex with the given id.
     *
     * @param id Id.
     */
    public void setRootVertex(int id) {
        VStrahler candidate = getVertex(id);
        if (candidate != null) {
            rootVertex = candidate;
        } else {
            throw new IllegalStateException(
                    "This vertex does not exist!");
        }
    }

    /**
     * Return the root vertex.
     *
     * @return The root vertex.
     */
    public VStrahler getRootVertex() {
        return rootVertex;
    }

    /**
     * Add an edge from the vertex with id source to the vertex with id target.
     *
     * @param source Source id.
     * @param target Target Id.
     *
     * @return The newly added edge, or null if it was not added.
     */
    public E addEdge(int source, int target) {
        if (!containsVertex(getVertex(source))) {
            addVertex(source);
        }
        if (!containsVertex(getVertex(target))) {
            addVertex(target);
        }
        return addEdge(getVertex(source), getVertex(target));
    }
}
