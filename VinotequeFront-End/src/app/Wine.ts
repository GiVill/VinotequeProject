import { Cantina } from "./Cantina";

export interface Wine {
  id : BigInt ;
  nome : String;
  annata : Number;
  prezzo : Number;
  gradazione_alcolica : Number;
  tipologia : string;
  cantina : Cantina;
  premi : String;
  foto : Blob;

}
