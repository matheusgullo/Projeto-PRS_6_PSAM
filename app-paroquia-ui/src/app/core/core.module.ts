import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthService } from '../seguranca/auth.service';
import localePt from '@angular/common/locales/pt';

import { AdminService } from './../admin/admin.service';


@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
  providers: [
    AuthService,
    AdminService
  ]
})
export class CoreModule { }

