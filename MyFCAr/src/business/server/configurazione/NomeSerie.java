package business.server.configurazione;

import exception.DatoInputErrato;

public enum NomeSerie {
	POSIZIONE_ORIZZONTALE_SEDILE, INCLINAZIONE_SEDILE, ANGOLO_AZIMUTALE_SPECCHIETTO_DX, ANGOLO_ZENITALE_SPECCHIETTO_DX, ANGOLO_AZIMUTALE_SPECCHIETTO_SX, ANGOLO_ZENITALE_SPECCHIETTO_SX, TEMPERATURA, FREQUENZA_STAZIONE_RADIO_1, FREQUENZA_STAZIONE_RADIO_2, FREQUENZA_STAZIONE_RADIO_3, FREQUENZA_STAZIONE_RADIO_4, FREQUENZA_STAZIONE_RADIO_5, FREQUENZA_STAZIONE_RADIO_6;
	
	public static NomeSerie StringToNomeSerie(String s) throws DatoInputErrato{
		NomeSerie n=null;
		switch(s){
		case "PosizioneOrizzontaleSedile":
			n= NomeSerie.POSIZIONE_ORIZZONTALE_SEDILE;
			break;
		case "InclinazioneSedile":
			n= NomeSerie.INCLINAZIONE_SEDILE;
			break;
		case "AngoloAzimutaleSpecchiettoDX":
			n= NomeSerie.ANGOLO_AZIMUTALE_SPECCHIETTO_DX;
			break;
		case "AngoloZenitaleSpecchiettoDX":
			n= NomeSerie.ANGOLO_ZENITALE_SPECCHIETTO_DX;
			break;
		case "AngoloAzimutaleSpecchiettoSX":
			n= NomeSerie.ANGOLO_AZIMUTALE_SPECCHIETTO_SX;
			break;
		case "AngoloZenitaleSpecchiettoSX":
			n= NomeSerie.ANGOLO_ZENITALE_SPECCHIETTO_SX;
			break;
		case "Temperatura":
			n= NomeSerie.TEMPERATURA;
			break;
		case "FrequenzaStazioneRadio1":
			n= NomeSerie.FREQUENZA_STAZIONE_RADIO_1;
			break;
		case "FrequenzaStazioneRadio2":
			n= NomeSerie.FREQUENZA_STAZIONE_RADIO_2;
			break;
		case "FrequenzaStazioneRadio3":
			n= NomeSerie.FREQUENZA_STAZIONE_RADIO_3;
			break;
		case "FrequenzaStazioneRadio4":
			n= NomeSerie.FREQUENZA_STAZIONE_RADIO_4;
			break;
		case "FrequenzaStazioneRadio5":
			n= NomeSerie.FREQUENZA_STAZIONE_RADIO_5;
			break;
		case "FrequenzaStazioneRadio6":
			n= NomeSerie.FREQUENZA_STAZIONE_RADIO_6;
			break;
		default:
			throw new DatoInputErrato("NomeSerie invalido "+s);
		}
		return n;
	}
}
