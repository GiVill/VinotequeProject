import { HttpClient, HttpHandler, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, NgForm, Validators } from '@angular/forms';
import { MatDatepickerModule} from '@angular/material/datepicker';
import { Router, RouterLink } from '@angular/router';
import { AuthenticationService } from 'src/app/Services/authentication.service';
import { User } from 'src/app/User';

@Component({
  selector: 'app-registration-card',
  templateUrl: './registration-card.component.html',
  styleUrls: ['./registration-card.component.css']
})
export class RegistrationCardComponent{

  minDate : Date
  maxDate : Date

  constructor(private service : AuthenticationService,
              private router : Router){
    const currentYear = new Date().getFullYear();
    const currentMonth = new Date().getMonth();
    const currentDay = new Date().getDay();
    this.minDate = new Date(1900, 0, 1);
    this.maxDate = new Date(currentYear - 18, currentMonth, currentDay + 8); //aggiustare il currentDay
    //console.log(currentYear,currentMonth,currentDay)
  }

  states : string[] = ['Albania', 'Andorra', 'Armenia', 'Austria', 'Azerbaigian', 'Bielorussia', 'Belgio', 'Bosnia-Erzegovina', 'Bulgaria', 'Cipro', 'Croazia', 'Danimarca', 'Estonia', 'Finlandia', 'Francia', 'Georgia', 'Germania', 'Grecia', 'Inghilterra', 'Irlanda', 'Islanda', 'Italia', 'Lettonia', 'Liechtenstein', 'Lituania', 'Lussemburgo', 'Malta', 'Moldavia', 'Monaco', 'Montenegro', 'Norvegia', 'Olanda', 'Polonia', 'Portogallo', 'Repubblica Ceca', 'Romania', 'San Marino', 'Serbia', 'Slovacchia', 'Slovenia', 'Spagna', 'Svezia', 'Svizzera', 'Turchia', 'Ucraina', 'Ungheria']

  hide = true;

  email = new FormControl('', [Validators.required, Validators.email]);

  getErrorMessage() {
    if (this.email.hasError('required')) {
      return 'You must enter a value';
    }

    return this.email.hasError('email') ? 'Not a valid email' : '';
  }



  onSubmit(form : NgForm){
    const newUser : User = {nome: form.value.name, cognome: form.value.surname,
      data_di_nascita: form.value.data, email: "caio@yahoo.it" , password: form.value.password, indirizzo: form.value.via}
    this.service.register(newUser).subscribe(data=> {
      console.log(data)

      this.router.navigate(['/']);
    })

    console.log(form.value);
    console.log(this.email.value);

  }
}
