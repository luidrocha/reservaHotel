package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer numeroQuarto;
	private Date dataEntrada;
	private Date dataSaida;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva() {

	}

	public Reserva(Integer numeroQuarto, Date dataEntrada, Date dataSaida) {

		this.numeroQuarto = numeroQuarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;

	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public long Duracao() {

		// Pega as datas em mile segundo e calcula a diferen�a.
		long diff = dataEntrada.getTime() - dataSaida.getTime();

		// Converte para dias o falor em diff.
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String AtualizaData(Date dataEntrada, Date dataSaida) {
// Melhora foi delegar a fun��o a classe tirando do programa principal
		
		Date dataHoje = new Date();
		// Verifica se as datas s�o antes da data de hoje.
		if (dataEntrada.before(dataHoje) || dataSaida.before(dataHoje)) {

			return "As datas para atualiza��o devem ser no futuro";

		}
		// Verifica se a dataSaida n�o � depois da dataEntrada
		if (!dataSaida.after(dataEntrada)) {

			return "Erro ao realizar A Reserva, data de SAIDA deve ser POSTERIOR a data de ENTRADA";
		}

		// Atualiza as datas de reserva
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		// Retorna nulo informando que n�o deu nenhum erro
		return null;
	}

	@Override

	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("Quarto: ");
		sb.append(numeroQuarto);
		sb.append(", Entrada ");
		sb.append(sdf.format(dataEntrada));
		sb.append(", Saida ");
		sb.append(sdf.format(dataSaida));
		sb.append(", Dura��o ");
		sb.append(Duracao() + " Dias");

		return sb.toString();

	}

}
