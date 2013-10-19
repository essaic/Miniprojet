package assignment;

import java.util.Random;

public class PageRankTask1 {

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
		/* Méthode à coder */
		
		int[] pages = new int[steps];
		
		//on commence a la page 0 
		pages[0] = 0;
		
		for(int i = 1; i < steps; ++i)
		{
			pages[i] = getNextPage(net, pages[i-1]);
		}
		
		return pages;
	}
	
	public static int getNextPage(int[][] net, int currentPage) {
		/* Méthode à coder
		 * Utilisez random.nextDouble() pour générer un réel aléatoire
		 * et random.nextInt(int n) pour générer un entier aléatoire.
		 */
		
		double damping = 0.9;
		
		double dampingChoice = random.nextDouble();
		
		if(dampingChoice > damping)
		{
			//On saute alors vers une page aleatoire
			return random.nextInt(net.length);
		}
		else
		{
			//On prend un lien de la page de face aleatoire
			int[] pageLinks = net[currentPage];
			int linkChoice = random.nextInt(pageLinks.length);
			
			return pageLinks[linkChoice];
		}
	}

	public static String visualizeVisit(int page, int totalPageNum) {
		/* Méthode à coder */
		
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
