package domain;

import exception.DatoNonValido;

public enum NomeOptional {
	RISCALDAMENTO_INTERNI;
	
	public static NomeOptional StringToNomeOptional(String s) throws DatoNonValido{
		NomeOptional n=null;
		switch(s){
		case "RiscaldamentoInterni":
			n= NomeOptional.RISCALDAMENTO_INTERNI;
			break;
		default:
			throw new DatoNonValido("NomeOptional invalido "+s);
		}
		return n;
	}
}
