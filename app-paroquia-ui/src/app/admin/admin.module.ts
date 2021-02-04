import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TableModule } from 'primeng/table';
import { AdminComponent } from './admin.component';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { TooltipModule } from 'primeng/tooltip';
import { SelectButtonModule } from 'primeng/selectbutton';
import { DropdownModule } from 'primeng/dropdown';
import { InputTextareaModule} from 'primeng/inputtextarea';

@NgModule({
  declarations: [AdminComponent],
  imports: [
    CommonModule,
    BrowserModule, 
    FormsModule,
    InputTextModule,
    ButtonModule,
    TableModule,
    TooltipModule,
    SelectButtonModule,
    DropdownModule,
    InputTextareaModule
  ]
})
export class AdminModule { } 
