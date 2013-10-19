package assignment;

import java.util.Random;

public class PageRankTask3 {

	/* Utilisez cet objet pour générer des nombres aléatoires*/
	public static Random random = new Random(2013);  
	
	/* Vraies valeur de pagerank pour le réseau "net" */
	public static final double[] realPageranks = new double[]{
		0.03800000000000003, 0.17960674190896989, 
		0.2873707867385369, 0.02000000000000001, 
		0.47502247135249404};
	
	/* Please modify this network with your solution of task 2.c */
	public static int [][] netpage0;

	public static void main(String[] argv) {   
		/*Réseau de pages exemple*/
		int [][] net = {
			{ 1, 2 },    //page 0
			{ 2, 2, 4},  //page 1
			{ 4 },       //page 2
			{ 0, 0},     //page 3
			{ 1, 2 , 4}  //page 4
		};

		int[] path = randomSurfer(net, 20);
		double[] ranks = computePageRank(path, net.length);
		
		for (int p = 0; p < ranks.length; p++) {
			System.out.print("La page " + p + " a été visitée " + countVisit(path, p) + " fois. ");
			System.out.println("Son PageRank estimé est de " + ranks[p]);
		}
		System.out.println("Il faut " + getConvSteps(net) + " itérations pour avoir un résultat précis");
	}

	public static int[] randomSurfer(int[][] net, int steps) {  
		/* Copiez/collez votre solution à la tâche 1 */
		return null;
	}
	
	public static int getNextPage(int[][] net, int currentPage) {
		/* Copiez/collez votre solution à la tâche 1 */
		return 0;
	}
	
	public static double[] computePageRank(int[] path, int pageCount) {
		/* Méthode à coder */
		return null;
	}
	
	public static double getMaxDiff(final double[] rank1, final double[] rank2) {
		/* Méthode à coder */
		return 0.0;
	}

	public static int getConvSteps(final int[][] net) {
		/* Méthode à coder */
		return 0;
	}
	
	public static int countVisit(int[] path, int page) {
		/* Méthode à coder */
		return 0;
	}

}
