import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WineViewComponent } from './Components/wine-view/wine-view.component';

const routes: Routes = [
  { path:'shop', component:WineViewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
