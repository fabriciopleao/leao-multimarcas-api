package com.leaomulti.leaocentermultimarcas.exception;

public class CadastroVeicularException extends RuntimeException{

	public CadastroVeicularException(String message) {
		super(message);
	}
	
	public static class BlankFieldException extends CadastroVeicularException {
		public BlankFieldException(){
			super("Preencha todos os campos para efetuar o cadastro.");
		}
	}
	
	public static class InvalidBrandModelException extends CadastroVeicularException {
		public InvalidBrandModelException() {
			super("A marca e modelo do veículo devem coincidir.");
		}
	}
	
	public static class InvalidYearModelException extends CadastroVeicularException {
		public InvalidYearModelException() {
			super("Ano mínimo do modelo permitido para anunciar é de 1980 à diante.");
		}
	}
	
	public static class InvalidFuelException extends CadastroVeicularException{
		public InvalidFuelException() {
			super("Tipos de combustíveis autorizados: gasolina, álcool, diesel ou elétrico.");
		}
	}
	
}
