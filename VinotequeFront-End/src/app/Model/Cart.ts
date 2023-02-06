import { Wine } from "./Wine";

export interface Cart{
  idUtente : BigInt,
  vini : BigInt[],
  quantity : number[],
  totale : number,
}

export function sconto(cart:Cart,promo: number){
  cart.totale = cart.totale -( cart.totale * (promo/100))
}


export function setWineQuantity(cart:Cart,wine:Wine,quantita:number){
  let index = cart.vini.indexOf(wine.id)
  let last = cart.quantity[index]
  cart.totale -= last * wine.prezzo.valueOf()

  cart.quantity[index] = quantita
  cart.totale += wine.prezzo.valueOf() * quantita
}


export function getWineQuantity(cart:Cart,wine:Wine):number{
  let index = cart.vini.indexOf(wine.id)
  if(index == -1){
    return 0
  }
  let quantita = cart.quantity[index]
  return quantita.valueOf()
}

export function addWine(cart:Cart,wine:Wine,quantity:number){
  cart.vini.push(wine.id);
  cart.quantity.push(quantity);
  cart.totale += wine.prezzo.valueOf();
}

export function removeWine(cart:Cart,wine:Wine){
  let index = cart.vini.indexOf(wine.id)
  let quantita = cart.quantity[index]
  cart.vini.splice(index, 1);
  cart.quantity.splice(index, 1);
  cart.totale -= wine.prezzo.valueOf()*quantita;
  if(cart.totale < 0 || cart.vini.length == 0){
    cart.totale = 0
  }
}

export function removeAllWine(cart:Cart){
  while(cart.vini.length != 0){
    console.log(cart.vini.length)
    let index = cart.vini.indexOf(cart.vini[0])
    cart.vini.splice(index, 1);
    cart.quantity.splice(index, 1);
    cart.totale = 0
  }
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
