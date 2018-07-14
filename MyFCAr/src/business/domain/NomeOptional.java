package business.domain;

import exception.DatoInputErrato;

public enum NomeOptional {
	RISCALDAMENTO_INTERNI;
	
	public static NomeOptional StringToNomeOptional(String s) throws DatoInputErrato{
		NomeOptional n=null;
		switch(s){
		case "RiscaldamentoInterni":
			n= NomeOptional.RISCALDAMENTO_INTERNI;
			break;
		default:
			throw new DatoInputErrato("NomeOptional invalido "+s);
		}
		return n;
	}
}
