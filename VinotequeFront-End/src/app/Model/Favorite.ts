import { AuthenticationService } from "../Services/authentication.service";
import { User } from "./User";
import { Wine } from "./Wine";

export interface Favorite{
  preferiti_utente : User;
  preferiti_vino : Wine;
}

export function removeFromArray(array: Number[], itemToRemove: Number) {
  return array.filter(item => item !== itemToRemove);
}
