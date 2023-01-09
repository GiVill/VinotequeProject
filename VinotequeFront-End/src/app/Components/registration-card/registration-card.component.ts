import { Component } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { MatDatepickerModule} from '@angular/material/datepicker';

@Component({
  selector: 'app-registration-card',
  templateUrl: './registration-card.component.html',
  styleUrls: ['./registration-card.component.css']
})
export class RegistrationCardComponent {

  minDate : Date
  maxDate : Date

  constructor(){
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
}
