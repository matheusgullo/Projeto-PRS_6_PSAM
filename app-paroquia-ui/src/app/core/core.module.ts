import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthService } from '../seguranca/auth.service';

import { AdminService } from './../admin/admin.service';
import { RouterModule } from '@angular/router';
import { ErrorHandlerService } from './error-handler.service';

import { ToastModule } from 'primeng/toast';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ConfirmationService, MessageService } from 'primeng/api';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule,
    ToastModule,
    ConfirmDialogModule
  ],
  exports:[
    ToastModule,
    ConfirmDialogModule 
  ],
  providers: [
    AuthService,
    AdminService,
    ErrorHandlerService,
    MessageService,
    ConfirmationService
  ]
})
export class CoreModule { }

