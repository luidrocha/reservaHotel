package aplicacation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reserva;

public class Aplicacao {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.printf("Digite o numero do Quarto: ");
		int quarto = sc.nextInt();

		System.out.println("Entrada: ");
		Date dataEntrada = sdf.parse(sc.next());

		System.out.println("Saida: ");
		Date dataSaida = sdf.parse(sc.next());

		// Veriufica se dataEntrada não é depois de dataSaida
		if (!dataSaida.after(dataEntrada)) {

			System.out.println("Erro ao realizar A Reserva, data de SAIDA deve ser POSTERIOR a data de ENTRADA");
		} else {

			Reserva reserva = new Reserva(quarto, dataEntrada, dataSaida);

			System.out.print("Reserva: \n" + reserva.toString());

			// inicio da atualização da reserva.

			System.out.println();
			System.out.printf("\n Atualização de Reservas \n");

			System.out.println("Entrada: ");
			dataEntrada = sdf.parse(sc.next());

			System.out.println("Saida: ");
			dataSaida = sdf.parse(sc.next());

			Date dataHoje = new Date();

			// Verifica se as datas são antes da data de hoje.

			if (dataEntrada.before(dataHoje) || dataSaida.before(dataHoje)) {

				System.out.println("As datas para atualização devem ser no futuro");

			} else if (!dataSaida.after(dataEntrada)) {

				System.out.println("Erro ao realizar A Reserva, data de SAIDA deve ser POSTERIOR a data de ENTRADA");
			} else {

				// Atualiza as datas de reserva

				reserva.AtualizaData(dataEntrada, dataSaida);

				// Mostra a reserva atualizada
				
				System.out.println(reserva.toString());

				sc.next();
				sc.close();
			}

		}
	}
}