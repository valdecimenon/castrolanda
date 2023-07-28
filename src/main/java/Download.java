

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;


// faz download da imagem sucesso.jpg do local /WEB-INF/img
@WebServlet("/download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String imagem = getServletContext().getRealPath("/WEB-INF/img/sucesso.jpg");
		// tipo MIME: application/pdf
		response.setContentType("images/jpeg");
		response.addHeader("Content-Disposition", "attachment; filename=imagem.jpg");
		
		try (FileInputStream entrada = new FileInputStream(imagem);
				OutputStream saida = response.getOutputStream()) {
			
			byte[] buffer = new byte[1024];
			int b;
			
			while ((b = entrada.read(buffer)) > -1) {
				saida.write(buffer, 0, b);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
