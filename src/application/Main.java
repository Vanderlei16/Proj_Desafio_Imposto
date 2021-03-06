package application;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		double imp_sal, imp_rendserv, imp_ganhocap,  imp_brut,  sal_anual,abatimento;
		String opcao;
		
		System.out.println("********** CALCULO IMPOSTO RENDA ANUAL **********");

		do {
			System.out.println();
			System.out.print("Renda Salario anual: ");
			sal_anual = sc.nextDouble();
			double salario = sal_anual / 12;

			System.out.print("Renda Presta??o servi?os anual: ");
			double rend_serv = sc.nextDouble();

			System.out.print("Renda Ganho Capital anual: ");
			double ganho_cap = sc.nextDouble();

			System.out.print("Despesas Medicas: ");
			double gast_med = sc.nextDouble();

			System.out.print("Despesas com Educa??o: ");
			double gast_educ = sc.nextDouble();

			// Calculo imposto sobre Sal?rio

			imp_sal =  impostoSobreSalario(salario);    // Fun??o calculo Imp. Salario implementada
			
			
			
		/*	if (salario >= 5000.00) {
			imp_sal = sal_anual * 0.2;
		} else if (salario >= 3000.00 && salario < 5000.00) {
			imp_sal = sal_anual * 0.1;
			} else
				imp_sal = 0.0;   */
			
			
			

			// Calculo Imposto sobre Renda presta??o de Servi?os
				
			imp_rendserv = impostoSobreServicos(rend_serv) ; // Fun??o calculo Imp. RendaServ implementada

			// Calculo Imposto Ganho Capital
						
			imp_ganhocap = impostoSobreGC(ganho_cap);     // Fun??o calculo Imp. GC implementada
			

			// Imposto Bruto
						
			imp_brut =  impostoBrutoTotal_test(salario , rend_serv , ganho_cap);
			

			// Calculo Dedu??o com Gastos Medicos e Educa??o

			abatimento = abatimento(gast_med, gast_educ, imp_brut);
			
		  /*	med_educ = gast_med + gast_educ;
			if (med_educ < imp_brut * 0.3) {
				ded_mededuc = med_educ;
			} else
				ded_mededuc = imp_brut * 0.3;*/ 
			

			// Impress?o de teste comentada, por n?o ser pedida no desafio.
			/*
			 * System.out.printf("Renda anual com Sal?rio: %.2f\n",sal_anual);
			 * System.out.printf("Renda anual com Presta??o de Servi?os: %.2f\n",rend_serv);
			 * System.out.printf("Renda anual com Ganhos de Capital: %.2f\n",ganho_cap);
			 * System.out.println();
			 */

			
			// Saida dos dados e calculo dos impostos
			System.out.println();
			System.out.println("RELAT?RIO DE IMPOSTO DE RENDA ");
			System.out.println();
			System.out.println("CONSOLIDADO DE RENDA: ");
			System.out.printf("Imposto sobre sal?rio: %.2f\n", imp_sal);
			System.out.printf("Imposto sobre servi?os: %.2f\n", imp_rendserv);
			System.out.printf("Imposto sobre ganho de capital: %.2f\n", imp_ganhocap);
			System.out.println();

			System.out.println("DEDU??ES: ");
			System.out.printf("M?ximo dedut?vel: %.2f\n", imp_brut * 0.3);
			System.out.printf("Gastos dedut?veis: %.2f\n", abatimento);
			System.out.println();

			System.out.println("RESUMO: ");
			System.out.printf("Imposto bruto total: %.2f\n", imp_brut);
			System.out.printf("Abatimento: %.2f\n", abatimento);
			System.out.printf("Imposto devido: %.2f\n", imp_brut - abatimento);
			System.out.println();
			sc.nextLine();
			System.out.print("=> Deseja executar novo calculo de Imposto Renda (S/N): ");
			opcao = sc.nextLine();

		} while (opcao.equalsIgnoreCase("s") || opcao.equalsIgnoreCase("S"));

		System.out.println();
		System.out.println("Fim do Programa");

		sc.close();
		
		}
	
	// ------------------------------------Fun?oes-----------------------------------//

		// Imposto sobre salario

		public static double impostoSobreSalario(double salario) {
			if (salario >= 5000.00) {
				return salario * 12 * 0.2;
			} else if (salario >= 3000.00 && salario < 5000.00) {
				return salario * 12 * 0.1;
			} else {
				return 0.0;
			}
		}
		
		
		// Imposto sobre Servi?os

		public static double impostoSobreServicos(double renda_servic) {
			return renda_servic * 0.15;
		}
		
		// Imposto sobre Ganho Capital

		public static double impostoSobreGC(double ganho_cap) {
			return ganho_cap * 0.2;
		}
		
		// Imposto Bruto total

		public static double impostoBrutoTotal_test(double salario, double rend_serv, double ganho_cap) {
			if (salario >= 5000.00) {
				return (salario * 12 * 0.2) + (rend_serv * 0.15) + (ganho_cap * 0.2);
			} else if (salario >= 3000.00 && salario < 5000.00) {
				return (salario * 12 * 0.1) + (rend_serv * 0.15) + (ganho_cap * 0.2);
			} else {
				return 0.0 + (rend_serv * 0.15) + (ganho_cap * 0.2);
			}
		}
		
		// Abatimento
		
		public static double abatimento(double gast_med, double gast_educ, double imp_brut) {
			double gastMed_Educ = gast_med + gast_educ;
			if (gastMed_Educ < imp_brut * 0.3) {
				return gastMed_Educ;
			} else
				return imp_brut * 0.3;
		}
		
	
	}
	 
	 	

	   

