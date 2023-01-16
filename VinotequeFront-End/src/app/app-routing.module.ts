import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthPageComponent } from './Components/auth-page/auth-page.component';
import { LoginCardComponent } from './Components/login-card/login-card.component';
import { RegistrationCardComponent } from './Components/registration-card/registration-card.component';
import { ShopPageComponent } from './Components/shop-page/shop-page.component';
import { UserPageComponent } from './Components/user-page/user-page.component';
import { WinePageComponent } from './Components/wine-page/wine-page.component';

const routes: Routes = [
  { path:'shop', component:ShopPageComponent},
  { path:'login', component:LoginCardComponent},
  { path: 'registration', component:RegistrationCardComponent},
  { path: 'Auth', component:AuthPageComponent},
  { path: 'shop/:id', component: WinePageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
