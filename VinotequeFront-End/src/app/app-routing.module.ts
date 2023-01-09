import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginCardComponent } from './Components/login-card/login-card.component';
import { RegistrationCardComponent } from './Components/registration-card/registration-card.component';
import { ShopPageComponent } from './Components/shop-page/shop-page.component';

const routes: Routes = [
  { path:'shop', component:ShopPageComponent},
  { path:'login', component:LoginCardComponent},
  { path: 'registration', component:RegistrationCardComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
