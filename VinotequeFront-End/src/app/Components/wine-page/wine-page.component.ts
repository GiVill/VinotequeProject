import { NgFor } from '@angular/common';
import { ChangeDetectorRef, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { AuthenticationService } from 'src/app/Services/authentication.service';
import { WineService } from 'src/app/Services/wine.service';
import { User } from 'src/app/Model/User';
import { Wine } from 'src/app/Model/Wine';
import { ReviewService } from 'src/app/Services/review.service';
import { Review } from 'src/app/Model/Review';
import { Favorite, removeFromArray } from 'src/app/Model/Favorite';
import { MatSnackBar } from '@angular/material/snack-bar';
import { getWineQuantity, upload } from 'src/app/Model/Cart';

@Component({
  selector: 'app-wine-page',
  templateUrl: './wine-page.component.html',
  styleUrls: ['./wine-page.component.css']
})
export class WinePageComponent implements OnInit{

  @ViewChild('message') message!: ElementRef

  constructor(private route : ActivatedRoute,
              private wineService : WineService,
              private authService : AuthenticationService,
              private reviewService: ReviewService,
              private _snackBar: MatSnackBar){}

  wine !: Wine
  user !: User
  reviews !: Review[]
  canAddReview : boolean = false;
  index !: BigInt | null ;

  isPreferito : Boolean = false;

  ngOnInit(): void {

    window.scrollY

    this.index = BigInt(this.route.snapshot.paramMap.get("index")!)

    this.wineService.getWineById(this.index).subscribe(data =>{
      this.wine = data;
      this.takeReviews()
    })

    if(this.authService.isLogged()){

      if(this.authService.currentUser != null){
        this.user = this.authService.currentUser;
      } else if(localStorage.getItem("user") != null){
        this.user = this.authService.currentUser!;
      }

      if(this.authService.favourites == undefined){
        this.wineService.getFavoritesID(this.user.id).subscribe(data =>{
          this.authService.favourites = data
          this.isPreferito = this.authService.isInFavorites(Number(this.index))
        })
      }

      if(this.authService.isSommelier()){
        this.canAddReview = true;
      } else{
        this.canAddReview = false;
      }
    }

    if(this.authService.isLogged()){
      this.isPreferito = this.authService.isInFavorites(Number(this.index))
      console.log(this.isPreferito)
      console.log( this.authService.isInFavorites(Number(this.index)))
    }

  }

  show = false;

  sendReviewButton(value: string) {
    if (value.length > 0) {
      this.show = true;
    } else {
      this.show = false;
    }
  }


  takeReviews(){
    this.reviewService.getReviews(this.wine.id).subscribe(data =>{
      this.reviewService.review = data;
      this.reviews = data;
    })
  }

  addCart(){
    if(!this.authService.isLogged()){
      this._snackBar.open("Non sei loggato!", "OK");
    } else {
      let cart = JSON.parse(sessionStorage.getItem("cart")!);
      if(getWineQuantity(cart,this.wine) == 10){
        this._snackBar.open("Hai già la quantità massima nel carrello!");
      } else {
        upload(cart,this.wine)
        sessionStorage.setItem("cart",JSON.stringify(cart))
        this._snackBar.open("Prodotto aggiunto al carrello!");
      }
    }
  }


  favorite(){

    if(this.authService.isLogged()){

      if(this.isPreferito){
        this.isPreferito = false
        const favorite : Favorite = {
          preferiti_utente : this.user,
          preferiti_vino : this.wine
        }

        this.authService.favourites = removeFromArray(this.authService.favourites,Number(this.index))

        this.wineService.delFavorite(favorite).subscribe(data =>{
          if(data){
            this._snackBar.open("Prodotto rimosso dai preferit!","OK");
          }
        })

      } else {
        this.isPreferito = true

        const favorite : Favorite = {
        preferiti_utente : this.user,
        preferiti_vino : this.wine
        }

        this.authService.favourites.push(Number(this.index!))
        this.wineService.addFavorite(favorite).subscribe(data =>{
          if(data){
            this._snackBar.open("Prodotto aggiunto ai preferiti!","OK");
          }
        })
      }

    } else {
      this._snackBar.open("Non sei loggato!","OK");
    }
  }

  onSubmit(form:NgForm){

    let descrizione = this.message.nativeElement.value
    let data = new Date().toLocaleDateString();
    let id = 10

    const recensione : Review = {
      id : 10,
      descrizione : descrizione,
      recensione_sommelier : JSON.parse(localStorage.getItem("user")!),
      recensione_vino : this.wine,
      data : data,
    }

    this.reviewService.postReview(recensione).subscribe(data =>{
      if(data){

        this.message.nativeElement.value = ""

        this.index = BigInt(this.route.snapshot.paramMap.get("index")!)

        this.wineService.getWineById(this.index).subscribe(data =>{
          this.wine = data;
          this.takeReviews()
        })
      }
    })
  }
}
