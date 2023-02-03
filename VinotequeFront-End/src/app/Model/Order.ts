import { Promotion } from "./Promotion";
import { User } from "./User";

export interface Order{
  id : number;
  ordine_utente : User;
  ordine_carrello : String;
  metodo_pag : String;
  indirizzo : String;
  totale : Number;
  status : String;
  ordine_promozione : Promotion;
  data : String;
}
