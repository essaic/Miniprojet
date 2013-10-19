package assignment;

import java.util.Arrays;
import java.util.Random;

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
		/* Copiez/collez et adaptez votre solution à la tâche 1 */
		return null;
	}

	public static int getNextPage(int[][] net, int currentPage, double damping) {
		/* Copiez/collez et adaptez votre solution à la tâche 1 */
		return 0;
	}

}
