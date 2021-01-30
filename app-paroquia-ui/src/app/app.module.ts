import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { AuthService } from './seguranca/auth.service';
import { BrowserModule } from '@angular/platform-browser';
import {TableModule} from 'primeng/table';
import { SegurancaModule } from './seguranca/seguranca.module';
import { RatingModule } from 'ng-starrating';
import { PaginaModule } from './pagina/pagina.module';
import { HttpClientModule } from '@angular/common/http';
import { ButtonModule } from 'primeng/button';
import { TooltipModule } from 'primeng/tooltip';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    TableModule,
    ButtonModule,
    TooltipModule,
    RatingModule,
    SegurancaModule,
    PaginaModule    
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
