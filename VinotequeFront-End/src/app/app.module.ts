import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MainNavComponent } from './Components/main-nav/main-nav.component';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

//AngularMaterials
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { LayoutModule } from '@angular/cdk/layout';
import { MatListModule } from '@angular/material/list';
import { WineCardComponent } from './Components/wine-card/wine-card.component';
import { ReviewCardComponent } from './Components/review-card/review-card.component';
import {MatMenuModule} from '@angular/material/menu';
import { LoginCardComponent } from './Components/login-card/login-card.component';
import { ShopPageComponent } from './Components/shop-page/shop-page.component';
import {MatPaginatorModule} from '@angular/material/paginator';
import { RegistrationCardComponent } from './Components/registration-card/registration-card.component';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import {MatSelectModule} from '@angular/material/select';
import { AuthenticationService } from './Services/authentication.service';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { AuthPageComponent } from './Components/auth-page/auth-page.component';
import { ItemPageComponent } from './Components/item-page/item-page.component';


@NgModule({
  declarations: [
    AppComponent,
    MainNavComponent,
    WineCardComponent,
    ReviewCardComponent,
    LoginCardComponent,
    ShopPageComponent,
    RegistrationCardComponent,
    AuthPageComponent,
    ItemPageComponent,
  ],
  imports: [
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    NgbModule,
    FormsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatSidenavModule,
    LayoutModule,
    MatListModule,
    MatCardModule,
    MatGridListModule,
    MatMenuModule,
    MatPaginatorModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
    HttpClientModule
  ],
  providers: [AuthenticationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
