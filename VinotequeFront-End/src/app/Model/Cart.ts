import { Wine } from "./Wine";

export interface Cart{
  idUtente : BigInt,
  vini : BigInt[],
  quantity : number[],
  totale : number,
}


export function addWine(cart:Cart,wine:Wine,quantity:number){
  cart.vini.push(wine.id);
  cart.quantity.push(quantity);
  cart.totale += wine.prezzo.valueOf();
  // cart.totale.toFixed(2);
}

export function removeWine(cart:Cart,wine:Wine){
  let index = cart.vini.indexOf(wine.id)
  cart.vini.splice(index, 1);
  cart.quantity.splice(index, 1);
  cart.totale -= wine.prezzo.valueOf();
}

export function upload(cart:Cart,wine:Wine){
  if(cart.vini.indexOf(wine.id) == -1){
    addWine(cart,wine,1)
  } else {
    let index = cart.vini.indexOf(wine.id);
    if(cart.quantity[index] <10){
      cart.quantity[index] += 1;
      cart.totale += wine.prezzo.valueOf();
    }
  }
}
