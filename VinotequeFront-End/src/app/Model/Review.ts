import { User } from "./User";
import { Wine } from "./Wine";

export interface Review{
  id : Number;
  descrizione : String;
  recensione_sommelier : User;
  recensione_vino : Wine;
  data : String;
}


