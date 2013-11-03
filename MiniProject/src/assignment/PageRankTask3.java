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
	public static int [][] netpage0 = {
		{ 1, 2 },    //page 0
		{ 2, 2, 4},  //page 1
		{ 4 },       //page 2
		{ 0, 0},     //page 3
		{ 1, 2 , 4, 3}  //page 4
	};

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
		
		int[] pages = new int[steps];

		//Avoid errors
		if(net.length > 0 && steps > 0)
		{
			//We start on page 0
			pages[0] = 0;
		}

		for(int i = 1; i < steps; ++i)
		{
			pages[i] = getNextPage(net, pages[i-1]);
		}

		return pages;	
	}

	public static int getNextPage(int[][] net, int currentPage) {
		/* Copiez/collez votre solution à la tâche 1 */
		
		//The damping coefficient
		double damping = 0.9;

		double dampingChoice = random.nextDouble();

		int[] pageLinks = net[currentPage];

		if(dampingChoice < damping && pageLinks.length != 0)
		{
			//Take a random links from the page

			int linkChoice = random.nextInt(pageLinks.length);

			return pageLinks[linkChoice];
		}
		else
		{
			//Take a random url int the whole network
			return random.nextInt(net.length);
		}

	}

	public static double[] computePageRank(int[] path, int pageCount) {
		/* Méthode à coder */

		double[] PageRank = new double[pageCount];

		//Compute the pageRank for each page in path[]
		for(int i = 0; i < pageCount ; i++)
		{
			PageRank[i] = ( (double)countVisit(path, i) ) / ((double)path.length);
		}

		return PageRank;
	}

	public static double getMaxDiff(final double[] rank1, final double[] rank2) {
		/* Méthode à coder */

		//find which table has the minimum length to prevent from substracting things that doesn't exist.
		int minLength = (rank1.length <= rank2.length ? rank1.length : rank2.length);

		double diff = 0.0;

		//Go through the list to find the maximum difference
		for (int i = 0 ; i < minLength ; i++)
		{
			double actualDiff = Math.abs(rank1[i] - rank2[i]);
			if (actualDiff > diff)
			{
				diff = actualDiff;
			}
		}
		
		return diff;
	}

	public static int getConvSteps(final int[][] net) {
		/* Méthode à coder */
		
		//number of steps
		int k = 0;
		
		double[] ranks;
		
		//Repeat the pageRank algorithm until we found a accurate result
		do
		{
			k++;
			
			int[] path = randomSurfer(net, k);
			ranks = computePageRank(path, net.length);
			
		} while(getMaxDiff(ranks, realPageranks) >=  0.001);
		
		return k;
	}

	public static int countVisit(int[] path, int page) {
		/* Méthode à coder */

		//Count how many times a page has been visited
		int count = 0;

		for(int i : path)
		{
			if(i == page)
			{
				count += 1;
			}
		}

		return count;
	}

}
