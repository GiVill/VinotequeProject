import { AfterViewChecked, Component, OnInit } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/Services/authentication.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-main-nav',
  templateUrl: './main-nav.component.html',
  styleUrls: ['./main-nav.component.css']
})
export class MainNavComponent implements OnInit{

  logged : Boolean = false;
  sommelier : Boolean = false;
  admin : Boolean = false;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private breakpointObserver: BreakpointObserver,
              private service : AuthenticationService,
              private _snackBar: MatSnackBar) {}

  ngOnInit(): void {
    this.logged = this.service.isLogged();
  }

  cartAction(){
     if(this.logged){
      window.location.href = 'http://localhost:4200/cart';
     } else {
       this._snackBar.open("Non sei loggato!", "OK");
    }
  }

  loginRedirect(){
    window.location.href = 'http://localhost:8080/login.html';

  }

  doLogout(){
    const jsessionid = localStorage.getItem("jsessionid");

    this.service.logout(jsessionid!).subscribe(data =>{
      if(data){
        this.service.logged = false
        localStorage.clear();
        sessionStorage.clear();
        window.location.href = "http://localhost:4200"
      } else {
        this._snackBar.open("ERRORE!\n Riprova più tardi!", "OK");
      }
    })


  }

}
