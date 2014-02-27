package es.usc.citius.lab.hipster.examples;

import es.usc.citius.lab.hipster.algorithm.Algorithms;
import es.usc.citius.lab.hipster.algorithm.problem.HeuristicSearchProblem;
import es.usc.citius.lab.hipster.util.map.MapBasedGraphSearchProblem;
import es.usc.citius.lab.hipster.util.map.MapBasedRomaniaProblem;

import java.util.List;

/**
 * Implementation of the Romania problem as described in
 * http://www.pearsonhighered.com/assets/hip/us/hip_us_pearsonhighered/samplechapter/0136042597.pdf.
 *
 * @author Adrián González Sieira <adrian.gonzalez@usc.es>
 * @since 24/02/2014
 */
public class RomaniaProblem {

    public static void main(String[] args) throws InterruptedException {
        //This example is based in the graph definition of the Romania problem, which is a graph where the
        //nodes are the main cities of Romania, connected by arcs that represent the roads of the country, whose
        //weight is the distance in km between the cities.
        //The Goal of the problem is always the city of Bucharest. The heuristic of the problem is the distance
        //in km of the straight line between each city and Bucharest.
        MapBasedRomaniaProblem.City begin = MapBasedRomaniaProblem.City.Lugoj;
        MapBasedRomaniaProblem.City goal = MapBasedRomaniaProblem.City.Bucharest;
        //We instantiate the search problem using the graph-based implementation provided in Hipster.
        HeuristicSearchProblem<MapBasedRomaniaProblem.City, Double> problem =
                new MapBasedGraphSearchProblem<MapBasedRomaniaProblem.City>(
                        begin,
                        goal,
                        MapBasedRomaniaProblem.transitions(),
                        MapBasedRomaniaProblem.costs(),
                        MapBasedRomaniaProblem.heuristics()
                );
        List<MapBasedRomaniaProblem.City> path = Algorithms.createAStar(problem).getOptimalPath();
        System.out.println("Solution path: " + path);
    }

}
