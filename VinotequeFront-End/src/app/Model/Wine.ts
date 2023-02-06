import { Cantina } from "./Cantina";

export interface Wine {
  id : BigInt ;
  nome : String;
  annata : Number;
  prezzo : Number;
  gradazione_alcolica : Number;
  tipologia : string;
  vino_cantina : Cantina;
  premi : String;
  descrizione : String;
  vigneto : String;
  foto : Blob;
}
