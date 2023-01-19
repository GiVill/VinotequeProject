import { User } from "./User";
import { Wine } from "./Wine";

export interface Review{
  id : BigInt;
  descrizione : String;
  recensione_sommelier : User;
  recensione_vino : Wine;
  data : String;
}


