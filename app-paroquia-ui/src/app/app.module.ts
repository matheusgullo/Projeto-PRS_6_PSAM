import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { AuthService } from './seguranca/auth.service';
import { BrowserModule } from '@angular/platform-browser';
import { TableModule } from 'primeng/table';
import { SegurancaModule } from './seguranca/seguranca.module';
import { RatingModule } from 'ng-starrating';
import { PaginaModule } from './pagina/pagina.module';
import { HttpClientModule } from '@angular/common/http';
import { ButtonModule } from 'primeng/button';
import { TooltipModule } from 'primeng/tooltip';
import { AdminComponent } from './admin/admin.component';
import { RouterModule, Routes } from '@angular/router';
import { PaginaComponent } from './pagina/pagina.component';
import { LoginFormComponent } from './seguranca/login-form/login-form.component';
import { CoreModule } from './core/core.module';
import { AdminModule } from './admin/admin.module';
import { InputTextareaModule} from 'primeng/inputtextarea';

const rotas: Routes = [
  { path: 'home', component: PaginaComponent },
  { path: 'login', component: LoginFormComponent},
  { path: 'admin', component: AdminComponent}
];

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
    PaginaModule,
    RouterModule.forRoot(rotas),
    CoreModule,
    AdminModule,
    InputTextareaModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
