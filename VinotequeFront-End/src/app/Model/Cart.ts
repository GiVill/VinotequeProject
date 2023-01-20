import { User } from "./User";
import { Wine } from "./Wine";

export interface Cart{
  carrello_utente : User;
  vini : Map<Wine,Number>;
  data : String;
}
