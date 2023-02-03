import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartPageComponent } from './Components/cart-page/cart-page.component';
import { HomePageComponent } from './Components/home-page/home-page.component';
import { RedPageComponent } from './Components/Shop/red-page/red-page.component';
import { RosePageComponent } from './Components/Shop/rose-page/rose-page.component';
import { ShopPageComponent } from './Components/Shop/shop-page/shop-page.component';
import { WhitePageComponent } from './Components/Shop/white-page/white-page.component';
import { UserPageComponent } from './Components/user-page/user-page.component';
import { WinePageComponent } from './Components/wine-page/wine-page.component';

const routes: Routes = [
  { path:'shop', component:ShopPageComponent},
  { path: 'shop/:index', component: WinePageComponent},
  { path: 'cart', component: CartPageComponent},
  { path: 'profile', component: UserPageComponent},
  { path: 'redWine', component: RedPageComponent},
  { path: 'whiteWine', component: WhitePageComponent},
  { path: 'roseWine', component: RosePageComponent},
  { path: '', component: HomePageComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
