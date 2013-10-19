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
	public static Random random = new Random(2013);    
	
	public static void main(String[] argv) {   
		/*Réseau de pages exemple*/
		int [][] net = {
			{ 1, 2 },    //page 0
			{ 2, 2, 4},  //page 1
			{ 4 },       //page 2
			{ 0, 0},     //page 3
			{ 1, 2 , 4}  //page 4
		};
		
		System.out.println("Estimation du PageRank (random walk - 25 itérations - damping 0.9) : ");
		int[] path = PageRankTask1.randomSurfer(net, 25);
		System.out.println(Arrays.toString(PageRankTask3.computePageRank(path, net.length)));

		System.out.println("Estimation du PageRank (méthode matricielle) - 25 itérations - damping 0.9 : ");
		System.out.println(Arrays.toString(estimatePageRank(net, 25, 0.9)));	
	}


	public static double[] estimatePageRank(int[][] net, int steps, double dampingFactor) {
		/* Méthode à coder */
		return null;
	}

	public static double[][] computeTransitionsMatrix(int[][] net, double dampingFactor) {
		/* Méthode à coder */
		return null;
	}

	public static double[] pageRankIterations(double[][] transitions, int steps) {
		/* Méthode à coder */
		return null;
	}

}
