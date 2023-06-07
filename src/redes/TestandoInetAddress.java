package redes;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestandoInetAddress {

	public static void main(String[] args) throws UnknownHostException {
		
		InetAddress localHost = InetAddress.getLocalHost();
		System.out.println("Endereço local: " + localHost);
		System.out.println("é um IP local? " + localHost.isSiteLocalAddress());
		
		InetAddress enderecoPorDominio = InetAddress.getByName("yahoo.com.br");
		System.out.println(enderecoPorDominio);
		
		InetAddress enderecoPorIp = InetAddress.getByName("34.225.127.72");
		System.out.println(enderecoPorIp);
		System.out.println(enderecoPorIp.getHostName());
		
		byte[] array = {(byte) 142, (byte) 251, (byte) 128, (byte) 46};
		InetAddress enderecoPorArray = InetAddress.getByAddress(array);
		System.out.println(enderecoPorArray);
	}
}
