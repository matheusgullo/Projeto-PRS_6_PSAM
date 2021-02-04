import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { AdminService } from './admin.service';
import { Missa } from 'src/app/core/model';
import { Paroquia } from 'src/app/core/model';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  listaMissa = []; 

  paroquia = [];

  constructor(private adminService: AdminService) { }

  ngOnInit(): void {
    this.listarMissa();
    this.listarParoquia();
  }

  listarMissa(): void{
    this.adminService.listarMissa()
    .then(resultado => { 
      this.listaMissa = resultado;
    });
  }

  listarParoquia(): void{
    this.adminService.listarParoquia()
    .then(resultado => {
      this.paroquia = resultado;
    });
  }

  alterar(form: FormControl): void{

  }

}
