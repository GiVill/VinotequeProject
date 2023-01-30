export interface Cart{
  vini : BigInt[],
  quantity : Number[]
}


export function addWine(cart:Cart,id:BigInt,quantity:Number){
  cart.vini.push(id);
  cart.quantity.push(quantity);
}

export function removeWine(cart:Cart,id:BigInt){
  let index = cart.vini.indexOf(id)
  cart.vini.splice(index, 1);
  cart.quantity.splice(index, 1)
}

export function reload(cart:Cart,id:BigInt,quantity:Number){
  let index = cart.vini.indexOf(id);
  cart.quantity[index] = quantity;
}
