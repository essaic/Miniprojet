package assignment;

import java.util.Arrays;
import java.util.Random;

public class PageRankTask4 {

         /*
        Réponses à la question de la tâche 4.d :
                - Quelle méthode nécessite le moins d'itérations pour obtenir
                un PageRank précis ?
                - Réponse :
                
                - Pourquoi, selon vous ?
                - Réponse :
                
        */

        /* Utilisez cet objet pour générer des nombres aléatoires*/
        
        public static void main(String[] argv) {
                /*Réseau de pages exemple*/
                int [][] net = {
                        { 1, 2 }, //page 0
                        { 2, 2, 4}, //page 1
                        { 4 }, //page 2
                        { 0, 0}, //page 3
                        { 1, 2 , 4} //page 4
                };
                
                System.out.println("Estimation du PageRank (random walk - 25 itérations - damping 0.9) : ");
                int[] path = PageRankTask1.randomSurfer(net, 25);
                System.out.println(Arrays.toString(PageRankTask3.computePageRank(path, net.length)));

                System.out.println("Estimation du PageRank (méthode matricielle) - 25 itérations - damping 0.9 : ");
                System.out.println(Arrays.toString(estimatePageRank(net, 25, 0.9)));    
                
        }


        public static double[] estimatePageRank(int[][] net, int steps, double dampingFactor) {
                /* Méthode à coder */
        
                return pageRankIterations(computeTransitionsMatrix(net,dampingFactor), steps);
        }

        public static double[][] computeTransitionsMatrix(int[][] net, double dampingFactor) {
                /* Méthode à coder */
                
                double[][] transitions = new double[net.length][net.length];
                
                for(int i = 0; i<net.length; ++i ){ 
					for(int j = 0; j<net[i].length; ++j ){
						transitions[i][net[i][j]]++;
					}
				}
                
                for(int i = 0; i<net.length; ++i ){
                	int nbPageRef = 0;
                	for(int k = 0; k <net.length; ++k ){
						if(transitions[i][k] != 0){
							++nbPageRef;
						}
                	}
					for(int j = 0; j<net.length; ++j ){
						transitions[i][j] = transitions[i][j] * dampingFactor / nbPageRef  + (1 - dampingFactor)/net.length;
					}
				}    
                
      
                
                return transitions;
        }

        public static double[] pageRankIterations(double[][] transitions, int steps) {
                /* Methode à coder */
        		double[] table = new double[transitions.length];
        		table[0] = 1.0;
        		
        		
        		for(int pas = 0; pas <steps; ++pas){
        			double[] tableDeCalcul = new double[transitions.length];
        			
        			for(int i=0; i<transitions.length; ++i){
        				tableDeCalcul[i] = table[i];
        			}
     
        			for(int i= 0; i < transitions.length; ++i){
        				double somme = 0.0;
        				for(int j= 0; j < transitions.length; ++j){
            				somme += table[j] * transitions[j][i];
            			}
        				tableDeCalcul[i]= somme;
        			}
        			
        			for(int i=0; i<transitions.length; ++i){
        				table[i] = tableDeCalcul[i];	
        			}
        			
        		}
        	
        			 
        		return table;
        }

}
