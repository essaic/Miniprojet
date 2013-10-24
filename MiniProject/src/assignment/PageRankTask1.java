package assignment;

import java.util.Random;

public class PageRankTask1 {

	/* Utilisez cet objet pour générer des nombres aléatoires*/
	public static Random random = new Random(43218);     

	public static void main(String[] argv) {   
		/*Réseau de pages exemple*/
		int [][] net = {
				{ 1, 2 },    //page 0
				{ 2, 2, 4},  //page 1
				{ 4 },       //page 2
				{ 0, 0},     //page 3
				{ 1, 2 , 4}  //page 4
		};

		int[] path = randomSurfer(net, 10);
		for (int i = 0; i < path.length; i++) {
			System.out.println("L'utilisateur visite la page " + path[i]);
		}
		System.out.println("Visualisation graphique des visites : ");
		for (int i = 0; i < path.length; i++) {
			System.out.println(visualizeVisit(path[i], net.length));
		}
	}

	public static int[] randomSurfer(int[][] net, int steps) {  

		int[] pages = new int[steps];

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

	public static String visualizeVisit(int page, int totalPageNum) {

		String result = "";

		for(int i = 0; i < totalPageNum; i++)
		{
			if(i ==  page)
			{
				result += "x";
			}
			else
			{
				result += "-";
			}
		}

		return result;
	}
}
