import { User } from "./User";
import { Wine } from "./Wine";

export interface Favorite{
  preferiti_utente : User;
  preferiti_vino : Wine;
}
