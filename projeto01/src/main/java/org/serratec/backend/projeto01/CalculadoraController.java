package org.serratec.backend.projeto01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {
	
	@RequestMapping("/somar")
	public int somar(@RequestParam int valor1, int valor2) { 

		return valor1+valor2;
	}
	
	@RequestMapping("/subtrair")
	public int subtrair(@RequestParam int valor1, int valor2) { 

		return valor1-valor2;
	}
	
	@RequestMapping("/multiplicar")
	public int multiplicar(@RequestParam int valor1, int valor2) { 

		return valor1*valor2;
	}
	
	@RequestMapping("/dividir")
	public double dividir(@RequestParam double valor1, double valor2) { 

		return valor1/valor2;
	}
	
	@RequestMapping("/calculadora")
	public double dividir(@RequestParam double valor1, double valor2, String operacao) { 
		
		operacao.toLowerCase();
		switch(operacao) {
		case "soma":
			return valor1+valor2;
		case "sub":
			return valor1-valor2;
		case "multi":
			return valor1*valor2;
		case "div":
			return valor1/valor2;
		default:
			System.out.println("Erro.");
			return 0;
		}
	}
		
}
