/**
 * GraphHopper-SNA implements a collection of social network analysis
 * algorithms. It is based on the <a
 * href="http://graphhopper.com/">GraphHopper</a> library.
 *
 * GraphHopper-SNA is distributed under the GPL 3 license. It is produced by the
 * "Atelier SIG" team of the <a href="http://www.irstv.fr">IRSTV Institute</a>,
 * CNRS FR 2488.
 *
 * Copyright 2012 IRSTV (CNRS FR 2488)
 *
 * GraphHopper-SNA is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * GraphHopper-SNA is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * GraphHopper-SNA. If not, see <http://www.gnu.org/licenses/>.
 */
package com.graphhoppersna.alg;

import com.graphhopper.routing.DijkstraBidirection;
import com.graphhopper.routing.DijkstraSimple;
import com.graphhoppersna.centrality.ClosenessCentrality;
import com.graphhoppersna.storage.GDMSGraphStorage;
import gnu.trove.iterator.TIntDoubleIterator;
import gnu.trove.map.hash.TIntDoubleHashMap;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Test;

/**
 * A class to test {@link ClosenessCentrality}.
 *
 * @author Adam Gouge
 */
public class ClosenessCentralityTest {

//    /**
//     * Prints the closeness centrality result.
//     *
//     * @param resultIterator The iterator over the r
//     */
//    public void printResult(TIntDoubleHashMap result) {
//        TIntDoubleIterator resultIterator = result.iterator();
//        while (resultIterator.hasNext()) {
//            resultIterator.advance();
//            System.out.println(resultIterator.key() + ", " + resultIterator.
//                    value());
//        }
//    }
    /**
     * Tests the closeness centrality algorithm using a {@link DijkstraSimple}
     * on a 2D bidirectional graph loaded from a csv file.
     *
     * @throws IOException
     */
    @Test
    public void testClosenessCentralityGraph2DBidirectionalDijkstraSimple() throws IOException {

        GDMSGraphStorage graph = GDMSGraphStorage.loadGDMSGraph(
                "./target/Graph2D",
                "./files/graph2D.edges.csv",
                "length",
                true);
        ClosenessCentrality cc = new ClosenessCentrality(graph);
        TIntDoubleHashMap result = cc.calculateUsingDijkstraSimple();
    }

    /**
     * Tests the closeness centrality algorithm using a
     * {@link DijkstraBidirection} on a 2D bidirectional graph loaded from a csv
     * file.
     *
     * @throws IOException
     */
    @Test
    public void testClosenessCentralityGraph2DBidirectionalDijkstraBidirection() throws IOException {

        GDMSGraphStorage graph = GDMSGraphStorage.loadGDMSGraph(
                "./target/Graph2D",
                "./files/graph2D.edges.csv",
                "length",
                true);
        ClosenessCentrality cc = new ClosenessCentrality(graph);
        TIntDoubleHashMap result = cc.calculateUsingDijkstraBidirection();
    }

    /**
     * Tests the closeness centrality algorithm using a
     * {@link DijkstraBidirectionRef} on a 2D bidirectional graph loaded from a
     * csv file.
     *
     * @throws IOException
     */
    @Test
    public void testClosenessCentralityGraph2DBidirectionalDijkstraBidirectionRef() throws IOException {

        GDMSGraphStorage graph = GDMSGraphStorage.loadGDMSGraph(
                "./target/Graph2D",
                "./files/graph2D.edges.csv",
                "length",
                true);
        ClosenessCentrality cc = new ClosenessCentrality(graph);
        TIntDoubleHashMap result = cc.calculateUsingDijkstraBidirectionRef();
    }
}
