import { Component, EventEmitter, Input, Output } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { RequestSommelier } from 'src/app/Model/RequestSommelier';
import { RequestService } from 'src/app/Services/request.service';

@Component({
  selector: 'app-request-card',
  templateUrl: './request-card.component.html',
  styleUrls: ['./request-card.component.css']
})

export class RequestCardComponent {

  constructor(private service: RequestService,
              private _snackBar: MatSnackBar){}

  @Input() request !: RequestSommelier;

  @Output() valueChanged = new EventEmitter<string>();

  acceptRequest(){
    this.service.accept(this.request).subscribe( data =>{
      if (data){
        this.valueChanged.emit('richiesta');
        this._snackBar.open("Richiesta accettata", "OK")
      }
      else{
        this._snackBar.open("Errore, riprova più tardi", "OK")
      }
    })
  }

  refuseRequest(){
    this.service.refuse(this.request).subscribe( data =>{
      if (data){
        this.valueChanged.emit('richiesta');
        this._snackBar.open("Richiesta rifiutata", "OK")
      }
      else{
        this._snackBar.open("Errore, riprova più tardi", "OK")
      }
    })
  }

}
