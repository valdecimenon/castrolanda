package datas;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// SimpleDateFormat e DateFormat
public class FormatandoDatas {

	public static void main(String[] args) throws ParseException {
		Date agora = new Date();
		
		// Formatação de datas com SimpleDateFormat
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		String data = formatador.format(agora);
		System.out.println("Data: " + data);
		
		// Fomatação de hora
		formatador.applyPattern("HH:mm:ss");  // ou hh
		String hora = formatador.format(agora);
		System.out.println("Hora: " + hora);
		
		// Convertendo String em data e hora
		formatador.applyPattern("dd/MM/yyyy");
		Date novaData = formatador.parse("13/06/2023");
		System.out.println(novaData);
		
		// Data por extenso: Ponta Grossa, 13 de Junho de 2023
		formatador.applyPattern("dd");
		String dia = formatador.format(agora);
		System.out.println(dia);
		
		formatador.applyPattern("MMMM");
		String mes = formatador.format(agora);
		System.out.println(mes);
		
		formatador.applyPattern("yyyy");
		String ano = formatador.format(agora);
		System.out.println(ano);
		
		System.out.printf("Ponta Grossa, %s de %s de %s", dia, mes, ano);
		
		// Formatação de datas com DateFormat
		
		// português, Brasil: pt-BR
		DateFormat formatadorBrasil = DateFormat.getDateInstance(DateFormat.LONG,  Locale.forLanguageTag("pt"));
		System.out.printf("\nPonta Grossa, %s", formatadorBrasil.format(agora));
		
		// França
		DateFormat formatadorFranca = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRANCE);
		System.out.printf("\nParis, %s", formatadorFranca.format(agora));
		
		// US
		DateFormat formatadorUSA = DateFormat.getDateInstance(DateFormat.LONG, Locale.US);
		System.out.printf("\nNew York, %s", formatadorUSA.format(agora));
		
		DateFormat formatadorKorea = DateFormat.getDateInstance(DateFormat.LONG, Locale.KOREA);
		System.out.printf("\nKorea, %s", formatadorKorea.format(agora));
	}
}
