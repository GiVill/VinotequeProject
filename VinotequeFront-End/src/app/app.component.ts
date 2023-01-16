import { AfterContentInit, AfterViewChecked, AfterViewInit, Component, OnChanges, OnDestroy, OnInit, SimpleChanges } from '@angular/core';
import { UrlSegment } from '@angular/router';
import { AuthenticationService } from './Services/authentication.service';
import { User } from './User';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  constructor(private service : AuthenticationService){}

  sessionId : String = "";

  title = 'Vinoteque';

  ngOnInit(): void {
    const urlParams = new URLSearchParams(window.location.search);
    var sessionId = urlParams.get("jsessionid");
    if (sessionId){
      this.sessionId = sessionId;
      this.service.logged = true;
      this.service.checkLogin(sessionId).subscribe(userData => {
        if (userData){
          this.service.currentUser = userData;
          localStorage.setItem(this.sessionId.toString(),JSON.stringify(userData));
          console.log(userData)
        }
      });
    }
  }
}
