package aplicacation;
/* Nessa versão, criamos um pacote para guardar nossa Classe 
 * DomainException que é uma exceção personalizada do Dominio
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.DomainException.DomainException;
import model.entities.Reserva;

public class Aplicacao {

	// Com a DomainException se torna obrigotorio tratar o erro, ela estende de Exception 
	// public static void main(String[] trows DomainException args) 
	public static void main(String[] args)  {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.printf("Digite o numero do Quarto: ");
			int quarto = sc.nextInt();

			System.out.println("Entrada: ");
			Date dataEntrada = sdf.parse(sc.next());

			System.out.println("Saida: ");
			Date dataSaida = sdf.parse(sc.next());

			Reserva reserva = new Reserva(quarto, dataEntrada, dataSaida);

			System.out.print("Reserva: \n" + reserva.toString());

			// inicio da atualização da reserva.

			System.out.println();
			System.out.printf("\n Atualização de Reservas \n");

			System.out.println("Entrada: ");
			dataEntrada = sdf.parse(sc.next());

			System.out.println("Saida: ");
			dataSaida = sdf.parse(sc.next());
			reserva.AtualizaData(dataEntrada, dataSaida);
			System.out.println(reserva.toString());

		} 
		 // Trata a inconsistencia de datas
		catch (ParseException e) {
			System.out.println(" Formato de data Invalido !");
		}

		// Captura a exceção e quarda em e.
		catch (DomainException e) {
			// imprime a mensagem de erro mais a mensagem capiturada da exceção.
			System.out.printf("Erro ao realizar a Reserva" + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println(" Ocorreu um erro inesperado ! Entre em contato com o Suporte 881");
		}
		sc.next();
		sc.close();
	}

}