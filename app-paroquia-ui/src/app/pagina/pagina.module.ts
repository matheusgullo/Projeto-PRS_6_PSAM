import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TableModule } from 'primeng/table';
import { RatingModule } from 'ng-starrating';
import { PaginaComponent } from './pagina.component';

@NgModule({
  declarations: [
    PaginaComponent
  ],
  imports: [
    CommonModule,
    TableModule,
    RatingModule
  ],
  exports: [
    PaginaComponent
  ]
})
export class PaginaModule { }
