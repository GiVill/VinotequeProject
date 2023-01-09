import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginCardComponent } from './Components/login-card/login-card.component';
import { ShopPageComponent } from './Components/shop-page/shop-page.component';

const routes: Routes = [
  { path:'shop', component:ShopPageComponent},
  { path:'login', component:LoginCardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
