/**
 * Java Network Analyzer provides a collection of graph theory and social
 * network analysis algorithms implemented on mathematical graphs using the
 * <a href="http://www.jgrapht.org/">JGraphT</a> library.
 *
 * Java Network Analyzer is developed by the GIS group of the DECIDE team of the 
 * Lab-STICC CNRS laboratory, see <http://www.lab-sticc.fr/>.
 * It is part of the OrbisGIS tool ecosystem.
 *
 * The GIS group of the DECIDE team is located at :
 *
 * Laboratoire Lab-STICC – CNRS UMR 6285
 * Equipe DECIDE
 * UNIVERSITÉ DE BRETAGNE-SUD
 * Institut Universitaire de Technologie de Vannes
 * 8, Rue Montaigne - BP 561 56017 Vannes Cedex
 * 
 * Java Network Analyzer is distributed under GPL 3 license.
 *
 * Copyright (C) 2012-2014 CNRS (IRSTV CNRS FR 2488)
 * Copyright (C) 2015-2017 CNRS (Lab-STICC CNRS UMR 6285)
 *
 * Java Network Analyzer is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * Java Network Analyzer is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Java Network Analyzer. If not, see <http://www.gnu.org/licenses/>.
 * 
 * For more information, please consult: <http://www.orbisgis.org/>
 * or contact directly:
 * info_at_ orbisgis.org
 */
package org.javanetworkanalyzer.analyzers;

import org.javanetworkanalyzer.progress.ProgressMonitor;
import java.util.Set;
import org.jgrapht.Graph;

/**
 * Root class of all classes that do some type of analysis on graphs
 * (centrality, connectedness, etc.).
 *
 * @author Adam Gouge
 * @param <V> vertex
 * @param <E> edge
 */
public abstract class GeneralizedGraphAnalyzer<V, E> {

    /**
     * The graph to be analyzed.
     */
    protected final Graph<V, E> graph;
    /**
     * The set of nodes of this graph.
     */
    protected final Set<V> nodeSet;
    /**
     * The number of nodes in this graph.
     */
    protected final int nodeCount;

    /**
     * Initializes a new instance of a graph analyzer with the given
     * {@link ProgressMonitor}.
     *
     * @param graph The graph to be analyzed.
     */
    public GeneralizedGraphAnalyzer(Graph<V, E> graph) {
        this.graph = graph;
        this.nodeSet = graph.vertexSet();
        this.nodeCount = this.nodeSet.size();
    }

    /**
     * Returns the graph this analyzer is using.
     *
     * This is often used for gaining access to the vertices which contain the
     * results of the analysis.
     *
     * @return The graph
     */
    public Graph<V, E> getGraph() {
        return graph;
    }
}
