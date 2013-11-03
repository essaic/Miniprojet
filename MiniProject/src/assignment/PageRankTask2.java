package assignment;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PageRankTask2 {

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
		
		int[] path = randomSurfer(net);
		System.out.println("Séquence des pages suivies : " + Arrays.toString(path));
	}

	public static int[] randomSurfer(int[][] net) {  	
		
		Scanner keyb = new Scanner(System.in);
		
		//Ask for the number of steps
		System.out.println("Entrez le nombre de pas : ");
		int steps = keyb.nextInt();
		
		//Ask for the damping coefficient
		System.out.println("Entrez le facteur de damping : ");
		double damping = keyb.nextDouble();
		
		int[] pages = new int[steps];

		//Avoid errors
		if(net.length > 0 && steps > 0)
		{
			//We start on page 0
			pages[0] = 0;
		}

		for(int i = 1; i < steps; ++i)
		{
			pages[i] = getNextPage(net, pages[i-1], damping);
		}

		return pages;
	}

	public static int getNextPage(int[][] net, int currentPage, double damping) {

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

}
