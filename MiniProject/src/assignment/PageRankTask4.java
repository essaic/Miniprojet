package assignment;

import java.util.Arrays;
import java.util.Random;

public class PageRankTask4 {

        /*
        RÉPONSES À LA QUESTION DE LA TÂCHE 4.D :
                - QUELLE MÉTHODE NÉCESSITE LE MOINS D'ITÉRATIONS POUR OBTENIR
                UN PAGERANK PRÉCIS ?
                - RÉPONSE :
                
                - POURQUOI, SELON VOUS ?
                - RÉPONSE :
                
        */

        /* UTILISEZ CET OBJET POUR GÉNÉRER DES NOMBRES ALÉATOIRES*/
        
        PUBLIC STATIC VOID MAIN(STRING[] ARGV) {
                /*RÉSEAU DE PAGES EXEMPLE*/
                INT [][] NET = {
                        { 1, 2 }, //PAGE 0
                        { 2, 2, 4}, //PAGE 1
                        { 4 }, //PAGE 2
                        { 0, 0}, //PAGE 3
                        { 1, 2 , 4} //PAGE 4
                };
                
                SYSTEM.OUT.PRINTLN("ESTIMATION DU PAGERANK (RANDOM WALK - 25 ITÉRATIONS - DAMPING 0.9) : ");
                INT[] PATH = PAGERANKTASK1.RANDOMSURFER(NET, 25);
                SYSTEM.OUT.PRINTLN(ARRAYS.TOSTRING(PAGERANKTASK3.COMPUTEPAGERANK(PATH, NET.LENGTH)));

                SYSTEM.OUT.PRINTLN("ESTIMATION DU PAGERANK (MÉTHODE MATRICIELLE) - 25 ITÉRATIONS - DAMPING 0.9 : ");
                SYSTEM.OUT.PRINTLN(ARRAYS.TOSTRING(ESTIMATEPAGERANK(NET, 25, 0.9)));    
                
        }


        PUBLIC STATIC DOUBLE[] ESTIMATEPAGERANK(INT[][] NET, INT STEPS, DOUBLE DAMPINGFACTOR) {
                /* MÉTHODE À CODER */
        
                RETURN PAGERANKITERATIONS(COMPUTETRANSITIONSMATRIX(NET,DAMPINGFACTOR), STEPS);
        }

        PUBLIC STATIC DOUBLE[][] COMPUTETRANSITIONSMATRIX(INT[][] NET, DOUBLE DAMPINGFACTOR) {
                /* MÉTHODE À CODER */
                
                DOUBLE[][] TRANSITIONS = NEW DOUBLE[NET.LENGTH][NET.LENGTH];
                
                FOR(INT I = 0; I<NET.LENGTH; ++I ){ 
					FOR(INT J = 0; J<NET[I].LENGTH; ++J ){
						TRANSITIONS[I][NET[I][J]]++;
					}
				}
                
                FOR(INT I = 0; I<NET.LENGTH; ++I ){
                	INT NBPAGEREF = 0;
                	FOR(INT K = 0; K <NET.LENGTH; ++K ){
						IF(TRANSITIONS[I][K] != 0){
							++NBPAGEREF;
						}
                	}
					FOR(INT J = 0; J<NET.LENGTH; ++J ){
						TRANSITIONS[I][J] = TRANSITIONS[I][J] * DAMPINGFACTOR / NBPAGEREF  + (1 - DAMPINGFACTOR)/NET.LENGTH;
					}
				}    
                
      
                
                RETURN TRANSITIONS;
        }

        PUBLIC STATIC DOUBLE[] PAGERANKITERATIONS(DOUBLE[][] TRANSITIONS, INT STEPS) {
                /* METHODE À CODER */
        		DOUBLE[] TABLE = NEW DOUBLE[TRANSITIONS.LENGTH];
        		TABLE[0] = 1.0;
        		
        		
        		FOR(INT PAS = 0; PAS <STEPS; ++PAS){
        			DOUBLE[] TABLEDECALCUL = NEW DOUBLE[TRANSITIONS.LENGTH];
        			
        			FOR(INT I=0; I<TRANSITIONS.LENGTH; ++I){
        				TABLEDECALCUL[I] = TABLE[I];
        			}
     
        			FOR(INT I= 0; I < TRANSITIONS.LENGTH; ++I){
        				DOUBLE SOMME = 0.0;
        				FOR(INT J= 0; J < TRANSITIONS.LENGTH; ++J){
            				SOMME += TABLE[J] * TRANSITIONS[J][I];
            			}
        				TABLEDECALCUL[I]= SOMME;
        			}
        			
        			FOR(INT I=0; I<TRANSITIONS.LENGTH; ++I){
        				TABLE[I] = TABLEDECALCUL[I];	
        			}
        			
        		}
        	
        			 
        		RETURN TABLE;
        }

}
